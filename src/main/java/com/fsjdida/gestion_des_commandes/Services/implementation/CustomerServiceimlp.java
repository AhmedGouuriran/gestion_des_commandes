package com.fsjdida.gestion_des_commandes.Services.implementation;

import com.fsjdida.gestion_des_commandes.Dao.CustomerDao;
import com.fsjdida.gestion_des_commandes.Dto.CustomerRequestDto;
import com.fsjdida.gestion_des_commandes.Dto.CustomerResponseDto;
import com.fsjdida.gestion_des_commandes.Exceptions.EntityNotFoundException;
import com.fsjdida.gestion_des_commandes.Services.CustomerService;
import com.fsjdida.gestion_des_commandes.models.Customer;
import lombok.extern.slf4j.Slf4j; // Import the Lombok Slf4j annotation
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j // Use Lombok's Slf4j annotation to create a logger
@Service("impl1")
public class CustomerServiceimlp implements CustomerService { // Keeping the class name as "CustomerServiceimlp"
    private final CustomerDao customerDao; // Made fields final for better practice
    private final ModelMapper modelMapper;

    public CustomerServiceimlp(CustomerDao customerDao, ModelMapper modelMapper) {
        this.customerDao = customerDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {
        Customer customer = modelMapper.map(customerRequestDto, Customer.class);
        Customer saved = customerDao.save(customer);
        log.info("Customer saved with ID: {}", saved.getId_customer()); // Log saved customer info
        return modelMapper.map(saved, CustomerResponseDto.class);
    }

    @Override
    public CustomerResponseDto findById(Long id_customer) {
        Customer customer = customerDao.findById(id_customer)
                .orElseThrow(() -> new EntityNotFoundException("Customer with ID: " + id_customer + " not found"));

        log.info("Customer found with ID: {}", id_customer); // Log found customer info
        return modelMapper.map(customer, CustomerResponseDto.class);
    }

    @Override
    public CustomerResponseDto fundByFirstName(String firstName) {
        Customer customer = customerDao.findByFirstName(firstName);
        log.info("Customer found with first name: {}", firstName); // Log found customer info
        return modelMapper.map(customer, CustomerResponseDto.class);
    }

    @Override
    public void deleteById(Long id_customer) {
        customerDao.deleteById(id_customer);
        log.info("Customer deleted with ID: {}", id_customer); // Log deletion info
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto, long id_customer) {
        Optional<Customer> customer = customerDao.findById(id_customer);
        if (customer.isPresent()) {
            Customer myCustomer = modelMapper.map(customerRequestDto, Customer.class);
            myCustomer.setId_customer(id_customer);
            Customer updated = customerDao.save(myCustomer);
            log.info("Customer updated with ID: {}", id_customer); // Log update info
            return modelMapper.map(updated, CustomerResponseDto.class);
        } else {
            log.warn("Attempt to update a non-existing customer with ID: {}", id_customer); // Log warning
            throw new EntityNotFoundException("Customer not found for updating");
        }
    }

    @Override
    public List<CustomerResponseDto> findAll() {
        List<Customer> customers = customerDao.findAll();
        log.info("DAO returned {} customers", customers.size()); // Log the size of the list

        return customers.stream()
                .map(element -> modelMapper.map(element, CustomerResponseDto.class))
                .collect(Collectors.toList());
    }
}

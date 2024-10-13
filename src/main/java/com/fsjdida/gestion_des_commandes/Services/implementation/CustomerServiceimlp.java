package com.fsjdida.gestion_des_commandes.Services.implementation;

import com.fsjdida.gestion_des_commandes.Dao.CustomerDao;
import com.fsjdida.gestion_des_commandes.Dto.CustomerRequestDto;
import com.fsjdida.gestion_des_commandes.Dto.CustomerResponseDto;
import com.fsjdida.gestion_des_commandes.Services.CustomerService;
import com.fsjdida.gestion_des_commandes.models.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("impl1")
public class CustomerServiceimlp implements CustomerService {
    private CustomerDao customerDao;
    private ModelMapper modelMapper;

    //    @Autowired
    public CustomerServiceimlp(CustomerDao customerDao, ModelMapper modelMapper) {
        this.customerDao = customerDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {
        Customer customer = modelMapper.map(customerRequestDto, Customer.class);
        Customer saved = customerDao.save(customer);
        return modelMapper.map(saved, CustomerResponseDto.class); // reponse est customer response dto
    }

    @Override
    public CustomerResponseDto findById(Long id_customer) {
        Customer customer = customerDao.findById(id_customer).orElseThrow(() -> new RuntimeException("Customer not found"));

        return modelMapper.map(customer, CustomerResponseDto.class);
    }

    @Override
    public CustomerResponseDto fundByFirstName(String fisrtName) {
        Customer customer = customerDao.findByFirstName(fisrtName);

        return modelMapper.map(customer, CustomerResponseDto.class);
    }

    @Override
    public void deleteById(Long id_customer) {
        customerDao.deleteById(id_customer);
        //Customer customer =customerDao.findById(id_customer).orElseThrow(()->new RuntimeException("Customer not found"));
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto, long id_customer) {
        Optional<Customer> customer = customerDao.findById(id_customer);
        if (customer.isPresent()) {
            Customer mycustomer = modelMapper.map(customerRequestDto, Customer.class);
            mycustomer.setId_customer(id_customer);// if we don't add this one he will add a new instance not updated thwe old one
            Customer updated = customerDao.save(mycustomer);
            return modelMapper.map(updated, CustomerResponseDto.class);
        } else {
            throw new RuntimeException("Customer not found");
        }


    }

    @Override
    public List<CustomerRequestDto> findAll() {
        return customerDao.findAll().stream()
                .map(element -> modelMapper.map(element, CustomerRequestDto.class))
                .collect(Collectors.toList());
    }
}

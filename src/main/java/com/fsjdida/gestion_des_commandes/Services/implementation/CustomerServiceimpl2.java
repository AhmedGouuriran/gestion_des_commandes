package com.fsjdida.gestion_des_commandes.Services.implementation;

import com.fsjdida.gestion_des_commandes.Dto.CustomerRequestDto;
import com.fsjdida.gestion_des_commandes.Dto.CustomerResponseDto;
import com.fsjdida.gestion_des_commandes.Services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("impl2")
public class CustomerServiceimpl2 implements CustomerService {
    @Override
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {
        return null;
    }

    @Override
    public CustomerResponseDto findById(Long id_customer) {
        return null;
    }

    @Override
    public CustomerResponseDto fundByFirstName(String fisrtName) {
        return null;
    }

    @Override
    public void deleteById(Long id_customer) {

    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto, long id_customer) {
        return null;
    }

    @Override
    public List<CustomerResponseDto> findAll() {
        return List.of();
    }
}

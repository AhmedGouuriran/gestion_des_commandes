package com.fsjdida.gestion_des_commandes.Services;

import com.fsjdida.gestion_des_commandes.Dto.CustomerRequestDto;
import com.fsjdida.gestion_des_commandes.Dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {

    CustomerResponseDto save(CustomerRequestDto customerRequestDto);

    CustomerResponseDto findById(Long id_customer);

    CustomerResponseDto fundByFirstName(String fisrtName);

    void  deleteById(Long id_customer);


    CustomerResponseDto update(CustomerRequestDto customerRequestDto , long id_customer);

    List<CustomerRequestDto> findAll();
}

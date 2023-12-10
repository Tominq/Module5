package com.example.customermanagememt.service;

import com.example.customermanagememt.dto.CustomerDto;
import com.example.customermanagememt.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer save(Customer customer);

    Customer findById(Long id);

    Customer findByName(String name);

    Customer update(Long id, CustomerDto customerDto);

    void delete(Long id);
}
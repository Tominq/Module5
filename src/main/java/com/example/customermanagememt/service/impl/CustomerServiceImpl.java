package com.example.customermanagememt.service.impl;

import com.example.customermanagememt.dto.CustomerDto;
import com.example.customermanagememt.model.Customer;
import com.example.customermanagememt.repository.CustomerRepository;
import com.example.customermanagememt.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        Customer customerSave = new Customer();
        customerSave.setName(customer.getName());
        customerSave.setEmail(customer.getEmail());
        customerSave.setAddress(customer.getAddress());
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null);
    }

    @Override
    public Customer findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Customer update(Long id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setName(customerDto.getName());
            customer.setEmail(customerDto.getEmail());
            customer.setAddress(customerDto.getAddress());
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}

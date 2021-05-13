package com.example.demo.servicies;

import com.example.demo.model.Customer;
import com.example.demo.model.Passport;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void addNewCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Customer findByPassport(){
        Passport passport = new Passport();
        passport.setNumber("2113123v");
        passport.setId(1L);
        return  customerRepository.findCustomerByPassport(passport).orElse( null);
    }
}

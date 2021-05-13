package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Passport;
import com.example.demo.model.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Optional<Customer> findCustomerByPassport(Passport passport);
}
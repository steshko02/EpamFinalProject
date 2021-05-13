package com.example.demo.model.domain;

import com.example.demo.model.Customer;
import com.example.demo.model.Passport;
import com.example.demo.model.domain.Role;
import com.example.demo.model.domain.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="users_db")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Enumerated(value=EnumType.STRING)
    private Role role;
    @Enumerated(value=EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}

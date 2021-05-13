package com.example.demo.model;


import com.example.demo.model.domain.User;
import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String patronymic;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    private int Age;
    @Enumerated(value=EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private User user;

    public Customer() {
    }
}

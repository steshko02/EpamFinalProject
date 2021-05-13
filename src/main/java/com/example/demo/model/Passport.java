package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private Customer customer;
    public Passport() {
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", customer=" + customer +
                '}';
    }
}

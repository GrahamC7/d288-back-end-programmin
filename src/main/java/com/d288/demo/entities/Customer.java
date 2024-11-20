package com.d288.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
@Data

public class Customer {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String postal_code;

    private String phone;

    private Date create_date;

    private Date last_update;

    private Division division;

    private Set<Cart> carts;
}

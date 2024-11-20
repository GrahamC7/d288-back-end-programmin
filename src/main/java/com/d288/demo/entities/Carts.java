package com.d288.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "cart")
@Data
public class Carts {

    private Long id;

    private String orderTrackingNumber;

    private BigDecimal package_price;

    private int party_size;

    private StatusType status;

    private Date create_date;

    private Date last_update;

    private Customer customer;
}

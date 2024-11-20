package com.d288.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "division")
@Data

public class Division {

    private Long id;

    private String division_name;

    private Date create_date;

    private Date last_update;

    private Country country;
}

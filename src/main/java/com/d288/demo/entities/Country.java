package com.d288.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "country")
@Data

public class Country {

    private Long id;

    private String country_name;

    private Date create_date;

    private Date last_update;

    private Set<Division> divisions;
}

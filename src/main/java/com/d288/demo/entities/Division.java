package com.d288.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id", nullable = false)
    private Long id;

    @Column(name = "division", nullable = false)
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update", updatable = false)
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @Column(name = "country_id", nullable = false, updatable = false)
    private Long country_id;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Customer> customers = new HashSet<>();

    // TODO fix for front end not populating division
    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

    /*
    public Division(String url){
        // this extracts the portion of the url containing the division id
        // url might look something like
        // http://localhost:8080/api/divisions/102
        // the division id is 102
        String divisionId = url.substring(url.lastIndexOf('/')+1);
        this.id = Long.parseLong(divisionId);
    }

     */

}

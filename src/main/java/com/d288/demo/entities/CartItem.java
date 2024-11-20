package com.d288.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Data
@Getter
@Setter

public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @Column(name = "vacation_id")
    @OneToMany
    private Vacation vacation;

    @ManyToOne
    private Set<Excursion> excursions;

    @Column(name = "cart_id")
    @ManyToOne
    private Cart cart;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;

    public CartItem(){

    }
}

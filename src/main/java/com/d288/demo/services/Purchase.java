package com.d288.demo.services;

import com.d288.demo.entities.Cart;
import com.d288.demo.entities.CartItem;
import com.d288.demo.entities.Customer;
import com.d288.demo.entities.Excursion;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

public class Purchase {
    private Cart cart;
    private Customer customer;
    private Set<CartItem> cartItems = new HashSet<>();
    private Set<Excursion> excursions = new HashSet<>();
}

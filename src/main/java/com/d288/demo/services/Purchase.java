package com.d288.demo.services;

import com.d288.demo.entities.Cart;
import com.d288.demo.entities.CartItem;
import com.d288.demo.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor

public class Purchase {
    private Cart cart;
    private Customer customer;
    private Set<CartItem> cartItems;
}

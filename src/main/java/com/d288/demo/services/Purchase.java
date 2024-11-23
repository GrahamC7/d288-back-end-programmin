package com.d288.demo.services;

import com.d288.demo.entities.Cart;
import com.d288.demo.entities.CartItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Cart cart;
    private Set<CartItem> cartItems;
}

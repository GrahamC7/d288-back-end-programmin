package com.d288.demo.services;


import com.d288.demo.dao.CartItemRepository;
import com.d288.demo.dao.CartRepository;
import com.d288.demo.dao.CustomerRepository;
import com.d288.demo.entities.Cart;
import com.d288.demo.entities.CartItem;
import com.d288.demo.entities.Customer;
import com.d288.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CartRepository cartRepository;
    private CustomerRepository customerRepository;
    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository, CartItemRepository cartItemRepository) {

        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();

        // cart population
        cartItems.forEach(item -> item.setCart(cart));
        cartItems.forEach(item -> cart.add(item));

        if (cartItems.isEmpty()) {
            cart.setStatus(StatusType.canceled);
            return new PurchaseResponse("Purchase Failure: Cart Empty");
        }

        // tracking order generation
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        cart.setStatus(StatusType.ordered);
        cartRepository.save(cart);

        Customer customer = purchase.getCustomer();
        customer.add(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
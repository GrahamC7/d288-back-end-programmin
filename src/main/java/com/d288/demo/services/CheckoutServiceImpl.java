package com.d288.demo.services;

import com.d288.demo.dao.CartRepository;
import com.d288.demo.dao.CustomerRepository;
import com.d288.demo.entities.Cart;
import com.d288.demo.entities.CartItem;
import com.d288.demo.entities.Customer;
import com.d288.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // data retrieval
        Cart cart = purchase.getCart();

        // tracking number generation
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.getCartItem().add(item));
        cart.setStatus(StatusType.ordered);

        Customer customer = purchase.getCustomer();
        customer.getCarts().add(cart);

        customerRepository.save(customer);
        cartRepository.save(cart);

        // order confirmation error message
        if (cartItems.isEmpty()){
            return new PurchaseResponse("Your cart is empty. Database has not been updated. Please add items to make a purchase.");
        }

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        String orderTrackingNumber = UUID.randomUUID().toString();
        return orderTrackingNumber;
    }
}
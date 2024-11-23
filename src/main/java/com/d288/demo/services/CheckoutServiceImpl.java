package com.d288.demo.services;

import com.d288.demo.dao.CartRepository;
import com.d288.demo.dao.CustomerRepository;
import com.d288.demo.entities.Cart;
import com.d288.demo.entities.CartItem;
import com.d288.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private CartRepository cartRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository,CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // data retrieval
        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();

        // order confirmation error message
        if (cartItems.isEmpty()){
            return new PurchaseResponse("Your cart is empty. Database has not been updated. Please add items to make a purchase.");
        }

        // item association
        cartItems.forEach(cart::add);

        // tracking number generation
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // setting cart status to ordered
        cart.setStatus(StatusType.ordered);

        // saving cart
        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
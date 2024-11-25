package com.d288.demo.services;

import com.d288.demo.dao.CartRepository;
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

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // data retrieval
        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();

        // tracking number generation
        String orderTrackingNumber = UUID.randomUUID().toString();

        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);
        cartItems.forEach(item -> {
            cart.add(item);
            item.setCart(cart);
        });

        cartRepository.save(cart);

        // order confirmation error message
        if (cartItems.isEmpty()) {
            return new PurchaseResponse("Your cart is empty. Database has not been updated. Please add items to make a purchase.");
        }

        return new PurchaseResponse(orderTrackingNumber);
    }
}
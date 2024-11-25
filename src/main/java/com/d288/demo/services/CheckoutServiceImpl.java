package com.d288.demo.services;

import com.d288.demo.dao.CartItemRepository;
import com.d288.demo.dao.CartRepository;
import com.d288.demo.dao.CustomerRepository;
import com.d288.demo.dao.ExcursionRepository;
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
    private ExcursionRepository excursionRepository;

    public CheckoutServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository, CartItemRepository cartItemRepository, ExcursionRepository excursionRepository) {

        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
        this.excursionRepository = excursionRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        try {
            // data retrieval
            Cart cart = purchase.getCart();

            Set<CartItem> cartItems = purchase.getCartItems();
            cartItems.forEach(item -> item.setCart(cart));

            cart.setCartItem(cartItems);

            // tracking number generation
            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);

            Customer customer = purchase.getCustomer();
            cart.setCustomer(customer);

            customerRepository.save(customer);
            cartRepository.save(cart);

            cart.setStatus(StatusType.ordered);

            // order confirmation error message
            if (customer == null || cartItems.isEmpty()) {
                throw new IllegalArgumentException("Customer field cannot be empty. Cart items cannot be empty.");
            }

            return new PurchaseResponse(orderTrackingNumber);
        } catch (Exception e) {
            return new PurchaseResponse(e.getMessage());
        }
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
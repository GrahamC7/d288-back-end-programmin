package com.d288.demo.controllers;

import com.d288.demo.services.CheckoutService;
import com.d288.demo.services.Purchase;
import com.d288.demo.services.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")

public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/purchase")
    @CrossOrigin("http://localhost:4200")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}

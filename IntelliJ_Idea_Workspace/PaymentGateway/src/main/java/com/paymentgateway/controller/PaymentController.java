package com.paymentgateway.controller;

import com.paymentgateway.service.PaymentService;
import net.authorize.api.contract.v1.ANetApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public String hello() {
        return "hello world!";
    }

    @PostMapping("/pay")
    public ANetApiResponse pay(@RequestBody Map<String, String> body) {
        String creditCardNumber = body.get("creditCardNumber");
        String expiryDate = body.get("expiryDate");
        String email = body.get("email");

        return paymentService.chargeCreditCard(500.0, creditCardNumber, expiryDate, email);
    }
}

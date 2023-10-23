package com.example.paymentms.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.paymentms.Model.Payment;
import com.example.paymentms.Model.ServiceFournisseur;
import com.example.paymentms.Model.User;
import com.example.paymentms.Repository.PaymentRepository;
import com.example.paymentms.Repository.ServiceFornisseurRepo;
import com.example.paymentms.Repository.UserRepository;
import com.example.paymentms.Service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.example.paymentms.Model.CheckoutPayment;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class StripeController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceFornisseurRepo serviceFornisseurRepo;

    @Autowired
    private CurrencyConversionService currencyConversionService;


    // create a Gson object
    private static Gson gson = new Gson();

    @PostMapping("/payment")
    /**
     * Payment with Stripe checkout page
     *
     * @throws StripeException
     */
    public String paymentWithCheckoutPage(@RequestBody CheckoutPayment payment,String userName, Long idServiceFournisseur) throws StripeException {

        // Convert TND to USD
        double amountInUSD = currencyConversionService.convertTNDtoUSD(payment.getAmount());

        // Initialize stripe object with the API key
        init();

        // Convert the USD amount to cents for Stripe since Stripe works in the smallest unit of any currency
        long amountInCents = (long) (amountInUSD * 100);

        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(payment.getSuccessUrl())
                .setCancelUrl(payment.getCancelUrl())
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setQuantity(payment.getQuantity())
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency("usd")  // Now setting currency as USD since we've converted the amount to USD
                                                .setUnitAmount(amountInCents)
                                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData
                                                        .builder().setName(payment.getName()).build())
                                                .build())
                                .build())
                .build();

        // Create a stripe session
        Session session = Session.create(params);
        Map<String, String> responseData = new HashMap<>();
        responseData.put("id", session.getId());

        // Create and save newPayment
        Payment newPayment = new Payment();
        newPayment.setName(payment.getName());
        double tndamount = amountInCents /100.0;
        newPayment.setAmount((long) tndamount);  // Save the converted amount (in cents) into the payment record
        newPayment.setQuantity(payment.getQuantity());
        newPayment.setCancelUrl(payment.getCancelUrl());
        newPayment.setSuccessUrl(payment.getSuccessUrl());
        newPayment.setCurrency("usd");  // Set currency of the payment record as USD

        User staticUser = userRepository.findById(userName).orElse(null);
        if (staticUser == null) {
            throw new RuntimeException("Static user not found!");
        }

        ServiceFournisseur serviceFournisseur = serviceFornisseurRepo.findById(idServiceFournisseur).orElse(null);
        if (serviceFournisseur == null) {
            throw new RuntimeException("Service Fournisseur not found!");
        }
        newPayment.setServiceFournisseur(serviceFournisseur);
        newPayment.setUser(staticUser);
        newPayment.setPaymentStatus("payment successful");

        paymentRepository.save(newPayment);

        return gson.toJson(responseData);
    }




    private static void init() {
        Stripe.apiKey = "sk_test_51O4Om8GxnCYriM4YeLIOhGou192DKBEqKsqUOxaxyTnuXU2Bf8pO7qAySeupJXO3RK2WKtiS9uwHxZ2TCyH2RUgs00TvFFPGOi";
    }





}

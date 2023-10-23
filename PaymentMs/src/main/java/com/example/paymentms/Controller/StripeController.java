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


    // create a Gson object
    private static Gson gson = new Gson();

    @PostMapping("/payment")
    /**
     * Payment with Stripe checkout page
     *
     * @throws StripeException
     */
    public String paymentWithCheckoutPage(@RequestBody CheckoutPayment payment,String userName,
                                          Long idServiceFournisseur) throws StripeException {

        // We initilize stripe object with the api key
        init();
        // We create a  stripe session parameters
        SessionCreateParams params = SessionCreateParams.builder()
                // We will use the credit card payment method
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(payment.getSuccessUrl())
                .setCancelUrl(
                        payment.getCancelUrl())
                .addLineItem(
                        SessionCreateParams.LineItem.builder().setQuantity(payment.getQuantity())
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency(payment.getCurrency()).setUnitAmount(payment.getAmount())
                                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData
                                                        .builder().setName(payment.getName()).build())
                                                .build())
                                .build())
                .build();
        // create a stripe session
        Session session = Session.create(params);
        Map<String, String> responseData = new HashMap<>();
        // We get the sessionId and we putted inside the response data you can get more info from the session object
        responseData.put("id", session.getId());
        // We can return only the sessionId as a String
        Payment newPayment = new Payment();
        newPayment.setName(payment.getName());
        newPayment.setAmount(payment.getAmount());
        newPayment.setQuantity(payment.getQuantity());
        newPayment.setCancelUrl(payment.getCancelUrl());
        newPayment.setSuccessUrl(payment.getSuccessUrl());
        newPayment.setCurrency(payment.getCurrency());

        User staticUser = userRepository.findById(userName).orElse(null);
        if (staticUser == null) {
            throw new RuntimeException("Static user not found!"); // or handle this case as you see fit

        }

        ServiceFournisseur serviceFournisseur =serviceFornisseurRepo.findById(idServiceFournisseur).orElse(null);
        if (serviceFournisseur == null) {
            throw new RuntimeException("Static user not found!"); // or handle this case as you see fit

        }
        newPayment.setServiceFournisseur(serviceFournisseur);
        newPayment.setUser(staticUser);
        newPayment.setPaymentStatus("payment successful");




        paymentRepository.save(newPayment);




        return gson.toJson(responseData);
    }




    private static void init() {
        Stripe.apiKey = "sk_test_51KZPLpK9uxhGdpuqEQuLMDPvriZm3vPdL57rGiLTO7lLvgyrGI40g0KBbMkxbVjXjhN6KH6Opz5R7sXHJChay7Dx006mDEbAId";
    }





}

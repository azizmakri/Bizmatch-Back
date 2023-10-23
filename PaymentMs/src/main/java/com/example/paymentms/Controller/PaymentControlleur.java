package com.example.paymentms.Controller;

import com.example.paymentms.Model.Payment;
import com.example.paymentms.Model.User;
import com.example.paymentms.Repository.PaymentRepository;
import com.example.paymentms.Repository.ServiceFornisseurRepo;
import com.example.paymentms.Repository.UserRepository;
import com.example.paymentms.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/payment")
@CrossOrigin("*")
public class PaymentControlleur {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceFornisseurRepo serviceFornisseurRepo;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getPaymentsByUser(@RequestParam String userName) {
        User user = userRepository.findById(userName).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Payment> payments = paymentRepository.findByUser(user);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Payment>> getListPayment() {
        return new ResponseEntity<>(paymentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/totalpayment")
    public ResponseEntity<Long> getTotalPaymentForMonth(@RequestParam String userName, @RequestParam int year, @RequestParam int month) {
        User user = userRepository.findById(userName).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        long totalPayment = paymentService.calculateTotalPaymentForMonth(user, year, month);
        return new ResponseEntity<>(totalPayment, HttpStatus.OK);
    }



    @GetMapping("/total-amount/current-month")
    public Long getTotalAmountForCurrentMonth() {
        return paymentService.getTotalAmountForCurrentMonth();
    }





}

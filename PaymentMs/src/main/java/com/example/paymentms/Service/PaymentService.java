package com.example.paymentms.Service;

import com.example.paymentms.Model.Payment;
import com.example.paymentms.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public List<Payment> getall(){
        return paymentRepository.findAll();
    }






}

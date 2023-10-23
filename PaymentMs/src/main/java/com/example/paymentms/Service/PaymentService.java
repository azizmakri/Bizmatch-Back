package com.example.paymentms.Service;

import com.example.paymentms.Model.Payment;
import com.example.paymentms.Model.User;
import com.example.paymentms.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public List<Payment> getall(){
        return paymentRepository.findAll();
    }


    public long calculateTotalPaymentForMonth(User user, int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1, 0, 0, 0);  // month is 0-based in Calendar
        cal.set(Calendar.MILLISECOND, 0);
        Date startDate = cal.getTime();

        cal.add(Calendar.MONTH, 1); // move to the next month
        Date endDate = cal.getTime();

        // Fetch payments within the date range for a specific user
        List<Payment> payments = paymentRepository.findByDateBetweenAndUser(startDate, endDate, user);

        // Calculate total
        long total = 0;
        for (Payment payment : payments) {
            total += payment.getAmount() * payment.getQuantity();
        }

        return total;
    }


    public Long getTotalAmountForCurrentMonth() {
        return paymentRepository.sumAmountForCurrentMonth();
    }







}

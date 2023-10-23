package com.example.paymentms.Repository;

import com.example.paymentms.Model.Payment;
import com.example.paymentms.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByUser(User user);
    List<Payment> findByDateBetweenAndUser(Date startDate, Date endDate, User user);


    @Query("SELECT SUM(p.amount) FROM Payment p WHERE MONTH(p.date) = MONTH(CURRENT_DATE)")
    Long sumAmountForCurrentMonth();


}

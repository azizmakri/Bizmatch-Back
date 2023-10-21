package com.example.paymentms.Repository;

import com.example.paymentms.Model.ServiceFournisseur;
import com.example.paymentms.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ServiceFornisseurRepo extends JpaRepository<ServiceFournisseur,Long> {


}

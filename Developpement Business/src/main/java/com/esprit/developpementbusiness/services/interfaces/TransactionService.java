package com.esprit.developpementbusiness.services.interfaces;

import com.esprit.developpementbusiness.persistence.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction save(Transaction transaction);
    public Transaction Update(Transaction transaction);

    public List<Transaction> findAll();
    public  Transaction findById(Long id);
    public boolean deleteById(Long id);
}

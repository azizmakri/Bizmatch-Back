package com.esprit.developpementbusiness.rest;

import com.esprit.developpementbusiness.persistence.entity.Transaction;
import com.esprit.developpementbusiness.services.interfaces.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DevBusiness")
@AllArgsConstructor
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transaction/add")
    public Transaction add(@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }
    @PutMapping("/transaction/update")
    public Transaction Update(@RequestBody Transaction transaction) {
        return	transactionService.Update(transaction);
    }

    @GetMapping("/transaction/getAll")
    public List<Transaction> getAll() {
        return transactionService.findAll();
    }

    @GetMapping("/transaction/getById/{id}")
    public Transaction getById(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @DeleteMapping("/transaction/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return transactionService.deleteById(id);
    }
}

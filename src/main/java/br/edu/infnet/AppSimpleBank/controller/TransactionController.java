package br.edu.infnet.AppSimpleBank.controller;


import br.edu.infnet.AppSimpleBank.domain.transaction.Transaction;
import br.edu.infnet.AppSimpleBank.domain.user.User;
import br.edu.infnet.AppSimpleBank.service.transaction.TransactionService;
import br.edu.infnet.AppSimpleBank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/getall")
    public List<Transaction> getAll() {
        return (List<Transaction>) transactionService.getAll();
    }
    @PostMapping(value = "/create")
    public void create(@RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
    }
    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable Integer id) {
        transactionService.delete(id);
    }
}

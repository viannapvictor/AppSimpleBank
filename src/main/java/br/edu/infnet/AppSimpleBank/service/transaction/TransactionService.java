package br.edu.infnet.AppSimpleBank.service.transaction;

import br.edu.infnet.AppSimpleBank.domain.transaction.Transaction;
import br.edu.infnet.AppSimpleBank.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void addTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public Collection<Transaction> getAll() {
        return (Collection<Transaction>) transactionRepository.findAll();
    }

    public void delete (Integer id) {
        transactionRepository.deleteById(id);
    }

}

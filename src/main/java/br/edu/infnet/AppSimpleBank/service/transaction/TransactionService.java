package br.edu.infnet.AppSimpleBank.service.transaction;

import br.edu.infnet.AppSimpleBank.domain.transaction.Transaction;
import br.edu.infnet.AppSimpleBank.domain.transaction.Transaction;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class TransactionService {

    private Map<Integer, Transaction> transactionMap = new HashMap<Integer, Transaction>();

    public void addTransaction(Transaction transaction) {
        transactionMap.put(transaction.getId(),transaction);
    }

    public Collection<Transaction> getAll() {
        return transactionMap.values();
    }

}

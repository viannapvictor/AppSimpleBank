package br.edu.infnet.AppSimpleBank.repositories;

import br.edu.infnet.AppSimpleBank.domain.transaction.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
}

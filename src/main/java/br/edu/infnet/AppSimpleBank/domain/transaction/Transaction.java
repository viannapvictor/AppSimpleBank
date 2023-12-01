package br.edu.infnet.AppSimpleBank.domain.transaction;

import br.edu.infnet.AppSimpleBank.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Transaction {
    private int id;
    private double amount;
    private User sender;
    private User receiver;
    private LocalDateTime transactionDate;
    public Transaction (int id, double amount, User sender, User receiver, LocalDateTime transactionDate) {
        setId(id);
        setAmount(amount);
        setSender(sender);
        setReceiver(receiver);
        setTransactionDate(transactionDate);
    }

    @Override
    public String toString() {
        return String.format("[Transações]\nBeneficiado: %s\nBeneficiário: %s\nValor: %.2f\nData: %s\n",
                receiver.getFirstName(), sender.getFirstName(), amount, transactionDate);
    }
}

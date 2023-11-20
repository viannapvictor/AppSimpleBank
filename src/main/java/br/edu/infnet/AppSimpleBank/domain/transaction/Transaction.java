package br.edu.infnet.AppSimpleBank.domain.transaction;

import br.edu.infnet.AppSimpleBank.domain.user.User;

import java.time.LocalDateTime;

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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return String.format("[Transações]\nBeneficiado: %s\nBeneficiário: %s\nValor: %.2f\nData: %s\n",
                receiver.getFirstName(), sender.getFirstName(), amount, transactionDate);
    }
}

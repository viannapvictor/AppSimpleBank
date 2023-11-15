package br.edu.infnet.AppSimpleBank.domain.transaction;

import br.edu.infnet.AppSimpleBank.domain.user.User;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private double amount;
    private User sender;
    private User receiver;
    private String password;
    private LocalDateTime transactionDate;
}

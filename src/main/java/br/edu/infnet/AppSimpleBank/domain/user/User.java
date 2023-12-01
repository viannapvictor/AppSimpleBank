package br.edu.infnet.AppSimpleBank.domain.user;

import br.edu.infnet.AppSimpleBank.domain.transaction.Transaction;
import br.edu.infnet.AppSimpleBank.utils.exceptions.InvalidValueException;
import br.edu.infnet.AppSimpleBank.utils.exceptions.NullOrEmptyException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String document;
    private String email;
    private String password;
    private double balance;
    private UserTypeEnum userType;

    private List<Transaction> transactionList = new ArrayList<>();

    public User() {

    }

    public User(int id, String firstName, String lastName,
                String document, String password,
                String email, double balance, UserTypeEnum userType)
            throws NullOrEmptyException, InvalidValueException {

        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setDocument(document);
        setEmail(email);
        setPassword(password);
        setBalance(balance);

        if (userType != null && !userType.getUserType().isBlank() && !userType.getUserType().isEmpty())
            this.userType = userType;
        else {
            throw new NullOrEmptyException("Valores nulos ou vazio não são aceitos");
        }

    }

    public void setBalance(double balance) throws InvalidValueException {
        if (balance >= 0.0)
            this.balance = balance;
        else {
            throw new InvalidValueException("Não existem valores negativos para o aluguel.");
        }
    }
    public void addTransactionList(Transaction transaction) {
        transactionList.add(transaction);
    }


    @Override
    public String toString() {
        return String.format("Tipo de conta: %s\nNome: %s %s\nDocument: %sz\nEmail: %s", userType, firstName, lastName ,document, email)
                + String.format("\nInformações de conta: %.2f\n", balance)
                ;
    }
}

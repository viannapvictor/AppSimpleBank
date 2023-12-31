package br.edu.infnet.AppSimpleBank.domain.user;

import br.edu.infnet.AppSimpleBank.domain.adress.UserAdress;
import br.edu.infnet.AppSimpleBank.domain.transaction.Transaction;
import br.edu.infnet.AppSimpleBank.utils.exceptions.InvalidValueException;
import br.edu.infnet.AppSimpleBank.utils.exceptions.NullOrEmptyException;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private double balance;
    @Enumerated(EnumType.STRING)
    private UserTypeEnum userType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "idSender")
    @JsonBackReference(value = "senderList")
    private List<Transaction> transactionSenderList;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "idReceiver")
    @JsonBackReference(value = "receiverList")
    private List<Transaction> transactionReceiverList;

    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "idAdress")
    private UserAdress userAdress;

    public User() {

    }

    public User(int id, String firstName, String lastName,
                String document, String password,
                String email, double balance, UserTypeEnum userType, UserAdress userAdress)
            throws NullOrEmptyException, InvalidValueException {

        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setDocument(document);
        setEmail(email);
        setPassword(password);
        setBalance(balance);
        setUserAdress(userAdress);

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

    @Override
    public String toString() {
        return String.format("Tipo de conta: %s\nNome: %s %s\nDocument: %s\nEmail: %s", userType, firstName, lastName ,document, email)
                + String.format("\nInformações de conta: %.2f\n", balance);
    }
}

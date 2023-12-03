package br.edu.infnet.AppSimpleBank.domain.transaction;

import br.edu.infnet.AppSimpleBank.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="TB_TRANSACTIONS")
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idSender")
    private User sender;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idReceiver")
    private User receiver;
    private LocalDateTime transactionDate;

    public Transaction() {

    }

    @Override
    public String toString() {
        return String.format("[Transações]\nBeneficiado: %s\nBeneficiário: %s\nValor: %.2f\n" +
                        "Data: %s\n", receiver, sender, amount, transactionDate);
    }
}

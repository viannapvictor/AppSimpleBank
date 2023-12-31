package br.edu.infnet.AppSimpleBank;

import br.edu.infnet.AppSimpleBank.domain.transaction.Transaction;
import br.edu.infnet.AppSimpleBank.domain.user.User;
import br.edu.infnet.AppSimpleBank.service.transaction.TransactionService;
import br.edu.infnet.AppSimpleBank.service.user.UserService;
import br.edu.infnet.AppSimpleBank.utils.exceptions.FileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;

@Order(2)
@Component
public class TransactionLoader implements ApplicationRunner {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            FileReader file = new FileReader("files/transactions.txt");
            BufferedReader read = new BufferedReader(file);

            String line = read.readLine();
            String[] fields;

            while (line != null) {

                fields = line.split(";");

                int id = Integer.parseInt(fields[0]);
                double amount = Double.parseDouble(fields[1]);
                User sender = userService.findUserById(Integer.parseInt(fields[2]));
                User receiver = userService.findUserById(Integer.parseInt(fields[3]));

                Transaction transaction = new Transaction(id, amount, sender, receiver, LocalDateTime.now());

                transactionService.addTransaction(transaction);

                line = read.readLine();

            }

            for (Transaction transaction : transactionService.getAll()) {
                System.out.println(transaction);
                System.out.println("Tamanho das listas de Lojistas: "+ transaction.getReceiver().getTransactionReceiverList().size());
                System.out.println("\nTamanho das listas de Clientes: "+ transaction.getSender().getTransactionSenderList().size());
            }


            read.close();

        } catch (Exception fr) {
            throw new FileException("Impossível de ler o arquivo!");
        }

    }
}

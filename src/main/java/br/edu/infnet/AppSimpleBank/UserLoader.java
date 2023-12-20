package br.edu.infnet.AppSimpleBank;

import br.edu.infnet.AppSimpleBank.domain.adress.UserAdress;
import br.edu.infnet.AppSimpleBank.domain.user.User;
import br.edu.infnet.AppSimpleBank.domain.user.UserTypeEnum;
import br.edu.infnet.AppSimpleBank.service.user.UserService;
import br.edu.infnet.AppSimpleBank.utils.exceptions.FileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class UserLoader implements ApplicationRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            FileReader file = new FileReader("files/users.txt");
            BufferedReader read = new BufferedReader(file);

            String line = read.readLine();
            String[] fields;

            while (line != null) {

                fields = line.split(";");

                User user = new User();

                double balance = Double.parseDouble(fields[6]);
                UserTypeEnum userType = fields[7].equalsIgnoreCase("client")
                        ? UserTypeEnum.CLIENT : UserTypeEnum.MERCHANT;

                user.setFirstName(fields[1]);
                user.setLastName(fields[2]);
                user.setDocument(fields[3]);
                user.setPassword(fields[4]);
                user.setEmail(fields[5]);
                user.setBalance(balance);
                user.setUserType(userType);
                user.setUserAdress(new UserAdress(fields[8]));

                userService.addUser(user);

                line = read.readLine();

            }

            for (User users : userService.getAll()) {
                System.out.println(users);
            }

            read.close();

        } catch (Exception fr) {
            throw new FileException("Impossível de ler o arquivo!");
        }

    }
}

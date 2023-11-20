package br.edu.infnet.AppSimpleBank;

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
import java.util.HashMap;
import java.util.Map;

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

                int id = Integer.parseInt(fields[0]);
                double balance = Double.parseDouble(fields[6]);
                UserTypeEnum userType = fields[7].equalsIgnoreCase("client")
                        ? UserTypeEnum.CLIENT : UserTypeEnum.MERCHANT;

                User user = new User(id, fields[1], fields[2], fields[3], fields[4], fields[5], balance, userType);

                userService.addUser(user);

                line = read.readLine();

            }

            read.close();

        } catch (Exception fr) {
            throw new FileException("Impossível de ler o arquivo!");
        }

    }
}

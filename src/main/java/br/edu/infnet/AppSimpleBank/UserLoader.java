package br.edu.infnet.AppSimpleBank;

import br.edu.infnet.AppSimpleBank.domain.user.User;
import br.edu.infnet.AppSimpleBank.domain.user.UserTypeEnum;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserLoader implements ApplicationRunner {

    private Map<Integer, User> userMap = new HashMap<Integer, User>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/users.txt");
        BufferedReader read = new BufferedReader(file);

        String line = read.readLine();
        String[] fields =  null;
        while (line != null) {

            fields = line.split(";");

            int id = Integer.parseInt(fields[0]);
            double balance = Double.parseDouble(fields[6]);
            UserTypeEnum userType = fields[7].equalsIgnoreCase("client")
                    ?  UserTypeEnum.CLIENT : UserTypeEnum.MERCHANT;

            User user = new User(id, fields[1], fields[2], fields[3], fields[4], fields[5], balance, userType);

            userMap.put(user.getId(), user);

            line = read.readLine();
        }

        for (User user: userMap.values()) {
            System.out.println("[User]: " +  user);
        }

        read.close();

    }
}

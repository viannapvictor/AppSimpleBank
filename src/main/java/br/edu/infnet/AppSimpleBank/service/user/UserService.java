package br.edu.infnet.AppSimpleBank.service.user;

import br.edu.infnet.AppSimpleBank.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private Map<Integer, User> userMap = new HashMap<Integer, User>();

    public void addUser(User user) {
        userMap.put(user.getId(),user);
    }

    public Collection<User> getAll() {
        return userMap.values();
    }

    public User findUserById(int id) {
        User selectedUser = null;
        for (User user : userMap.values()) {
            if (user.getId() == id) {
                selectedUser = user;
            }
        }
        return selectedUser;
    }

}

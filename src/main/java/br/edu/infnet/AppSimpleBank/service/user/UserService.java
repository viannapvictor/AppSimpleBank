package br.edu.infnet.AppSimpleBank.service.user;

import br.edu.infnet.AppSimpleBank.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private Map<Integer, User> userMap = new HashMap<Integer, User>();

    public void addUser(User user) {
        userMap.put(user.getId(),user);
    }

    public List<User> getAll() {
        return userMap.values().stream().toList();
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

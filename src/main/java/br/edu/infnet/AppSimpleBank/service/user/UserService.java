package br.edu.infnet.AppSimpleBank.service.user;

import br.edu.infnet.AppSimpleBank.domain.user.User;
import br.edu.infnet.AppSimpleBank.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRespository userRespository;

    public void addUser(User user) {
        userRespository.save(user);
    }

    public Collection<User> getAll() {
        return (Collection<User>) userRespository.findAll();
    }

    public User findUserById(int id) {
        User selectedUser = null;
        for (User user : getAll()) {
            if (user.getId() == id) {
                selectedUser = user;
            }
        }
        return selectedUser;
    }

}

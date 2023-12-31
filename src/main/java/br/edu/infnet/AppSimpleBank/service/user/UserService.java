package br.edu.infnet.AppSimpleBank.service.user;

import br.edu.infnet.AppSimpleBank.domain.adress.UserAdress;
import br.edu.infnet.AppSimpleBank.domain.user.User;
import br.edu.infnet.AppSimpleBank.repositories.UserRespository;
import br.edu.infnet.AppSimpleBank.service.adress.UserAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRespository userRespository;
    @Autowired
    private UserAdressService userAdressService;

    public void addUser(User user) {

        String cep = user.getUserAdress().getCep();

        UserAdress userAdress = userAdressService.getAdressByCEP(cep);

        user.setUserAdress(userAdress);

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

    public void delete(Integer id) {
        userRespository.deleteById(id);
    }

}

package br.edu.infnet.AppSimpleBank.service.adress;

import br.edu.infnet.AppSimpleBank.clients.IUserAdressClient;
import br.edu.infnet.AppSimpleBank.domain.adress.UserAdress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAdressService {

    @Autowired
    private IUserAdressClient userAdressClient;
    public UserAdress getAdressByCEP(String cep) {
        return userAdressClient.getAdressByCEP(cep);
    }

}

package br.edu.infnet.AppSimpleBank.clients;

import br.edu.infnet.AppSimpleBank.domain.adress.UserAdress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface IUserAdressClient {
    @GetMapping(value = "/{cep}/json/")
    UserAdress getAdressByCEP(@PathVariable("cep") String cep);
}

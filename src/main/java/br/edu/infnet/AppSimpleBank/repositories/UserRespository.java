package br.edu.infnet.AppSimpleBank.repositories;

import br.edu.infnet.AppSimpleBank.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends CrudRepository<User,Integer> {

}

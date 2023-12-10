package br.edu.infnet.AppSimpleBank.controller;

import br.edu.infnet.AppSimpleBank.domain.transaction.Transaction;
import br.edu.infnet.AppSimpleBank.domain.user.User;
import br.edu.infnet.AppSimpleBank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getall")
    public List<User> getAll() {
        return (List<User>) userService.getAll();
    }
    @PostMapping(value = "/create")
    public void create(@RequestBody User user) {
        userService.addUser(user);
    }
    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}

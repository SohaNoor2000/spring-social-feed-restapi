package com.springboot.restapi.socialmediaUsers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersRestController {

    private UserDaoService userDaoService;

    public UsersRestController(UserDaoService userDaoService){
        this.userDaoService=userDaoService;

    }
    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
      return userDaoService.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User getOneUser(@PathVariable int id){
        return userDaoService.getUserById(id);
    }

    @PostMapping (path = "/users")
    public void addUser(@RequestBody User user){
        userDaoService.addUser(user);
    }

    @DeleteMapping (path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deleteUser(id);
    }

}

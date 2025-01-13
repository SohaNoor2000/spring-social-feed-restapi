package com.springboot.restapi.socialmediaUsers;

import com.springboot.restapi.exceptionhandling.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = userDaoService.getUserById(id);
        if(user==null){
            throw new UserNotFoundException("User not found for id: "+id);
        }
        return user;
    }

    @PostMapping (path = "/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        userDaoService.addUser(user);
        URI location = ServletUriComponentsBuilder.
                        fromCurrentRequest().
                        path("/{id}").
                        buildAndExpand(user.getId()).
                        toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping (path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
       userDaoService.deleteUser(id);
    }

}

package com.springboot.restapi.socialmediaUsers;


import com.springboot.restapi.exceptionhandling.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {


    private static List<User> Users=new ArrayList<>();
    static int userId =0;
    static {
        Users.add(new User(++userId,"John", LocalDate.now().minusYears(23)));
        Users.add(new User(++userId,"Burak", LocalDate.now().minusYears(40)));
        Users.add(new User(++userId,"Jackuline", LocalDate.now().minusYears(16)));
    }


    public List<User> getAllUsers() {
        return Users;
    }

    public User getUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return Users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User addUser(User user) {
        user.setId(++userId);
        Users.add(user);
        return user;

    }

    public void deleteUser(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        boolean removed=Users.removeIf(predicate);

        if(!removed){
           throw new UserNotFoundException("User Not Found");
        }
    }
}

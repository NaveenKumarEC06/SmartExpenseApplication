package com.expensemanager.SmartExpenseApplication.Service;


import com.expensemanager.SmartExpenseApplication.Entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class UserService {

    HashMap<Long, User> userList = new HashMap<>();

    public ResponseEntity<String> addUser(Long mobile, User user)
    {
        if (userList.containsKey(mobile) == false)
        {
            UUID uuid = UUID.randomUUID();
            String id = uuid.toString();
            user.setId(id);
            userList.put(mobile, user);
        }
        else
            return ResponseEntity.ok("DUPLICATE USERS NOT ALLOWED !");
        return ResponseEntity.ok("USER ADDED SUCCESSFULLY !");
    }

    public Collection<User> viewAllUsers() {
        Collection<User> temp = userList.values();
        return temp;
    }

    public String getUserByMobile(Long mobile)
    {
        if(userList.containsKey(mobile))
            return userList.get(mobile).toString();
        else
            return "NOT FOUND !!";
    }
}

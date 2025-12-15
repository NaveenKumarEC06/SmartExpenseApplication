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

    HashMap<Long, User> map = new HashMap<>();

    public ResponseEntity<String> addUser(Long mobile, User user) {
        if (map.containsKey(mobile) == false) {
            UUID uuid = UUID.randomUUID();
            String idAndName = uuid.toString() + " " + user.getName();
            user.setName(idAndName);
            map.put(mobile, user);
        } else {
            return ResponseEntity.ok("DUPLICATE USERS NOT ALLOWED !");
        }
        return ResponseEntity.ok("USER ADDED SUCCESSFULLY !");
    }

    public Collection<User> viewAllUsers() {
        Collection<User> temp = map.values();
        return temp;
    }

    public String getUserByMobile(Long mobile)
    {
        if(map.containsKey(mobile))
        {
            return map.get(mobile).toString();
        }
        else {
            return "NOT FOUND !!";        }

    }
}

package com.expensemanager.SmartExpenseApplication.Controller;

import com.expensemanager.SmartExpenseApplication.Entity.User;
import com.expensemanager.SmartExpenseApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController
{
    @Autowired
    UserService userService;
    @PostMapping("/Add")
    public ResponseEntity<String> addUser(@RequestBody User user)
    {
        return userService.addUser(user.getMobile(),user);
    }
    @GetMapping("/View")
    public Collection<User> viewAllUsers()
    {
        return userService.viewAllUsers();
    }
    @GetMapping("Get/{mobile}")
    public ResponseEntity<User> getUserByMobile(@PathVariable Long mobile)
    {
        User user = userService.getUserByMobile(mobile);
        if( user != null )
            return ResponseEntity.ok(user);
        else
            return ResponseEntity.notFound().build();
    }
}

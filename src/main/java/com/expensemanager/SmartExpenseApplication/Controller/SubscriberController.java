package com.expensemanager.SmartExpenseApplication.Controller;

import com.expensemanager.SmartExpenseApplication.DTO.UserSubscriberDTO;
import com.expensemanager.SmartExpenseApplication.Entity.Subscriber;
import com.expensemanager.SmartExpenseApplication.Entity.User;
import com.expensemanager.SmartExpenseApplication.Service.SubscriberService;
import com.expensemanager.SmartExpenseApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Subscriber")
public class SubscriberController {

    @Autowired
    SubscriberService subscriberService;
    UserService userService;
    @PostMapping("/Add")
    public ResponseEntity<List<UserSubscriberDTO>> addSubscriber(@RequestBody Subscriber subscriber)
    {
        return subscriberService.addSubscriber(subscriber);
    }

}

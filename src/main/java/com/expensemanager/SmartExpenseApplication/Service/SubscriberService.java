package com.expensemanager.SmartExpenseApplication.Service;

import com.expensemanager.SmartExpenseApplication.DTO.UserSubscriberDTO;
import com.expensemanager.SmartExpenseApplication.Entity.Subscriber;
import com.expensemanager.SmartExpenseApplication.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubscriberService {

    @Autowired
    UserService userService;

    Map<User,Subscriber> subscribersList = new HashMap<>();
    public ResponseEntity<List<UserSubscriberDTO>> addSubscriber(Subscriber subscriber)
    {
        try
        {
            User s = userService.getUser(subscriber.getMobile());
            subscribersList.put(s,subscriber);
            List<UserSubscriberDTO> dtoList = subscribersList.entrySet()
                    .stream()
                    .map(entry -> new UserSubscriberDTO(
                            entry.getKey(),
                            entry.getValue()
                    ))
                    .toList();

            return ResponseEntity.ok(dtoList);
        }
        catch(NullPointerException e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<> pauseSubscription(User user)
    {

    }
}

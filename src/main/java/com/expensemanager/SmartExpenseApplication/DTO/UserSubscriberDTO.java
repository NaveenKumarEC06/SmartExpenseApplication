package com.expensemanager.SmartExpenseApplication.DTO;

import com.expensemanager.SmartExpenseApplication.Entity.Subscriber;
import com.expensemanager.SmartExpenseApplication.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSubscriberDTO {

    private User user;
    private Subscriber subscriber;
}

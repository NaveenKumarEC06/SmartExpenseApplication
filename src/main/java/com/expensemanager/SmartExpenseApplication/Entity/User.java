package com.expensemanager.SmartExpenseApplication.Entity;

import lombok.*;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String name;
    private long mobile;
}

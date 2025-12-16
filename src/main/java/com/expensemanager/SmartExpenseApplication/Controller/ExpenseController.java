package com.expensemanager.SmartExpenseApplication.Controller;

import com.expensemanager.SmartExpenseApplication.Entity.Expense;
import com.expensemanager.SmartExpenseApplication.Entity.Range;
import com.expensemanager.SmartExpenseApplication.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Expense")
public class ExpenseController
{
    @Autowired
    ExpenseService expenseService;
    @PostMapping("/Add")
    public ResponseEntity<String> addExpense(@RequestBody Expense expense)
    {
        return expenseService.addExpense(expense);
    }

    @GetMapping("/View")
    public Map<String,Double> viewExpenseList()
    {
        return expenseService.viewExpenseList();
    }

    @PostMapping("/Filter/BelowTheLimit")
    public Map<String,Double> filterExpenseBelowTheLimit(@RequestBody double price)
    {
        return expenseService.filterExpenseBelowTheLimit(price);
    }
    @PostMapping("/Filter/AboveTheLimit")
    public Map<String,Double> filterExpenseAboveTheLimit(@RequestBody double price)
    {
        return expenseService.filterExpenseAboveTheLimit(price);
    }

    @PostMapping("/Filter/BetweenTheRange")
    public Map<String,Double> filterExpenseBetweenTheRange(@RequestBody Range range)
    {
        return expenseService.filterExpenseBetweenTheRange(range);
    }

    @GetMapping("/Remove")
    public ResponseEntity<String> removeExpense(@RequestParam String removeExp)
    {
        return expenseService.removeExpense(removeExp);
    }
}

package com.example.endsem;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button addExpenseButton;
    private RecyclerView expensesRecyclerView;
    private ExpenseAdapter expenseAdapter;
    private List<Expense> expenseList;
    private TextView totalExpensesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        addExpenseButton = findViewById(R.id.addExpenseButton);
        totalExpensesTextView = findViewById(R.id.totalExpenseTextView);
        expensesRecyclerView = findViewById(R.id.expensesRecyclerView);

        // Initialize expense list and populate with sample data (replace with actual data)
        expenseList = new ArrayList<>();
        expenseList.add(new Expense("Lunch", 15.0, "Food", "12/10/2024"));
        expenseList.add(new Expense("Taxi", 25.0, "Transport", "13/10/2024"));
        expenseList.add(new Expense("Hotel", 150.0, "Accommodation", "14/10/2024"));

        // Calculate and display total expenses
        double totalExpenses = 0;
        for (Expense expense : expenseList) {
            totalExpenses += expense.getAmount();
        }
        totalExpensesTextView.setText("Total Expenses: $" + totalExpenses);

        // Set up RecyclerView with the ExpenseAdapter
        expenseAdapter = new ExpenseAdapter(expenseList);
        expensesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        expensesRecyclerView.setAdapter(expenseAdapter);

        // Set click listener for the Add Expense button
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to AddExpenseActivity
                Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.endsem;

public class Expense {
    private String name;
    private double amount;
    private String category;
    private String date;
    public Expense(String name, double amount, String category, String date) {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Getter for category
    public String getCategory() {
        return category;
    }

    // Getter for amount
    public double getAmount() {
        return amount;
    }

    // Other getters if needed
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}

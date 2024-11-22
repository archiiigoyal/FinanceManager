import java.util.*;

public class ExpenseTracker {
    
    private List<Expense> expenseHistory;    // To store all expenses
    private Set<Expense> expenseSet;         // To prevent duplicate expenses
    private PriorityQueue<Expense> priorityQueue; // To track most expensive expenses

    // Constructor
    public ExpenseTracker() {
        expenseHistory = new ArrayList<>();
        expenseSet = new HashSet<>();
        priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Expense::getAmount).reversed());
    }

    // Method to add an expense
    public void addExpense(String description, double amount, String category, String date) {
        Expense newExpense = new Expense(description, amount, category, date);
        
        // Prevent duplicate expense entries
        if (!expenseSet.contains(newExpense)) {
            expenseHistory.add(newExpense);
            expenseSet.add(newExpense);
            priorityQueue.add(newExpense);
        } else {
            System.out.println("Expense already exists!");
        }
    }

    // Method to get the most expensive expense
    public Expense getMostExpensiveExpense() {
        return priorityQueue.peek();  // The root of the priority queue will be the highest value
    }

    // Method to display all expenses
    public void displayExpenses() {
        for (Expense expense : expenseHistory) {
            System.out.println(expense);
        }
    }

    // Method to display top N most expensive expenses
    public void displayTopExpenses(int n) {
        if (n > priorityQueue.size()) {
            n = priorityQueue.size();
        }
        System.out.println("Top " + n + " Most Expensive Expenses:");
        PriorityQueue<Expense> tempQueue = new PriorityQueue<>(priorityQueue);
        for (int i = 0; i < n; i++) {
            System.out.println(tempQueue.poll());
        }
    }

    // Method to get the entire expense history
    public List<Expense> getExpenseHistory() {
        return expenseHistory;  // Return the list of all expenses
    }
}

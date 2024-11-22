import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an instance of ExpenseTracker
        ExpenseTracker tracker = new ExpenseTracker();
        
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Display options for the user
        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Display All Expenses");
            System.out.println("3. Display Top N Expensive Expenses");
            System.out.println("4. View Most Expensive Expense");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1: // Add an expense
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter date (yyyy-mm-dd): ");
                    String date = scanner.nextLine();

                    tracker.addExpense(description, amount, category, date);
                    break;

                case 2: // Display all expenses
                    tracker.displayExpenses();
                    break;

                case 3: // Display top N expensive expenses
                    System.out.print("Enter the number of top expenses to display: ");
                    int n = scanner.nextInt();
                    tracker.displayTopExpenses(n);
                    break;

                case 4: // View most expensive expense
                    Expense mostExpensive = tracker.getMostExpensiveExpense();
                    if (mostExpensive != null) {
                        System.out.println("Most Expensive Expense: \n" + mostExpensive);
                    } else {
                        System.out.println("No expenses available.");
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting the Expense Tracker.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


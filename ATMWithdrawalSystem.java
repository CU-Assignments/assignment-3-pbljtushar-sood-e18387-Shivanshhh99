import java.util.Scanner;

public class ATMWithdrawalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int correctPin = 1234;
        double balance = 3000;
        
        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();
        
        try {
            if (enteredPin != correctPin) {
                throw new IllegalArgumentException("Invalid PIN.");
            }
            
            System.out.print("Withdraw Amount: ");
            double withdrawAmount = scanner.nextDouble();
            
            if (withdrawAmount > balance) {
                throw new IllegalArgumentException("Insufficient balance.");
            }
            
            balance -= withdrawAmount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + " Current Balance: " + balance);
        } finally {
            scanner.close();
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            JOptionPane.showMessageDialog(null, "Deposit successful. New balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrawal successful. New balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid withdrawal amount or insufficient funds.");
        }
    }
}

class ATM extends JFrame {
    private BankAccount userAccount;
    private JTextField amountField;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;

        
        JLabel amountLabel = new JLabel("Enter amount:");
        amountField = new JTextField(10);
        JButton checkBalanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        setLayout(new FlowLayout());
        add(amountLabel);
        add(amountField);
        add(checkBalanceButton);
        add(depositButton);
        add(withdrawButton);
        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });
        setTitle("ATM Machine");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void checkBalance() {
        JOptionPane.showMessageDialog(null, "Your balance: " + userAccount.getBalance());
    }

    private void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            userAccount.deposit(amount);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        }
    }

    private void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            userAccount.withdraw(amount);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        BankAccount userAccount = new BankAccount(1000.0);
         ATM atm = new ATM(userAccount);
        atm.setVisible(true);
    }
}

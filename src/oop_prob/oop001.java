import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class BankAccount {
    private String id;
    private double balance;
    private static int transactions = 0;
    
    public BankAccount(String id) {
        this.id = id;
        this.balance = 0.0;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getID() {
        return id;
    }
    
    public int getTransactions() {
        return transactions;
    }
    
    public void deposit(double amount) {
        if(amount >= 0 && amount <= 500) {
            balance += amount;
            transactions++;
        }
    }
    
    public void withdraw(double amount) {
        if(balance > 0 && amount <= balance) {
            balance -= amount;
            transactions++;
        }
    }
    
    public boolean transactionFee(double amount) {
        double total = 0;
		// double totalTransactionsFee = amount*transactions*(transactions+1)/2;
        // balance -= totalTransactionsFee;
		for(int i=1; i<=transactions; i++) {
            total += i*amount;
        }
        balance -= total;
        // System.out.println(balance);
        
        if(balance<=0) {
            return false;
        } else { 
            return true; 
        }
        
        
    }
}

public class oop001 {
    public static void main(String args[]) {
		BankAccount savings = new BankAccount("Jimmy");
        savings.deposit(10.00);
        savings.deposit(50.00);
        savings.deposit(10.00);
        savings.deposit(70.00);
        // System.out.println(savings.getTransactions());
        System.out.println(savings.transactionFee(5.00));
        System.out.println(savings.transactionFee(10.00));
    }
}
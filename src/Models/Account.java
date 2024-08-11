package Models;

import interfaces.AccountService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Account  implements AccountService {
    private int accountId;
    private int balance;

    private List<Transaction> transactions;

    public Account(int accountId, int balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public Account(int accountId) {
        this.accountId = accountId;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public Account() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("le montant doit être positif.");
        }
        this.balance += amount;
        int id= transactions.size()+1;
        Transaction transaction=new Transaction(id,amount, LocalDate.now());
         this.transactions.add(transaction);
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(" le montant doit être positif.");
        }
        if (this.balance < amount) {
            throw new IllegalArgumentException("Solde insuffisant.");
        }
        this.balance -= amount;
        int id= transactions.size()+1;
        Transaction transaction=new Transaction(id,-amount, LocalDate.now());
        this.transactions.add(transaction);

    }

    @Override
    public void printStatement() {
        System.out.println("Date       ||Amount|| Balance");
        int currentBalance = balance;

        // Parcourir la liste
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction transaction = transactions.get(i);
            System.out.printf("%s || %d || %d%n", transaction.getDate(), transaction.getAmount(), currentBalance);
            currentBalance -= transaction.getAmount();
        }
    }
}

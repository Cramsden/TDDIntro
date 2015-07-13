package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by carsonramsden on 7/12/15.
 */
public class BankAccount {
    private int balance = 0;

    public BankAccount(int balance){
        this.balance = balance;
    }
    public int getBalance(){
        return balance;
    }
    public void deposit(int depositAmt){
        balance = balance + depositAmt;
    }
    public void withdraw(int withdrawalAmt){
        if (!(withdrawalAmt > balance)) {
            balance = balance - withdrawalAmt;
        }
    }

}

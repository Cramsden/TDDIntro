package com.thoughtworks.tddintro.accountbalance;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    private BankAccount acct;
    //private int initialBalance=100;
    @Before
    public void setUp() throws Exception{
        acct = new BankAccount(100);
    }
    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        //BankAccount acct = new BankAccount(100);
        acct.deposit(50);
        assertThat(acct.getBalance(),is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        //BankAccount acct = new BankAccount(100);
        acct.withdraw(50);
        assertThat(acct.getBalance(),is(50));
    }
    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        acct.withdraw(50);
        acct.withdraw(100);
        assertThat(acct.getBalance(),is(50));
    }
}

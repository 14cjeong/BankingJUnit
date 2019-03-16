package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

//This isn't a normal test class
//we are doing a parameterized test class
//I'm not sure how this goes in JUnit 5
//to specify a parameterized test class
//do the following annotation:
@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Chang", "Jeong", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    //Self-explanatory
    //This lets JUnit know what parameters we are trying to test
    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00}
                //each line from 30-34
                //is the set of parameters we want to test
                //followed by the expected value
                //Now when we run this
                //junit will create a new instance of the
                //bank account test parameterized class
                //for each set of test data
                //But to do that, we also need to do two more
                //things.
                //1) add instance variables for the deposit
                //amount, the branh value, and the expected value
                //2) add a constructor that accepts the values
                //and sets the instance variables.
                //the following is now added to lines 18-20
                //and 22
        });
    }


    @org.junit.Test
    public void deposit() throws Exception{
        //   BankAccount account = new BankAccount("Chang", "Jeong", 1000.00, BankAccount.CHECKING);
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), .01);


    }
}

package com.company;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;
    //remember that static means
    // that you don't have to create an instance of the class
    //to access it. You can just access as is

  //This is to run a method, not before every single test method,
    //but before all the test methods--ONCE.
    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test case. Count = " + count++);

    }
    //This then requires an AfterClass, which is on line 75 ,
    //this will clean up any test code

    @org.junit.Before //this runs before each test method
    public void setup() {
      account = new BankAccount("Chang", "Jeong", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @org.junit.Test
    public void deposit() throws Exception{
        //The reason we are adding these is so that
        //we know that these have yet to be implemented
        //it would be bad to have a false positive,
        //simply because there was nothing in this method

       // BankAccount account = new BankAccount("Chang", "Jeong", 1000.00, BankAccount.CHECKING);
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
        //The third parameter delta is just some leeway, a range,
        // of difference between the expected and actual value

    }

    @org.junit.Test
    public void withdraw_branch() throws Exception{
       double balance = account.withdraw(600.00, true);
       assertEquals(400.00, balance, 0);
    }

    //We have to add in the following parameter
    //to pass the test. (since it throws the exception
    //as expected, the test works.)
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
       /*double balance =*/ account.withdraw(600.00, false);
       //assertEquals(400.00, balance, 0);
    }

    @org.junit.Test
    public void getBalance_deposit() throws Exception{
     //   BankAccount account = new BankAccount("Chang", "Jeong", 1000.00, BankAccount.CHECKING);
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);


    }

    @org.junit.Test
    public void getBalance_withdraw() throws Exception{
     //   BankAccount account = new BankAccount("Chang", "Jeong", 1000.00,BankAccount.CHECKING);
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);


    }

    @org.junit.Test
    public void isChecking_true() {
       // BankAccount account = new BankAccount("Chang", "Jeong", 1000.00,BankAccount.CHECKING);
       // assertEquals(true, account.isChecking());
        assertTrue("The account is NOT a checking account", account.isChecking());
        //The message is putputted when the test fails.
    }

    /*@org.junit.Test
    public void dummyTest() {
        assertEquals(20, 21);

    }*/

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test case. Count = " + count++);
    }
    //also a note, the console output may be out of order
    //and this is because the print statements are spooled
    //to an IO thread. The execution, however, is indeed
    //running in order

    @org.junit.After
     public void teardown() {
        System.out.println("Count = " + count++);
    }
    //likewise, after methods, will run after EACH test method
    //(or unit)

}

//a unit is typically a method.
//so one unit will typically test one method

//Junit tests a method against an assertion
//that we've made about the expected output
//so test fails if the assertion isn't met
//That's why JUnit reports test stubs as passes
//because they simply don't assert anything and so
//no assertions fail

//notice that these test methods are public and void

//What's inside the body is known as an
//"Assertion"

//Good Rule of Thumb
//Every test method should be self-contained and
//not depend on another test method
//We're being scientific here to find the root problem
//so ask yourself. Can this test run on its own?
//Should always be YES
//This is why we're going to have copies of code in each
//test method. Making an instance everytime for example

//other JUnit assertion methods
//assertNotEquals() - we can use this instead of assertEquals()
//assertArrayEquals() - checks to see if arrays are equal in length
//and if every element in both arrays is the same (and in the
//same order).
//assertNull() and assertNotNull(), now we can use assertEquals()
//to check for null, but as with assertTrue() and assertFalse()
//using assertNull() or assertNotNull() makes the intention cleaer
//AND we only have to pass the actual value to the method
//assertSame() and assertNotSame() compares whether two instances
//are the exact same instance.
//Remember that assertEquals() method uses the equals() method
//which tests for equality. assertSame() method compares
//the object references.
//assertThat() - compares the actual value against a matcher
//(a JUnit matcher class, not the Matcher in the JDK)
//This is more powerful than the other assert methods,
//since we can compare the actual value against a range of values










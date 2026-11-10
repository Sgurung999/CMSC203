/*
 * Class: CMSC203 CRN 21305
 * Instructor: Professor Grigoriy Grinberg
 * Description: SavingsAccount is a BankAccount that earns interest.
 *   Each savings account has a number like 100002-0, 100002-1.
 * Due: 11/09/2026
 * Platform/compiler: Eclipse IDE, Java 21
 * I pledge that I have completed the programming assignment
 *   independently. I have not copied the code from a student or
 *   any source. I have not given my code to any student.
 * Print your Name here: Samik Gurung
 */

/**
 * A savings account that earns monthly interest.
 *
 * @author Samik Gurung
 */
public class SavingsAccount extends BankAccount
{
    /** Annual interest rate (2.5%). */
    private double rate = 0.025;

    /** Which savings account this is for the same account number. */
    private int savingsNumber = 0;

    /** Hides the accountNumber in BankAccount. */
    private String accountNumber;

    /**
     * Creates a savings account.
     *
     * @param name the owner of the account
     * @param amount the beginning balance
     */
    public SavingsAccount(String name, double amount)
    {
        super(name, amount);
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    /**
     * Copy constructor: creates another savings account for the same owner.
     *
     * @param oldAccount the savings account to copy
     * @param amount the beginning balance of the new account
     */
    public SavingsAccount(SavingsAccount oldAccount, double amount)
    {
        super(oldAccount, amount);
        savingsNumber = oldAccount.savingsNumber + 1;
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    /**
     * Adds one month of interest to the balance.
     */
    public void postInterest()
    {
        double interest = getBalance() * rate / 12;
        deposit(interest);
    }

    /**
     * Gets the savings account number.
     *
     * @return the account number, for example 100002-0
     */
    @Override
    public String getAccountNumber()
    {
        return accountNumber;
    }
}

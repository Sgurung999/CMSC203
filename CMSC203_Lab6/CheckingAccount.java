/*
 * Class: CMSC203 CRN 21305
 * Instructor: Professor Grigoriy Grinberg
 * Description: CheckingAccount is a BankAccount that charges a fee
 *   for each check and has an account number ending in -10.
 * Due: 11/09/2026
 * Platform/compiler: Eclipse IDE, Java 21
 * I pledge that I have completed the programming assignment
 *   independently. I have not copied the code from a student or
 *   any source. I have not given my code to any student.
 * Print your Name here: Samik Gurung
 */

/**
 * A checking account that charges a fee to clear each check.
 *
 * @author Samik Gurung
 */
public class CheckingAccount extends BankAccount
{
    /** Cost of clearing one check. */
    private static final double FEE = 0.15;

    /**
     * Creates a checking account and adds -10 to the account number.
     *
     * @param name the owner of the account
     * @param amount the beginning balance
     */
    public CheckingAccount(String name, double amount)
    {
        super(name, amount);
        setAccountNumber(getAccountNumber() + "-10");
    }

    /**
     * Withdraws the amount plus the check fee.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal worked, false otherwise
     */
    @Override
    public boolean withdraw(double amount)
    {
        return super.withdraw(amount + FEE);
    }
}

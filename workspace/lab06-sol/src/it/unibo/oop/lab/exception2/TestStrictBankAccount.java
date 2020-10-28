package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link it.unibo.oop.lab.exception2.StrictBankAccount}.
 */
public class TestStrictBankAccount {

	private static final int MAX_ATM_TRANSACTIONS = 10;
    private static final int INITIAL_AMOUNT = 10_000;
    private static final int TOO_MUCH = 50_000;

    /**
     * Used to test Exceptions on
     * {@link it.unibo.oop.lab.exception2.StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {

        final AccountHolder usr1 = new AccountHolder("Mario", "Rossi", 1);
        final AccountHolder usr2 = new AccountHolder("Luigi", "Bianchi", 2);
        final StrictBankAccount account1 = new StrictBankAccount(usr1.getUserID(), INITIAL_AMOUNT, MAX_ATM_TRANSACTIONS);
        final StrictBankAccount account2 = new StrictBankAccount(usr2.getUserID(), INITIAL_AMOUNT, MAX_ATM_TRANSACTIONS);
        try {
            account1.deposit(4, 100);
            fail();
        } catch (WrongAccountHolderException e) {
            assertNotNull(e);
        }
        for (int i = 0; i < MAX_ATM_TRANSACTIONS; i++) {
            try {
                account2.depositFromATM(usr2.getUserID(), 1);
            } catch (TransactionsOverQuotaException | WrongAccountHolderException e) {
                fail("Not exceeded yet max no. transactions!");
            }
        }
        try {
            account2.depositFromATM(usr2.getUserID(), 1);
            fail("Should raise the exception signaling that we exceeded max no. transactions!");
        } catch (TransactionsOverQuotaException | WrongAccountHolderException e) {
            assertNotNull(e);
        }
        try {
            account1.withdraw(usr1.getUserID(), TOO_MUCH);
        } catch (WrongAccountHolderException e) {
            fail();
        } catch (NotEnoughFoundsException e) {
            assertNotNull(e);
        }
    }

}

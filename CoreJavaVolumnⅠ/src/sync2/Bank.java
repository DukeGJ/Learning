package sync2;

import java.util.Arrays;

/**
 * A bank with a number of bank accounts that uses locks for serializing access.
 * 
 * @author GJ
 *
 */
public class Bank {

	private final double[] accounts;

	/**
	 * Constructs the bank
	 * 
	 * @param n
	 *            the number of accounts
	 * @param initialBalance
	 *            the initial balance for each account
	 */
	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		Arrays.fill(accounts, initialBalance);
	}

	/**
	 * Transfers money form one account to another.
	 * 
	 * @param from
	 *            the account to transfer from
	 * @param to
	 *            the account to transfer to
	 * @param amount
	 *            the amount to transfer
	 * @throws InterruptedException
	 */
	public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
		while (accounts[from] < amount) {
			wait();
		}
		System.out.println(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf("%10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.printf(" Total balance:%10.2f%n", getTotalBalance());
		notifyAll();
	}

	/**
	 * Gets the sum of all account balances.
	 * 
	 * @return the total balance
	 */
	public synchronized double getTotalBalance() {
		double sum = 0;
		for (double d : accounts) {
			sum += d;
		}
		return sum;
	}

	/**
	 * Gets the number of accounts in the bank.
	 * 
	 * @return the number of accounts
	 */
	public int size() {
		return accounts.length;
	}
}

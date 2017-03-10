package ATM;

import java.util.ArrayList;

/**
 * Created by Jason on 11/13/2016.
 */
public class Bank {
	private ArrayList<Account> checkingAccounts;
	private ArrayList<Account> savingsAccounts;


	public Bank() {
		checkingAccounts = new ArrayList();
		savingsAccounts = new ArrayList();
		// Hard coded accounts to save on time versus creating a file to hold this.
		Account acct1 = new Account(123456, "John Doe", "savings", 2000.00);
		savingsAccounts.add(acct1);
		Account acct2 = new Account(123457, "John Doe", "checking", 5000.00);
		checkingAccounts.add(acct2);
	}

	public Account getAccount(String accountHolder, String accountType) {
		ArrayList<Account> accountsList;
		if(accountType.equals("savings")) accountsList = savingsAccounts;
		else accountsList = checkingAccounts;

		for (int i = 0; i < accountsList.size(); i++){
			Account a = accountsList.get(i);
			if(accountHolder.equals(a.accountHolder)){
				return a;
			}
		}

		System.out.println("No such account found.");
		return null;
	}

	public void createTransaction(double amount, Account account){
		Transaction t = new Transaction(amount);
		account.addTransaction(t);
	}
}

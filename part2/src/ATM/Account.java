package ATM;

import java.util.ArrayList;

/**
 * Created by Jason on 11/13/2016.
 */
public class Account {
	int accountNumber;
	String accountHolder;
	String accountType;
	private ArrayList<Transaction> transactions;
	private Double currentBalance;

	public Account(int accountNumber, String name, String accountType, double startBal){
		this.accountNumber = accountNumber;
		accountHolder = name;
		this.accountType = accountType;
		transactions = new ArrayList<>();
		currentBalance = startBal;
	}

	public void addTransaction(Transaction t){
		transactions.add(t);
		currentBalance += t.getAmount();
	}

	public double getCurrentBalance(){
		return currentBalance;
	}

	public void printTransactions(){
		for(int i = 0; i < transactions.size(); i++){
			transactions.get(i).print();
		}
	}
}

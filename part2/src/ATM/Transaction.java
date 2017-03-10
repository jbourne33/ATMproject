package ATM;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jason on 11/13/2016.
 */
public class Transaction {
	private String transactionType;
	private String date;
	private double amount;
	protected double balanceAfterTransaction;

	public Transaction(double amount){
		DateFormat df = new SimpleDateFormat("dd/MM/YY HH:mm:ss");
		Date dateobj = new Date();
		if (amount < 0){ // negative amount, debit transaction
			transactionType = "debit";
		}

		if (amount > 0) { // positive amount, credit transaction
			transactionType = "credit";
		}

		date = df.format(dateobj);
		this.amount = amount;
	}

	public void print(){
		System.out.println(date + "  " + transactionType + "........." + amount + "  "
				+ balanceAfterTransaction);
	}

	public double getAmount(){return amount;}

}

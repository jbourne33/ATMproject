package ATM;

import java.util.Scanner;

/**
 * Created by jbourne33 on 11/7/16.
 */
public class ATM {
	String user;
	private Bank theBank = new Bank(); // create "connection" to bank system
	private Integer cashInATM = 10000;

	public ATM(String userName) {
		user = userName;
		System.out.println("Welcome to your bank"+ user +"!");
		// run welcome
		welcome();
		// run transaction loops
	}

	private void welcome() {
		while(true) {
			System.out.println("\nWhat can we help you with today?");
			System.out.println("Select one of the following options by typing in the " +
					"corresponding number and pressing enter:");
			System.out.print(
					"1) Make a withdrawal\n" +
							"2) Make a deposit\n" +
							"3) View account balances\n" +
							"4) Exit\n");
			Scanner s = new Scanner(System.in);
			char selection = s.next().charAt(0);
			switch (selection) {
				case '1':
					withdrawal();
					continue;
				case '2':
					deposit();
					continue;
				case '3':
					printStatement();
					continue;
				case '4':
					exit();
				default:
					System.out.println("That is not an option. Please choose an option " +
							"between 1 and 4 on the keyboard.");
			}
			askExit();
		}
	}

	private void deposit(){
		char selection;

		System.out.println("Would you like to deposit to your Savings or Checking " +
				"account? Enter \"1\" for Savings and \"2\" for Checking");
		Scanner s = new Scanner(System.in);
		selection = s.next().charAt(0);

		String accountType;
		switch(selection) {
			case '1' :
				accountType = "savings";
			case '2' :
				accountType = "checking";
			default :
				accountType = "checking";
		}

		Account targetAccount = theBank.getAccount(user,accountType);

		System.out.println("Enter amount of cash/check(s) to be deposited:");
		double amount = s.nextDouble();

		System.out.println("Great! Now pretend to insert the checks/cash");

		theBank.createTransaction(amount, targetAccount);
		System.out.println("Your new balance is:" + targetAccount.getCurrentBalance());
	}

	private void withdrawal(){
		char selection;

		System.out.println("Would you like to withdraw from your Savings or Checking " +
				"account? Enter \"1\" for Savings and \"2\" for Checking");
		Scanner s = new Scanner(System.in);
		selection = s.next().charAt(0);

		String accountType;
		switch(selection) {
			case '1' :
				accountType = "savings";
			case '2' :
				accountType = "checking";
			default :
				accountType = "checking";
		}

		Account targetAccount = theBank.getAccount(user,accountType);

		System.out.println("Enter amount of cash/check(s) to withdraw in whole numbers:");
		double amount = s.nextDouble();
		amount = -1.0 * amount;
		theBank.createTransaction(amount, targetAccount);

		System.out.println("Take pretend cash from the dispenser now.");
		System.out.println("Your new balance is:" + targetAccount.getCurrentBalance());
	}

	private void printStatement(){
		char selection;

		System.out.println("Would you like to print your Savings or Checking " +
				"account? Enter \"1\" for Savings and \"2\" for Checking");
		Scanner s = new Scanner(System.in);
		selection = s.next().charAt(0);

		String accountType;
		switch(selection) {
			case '1' :
				accountType = "savings";
			case '2' :
				accountType = "checking";
			default :
				accountType = "checking";
		}

		Account targetAccount = theBank.getAccount(user,accountType);

		System.out.println("Account Number:" + targetAccount.accountNumber);
		System.out.println("Account Type:" + targetAccount.accountType);
		System.out.println("Account Holder:" + targetAccount.accountHolder);
		System.out.println("Current Balance:" + targetAccount.getCurrentBalance());
		targetAccount.printTransactions();
	}

	private void askExit(){
		System.out.println("Do you want to do another transaction? Enter \"y or n\" and" +
				" " +
				"press enter.");
		String yn = System.console().readLine();
		if(yn.equals("y")) welcome();
		else exit();
	}

	private void exit() {
		System.out.println("Thanks for stopping by!");
		System.exit(0);
	}
}
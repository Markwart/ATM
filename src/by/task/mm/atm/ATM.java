package by.task.mm.atm;

public class ATM {

	private static int currentAccount;

	public static int getCurrentAccount() {
		return currentAccount;
	}

	public static void setCurrentAccount(int currentAccount) {
		ATM.currentAccount = currentAccount;
	}
}

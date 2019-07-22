package by.task.mm.atm;

public class Operation {

	private Validation validation;
	private ATM atm;

	public void checkBalance(BankCard bankCard) {
		System.out.println(bankCard.getBalance());
		// newOperation(bankCard);
	}

	public void addCash(BankCard bankCard) {
		InputData inputData = new InputData();
		Cash cash = new Cash();
		cash.setCash(inputData.enterCash());

		if (validation.validAddedAmount(cash.getCash())) {
			int newBalance = bankCard.getBalance() + cash.getCash();
			bankCard.setBalance(newBalance);
			atm.setCurrentAccount(atm.getCurrentAccount() + cash.getCash());
			System.out.println("Operation completed successfully.");
		} else {
			System.out.println("The amount is too large. Try again.");
			inputData.enterCash();
		}
		// newOperation(bankCard);
	}

	public void withdrawCash(BankCard bankCard) {
		InputData inputData = new InputData();
		Cash cash = new Cash();
		cash.setCash(inputData.enterCash());

		if (validation.validWithdrawnAmount(cash.getCash(), bankCard.getBalance())) {
			int newBalance = bankCard.getBalance() - cash.getCash();
			bankCard.setBalance(newBalance);
			atm.setCurrentAccount(atm.getCurrentAccount() - cash.getCash());
			System.out.println("Operation completed successfully.");
		} else {
			System.out.println("The amount is too large. Try again.");
			inputData.enterCash();
		}
		// newOperation(bankCard);
	}

	public void newOperation(BankCard bankCard) {
		InputData inputData = new InputData();
		System.out.println("Do you want to perform another operation?");
		inputData.continueWork(bankCard);
	}
}

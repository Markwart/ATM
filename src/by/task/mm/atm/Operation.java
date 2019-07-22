package by.task.mm.atm;

public class Operation {

	Validation validation = new Validation();
	InputData inputData = new InputData();
	Cash cash = new Cash();

	public void checkBalance(BankCard bankCard) {
		System.out.println(bankCard.getBalance());
		newOperation(bankCard);
	}

	public void addCash(BankCard bankCard) {
		cash.setCash(inputData.enterCash());

		if (validation.validAddedAmount(cash.getCash())) {
			int newBalance = bankCard.getBalance() + cash.getCash();
			bankCard.setBalance(newBalance);
			ATM.setCurrentAccount(ATM.getCurrentAccount() + cash.getCash());
			System.out.println("Operation completed successfully.");
			//System.out.println("Your balance - " + bankCard.getBalance());
			// System.out.println(ATM.getCurrentAccount());
		} else {
			System.out.println("The amount is too large. Try again.");
			addCash(bankCard);
		}
		newOperation(bankCard);
	}

	public void withdrawCash(BankCard bankCard) {
		cash.setCash(inputData.enterCash());

		if (validation.validWithdrawnAmount(cash.getCash(), bankCard.getBalance())) {
			int newBalance = bankCard.getBalance() - cash.getCash();
			bankCard.setBalance(newBalance);
			ATM.setCurrentAccount(ATM.getCurrentAccount() - cash.getCash());
			System.out.println("Operation completed successfully.");
			//System.out.println("Your balance - " + bankCard.getBalance());
			// System.out.println(ATM.getCurrentAccount());
		} else {
			System.out.println("The amount is too large. Try again.");
			withdrawCash(bankCard);
		}
		newOperation(bankCard);
	}

	public void newOperation(BankCard bankCard) {
		InputData inputData = new InputData();
		System.out.printf("\nDo you want to perform another operation?\n");
		inputData.continueWork(bankCard);
	}
}

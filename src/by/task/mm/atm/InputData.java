package by.task.mm.atm;

import java.util.Scanner;

public class InputData {

	Scanner scanner = new Scanner(System.in);
	Validation validation = new Validation();

	public String enterCardNumber() {
		String cardNumber = null;
		System.out.println("Please, enter card number:");
		try {
			cardNumber = scanner.next();

			if (!validation.validCardNumber(cardNumber)) {
				System.out.println("Incorrectly entered card number! Try again.");
				enterCardNumber();
			}
		} catch (Exception e) {
			System.out.println("Incorrectly entered card number! Try again.");
			enterCardNumber();
		}
		return cardNumber;
	}

	public int enterPIN() {
		int pin = 0;
		System.out.println("Please, enter pin:");
		try {
			pin = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Incorrectly entered pin! Try again.");
			enterPIN();
		}
		return pin;
	}

	public void enterOperation(BankCard bankCard) {
		System.out.println("Choose operation, enter the number:");
		System.out.printf("1. Check the balance \n2. Withdraw cash \n3. Top up balance \n");

		Operation operation = new Operation();

		int numberOperation = 0;
		try {
			numberOperation = scanner.nextInt();

			switch (numberOperation) {
			case 1:
				operation.checkBalance(bankCard);
				break;
			case 2:
				operation.withdrawCash(bankCard);
				break;
			case 3:
				operation.addCash(bankCard);
				break;
			default:
				System.out.println("Incorrectly entered operation number! Try again.");
				enterOperation(bankCard);
				break;
			}
		} catch (Exception e) {
			System.out.println("Incorrectly entered operation number! Try again.");
			enterOperation(bankCard);
		}
	}

	public int enterCash() {
		System.out.println("Enter desirable sum:");

		int cash = 0;
		try {
			cash = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Incorrectly entered sum. Try again.");
			enterCash();
		}
		return cash;
	}

	public void continueWork(BankCard bankCard) {
		System.out.printf("1. Yes / 2. No \n");

		int operation = 0;
		try {
			operation = scanner.nextInt();
			switch (operation) {
			case 1:
				enterOperation(bankCard);
				break;
			case 2:
				System.out.println("Thank you for choosing our Bank.");
				break;
			}
		} catch (Exception e) {
			System.out.println("Incorrectly entered operation! Try again.");
			continueWork(bankCard);
		}
	}
}

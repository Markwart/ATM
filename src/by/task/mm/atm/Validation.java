package by.task.mm.atm;

public class Validation {

	private ATM atm;

	public boolean validAddedAmount(int cash) {
		boolean result = (cash <= 1000000);
		return result;
	}

	public boolean validWithdrawnAmount(int cash, int balance) {
		boolean result = (cash <= balance & cash <= atm.getCurrentAccount());
		return result;
	}

	public boolean validCardNumber(String cardNumber) {
		boolean result = cardNumber.matches("\\d{4}(\\-*)\\d{4}(\\-*)\\d{4}(\\-*)\\d{4}");
		return result;
	}

}

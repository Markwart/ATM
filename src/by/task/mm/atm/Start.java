package by.task.mm.atm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		ATM atm = new ATM();
		atm.setCurrentAccount(5000);

		InputData inputData = new InputData();
		Validation validation = new Validation();

		List<BankCard> cardList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("data/personal_data.txt"));) {
			String strLine;
			while ((strLine = br.readLine()) != null) {
				String[] wordsArray = strLine.split("\\s");

				BankCard bankCard = new BankCard();
				bankCard.setNumber(wordsArray[0]);
				bankCard.setPin(Integer.parseInt(wordsArray[1]));
				bankCard.setBalance(Integer.parseInt(wordsArray[2]));

				cardList.add(bankCard);
			}
		}

		System.out.println(
				cardList.get(2).getNumber() + " " + cardList.get(2).getPin() + " " + cardList.get(2).getBalance());

		String cardNumber = inputData.enterCardNumber();
		int pin = inputData.enterPIN();

		// validation.checkNumberAndPIN(cardList,cardNumber, pin);

		for (BankCard bankCard : cardList) {
			if (bankCard.getNumber().contains(cardNumber) & pin == bankCard.getPin()) {
				inputData.enterOperation(bankCard);
				break;
			} else if (bankCard.getNumber().contains(cardNumber) & pin != bankCard.getPin()) {
				System.out.println("The card number or pin was entered incorrectly. Try again.");
				break;
			}
		}

	}
}

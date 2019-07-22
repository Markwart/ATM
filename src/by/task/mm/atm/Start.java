package by.task.mm.atm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		ATM.setCurrentAccount(5000);

		InputData inputData = new InputData();

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
		/*
		 * System.out.println("card number: " + cardList.get(2).getNumber() + " pin: " +
		 * cardList.get(2).getPin() + " balance: " + cardList.get(2).getBalance());
		 */

		enterNumberAndPIN(inputData, cardList);

		try (BufferedWriter wr = new BufferedWriter(new FileWriter("data/personal_data.txt", false));) {
			for (BankCard bankCard : cardList) {
				wr.write(bankCard.getNumber() + " " + bankCard.getPin() + " " + bankCard.getBalance()
						+ System.getProperty("line.separator"));
			}
			wr.flush();
			wr.close();
		}
	}

	private static void enterNumberAndPIN(InputData inputData, List<BankCard> cardList) {
		String cardNumber = inputData.enterCardNumber();
		int pin = inputData.enterPIN();

		for (BankCard bankCard : cardList) {
			if (bankCard.getNumber().contains(cardNumber) & pin == bankCard.getPin()) {
				inputData.enterOperation(bankCard);
				break;
			} else if (bankCard.getNumber().contains(cardNumber) & pin != bankCard.getPin()) {
				System.out.println("The card number or pin was entered incorrectly. Try again.");
				enterNumberAndPIN(inputData, cardList);
			}
		}
	}
}

package by.task.mm.atm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dfg {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Scanner scanner = new Scanner(System.in);

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

		String cardNumber = null;
		System.out.println("Please, enter card number:");
		try {
			cardNumber = scanner.next();
		} catch (Exception e) {
			System.out.println("Incorrectly entered card number! Try again.");
		}

		String str = cardNumber;
		boolean result = str.matches("\\d{4}(\\-*)\\d{4}(\\-*)\\d{4}(\\-*)\\d{4}");

		if (result) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
		scanner.close();
	}

}

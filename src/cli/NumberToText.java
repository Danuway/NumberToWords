package cli;

import java.util.Scanner;

import converter.Number;

public class NumberToText {


	/**
	 * This function takes an integer value and returns its text
	 * literal / literal name in String
	 *
	 * TODO: Recomend using StringBuilder class:
	 * StringBuilder sb = new StringBuilder(getDigitsAt/getOnes...);
	 * sb.append(" ");
	 * sb.append(getMiles());
	 * ...
	 * return sb.toStrding();
	 *
	 * @return String
	 */


	public static void main(String[] args) {
		System.out.print("Enter a number :");
		Scanner cin = new Scanner(System.in);

		int input = cin.nextInt();

		cin.close();

		Number number = new Number(input);

		number.showNumberInText();
	}
}

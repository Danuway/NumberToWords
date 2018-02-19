package converter;
import cli.Display;


public class Number {

	/**
	 * Create a method that converts a numeric number and returns
	 * a text string with the same number in words.
	 * English or Swedish.
	 *
	 * Ex.
	 * String result = numberToWords(29);
	 *
	 * Print:
	 * Twenty Nine
	 *
	 */
	private int number;
	private int [] digits;
	private int counter = 0; // Counts the number of digits, or number of elements.
	private Computation expectedValue;
	private TextValueDatas textValue;
	private String result;

	/**
	 * Constructor
	 */
	public Number(int number) {
		this.number = number;
		this.digits = new int[7];
		this.textValue = new TextValueDatas();
		this.expectedValue = new Computation(this,textValue);
		numberToWords();
	}


	public int getDigitsAt(int index) {
		return digits[index];
	}


	public void numberToWords(){
		result = constructString();
	}

	private String constructString(){
		collectDigitsOfNumbers();
		StringBuilder coefficient = new StringBuilder();
		for (int i = counter; i >= 0; i--) {

			if (counter == i) {
				coefficient.append(coef(i));
				coefficient.append(" ");
			}else {
				do{
					if(this.digits[i] != 0){
						coefficient.append(coef(i));
						coefficient.append(" ");
						if (expectedValue.hasPreceedingSignificantCoefficients(counter)) {
							coefficient.append(pow(i));
						}

						coefficient.append(" ");
						--counter;
					}

				}while(expectedValue.hasRemainingSignificantCoefficients(counter));
			}

		}
		return coefficient.toString();
	}

	private void collectDigitsOfNumbers(){
		int inputNumber = this.number;
		while (inputNumber > 0) {
			this.digits[counter] = inputNumber % 10;
			inputNumber /= 10;
			counter++;
		}
		counter--;
	}

	private String coef(int num){
		return this.expectedValue.getNumberLiteral(num);
	}


	private String pow(int num){
		return expectedValue.getPowersOfNumbers(num);
	}


	public int getNumberOfElements() {
		return counter;
	}


	public void showNumberInText() {
		Display display = new Display();
		display.displayResult(result);
	}


}

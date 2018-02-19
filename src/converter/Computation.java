package converter;

public class Computation {

	//TODO: Collect the logic from TextValueDatas.java to here
	private Number computableNumber;
	private TextValueDatas textValue;
	private int traversal = 0;
	private StringBuilder sb;


	/**
	 * @param computableNumber
	 * @param textValue
	 */
	public Computation(Number computableNumber, TextValueDatas textValue) {
		this.computableNumber = computableNumber;
		this.textValue = textValue;
		this.sb = new StringBuilder();
	}

	/**
	 * TODO: Force this method to be private and use this->computableNumber
	 * So that all external objects should through declaration of number class
	 * @param number
	 * @param n
	 * @return
	 */

	public String getNumberLiteral(int number) {
		if (computableNumber.getNumberOfElements() == 1) {
			try {
				sb.append(textValue.getTenth(number));
			} catch (NumberNotFound e) {
				e.printStackTrace();
			}
		}

		else if (computableNumber.getNumberOfElements() == 2) {
			try {
				sb.append(textValue.getOnes(number));
				sb.append(" ");
				sb.append(textValue.getMils(number));
			} catch (NumberNotFound e) {
				e.printStackTrace();
			}
		}

		else if (computableNumber.getNumberOfElements() == 3) {
			try {
				sb.append(textValue.getOnes(number));
				sb.append(" ");
				sb.append(textValue.getMils(++number));
			} catch (NumberNotFound e) {
				e.printStackTrace();
			}
		}

		else if (computableNumber.getNumberOfElements() == 4) {
			try {
				if (computableNumber.getDigitsAt(number) == 1) {
					sb.append(textValue.getTenth(number));
					sb.append(" ");
					sb.append(textValue.getMils(++number));
				}else {
					sb.append(textValue.getThous(number));
					sb.append(" ");
					sb.append(textValue.getMils(++number));
				}

			} catch (NumberNotFound e) {
				e.printStackTrace();
			}
		}

		else if (computableNumber.getNumberOfElements() == 5) {
			try {

				sb.append(textValue.getMils(number));
				sb.append(" ");
				sb.append(textValue.getMils(++number));

			} catch (NumberNotFound e) {
				e.printStackTrace();
			}
		}

		else if (computableNumber.getNumberOfElements() == 6) {
			try {
				sb.append(textValue.getTenth(number));
				sb.append(" ");
				sb.append(textValue.getMils(++number));
			}
			catch (NumberNotFound e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}


	public boolean hasRemainingSignificantCoefficients(int index) {
		for (int i = 1; i <= index; i++) {
			if (index > 0 && computableNumber.getDigitsAt(index - i ) == 0) {
				traversal = 1;
			}
		}
		return (traversal == 0)?true:false;
	}

	public boolean hasPreceedingSignificantCoefficients(int index) {

		if (index > 0 && computableNumber.getDigitsAt(--index ) == 0) {
			traversal = 1; 
		}
		return (traversal == 0)?true:false;
	}

	public String getPowersOfNumbers(int num) {
		switch (num) {
		case 12:
			try {
				if (num > 1 && hasPreceedingSignificantCoefficients(num)) {
					if (hasRemainingSignificantCoefficients(num)) {
						sb.append(textValue.getMils((6)));
						sb.append(" ");
						return sb.toString() + " " + getPowersOfNumbers(--num);
					}else {
						sb.append(textValue.getMils((6)));
						sb.append(" ");
						return sb.toString() + " " + getPowersOfNumbers(num-=2);
					}
				}else {
					sb.append(textValue.getMils((6)));
					sb.append(" ");
					sb.append(textValue.getMils(2));
					return sb.toString();
				}


			} catch (NumberNotFound e) {
				e.printStackTrace();
				break;
			}
		case 9:
			try {
				if (hasPreceedingSignificantCoefficients(num)) {
					if (hasRemainingSignificantCoefficients(num)) {
						sb.append(textValue.getMils((5)));
						sb.append(" ");
						return sb.toString() + " " + getPowersOfNumbers(--num);
					}else {
						sb.append(textValue.getMils((5)));
						sb.append(" ");
						return sb.toString() + " " + getPowersOfNumbers(num-=2);
					}
				}else {
					sb.append(textValue.getMils((5)));
					sb.append(" ");
					sb.append(textValue.getMils(2));
					return sb.toString();
				}
			} catch (NumberNotFound e) {
				e.printStackTrace();
				break;
			}
		case 6:
			try {
				if (hasPreceedingSignificantCoefficients(num)) {
					if (hasRemainingSignificantCoefficients(num)) {
						sb.append(textValue.getMils((4)));
						sb.append(" ");
						return sb.toString() + " " + getPowersOfNumbers(--num);
					}else {
						sb.append(textValue.getMils((4)));
						sb.append(" ");
						return sb.toString() + " " + getPowersOfNumbers(num-=2);
					}
				}else {
					sb.append(textValue.getMils((4)));
					sb.append(" ");
					sb.append(textValue.getMils(2));
					return sb.toString();
				}
			}catch (NumberNotFound e) {
				e.printStackTrace();
				break;
			}
		case 3:
			try {
				if (hasPreceedingSignificantCoefficients(num)) {
					if (hasRemainingSignificantCoefficients(num)) {
						sb.append(textValue.getMils((3)));
						sb.append(" ");
						return sb.toString() ;
					}else {
						sb.append(textValue.getMils((3)));
						sb.append(" ");
						return sb.toString();
					}
				}else {
					sb.append(textValue.getMils((3)));
					sb.append(" ");
					sb.append(textValue.getMils(2));
					return sb.toString();
				}
			} catch (NumberNotFound e) {
				e.printStackTrace();
				break;
			}
		case 2:
			try {
				if (hasPreceedingSignificantCoefficients(num)) {
					if (hasRemainingSignificantCoefficients(num)) {
						sb.append(textValue.getMils((2)));
						sb.append(" ");
						return sb.toString();
					}else {
						sb.append(textValue.getMils((2)));
						sb.append(" ");
						return sb.toString();
					}
				}else {
					sb.append(textValue.getMils((2)));
					sb.append(" ");
					sb.append(textValue.getMils(2));
					return sb.toString();
				}
			}catch (NumberNotFound e) {
				e.printStackTrace();
				break;
			}
		default:
			try {
				if (hasPreceedingSignificantCoefficients(num)) {
					if (hasRemainingSignificantCoefficients(num)) {
						sb.append(textValue.getThous(num));
						sb.append(" ");
						return sb.toString();
					}

				}

			} catch (NumberNotFound e) {
				e.printStackTrace();
			}
			break;
		}
		return sb.toString();

	}


}

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
		try {
			return textValue.getOnes(number);
		} catch (NumberNotFound e) {
			System.out.println("Invalid number...");
			e.printStackTrace();
		}

		return null;
}


	public boolean hasRemainingSignificantCoefficients(int index) {
			for (int i = 1; i <= index; i++) {
				if (computableNumber.getDigitsAt(index - i ) == 0) {
					traversal = 1;
				}
			}
			return (traversal == 0)?true:false;
		}

	public boolean hasPreceedingSignificantCoefficients(int index) {

			if (computableNumber.getDigitsAt(--index ) == 0) {
				traversal = 1;
		}
		return (traversal == 0)?true:false;
	}

	public String getPowersOfNumbers(int num) {
		switch (num) {
		case 12:
			try {
				return textValue.getMils((6));
			} catch (NumberNotFound e) {
				e.printStackTrace();
				break;
			}
		case 9:
			try {
				return textValue.getMils((5));
			} catch (NumberNotFound e) {
				e.printStackTrace();
				break;
			}
		case 6:
			try {
				return textValue.getMils((4));
			} catch (NumberNotFound e) {
				e.printStackTrace();
				break;
			}
		case 3:
			try {
				return textValue.getMils((3));
			} catch (NumberNotFound e) {
				e.printStackTrace();
				break;
			}
		case 2:
			try {
				return textValue.getMils((2));
			} catch (NumberNotFound e) {
				e.printStackTrace();
				break;
			}
		default:
			break;
		}
		return null;


//			if (num == 3 ){
//			if (!hasRemainingSignificantCoefficients(num)) {
//
//				try {
//					sb.append(textValue.getOnes(computableNumber.getDigitsAt(num)));
//				} catch (NumberNotFound e) {
//					System.out.println("The input nnumber is invalid");
//					System.exit(1);
//				}
//
//				sb.append(" ");
//				try {
//					sb.append(textValue.getMils(num));
//				} catch (NumberNotFound e) {
//					System.out.println("The input nnumber is invalid");
//					System.exit(1);
//				}
//				return sb.toString();
//			}
//
//			else if (hasRemainingSignificantCoefficients(num)) {
//				try {
//					sb.append(textValue.getOnes(computableNumber.getDigitsAt(num)));
//				} catch (NumberNotFound e) {
//					e.printStackTrace();
//					System.out.println("The input nnumber is invalid");
//					System.exit(1);
//
//				}
//				sb.append(" ");
//				try {
//					sb.append(textValue.getMils(num));
//				} catch (NumberNotFound e) {
//					e.printStackTrace();
//					System.out.println("The input nnumber is invalid");
//					System.exit(1);
//				}
//				sb.append(" ");
//				try {
//					if(computableNumber.getDigitsAt(num - 1) > 1){
//						sb.append(textValue.getThous(num - 1));
//						sb.append(textValue.getOnes(computableNumber.getDigitsAt(num - 2)));
//					}
//					else
//						sb.append(textValue.getTenth(computableNumber.getDigitsAt(num - 2)));
//				} catch (NumberNotFound e) {
//					e.printStackTrace();
//					System.out.println("The input nnumber is invalid");
//					System.exit(1);
//
//				}
//				return sb.toString();
//			} else
//				return null;
//		}
//		else
//			return null;
		}


	}

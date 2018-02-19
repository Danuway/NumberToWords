package converter;

public class TextValueDatas {
	/**
	 * First trial
	 * ========================
	 * Assume representing numbers like coefficient names and powers of ten.
	 * =====================================================================
	 *
	 */
	private String[] mils;
	private String[] ones;
	private String[] tenth;
	private String[] thous;
	public TextValueDatas() {
		this.mils = new String[] {"","" ,"hundred","thousand","million", "billion","trillion"};
		this.ones = new String[] {"","one","two","three","four","five","six","seven","eight","nine"};
		this.tenth = new String[] {"ten","eleven","twelve","thirteen", "fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		this.thous = new String[] {"","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	}


	public String getMils(int num) throws NumberNotFound {
		if (num < 5) {
			return mils[num];
		}
		throw new NumberNotFound();
	}


	public String getOnes(int num) throws NumberNotFound {
		if (num < 9) {
			return ones[num];
		}
		throw new NumberNotFound();
	}

	public String getTenth(int num) throws NumberNotFound {
		if (num < 9) {
			return tenth[num];
		}
		throw new NumberNotFound();
	}

	public String getThous(int num) throws NumberNotFound {
		if (num < 8) {
			return thous[num];
		}
		throw new NumberNotFound();
	}


}
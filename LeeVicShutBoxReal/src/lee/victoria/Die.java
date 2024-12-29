package lee.victoria;
import java.util.Random;

public class Die {
	
	private int value;
	private int numSides;
	Random random = new Random();
	
	/**
	 * Purpose: Cdosjdsf
	 * @param n
	 */
	public Die(int n) {
		this.numSides = n;
		this.value = roll();
	}
	/**
	 * 
	 */
	public Die() {
		this.numSides = 6;
		this.value = roll();
	}
	//test test test
	//test test II
	/**
	 * 
	 * @return
	 */
	public int roll() {
		return random.nextInt(numSides)+1;
	}
	public int roll2() {
		//rolling a minimum of 2, maximum of 12
		return random.nextInt(11)+2;
	}
}

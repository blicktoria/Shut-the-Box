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
	/**
	 * 
	 * @return
	 */
	public int roll() {
		return random.nextInt(numSides)+1;
	}
	public int roll2() {
		return random.nextInt(12)+1;
	}
}

package lee.victoria;
import java.util.Random;
/**
 * Purpose: Create Die objects to be rolled in the Shut the Box game
 * @author V. Lee
 * @date December 29 2024
 */
public class Die {
	
	//private int value;
	private int numSides;
	Random random = new Random();
	
	/**
	 * Purpose: When an integer value of sides is provided, initialize a Die object with n sides
	 * @param n int number of Die sides
	 */
	public Die(int n) {
		this.numSides = n;
		//this.value = roll();
	}
	/**
	 * Purpose: When no other parameters are provided, initialize a Die object with 6 sides 
	 */
	public Die() {
		this.numSides = 6;
		//this.value = roll();
	}
	
	
	/**
	 * Purpose: to roll a Die object
	 * @return Random integer of a certain range, depending on the number of sides
	 */
	public int roll() {
		return random.nextInt(numSides)+1;
	}
	
}

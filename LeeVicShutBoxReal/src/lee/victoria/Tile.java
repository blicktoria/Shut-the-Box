package lee.victoria;

public class Tile {
	private int value;
	private boolean isUp;
	
	Tile(int n){
		value = n;
		isUp = true;
	}
	public int getValue() {
		return value;
	}
	
	public boolean isUp() {
		return isUp;
	}
	
	public void putDown() {
		isUp = false;
	}
	
	//i would always override toString
	@Override
	public String toString() {
		String response = "";
		if (isUp) {
			response = "Value " + value + " : UP ";
		}
		else {
			response = "Value " + value + " : DOWN ";
		}
		return response;
	}




}
package logic;

import java.util.HashMap;

public class ResistorObject {
	HashMap<String, Integer> digit1;
	HashMap<String, Integer> digit2;
	HashMap<String, Integer> digit3;
	HashMap<String, Float> multiplier;
	HashMap<String, String> tolerance;
	HashMap<String, Integer> tempCoeff;
	
	
	public HashMap<String, Integer> getDigit1(String color) {
		return digit1;
	}
	
	
	public HashMap<String, Integer> getDigit2(String color) {
		return digit2;
	}
	
	
	public HashMap<String, Integer> getDigit3(String color) {
		return digit3;
	}
	
	
	public HashMap<String, Float> getMultiplier(String color) {
		return multiplier;
	}
	
	
	public HashMap<String, String> getTolerance(String color) {
		return tolerance;
	}
	
	
	public HashMap<String, Integer> getTempCoeff(String color) {
		return tempCoeff;
	}
	
	
	
	
}

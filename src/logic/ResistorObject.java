package logic;

import java.util.HashMap;

public class ResistorObject {
	HashMap<String, Integer> digit1;
	HashMap<String, Integer> digit2;
	HashMap<String, Integer> digit3;
	HashMap<String, Float> multiplier;
	HashMap<String, String> tolerance;
	HashMap<String, Integer> tempCoeff;
	
	public ResistorObject() {
		setDefaultValues();
		
	}
	
	public Integer getDigit1(String color) {
		return digit1.get(color);
	}
	
	
	public Integer getDigit2(String color) {
		return digit2.get(color);
	}
	
	
	public Integer getDigit3(String color) {
		return digit3.get(color);
	}
	
	
	public Float getMultiplier(String color) {
		return multiplier.get(color);
	}
	
	
	public String getTolerance(String color) {
		return tolerance.get(color);
	}
	
	
	public Integer getTempCoeff(String color) {
		return tempCoeff.get(color);
	}
	
	
	
	private void setDigit1(String key, Integer value) {
		this.digit1.put(key, value); 
	}

	private void setDigit2(String key, Integer value) {
		this.digit2.put(key, value);
	}

	private void setDigit3(String key, Integer value) {
		this.digit3.put(key, value);
	}

	private void setMultiplier(String key, Float value) {
		this.multiplier.put(key, value);
	}

	private void setTolerance(String key, String value) {
		this.tolerance.put(key, value);
	}

	private void setTempCoeff(String key, Integer value) {
		this.tempCoeff.put(key, value);
	}

	
	private void defineDigits() {
		
		setDigit1("black", 0);
		setDigit2("black", 0);
		setDigit3("black", 0);
		
		setDigit1("brown", 1);
		setDigit2("brown", 1);
		setDigit3("brown", 1);
		
		setDigit1("red", 2);
		setDigit2("red", 2);
		setDigit3("red", 2);
		
		setDigit1("orange", 3);
		setDigit2("orange", 3);
		setDigit3("orange", 3);
	
		setDigit1("yellow", 4);
		setDigit2("yellow", 4);
		setDigit3("yellow", 4);
	
		setDigit1("green", 5);
		setDigit2("green", 5);
		setDigit3("green", 5);
		
		setDigit1("blue", 6);
		setDigit2("blue", 6);
		setDigit3("blue", 6);
		
		setDigit1("violet", 7);
		setDigit2("violet", 7);
		setDigit3("violet", 7);
		
		setDigit1("grey", 8);
		setDigit2("grey", 8);
		setDigit3("grey", 8);
		
		setDigit1("white", 9);
		setDigit2("white", 9);
		setDigit3("white", 9);
		
	}
	
	
	private void defineMultiplier() {
		
	}
	
	
	private void defineTolerance() {
		
	}
	
	
	private void defineTempCoeff() {
		
	}
	
	
	private void setDefaultValues() {
		defineDigits();
		
	}
	
	
}

package logic;

import java.util.HashMap;

public class ResistorObject {
	HashMap<String, Integer> digit1 = new HashMap<>();
	HashMap<String, Integer> digit2 = new HashMap<>();
	HashMap<String, Integer> digit3 = new HashMap<>();
	HashMap<String, Float> multiplier = new HashMap<>();
	HashMap<String, String> tolerance = new HashMap<>();
	HashMap<String, Integer> tempCoeff = new HashMap<>();
	
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
		
		setMultiplier("black", 1f);
		setMultiplier("brown", 10f);
		setMultiplier("red", 100f);
		setMultiplier("orange", 1000f);
		setMultiplier("yellow", 10000f);
		setMultiplier("green", 100000f);
		setMultiplier("blue", 1000000f);
		setMultiplier("violet", 10000000f);
		setMultiplier("grey", 100000000f);
		setMultiplier("white", 1000000000f);
		setMultiplier("gold", 0.1f);
		setMultiplier("silver", 0.01f);
	}
	
	
	private void defineTolerance() {
		
		setTolerance("brown", "±1%");
		setTolerance("red", "±2%");
		setTolerance("green", "±0.5%");
		setTolerance("blue", "±0.25%");
		setTolerance("violet", "±0.10%");
		setTolerance("grey", "±0.05%");
		setTolerance("gold", "±5%");
		setTolerance("silver", "±10%");
		setTolerance(null, "±20%");
		
	}
	
	
	private void defineTempCoeff() {
		
		setTempCoeff("black", 250);
		setTempCoeff("brown", 100);
		setTempCoeff("red", 50);
		setTempCoeff("orange", 15);
		setTempCoeff("yellow", 25);
		setTempCoeff("green", 20);
		setTempCoeff("blue", 10);
		setTempCoeff("violet", 5);
		setTempCoeff("grey", 1);
		
	}
	
	
	private void setDefaultValues() {
		defineDigits();
		defineMultiplier();
		defineTolerance();
		defineTempCoeff();
		
	}
	
	
}

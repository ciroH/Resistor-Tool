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

	private void setDefaultValues() {
		
		
	}
	
	
}

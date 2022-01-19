package logic;

public class Processing {
	ResistorObject resistorReference = new ResistorObject();
	
	public String measureResistor(String numberOfBands, String digit1Color, String digit2Color, String digit3Color, String multiplierColor, String toleranceColor, String tempCoeffColor) {
		Integer digit1;
		Integer digit2;
		Integer digit3;
		Float multiplier;
		String tolerance = new String();
		Integer tempCoeff;
		Float resistorValue;
		String results = new String();
		//set basic resistor values
		digit1 = resistorReference.getDigit1(digit1Color);
		digit2 = resistorReference.getDigit2(digit2Color);
		multiplier = resistorReference.getMultiplier(multiplierColor);
		tolerance = resistorReference.getTolerance(toleranceColor);
		switch (numberOfBands) {
		case "3 Bands":
			resistorValue = Integer.parseInt(digit1.toString() + digit2.toString()) * multiplier;
			results = "<html><body>" + resistorValue.toString() + "Ω<br>" + tolerance + "</body></html>";
			break;
		case "4 Bands":
			resistorValue = Integer.parseInt(digit1.toString() + digit2.toString()) * multiplier;
			results = "<html><body>" + resistorValue.toString() + "Ω<br>" + tolerance + "</body></html>";
			break;
		case "5 Bands":
			digit3 = resistorReference.getDigit3(digit3Color);
			resistorValue = Integer.parseInt(digit1.toString() + digit2.toString() + digit3.toString()) * multiplier;
			results = "<html><body>" + resistorValue.toString() + "Ω<br>" + tolerance + "</body></html>";
			break;
		case "6 Bands":
			digit3 = resistorReference.getDigit3(digit3Color);
			tempCoeff = resistorReference.getTempCoeff(tempCoeffColor);
			resistorValue = Integer.parseInt(digit1.toString() + digit2.toString() + digit3.toString()) * multiplier;
			results = "<html><body>" + resistorValue.toString() + "Ω<br>" + tolerance + "<br>"  + tempCoeff.toString() + "ppm" + "</body></html>";
			break;
		default:
			resistorValue = Integer.parseInt(digit1.toString() + digit2.toString()) * multiplier;
			results = "<html><body>" + resistorValue.toString() + "Ω<br>" + tolerance + "</body></html>";
			break;
		}
		 
	return results;} //I'll return 3 lines: value (ohm), tolerance, and tempCoeff
}

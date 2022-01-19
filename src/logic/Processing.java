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
		//set basic resistor values
		digit1 = resistorReference.getDigit1(digit1Color);
		digit2 = resistorReference.getDigit2(digit2Color);
		multiplier = resistorReference.getMultiplier(multiplierColor);
		switch (numberOfBands) {
		case "3 Bands":
			
			break;
		case "4 Bands":
			tolerance = resistorReference.getTolerance(toleranceColor);
			
			break;
		case "5 Bands":
			tolerance = resistorReference.getTolerance(toleranceColor);
			digit3 = resistorReference.getDigit3(digit3Color);
			
			break;
		case "6 Bands":
			tolerance = resistorReference.getTolerance(toleranceColor);
			digit3 = resistorReference.getDigit3(digit3Color);
			tempCoeff = resistorReference.getTempCoeff(tempCoeffColor);
			
			break;

		default:
			break;
		}
		 
		 
		
			
	return "";} //I'll return 3 lines: value (ohms), tolerance, and tempCoeff
	
}

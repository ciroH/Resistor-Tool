/*
 * 	 Resistor-Tool: A tool built to measure a resistor's specs.
 *   Copyright (C) 2022  Ciro Haskour
 
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License version 2, as published by
 *   the Free Software Foundation.
 
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License along
 *   with this program; if not, write to the Free Software Foundation, Inc.,
 *   51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *   
 *   You can also contact the author of this program by sending an email at ciroh.jobs@gmail.com
 */

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

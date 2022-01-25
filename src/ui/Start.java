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

package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Processing;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;

public class Start extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton digit1Button;
	private JButton tempCoeffButton;
	private JButton digit3Button;
	private JButton toleranceButton;
	private JButton multiplierButton;
	private JButton digit2Button;
	ArrayList<String> selectedBandsList = new ArrayList<>(); //numberOfBands == [0] // band == [1+]
	String numberOfBands = "4 Bands";	//used when calling logic.Processing
	private JPanel resultsPane;
	private JLabel resultsLabel = new JLabel("");
	private Processing calculator = new Processing();
	public ImageIcon appIcon;
	
	public static void main(String[] args) {
		int width = getScreenWidth();
		int height = getScreenHeight();
		System.out.println(width+"x"+height);
		Start userInterface = new Start();
		userInterface.setVisible(true);
		userInterface.setResizable(false);
	}

	public static int getScreenHeight() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
	}

	public static int getScreenWidth() {
		int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		return width;
	}
	
	public Start() {
		checkHeadless();
		setTitle("Resistor-Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.GRAY);
		setBounds(0,0,240,300);
		setLocationRelativeTo(null);
		
		appIcon = new ImageIcon("res/alternative-icon.png");
		setIconImage(appIcon.getImage());
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel resistorPaneMid = new JPanel();
		resistorPaneMid.setBackground(new Color(210, 180, 140));
		resistorPaneMid.setBounds(70, 83, 100, 25);
		contentPane.add(resistorPaneMid);
		resistorPaneMid.setLayout(null);
		
		digit2Button = new JButton("");
		digit2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String color = new String();
				color = showColorSelector(2, digit2Button);
				paintButton(digit2Button, color);
				selectedBandsList.set(2, color);
				
			}
		});
		digit2Button.setBounds(7, 0, 10, 25);
		resistorPaneMid.add(digit2Button);
		
		digit3Button = new JButton("");
		digit3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String color = new String();
				color = showColorSelector(3, digit3Button);
				paintButton(digit3Button, color);
				selectedBandsList.set(3, color);
			}
		});
		digit3Button.setBounds(27, 0, 10, 25);
		resistorPaneMid.add(digit3Button);
		
		multiplierButton = new JButton("");
		multiplierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String color = new String();
				color = showColorSelector(4, multiplierButton);
				paintButton(multiplierButton, color);
				selectedBandsList.set(4, color);
			}
		});
		multiplierButton.setBounds(50, 0, 10, 25);
		resistorPaneMid.add(multiplierButton);
		
		toleranceButton = new JButton("");
		toleranceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String color = new String();
				color = showColorSelector(5, toleranceButton);
				paintButton(toleranceButton, color);
				selectedBandsList.set(5, color);
			}
		});
		toleranceButton.setBounds(75, 0, 10, 25);
		resistorPaneMid.add(toleranceButton);
		
		ArrayList<String> comboBoxOptions = new ArrayList<>();
		comboBoxOptions.add("3 Bands");
		comboBoxOptions.add("4 Bands");
		comboBoxOptions.add("5 Bands");
		comboBoxOptions.add("6 Bands");
		
		JComboBox<String> bandsComboBox = new JComboBox<String>();
		bandsComboBox.setBackground(Color.LIGHT_GRAY);
		bandsComboBox.setBounds(50, 12, 140, 20);
		for (int i = 0; i < comboBoxOptions.size(); i++) {
			bandsComboBox.addItem(comboBoxOptions.get(i));	
		}
		bandsComboBox.setSelectedIndex(1);
		bandsComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bandsSelection = new String(bandsComboBox.getSelectedItem().toString());
				arrangeUI(bandsSelection);
				clearSelectedBandsList(bandsSelection);
				
			}
		});
		
		contentPane.add(bandsComboBox);
		
		JPanel resistorPaneFirst = new JPanel();
		resistorPaneFirst.setLayout(null);
		resistorPaneFirst.setBackground(new Color(210, 180, 140));
		resistorPaneFirst.setBounds(50, 81, 20, 29);
		contentPane.add(resistorPaneFirst);
		
		digit1Button = new JButton("");
		digit1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String color = new String();
				color = showColorSelector(1, digit1Button);
				paintButton(digit1Button, color);
				selectedBandsList.set(1, color);
			}
		});
		digit1Button.setBounds(5, 0, 10, 29);
		resistorPaneFirst.add(digit1Button);
		
		JPanel resistorPaneLast = new JPanel();
		resistorPaneLast.setLayout(null);
		resistorPaneLast.setBackground(new Color(210, 180, 140));
		resistorPaneLast.setBounds(170, 81, 20, 29);
		contentPane.add(resistorPaneLast);
		
		tempCoeffButton = new JButton("");
		tempCoeffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String color = new String();
				color = showColorSelector(6, tempCoeffButton);
				paintButton(tempCoeffButton, color);
				selectedBandsList.set(6, color);
			}
		});
		tempCoeffButton.setBounds(5, 0, 10, 29);
		resistorPaneLast.add(tempCoeffButton);
		
		JButton refreshButton = new JButton("");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bandsSelection = bandsComboBox.getSelectedItem().toString();
				clearBandsColor();
				clearSelectedBandsList(bandsSelection);
				resultsLabel.setText("");
				
			}
		});
		refreshButton.setBounds(70, 136, 32, 32);
		contentPane.add(refreshButton);
		 Icon refreshIcon = new ImageIcon("res/refreshIcon.png");
		 refreshButton.setIcon(refreshIcon);
		
		JButton processButton = new JButton("");
		processButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String results = new String();
				boolean baseBandsnotEmpty = false;
				if (!selectedBandsList.get(1).equals("") && !selectedBandsList.get(2).equals("") && !selectedBandsList.get(4).equals("")) {
					baseBandsnotEmpty = true;
				}
				if (baseBandsnotEmpty) {
					if (selectedBandsList.get(0).equals("3 Bands")) {
						results = calculator.measureResistor(selectedBandsList.get(0),selectedBandsList.get(1), selectedBandsList.get(2), null, selectedBandsList.get(4), null, null);
						
					} else if (selectedBandsList.get(0).equals("4 Bands")) {
						 if (!selectedBandsList.get(5).equals("")){
								results = calculator.measureResistor(selectedBandsList.get(0),selectedBandsList.get(1), selectedBandsList.get(2), null, selectedBandsList.get(4), selectedBandsList.get(5), null);
								
						} else {
							notifyIncompleteBands();
						}
					} else if (selectedBandsList.get(0).equals("5 Bands")) {
						if (!selectedBandsList.get(5).equals("") && !selectedBandsList.get(3).equals("")){
							results = calculator.measureResistor(selectedBandsList.get(0),selectedBandsList.get(1), selectedBandsList.get(2), selectedBandsList.get(3), selectedBandsList.get(4), selectedBandsList.get(5), null);
							
						} else {
							notifyIncompleteBands();
						}
					} else if (selectedBandsList.get(0).equals("6 Bands")) {
						if (!selectedBandsList.get(5).equals("") && !selectedBandsList.get(3).equals("") && !selectedBandsList.get(6).equals("")){
							results = calculator.measureResistor(selectedBandsList.get(0),selectedBandsList.get(1), selectedBandsList.get(2), selectedBandsList.get(3), selectedBandsList.get(4), selectedBandsList.get(5), selectedBandsList.get(6));
							
						} else {
							notifyIncompleteBands();
						}
					}
				} else {
					notifyIncompleteBands();
				}
				resultsLabel.setText(results);
			}
		});
		processButton.setBounds(125, 136, 32, 32);
		contentPane.add(processButton);
		Icon processIcon = new ImageIcon("res/processIcon.png");
		processButton.setIcon(processIcon);
		
		resultsPane = new JPanel();
		resultsPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		resultsPane.setBackground(Color.GRAY);
		resultsPane.setBounds(12, 180, 208, 80);
		contentPane.add(resultsPane);
		resultsPane.setLayout(null);
		
		resultsLabel.setBounds(0, 0, 208, 80);
		resultsPane.add(resultsLabel);
		resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		clearSelectedBandsList("4 Bands");
		arrangeUI("4 Bands");
	}
	
	public String showColorSelector(int bandNumber, JButton parentComponent) {
		String[] colorArray = new String[] {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white", "gold", "silver"};
		ArrayList<String> colorList = new ArrayList<>();
		String selectedColor = new String();
		int selectedOption;
		for (int i = 0; i < colorArray.length; i++) {
			colorList.add(colorArray[i]);
		}
		//	JButton[] colorButtons = new JButton[0];  will need to create mutiple JButtons and change their colors whenever i improve the JOptionpane.ShowOptionDialog's appearance
		
		//Creating a static int representing every band would be a good thing to add more readability and context (static int DIGIT1 = 1;)
		switch (bandNumber) {
		case 1:	//digit 1
		case 2:	//digit 2
		case 3:	//digit 3
			colorList.remove("gold");
			colorList.remove("silver");
			break;
		case 4:	//multiplier
			// uses all bands
			break;
		case 5:	//tolerance
			colorList.remove("black");
			colorList.remove("orange");
			colorList.remove("yellow");
			colorList.remove("white");
			break;
		case 6:	//temperature coefficient
			colorList.remove("white");
			colorList.remove("gold");
			colorList.remove("silver");
			break;
		default:
			break;
		}

		try {
			selectedOption = JOptionPane.showOptionDialog(parentComponent, "Select a Color", "Color Selector", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, colorList.toArray(), colorList.get(0));
			if (selectedOption != JOptionPane.CLOSED_OPTION) {
				selectedColor = colorList.get(selectedOption);
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
	return selectedColor;} //if showColorSelection.isEmpty {/*do nothing*/} else paint the band JButton that calls this method
	
	private void arrangeUI(String numberOfBands) {
		switch (numberOfBands) {
		case "3 Bands":
			clearBandsColor();
			setVisibleMinBands(true);
			setVisibleExtraBands(false,false,false);
			break;
		case "4 Bands":
			clearBandsColor();
			setVisibleMinBands(true);
			setVisibleExtraBands(true,false,false);
			break;

		case "5 Bands":
			clearBandsColor();
			setVisibleMinBands(true);
			setVisibleExtraBands(true,true,false);
			break;
		case "6 Bands":
			clearBandsColor();
			setVisibleMinBands(true);
			setVisibleExtraBands(true,true,true);
			break;

		default:
			clearBandsColor();
			setVisibleMinBands(true);
			setVisibleExtraBands(true,false,false);
			break;
		}
	}
	
	private void checkHeadless() {
		if (GraphicsEnvironment.isHeadless()) {
			System.out.println("This system does not have an accesible graphics environment");
			System.exit(0);
		}
	}
	
	private void notifyIncompleteBands() {
		JOptionPane.showMessageDialog(null, "Please select a color for each band");
	}
	
	private void setVisibleMinBands(boolean state) {
		digit1Button.setVisible(state);
		digit2Button.setVisible(state);
		multiplierButton.setVisible(state);
	}

	private void setVisibleExtraBands(boolean toleranceBandState, boolean digit3BandState, boolean tempCoeffBandState) {
		toleranceButton.setVisible(toleranceBandState);
		digit3Button.setVisible(digit3BandState);
		tempCoeffButton.setVisible(tempCoeffBandState);
	}
	
	private void clearBandsColor() {
	digit1Button.setBackground(null);
	digit2Button.setBackground(null);	
	digit3Button.setBackground(null);	
	toleranceButton.setBackground(null);
	tempCoeffButton.setBackground(null);
	multiplierButton.setBackground(null);
	}
	
	private void clearSelectedBandsList(String numberOfBands) {
		selectedBandsList.clear();
		selectedBandsList.add(0,numberOfBands);
		selectedBandsList.add(1,"");
		selectedBandsList.add(2,"");
		selectedBandsList.add(3,"");
		selectedBandsList.add(4,"");
		selectedBandsList.add(5,"");
		selectedBandsList.add(6,"");
		
	}
	
	private void paintButton(JButton buttonToPaint, String colorName) {
		if (colorName != null && !colorName.isEmpty()) {
		Color color = new Color(0,0,0);
		switch (colorName) {
		case "black":
			color = new Color(0,0,0);
			break;
		case "brown":
			color = new Color(51,25,0);
			break;
		case "red":
			color = new Color(255,0,0);
		break;
		case "orange":
			color = new Color(255,128,0);
		break;
		case "yellow":
			color = new Color(255,255,0);
		break;
		case "green":
			color = new Color(0,204,0);
		break;
		case "blue":
			color = new Color(0,0,204);
		break;
		case "violet":
			color = new Color(127,0,255);
		break;
		case "grey":
			color = new Color(128,128,128);
		break;
		case "white":
			color = new Color(255,255,255);
		break;
		case "gold":
			color = new Color(204,204,0);
		break;
		case "silver":
			color = new Color(224,224,224);
			break;
		default:
			color = new Color(0,0,0);
			break;
		}
		
		buttonToPaint.setBackground(color);
		
		}
	}

}

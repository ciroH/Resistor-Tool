package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.ResistorObject;

import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Start extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton digit1Button;
	private JButton tempCoeffButton;
	private JButton digit3Button;
	private JButton toleranceButton;
	private JButton multiplierButton;
	private JButton digit2Button;
	ArrayList<String> selectedBandsList = new ArrayList<>();// numberOfBands == [0] // band == [1+]
	String numberOfBands = "4 Bands";	//used when calling logic.Processing
	
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
		setTitle("Resistor-Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.GRAY);
		setBounds(0,0,240,300);
		setLocationRelativeTo(null);
		
		selectedBandsList.add(0, numberOfBands);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel ResistorPaneMid = new JPanel();
		ResistorPaneMid.setBackground(new Color(210, 180, 140));
		ResistorPaneMid.setBounds(70, 83, 100, 25);
		contentPane.add(ResistorPaneMid);
		ResistorPaneMid.setLayout(null);
		
		digit2Button = new JButton("");
		digit2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		digit2Button.setBounds(7, 0, 10, 25);
		ResistorPaneMid.add(digit2Button);
		
		digit3Button = new JButton("");
		digit3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		digit3Button.setBounds(27, 0, 10, 25);
		ResistorPaneMid.add(digit3Button);
		
		multiplierButton = new JButton("");
		multiplierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		multiplierButton.setBounds(50, 0, 10, 25);
		ResistorPaneMid.add(multiplierButton);
		
		toleranceButton = new JButton("");
		toleranceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toleranceButton.setBounds(75, 0, 10, 25);
		ResistorPaneMid.add(toleranceButton);
		
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
				arrangeUI(bandsComboBox.getSelectedItem().toString());
				switch (bandsComboBox.getSelectedItem().toString()) {
				case "3 Bands":
					clearSelectedBandsList(3);
					break;
				case "4 Bands":
					clearSelectedBandsList(4);
					break;
				case "5 Bands":
					clearSelectedBandsList(5);
					break;
				case "6 Bands":
					clearSelectedBandsList(6);
					break;
				default:
					clearSelectedBandsList(4);
					break;
				}
			}
		});
		
		contentPane.add(bandsComboBox);
		
		JPanel ResistorPaneFirst = new JPanel();
		ResistorPaneFirst.setLayout(null);
		ResistorPaneFirst.setBackground(new Color(210, 180, 140));
		ResistorPaneFirst.setBounds(50, 81, 20, 29);
		contentPane.add(ResistorPaneFirst);
		
		digit1Button = new JButton("");
		digit1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String color = new String();
				color = showColorSelector(1, digit1Button);
				paintButton(digit1Button, color);
			}
		});
		digit1Button.setBounds(5, 0, 10, 29);
		ResistorPaneFirst.add(digit1Button);
		
		JPanel ResistorPaneLast = new JPanel();
		ResistorPaneLast.setLayout(null);
		ResistorPaneLast.setBackground(new Color(210, 180, 140));
		ResistorPaneLast.setBounds(170, 81, 20, 29);
		contentPane.add(ResistorPaneLast);
		
		tempCoeffButton = new JButton("");
		tempCoeffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tempCoeffButton.setBounds(5, 0, 10, 29);
		ResistorPaneLast.add(tempCoeffButton);
		
		JButton refreshButton = new JButton("");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		refreshButton.setBounds(70, 136, 32, 32);
		contentPane.add(refreshButton);
		 Icon refreshIcon = new ImageIcon("res/refreshIcon.png");
		 refreshButton.setIcon(refreshIcon);
		
		JButton processButton = new JButton("");
		processButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		processButton.setBounds(125, 136, 32, 32);
		contentPane.add(processButton);
		Icon processIcon = new ImageIcon("res/processIcon.png");
		processButton.setIcon(processIcon);
		
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
	
	private String MeasureResistorProperties(String digit1Color, String digit2Color, String digit3Color, String multiplierColor, String toleranceColor, String tempCoeffColor){
		ResistorObject resistor = new ResistorObject();
		String resistorInfo = new String();
		//if calls logic.Processing to measure resistor, sends numberOfBands value
		if (toleranceColor == null) {
			//numberOfBands = 3;
		} else if(digit3Color == null){
			//numberOfBands = 4;
		} else if(tempCoeffColor == null){
			//numberOfBands = 5;
		} else {
			//numberOfBands = 6;
		}
	return resistorInfo;}
	
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
	
	private void clearSelectedBandsList(int numberOfBands) {
		selectedBandsList.clear();
		selectedBandsList.add(0,this.numberOfBands);
	}
	
	private void paintButton(JButton buttonToPaint, String color) {
		if (color != null) {
		//	buttonToPaint.paint(color);
		}
	}
	
	//TODO: create method paintButton(JButton buttonToPaint,String color), and finish writing ActionListener of band's JButton
	//TODO: finish MeasureResistorProperties
	//TODO: create JPanel for showing results
	//TODO: check if system is headless
	//TODO: finish writing ActionListener for refresh and process JButtons. Extract switch from JcomboBox's ActionListener and integrate it into clearSelectedBandsList, to use it in the refresh JButton ActionListener
}

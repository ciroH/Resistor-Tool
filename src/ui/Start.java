package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.ResistorObject;

import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Start extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
		
		JButton digit2Button = new JButton("");
		digit2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		digit2Button.setBounds(7, 0, 10, 25);
		ResistorPaneMid.add(digit2Button);
		
		JButton digit3Button = new JButton("");
		digit3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		digit3Button.setBounds(27, 0, 10, 25);
		ResistorPaneMid.add(digit3Button);
		
		JButton multiplierButton = new JButton("");
		multiplierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		multiplierButton.setBounds(50, 0, 10, 25);
		ResistorPaneMid.add(multiplierButton);
		
		JButton toleranceButton = new JButton("");
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
				ArrangeUI(bandsComboBox.getSelectedItem().toString());
			}
		});
		
		contentPane.add(bandsComboBox);
		
		JPanel ResistorPaneFirst = new JPanel();
		ResistorPaneFirst.setLayout(null);
		ResistorPaneFirst.setBackground(new Color(210, 180, 140));
		ResistorPaneFirst.setBounds(50, 81, 20, 29);
		contentPane.add(ResistorPaneFirst);
		
		JButton digit1Button = new JButton("");
		digit1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		digit1Button.setBounds(5, 0, 10, 29);
		ResistorPaneFirst.add(digit1Button);
		
		JPanel ResistorPaneLast = new JPanel();
		ResistorPaneLast.setLayout(null);
		ResistorPaneLast.setBackground(new Color(210, 180, 140));
		ResistorPaneLast.setBounds(170, 81, 20, 29);
		contentPane.add(ResistorPaneLast);
		
		JButton tempCoeffButton = new JButton("");
		tempCoeffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tempCoeffButton.setBounds(5, 0, 10, 29);
		ResistorPaneLast.add(tempCoeffButton);

	}
	
	public String ShowColorSelection(int bandNumber) {

	return "";}
	
	private String MeasureResistorProperties(String digit1Color, String digit2Color, String digit3Color, String multiplierColor, String toleranceColor, String tempCoeffColor){
		ResistorObject resistor = new ResistorObject();
		String resistorInfo = new String();
		//calls logic.Processing to measure resistor
	return resistorInfo;}
	
	private void ArrangeUI(String numberOfBands) {
		
	}
}

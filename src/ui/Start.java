package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GraphicsEnvironment;
import java.awt.Color;

public class Start extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
		int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int height = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		System.out.println(width+"x"+height);
		Start userInterface = new Start();
		userInterface.setVisible(true);
		userInterface.setResizable(false);
	}
	
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.GRAY);
		setBounds(0,0,800,600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}

package ui.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class AirlinePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AirlinePanel() {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setLayout(new GridLayout(3, 2, 2, 2));
		
		JLabel lbKor = new JLabel("\uB300\uD55C\uD56D\uACF5");
		lbKor.setForeground(Color.WHITE);
		lbKor.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 20));
		lbKor.setHorizontalAlignment(SwingConstants.CENTER);
		lbKor.setBorder(new LineBorder(new Color(20, 235, 100), 2));
		add(lbKor);
		
		JLabel lbAsiana = new JLabel("\uC544\uC2DC\uC544\uB098");
		lbAsiana.setForeground(Color.WHITE);
		lbAsiana.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 20));
		lbAsiana.setHorizontalAlignment(SwingConstants.CENTER);
		lbAsiana.setBorder(new LineBorder(new Color(20, 235, 165), 2));
		add(lbAsiana);
		
		JLabel lbLCC = new JLabel("\uC800\uAC00\uD56D\uACF5");
		lbLCC.setForeground(Color.WHITE);
		lbLCC.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 20));
		lbLCC.setHorizontalAlignment(SwingConstants.CENTER);
		lbLCC.setBorder(new LineBorder(new Color(20, 235, 200), 2));
		add(lbLCC);

	}

}

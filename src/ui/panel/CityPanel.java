package ui.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CityPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CityPanel() {
		setBackground(Color.BLACK);
		setLayout(new GridLayout(3, 2, 2, 2));
		
		JLabel lbDanang = new JLabel("\uB2E4\uB0AD");
		lbDanang.setForeground(Color.WHITE);
		lbDanang.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 20));
		lbDanang.setHorizontalAlignment(SwingConstants.CENTER);
		lbDanang.setBorder(new LineBorder(new Color(20, 235, 100), 2));
		add(lbDanang);
		
		JLabel lbHanoi = new JLabel("\uD558\uB178\uC774");
		lbHanoi.setForeground(Color.WHITE);
		lbHanoi.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 20));
		lbHanoi.setHorizontalAlignment(SwingConstants.CENTER);
		lbHanoi.setBorder(new LineBorder(new Color(20, 235, 165), 2));
		add(lbHanoi);
		
		JLabel lbHochimin = new JLabel("\uD638\uCE58\uBBFC");
		lbHochimin.setForeground(Color.WHITE);
		lbHochimin.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 20));
		lbHochimin.setHorizontalAlignment(SwingConstants.CENTER);
		lbHochimin.setBorder(new LineBorder(new Color(20, 235, 200), 2));
		add(lbHochimin);

	}

}

package ui.panel.product;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.CardLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class HanoiKor extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	JToggleButton[] btnDays;
	public static final Font FNT_DAY = new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 10);
	public JTextField txtYear;
	public JTextField txtMonth;
	public JTextField txtAdultPr;
	public JTextField txtChildPr;
	public JTextField txtBabyPr;
	public JTextField txtTotal;
	public JTextField txtFlight;
	public JTextField txtHotel;
	public JPanel pnFh;
	public JPanel pnSchedule;
	public JLabel lbFlight;
	public JLabel lbHotel;
	public JTextArea txtSchedule;
	public JLabel lbPdImage1;
	public JLabel lbPdImage2;
	public JLabel lbPdImage3;
	public JSpinner spinAdult;
	public JSpinner spinChild;
	public JSpinner spinBaby;
	public JButton btnReservation;

	public HanoiKor() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lbPdImage1 = new JLabel("");
		lbPdImage1.setSize(280, 200);
		ImageIcon ic1 = new ImageIcon("C:/dev2020/java_ws/FirstTeamProject/images/danang/DanangGoldenBridge2.jpg");
		Image scaled = ic1.getImage().getScaledInstance(lbPdImage1.getWidth(),
				lbPdImage1.getHeight(), Image.SCALE_FAST);
		ic1.setImage(scaled);
		lbPdImage1.setIcon(ic1);
		panel.add(lbPdImage1);
		
		JLabel lblNewLabel = new JLabel("     ");
		panel.add(lblNewLabel);
		
		lbPdImage2 = new JLabel("");
		lbPdImage2.setSize(280, 200);
		ImageIcon ic2 = new ImageIcon("C:/dev2020/java_ws/FirstTeamProject/images/danang/DanangNightView.jpg");
		Image scaled2 = ic2.getImage().getScaledInstance(lbPdImage2.getWidth(),
				lbPdImage2.getHeight(), Image.SCALE_FAST);
		ic2.setImage(scaled2);
		lbPdImage2.setIcon(ic2);
		panel.add(lbPdImage2);
		
		JLabel label_1 = new JLabel("     ");
		panel.add(label_1);
		
		lbPdImage3 = new JLabel("");
		lbPdImage3.setSize(280, 200);
		ImageIcon ic3 = new ImageIcon("C:/dev2020/java_ws/FirstTeamProject/images/danang/HueCaidan.jpg");
		Image scaled3 = ic3.getImage().getScaledInstance(lbPdImage3.getWidth(),
				lbPdImage3.getHeight(), Image.SCALE_FAST);
		ic3.setImage(scaled3);
		lbPdImage3.setIcon(ic3);
		panel.add(lbPdImage3);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 102, 255), 2, true));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 5, 0, 0));
		
		JRadioButton rd1 = new JRadioButton("1\uC77C\uCC28");
		rd1.setSelected(true);
		rd1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lbFlight.setVisible(true);
				txtFlight.setVisible(true);
			}
		});
		rd1.setHorizontalAlignment(SwingConstants.CENTER);
		rd1.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		buttonGroup.add(rd1);
		panel_2.add(rd1);
		
		JRadioButton rd2 = new JRadioButton("2\uC77C\uCC28");
		rd2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lbFlight.setVisible(false);
				txtFlight.setVisible(false);
			}
		});
		rd2.setHorizontalAlignment(SwingConstants.CENTER);
		rd2.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		buttonGroup.add(rd2);
		panel_2.add(rd2);
		
		JRadioButton rd3 = new JRadioButton("3\uC77C\uCC28");
		rd3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lbFlight.setVisible(false);
				txtFlight.setVisible(false);
			}
		});
		rd3.setHorizontalAlignment(SwingConstants.CENTER);
		rd3.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		buttonGroup.add(rd3);
		panel_2.add(rd3);
		
		JRadioButton rd4 = new JRadioButton("4\uC77C\uCC28");
		rd4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lbFlight.setVisible(true);
				txtFlight.setVisible(true);
			}
		});
		rd4.setHorizontalAlignment(SwingConstants.CENTER);
		rd4.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		buttonGroup.add(rd4);
		panel_2.add(rd4);
		
		JRadioButton rd5 = new JRadioButton("5\uC77C\uCC28");
		rd5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lbFlight.setVisible(false);
				txtFlight.setVisible(false);
			}
		});
		rd5.setHorizontalAlignment(SwingConstants.CENTER);
		rd5.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		buttonGroup.add(rd5);
		panel_2.add(rd5);			
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel pnCalendar = new JPanel();
		panel_3.add(pnCalendar);
		pnCalendar.setLayout(new BorderLayout(0, 0));
		
		JPanel pnCdTop = new JPanel();
		pnCalendar.add(pnCdTop, BorderLayout.NORTH);
		
		JLabel lbYear = new JLabel("\uB144\uB3C4");
		lbYear.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		pnCdTop.add(lbYear);
		
		txtYear = new JTextField();
		txtYear.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		txtYear.setText("2021");
		pnCdTop.add(txtYear);
		txtYear.setColumns(4);
		
		JLabel lbMonth = new JLabel("\uC6D4");
		lbMonth.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		pnCdTop.add(lbMonth);
		
		txtMonth = new JTextField();
		txtMonth.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		txtMonth.setText("1");
		pnCdTop.add(txtMonth);
		txtMonth.setColumns(2);
		
		JToolBar toolBar = new JToolBar();
		pnCdTop.add(toolBar);
		
		JButton button = new JButton("\uB2EC\uB825\uAC80\uC0C9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year = Integer.parseInt(txtYear.getText());
				int month = Integer.parseInt(txtMonth.getText());
				showGuiMonthCalendar(year, month);
			}
		});
		button.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		toolBar.add(button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mvYear = Integer.parseInt(txtYear.getText());
				int mvMonth = Integer.parseInt(txtMonth.getText());
				mvMonth--;
				if( mvMonth == 0 ) { // ¿ÃÇØ 1¿ù¿¡¼­ => ÀÛ³â 12¿ù·Î
					mvMonth = 12;
					mvYear--;
					txtYear.setText(String.valueOf(mvYear));
				}
				txtMonth.setText(""+mvMonth);
				showGuiMonthCalendar(mvYear, mvMonth);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\TimeGUIProject\\icons\\arrow_left.png"));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mvYear = Integer.parseInt(txtYear.getText());
				int mvMonth = Integer.parseInt(txtMonth.getText());
				mvMonth++;
				if( mvMonth == 13 ) { // ¿ÃÇØ 12¿ù¿¡¼­ => ³»³â 1¿ù·Î
					mvMonth = 1;
					mvYear++;
					txtYear.setText(String.valueOf(mvYear));
				}
				txtMonth.setText(""+mvMonth);
				showGuiMonthCalendar(mvYear, mvMonth);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\TimeGUIProject\\icons\\arrow_right.png"));
		toolBar.add(btnNewButton_1);
		
		JPanel pnCdCenter = new JPanel();
		pnCalendar.add(pnCdCenter, BorderLayout.CENTER);
		pnCdCenter.setLayout(new GridLayout(7, 7, 0, 0));
		
		JLabel lbSunday = new JLabel("SUN");
		lbSunday.setHorizontalAlignment(SwingConstants.CENTER);
		lbSunday.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 15));
		lbSunday.setForeground(Color.RED);
		pnCdCenter.add(lbSunday);
		
		JLabel lbMonday = new JLabel("MON");
		lbMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lbMonday.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 15));
		pnCdCenter.add(lbMonday);
		
		JLabel lbTuesDay = new JLabel("TUE");
		lbTuesDay.setHorizontalAlignment(SwingConstants.CENTER);
		lbTuesDay.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 15));
		pnCdCenter.add(lbTuesDay);
		
		JLabel lbWendnesDay = new JLabel("WED");
		lbWendnesDay.setHorizontalAlignment(SwingConstants.CENTER);
		lbWendnesDay.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 15));
		pnCdCenter.add(lbWendnesDay);
		
		JLabel lbThursday = new JLabel("THU");
		lbThursday.setHorizontalAlignment(SwingConstants.CENTER);
		lbThursday.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 15));
		pnCdCenter.add(lbThursday);
		
		JLabel lbFirday = new JLabel("FRI");
		lbFirday.setHorizontalAlignment(SwingConstants.CENTER);
		lbFirday.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 15));
		pnCdCenter.add(lbFirday);
		
		JLabel lbSaturday = new JLabel("SAT");
		lbSaturday.setHorizontalAlignment(SwingConstants.CENTER);
		lbSaturday.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 15));
		lbSaturday.setForeground(Color.BLUE);
		pnCdCenter.add(lbSaturday);
		
		final int BTN_LIMIT = 42;
		this.btnDays = new JToggleButton[BTN_LIMIT];
		for (int i = 0; i < btnDays.length; i++) {
			JToggleButton btnDay = new JToggleButton("0");
			btnDay.setHorizontalAlignment(JButton.CENTER);
			btnDay.setFont(FNT_DAY);
			if( i % 7 == 0 )
				btnDay.setForeground(Color.RED);
			else if ( i % 7 == 6 )
				btnDay.setForeground(Color.BLUE);
			
			btnDays[i] = btnDay; // ¹è¿­¿¡ µî·Ï 0 ~ 41
			pnCdCenter.add(btnDay); // ±×¸®µå¿¡ µî·Ï 7 ~ 48 (1,0) ~ (6,6)
			btnDay.setEnabled(true);
		}
		
		JPanel pnPeople = new JPanel();
		panel_3.add(pnPeople);
		pnPeople.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel lbAdult = new JLabel("\uC131\uC778");
		lbAdult.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		lbAdult.setHorizontalAlignment(SwingConstants.CENTER);
		pnPeople.add(lbAdult);
		
		spinAdult = new JSpinner();
		pnPeople.add(spinAdult);
		
		JLabel lbChild = new JLabel("\uC544\uB3D9");
		lbChild.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		lbChild.setHorizontalAlignment(SwingConstants.CENTER);
		pnPeople.add(lbChild);
		
		spinChild = new JSpinner();
		pnPeople.add(spinChild);
		
		JLabel lbBaby = new JLabel("\uC720\uC544");
		lbBaby.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		lbBaby.setHorizontalAlignment(SwingConstants.CENTER);
		pnPeople.add(lbBaby);
		
		spinBaby = new JSpinner();
		pnPeople.add(spinBaby);
		
		JPanel pnPrice = new JPanel();
		panel_3.add(pnPrice);
		pnPrice.setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel lbAdultPr = new JLabel("\uC131\uC778\uC694\uAE08");
		lbAdultPr.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		lbAdultPr.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrice.add(lbAdultPr);
		
		txtAdultPr = new JTextField();
		txtAdultPr.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		txtAdultPr.setEnabled(false);
		pnPrice.add(txtAdultPr);
		txtAdultPr.setColumns(10);
		
		JLabel lbChildPr = new JLabel("\uC544\uB3D9\uC694\uAE08");
		lbChildPr.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		lbChildPr.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrice.add(lbChildPr);
		
		txtChildPr = new JTextField();
		txtChildPr.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		txtChildPr.setEnabled(false);
		pnPrice.add(txtChildPr);
		txtChildPr.setColumns(10);
		
		JLabel lbBabyPr = new JLabel("\uC720\uC544\uC694\uAE08");
		lbBabyPr.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		lbBabyPr.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrice.add(lbBabyPr);
		
		txtBabyPr = new JTextField();
		txtBabyPr.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		txtBabyPr.setEnabled(false);
		pnPrice.add(txtBabyPr);
		txtBabyPr.setColumns(10);
		
		JLabel lbTotal = new JLabel("\uCD1D\uC694\uAE08");
		lbTotal.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		lbTotal.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrice.add(lbTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		txtTotal.setEnabled(false);
		pnPrice.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("");
		pnPrice.add(lblNewLabel_8);
		
		btnReservation = new JButton("\uC608\uC57D\uD558\uAE30");
		btnReservation.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 12));
		pnPrice.add(btnReservation);
		
		pnSchedule = new JPanel();
		panel_1.add(pnSchedule, BorderLayout.CENTER);
		pnSchedule.setLayout(new BorderLayout(0, 0));
		
		pnFh = new JPanel();
		pnSchedule.add(pnFh, BorderLayout.NORTH);
		pnFh.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		lbFlight = new JLabel("\uD56D\uACF5\uD3B8");
		lbFlight.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		pnFh.add(lbFlight);
		
		txtFlight = new JTextField();
		txtFlight.setEnabled(false);
		txtFlight.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 15));
		pnFh.add(txtFlight);
		txtFlight.setColumns(10);
		
		lbHotel = new JLabel("\uD638\uD154");
		lbHotel.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		pnFh.add(lbHotel);
		
		txtHotel = new JTextField();
		txtHotel.setEnabled(false);
		txtHotel.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 15));
		pnFh.add(txtHotel);
		txtHotel.setColumns(10);
		
		txtSchedule = new JTextArea();
		txtSchedule.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		txtSchedule.setDisabledTextColor(Color.BLACK);
		txtSchedule.setText("adfsd\r\nfa\r\ndsf\r\nad\r\nf\r\ns\r\na\r\nfss\r\ndf\r\nasd\r\nf\r\nasd\r\nf\r\nasd\r\nfas\r\ndf\r\nads\r\nfa\r\nsd\r\nfa\r\ns");
		txtSchedule.setBorder(new LineBorder(new Color(0, 153, 255), 1, true));
		txtSchedule.setEnabled(false);
		pnSchedule.add(txtSchedule, BorderLayout.CENTER);

	}
	public void showGuiMonthCalendar(int year, int month) {
//		String result = "";
//		result += "ddd";
		//StringBuffer sb = new StringBuffer(); // °¡º¯±æÀÌ ¹®ÀÚ¿­
		//
		int totalDays = 0; // ÀÌ¹ø´ÞÀÇ 1ÀÏ±îÁöÀÇ ÃÑÀÏ¼ö??
		
		// ³âµµ °è»êÀ¸·Î ÃÑÀÏ ¼ö °è»ê
		for (int y = 1; y < year; y++) {
			if( y % 400 == 0 ) totalDays += 366; // À±³â
			else if( y % 100 == 0 ) totalDays += 365; // Æò³â
			else if( y % 4 == 0 ) totalDays += 366; // À±³â
			else totalDays += 365; // Æò³â
		} // ÀÛ³â±îÁö(12/31)ÀÇ ¸ðµç ÀÏ¼ö °è»ê
		
		boolean bLeapYear = false; // Æò³â
		if( year % 400 == 0 ) bLeapYear = true; // À±³â
		else if( year % 100 == 0 ) bLeapYear = false; // Æò³â
		else if( year % 4 == 0 ) bLeapYear = true; // À±³â
		else bLeapYear = false; // Æò³â
		
		// ¿ÃÇØÀÇ Àü¿ù±îÁöÀÇ ÀÏ¼ö¸¦ ¿ù´ÜÀ§ °è»êÀ¸·Î Ãß°¡
		int[] daysInMonth = {
			0, 31, bLeapYear ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31	
		}; // 2¿ù´Þ¸¸ À±³âÀÌ¸é 29ÀÏÀÌ³Ä ¾Æ´Ï³Ä... 28ÀÏ Æò³â
		for (int m = 1; m < month; m++) {
			totalDays += daysInMonth[m];
		}
		
		// ¿ÃÇØ ÀÌ¹ø´Þ 1ÀÏ Ãß°¡
		totalDays++;
		// ¼­¾ç½ÄÀ¸·Î ÀÏ¿äÀÏºÎÅÍ ½ÃÀÛµÊ.. 0 ÀÏ¿äÀÏ 1 ¿ù¿äÀÏ => 6 Åä¿äÀÏ
		int yoil = totalDays % 7; // 0 ~ 6

		// ¸ðµç ³¯Â¥ ¹öÆ°À» ¸®¼Â...
		for (JToggleButton btnDay : btnDays) {
			btnDay.setText("");
			btnDay.setEnabled(false); // ºñÈ°¼ºÈ­
			btnDay.setBorder(new EmptyBorder(0,0,0,0));
		}
			
		
		for (int day = 1; day <= daysInMonth[month]; day++) {
			String dayStr = String.format("%2d", day);
			JToggleButton btnDay = btnDays[day+yoil-1];
			btnDay.setText(dayStr);
			btnDay.setEnabled(true); // È°¼ºÈ­

		}

	}

}

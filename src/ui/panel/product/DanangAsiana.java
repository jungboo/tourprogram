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

import db.AdminDBMgr;
import db.ProductDBMgr;
import db.model.Product;
import ui.manager.ManagerPage;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class DanangAsiana extends JPanel {
	//����*
	ProductDBMgr pDBMgr = new ProductDBMgr();
	Product pd = new Product();
	//
	
	//����*2
	AdminDBMgr adDBMgr = new AdminDBMgr();
	//
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	JToggleButton[] btnDays;
	public static final Font FNT_DAY = new Font("�޸տ�����", Font.PLAIN, 10);
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
	//����*
	private final ButtonGroup btnDateGroup = new ButtonGroup();
	String selectedDate;
	private final int adultMinusChild = 200000;
	private final int babyPrice = 100000;
	//
	

	public DanangAsiana() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lbPdImage1 = new JLabel("");
		lbPdImage1.setSize(280, 200);
		//����*
		ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[1]).get(0));
		//
		Image scaled = ic1.getImage().getScaledInstance(lbPdImage1.getWidth(),
				lbPdImage1.getHeight(), Image.SCALE_FAST);
		ic1.setImage(scaled);
		lbPdImage1.setIcon(ic1);
		panel.add(lbPdImage1);
		
		JLabel lblNewLabel = new JLabel("     ");
		panel.add(lblNewLabel);
		
		lbPdImage2 = new JLabel("");
		lbPdImage2.setSize(280, 200);
		//����*
		ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[1]).get(1));
		//
		Image scaled2 = ic2.getImage().getScaledInstance(lbPdImage2.getWidth(),
				lbPdImage2.getHeight(), Image.SCALE_FAST);
		ic2.setImage(scaled2);
		lbPdImage2.setIcon(ic2);
		panel.add(lbPdImage2);
		
		JLabel label_1 = new JLabel("     ");
		panel.add(label_1);
		
		lbPdImage3 = new JLabel("");
		lbPdImage3.setSize(280, 200);
		//����*
		ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[1]).get(2));
		//
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
				//����*1
				if( rd1.isSelected()) {
					txtHotel.setText(pDBMgr.selectHotelByCode(pd.CODE_LIST[1]).get(0));
					txtSchedule.setText(pDBMgr.selectScheduleProductByCode(pd.CODE_LIST[1], 1).get(0));
				}
				//
			}
		});
		rd1.setHorizontalAlignment(SwingConstants.CENTER);
		rd1.setFont(new Font("�޸տ�����", Font.BOLD, 18));
		buttonGroup.add(rd1);
		panel_2.add(rd1);
		
		JRadioButton rd2 = new JRadioButton("2\uC77C\uCC28");
		rd2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lbFlight.setVisible(false);
				txtFlight.setVisible(false);
				//����*1
				if( rd2.isSelected()) {
					txtHotel.setText(pDBMgr.selectHotelByCode(pd.CODE_LIST[1]).get(1));
					txtSchedule.setText(pDBMgr.selectScheduleProductByCode(pd.CODE_LIST[1], 2).get(0));
				}
				//
			}
		});
		rd2.setHorizontalAlignment(SwingConstants.CENTER);
		rd2.setFont(new Font("�޸տ�����", Font.BOLD, 18));
		buttonGroup.add(rd2);
		panel_2.add(rd2);
		
		JRadioButton rd3 = new JRadioButton("3\uC77C\uCC28");
		rd3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lbFlight.setVisible(false);
				txtFlight.setVisible(false);
				//����*1
				if( rd3.isSelected()) {
					txtHotel.setText(pDBMgr.selectHotelByCode(pd.CODE_LIST[1]).get(2));
					txtSchedule.setText(pDBMgr.selectScheduleProductByCode(pd.CODE_LIST[1], 3).get(0));
				}
				//
			}
		});
		rd3.setHorizontalAlignment(SwingConstants.CENTER);
		rd3.setFont(new Font("�޸տ�����", Font.BOLD, 18));
		buttonGroup.add(rd3);
		panel_2.add(rd3);
		
		JRadioButton rd4 = new JRadioButton("4\uC77C\uCC28");
		rd4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lbFlight.setVisible(true);
				txtFlight.setVisible(true);
				///����*1
				if( rd4.isSelected()) {
					txtHotel.setText(pDBMgr.selectHotelByCode(pd.CODE_LIST[1]).get(3));
					txtSchedule.setText(pDBMgr.selectScheduleProductByCode(pd.CODE_LIST[1], 4).get(0));
				}
				//
			}
		});
		rd4.setHorizontalAlignment(SwingConstants.CENTER);
		rd4.setFont(new Font("�޸տ�����", Font.BOLD, 18));
		buttonGroup.add(rd4);
		panel_2.add(rd4);
		
		JRadioButton rd5 = new JRadioButton("5\uC77C\uCC28");
		rd5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lbFlight.setVisible(false);
				txtFlight.setVisible(false);
				//����*1
				if( rd5.isSelected()) {
					txtSchedule.setText(pDBMgr.selectScheduleProductByCode(pd.CODE_LIST[1], 5).get(0));
				}
				//
			}
		});
		rd5.setHorizontalAlignment(SwingConstants.CENTER);
		rd5.setFont(new Font("�޸տ�����", Font.BOLD, 18));
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
		lbYear.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		pnCdTop.add(lbYear);
		
		txtYear = new JTextField();
		txtYear.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		txtYear.setText("2021");
		pnCdTop.add(txtYear);
		txtYear.setColumns(4);
		
		JLabel lbMonth = new JLabel("\uC6D4");
		lbMonth.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		pnCdTop.add(lbMonth);
		
		txtMonth = new JTextField();
		txtMonth.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
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
		button.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		toolBar.add(button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mvYear = Integer.parseInt(txtYear.getText());
				int mvMonth = Integer.parseInt(txtMonth.getText());
				mvMonth--;
				if( mvMonth == 0 ) { // ���� 1������ => �۳� 12����
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
				if( mvMonth == 13 ) { // ���� 12������ => ���� 1����
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
		lbSunday.setFont(new Font("�޸տ�����", Font.PLAIN, 15));
		lbSunday.setForeground(Color.RED);
		pnCdCenter.add(lbSunday);
		
		JLabel lbMonday = new JLabel("MON");
		lbMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lbMonday.setFont(new Font("�޸տ�����", Font.PLAIN, 15));
		pnCdCenter.add(lbMonday);
		
		JLabel lbTuesDay = new JLabel("TUE");
		lbTuesDay.setHorizontalAlignment(SwingConstants.CENTER);
		lbTuesDay.setFont(new Font("�޸տ�����", Font.PLAIN, 15));
		pnCdCenter.add(lbTuesDay);
		
		JLabel lbWendnesDay = new JLabel("WED");
		lbWendnesDay.setHorizontalAlignment(SwingConstants.CENTER);
		lbWendnesDay.setFont(new Font("�޸տ�����", Font.PLAIN, 15));
		pnCdCenter.add(lbWendnesDay);
		
		JLabel lbThursday = new JLabel("THU");
		lbThursday.setHorizontalAlignment(SwingConstants.CENTER);
		lbThursday.setFont(new Font("�޸տ�����", Font.PLAIN, 15));
		pnCdCenter.add(lbThursday);
		
		JLabel lbFirday = new JLabel("FRI");
		lbFirday.setHorizontalAlignment(SwingConstants.CENTER);
		lbFirday.setFont(new Font("�޸տ�����", Font.PLAIN, 15));
		pnCdCenter.add(lbFirday);
		
		JLabel lbSaturday = new JLabel("SAT");
		lbSaturday.setHorizontalAlignment(SwingConstants.CENTER);
		lbSaturday.setFont(new Font("�޸տ�����", Font.PLAIN, 15));
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
			
			btnDays[i] = btnDay; // �迭�� ��� 0 ~ 41
			pnCdCenter.add(btnDay); // �׸��忡 ��� 7 ~ 48 (1,0) ~ (6,6)
			//����*
			btnDateGroup.add(btnDay);
			btnDay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int chkDate = Integer.parseInt(e.getActionCommand());
					String strYear = txtYear.getText();
					String strMonth = txtMonth.getText();
					if( strMonth.length() == 1 ) strMonth = "0" + strMonth;
					String strDate = String.valueOf(chkDate);
					if( strDate.length() == 1 ) strDate = "0" + strDate;
					selectedDate = strYear + "-" + strMonth + "-" + strDate;
					txtAdultPr.setText(String.valueOf(pDBMgr.selectPriceByCodeAndDate(pd.CODE_LIST[1], selectedDate)));
					txtChildPr.setText(String.valueOf
							(pDBMgr.selectPriceByCodeAndDate(pd.CODE_LIST[1], selectedDate) - adultMinusChild));
					txtBabyPr.setText(String.valueOf(babyPrice));
					System.out.println(selectedDate.substring(8));
				}
			});
			//
		}
		
		JPanel pnPeople = new JPanel();
		panel_3.add(pnPeople);
		pnPeople.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel lbAdult = new JLabel("\uC131\uC778");
		lbAdult.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		lbAdult.setHorizontalAlignment(SwingConstants.CENTER);
		pnPeople.add(lbAdult);
		
		spinAdult = new JSpinner();
		//����*
		spinAdult.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(txtAdultPr.getText() != null && txtChildPr.getText() != null && txtBabyPr.getText() != null &&
						!txtAdultPr.getText().isEmpty() && !txtChildPr.getText().isEmpty() && !txtBabyPr.getText().isEmpty()) {
				long totalAdultpr = (int)spinAdult.getValue() * Long.parseLong(txtAdultPr.getText());
				long totalChildpr = (int)spinChild.getValue() * Long.parseLong(txtChildPr.getText());
				long totalBabypr = (int)spinBaby.getValue() * Long.parseLong(txtBabyPr.getText());
				txtTotal.setText(String.valueOf(totalAdultpr + totalChildpr + totalBabypr));}
				else{txtTotal.setText("");}
			}
		});
		//
		spinAdult.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		pnPeople.add(spinAdult);
		
		JLabel lbChild = new JLabel("\uC544\uB3D9");
		lbChild.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		lbChild.setHorizontalAlignment(SwingConstants.CENTER);
		pnPeople.add(lbChild);
		
		spinChild = new JSpinner();
		//����*
		spinChild.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(txtAdultPr.getText() != null && txtChildPr.getText() != null && txtBabyPr.getText() != null &&
						!txtAdultPr.getText().isEmpty() && !txtChildPr.getText().isEmpty() && !txtBabyPr.getText().isEmpty()) {
				long totalAdultpr = (int)spinAdult.getValue() * Long.parseLong(txtAdultPr.getText());
				long totalChildpr = (int)spinChild.getValue() * Long.parseLong(txtChildPr.getText());
				long totalBabypr = (int)spinBaby.getValue() * Long.parseLong(txtBabyPr.getText());
				txtTotal.setText(String.valueOf(totalAdultpr + totalChildpr + totalBabypr));}
				else{txtTotal.setText("");}
			}
		});
		//
		spinChild.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		pnPeople.add(spinChild);
		
		JLabel lbBaby = new JLabel("\uC720\uC544");
		lbBaby.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		lbBaby.setHorizontalAlignment(SwingConstants.CENTER);
		pnPeople.add(lbBaby);
		
		spinBaby = new JSpinner();
		//����*
		spinBaby.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(txtAdultPr.getText() != null && txtChildPr.getText() != null && txtBabyPr.getText() != null &&
						!txtAdultPr.getText().isEmpty() && !txtChildPr.getText().isEmpty() && !txtBabyPr.getText().isEmpty()) {
				long totalAdultpr = (int)spinAdult.getValue() * Long.parseLong(txtAdultPr.getText());
				long totalChildpr = (int)spinChild.getValue() * Long.parseLong(txtChildPr.getText());
				long totalBabypr = (int)spinBaby.getValue() * Long.parseLong(txtBabyPr.getText());
				txtTotal.setText(String.valueOf(totalAdultpr + totalChildpr + totalBabypr));}
				else{txtTotal.setText("");}
			}
		});
		//
		spinBaby.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		pnPeople.add(spinBaby);
		
		JPanel pnPrice = new JPanel();
		panel_3.add(pnPrice);
		pnPrice.setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel lbAdultPr = new JLabel("\uC131\uC778\uC694\uAE08");
		lbAdultPr.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		lbAdultPr.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrice.add(lbAdultPr);
		
		txtAdultPr = new JTextField();
		txtAdultPr.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		txtAdultPr.setEnabled(false);
		pnPrice.add(txtAdultPr);
		txtAdultPr.setColumns(10);
		
		JLabel lbChildPr = new JLabel("\uC544\uB3D9\uC694\uAE08");
		lbChildPr.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		lbChildPr.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrice.add(lbChildPr);
		
		txtChildPr = new JTextField();
		txtChildPr.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		txtChildPr.setEnabled(false);
		pnPrice.add(txtChildPr);
		txtChildPr.setColumns(10);
		
		JLabel lbBabyPr = new JLabel("\uC720\uC544\uC694\uAE08");
		lbBabyPr.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		lbBabyPr.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrice.add(lbBabyPr);
		
		txtBabyPr = new JTextField();
		txtBabyPr.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		txtBabyPr.setEnabled(false);
		pnPrice.add(txtBabyPr);
		txtBabyPr.setColumns(10);
		
		JLabel lbTotal = new JLabel("\uCD1D\uC694\uAE08");
		lbTotal.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		lbTotal.setHorizontalAlignment(SwingConstants.CENTER);
		pnPrice.add(lbTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		txtTotal.setEnabled(false);
		pnPrice.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("");
		pnPrice.add(lblNewLabel_8);
		//����*2
		btnReservation = new JButton("\uC608\uC57D\uD558\uAE30");
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adDBMgr.updateReservationList(pd.CODE_LIST[1], new Date(), selectedDate, "������", 
						(int)((int)spinAdult.getValue()+(int)spinChild.getValue()+(int)spinBaby.getValue()), "010-5659-3885");
			}
		});
		//
		btnReservation.setFont(new Font("�޸տ�����", Font.PLAIN, 12));
		pnPrice.add(btnReservation);
		
		pnSchedule = new JPanel();
		panel_1.add(pnSchedule, BorderLayout.CENTER);
		pnSchedule.setLayout(new BorderLayout(0, 0));
		
		pnFh = new JPanel();
		pnSchedule.add(pnFh, BorderLayout.NORTH);
		pnFh.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		lbFlight = new JLabel("\uD56D\uACF5\uD3B8");
		lbFlight.setFont(new Font("�޸տ�����", Font.PLAIN, 14));
		pnFh.add(lbFlight);
		
		txtFlight = new JTextField();
		txtFlight.setEnabled(false);
		txtFlight.setFont(new Font("�޸տ�����", Font.PLAIN, 15));
		pnFh.add(txtFlight);
		txtFlight.setColumns(10);
		
		lbHotel = new JLabel("\uD638\uD154");
		lbHotel.setFont(new Font("�޸տ�����", Font.PLAIN, 14));
		pnFh.add(lbHotel);
		
		txtHotel = new JTextField();
		txtHotel.setEnabled(false);
		txtHotel.setFont(new Font("�޸տ�����", Font.PLAIN, 15));
		
		//����*1
		txtHotel.setText(pDBMgr.selectHotelByCode(pd.CODE_LIST[1]).get(0));
		txtHotel.setColumns(15);
		//
		pnFh.add(txtHotel);
		
		
		txtSchedule = new JTextArea();
		txtSchedule.setFont(new Font("�޸տ�����", Font.PLAIN, 14));
		txtSchedule.setDisabledTextColor(Color.BLACK);
		//����*1
		txtSchedule.setText(pDBMgr.selectScheduleProductByCode(pd.CODE_LIST[1], 1).get(0));
		//
		txtSchedule.setBorder(new LineBorder(new Color(0, 153, 255), 1, true));
		txtSchedule.setEnabled(false);
		pnSchedule.add(txtSchedule, BorderLayout.CENTER);

	}
	public void showGuiMonthCalendar(int year, int month) {
//		String result = "";
//		result += "ddd";
		//StringBuffer sb = new StringBuffer(); // �������� ���ڿ�
		//
		int totalDays = 0; // �̹����� 1�ϱ����� ���ϼ�??
		
		// �⵵ ������� ���� �� ���
		for (int y = 1; y < year; y++) {
			if( y % 400 == 0 ) totalDays += 366; // ����
			else if( y % 100 == 0 ) totalDays += 365; // ���
			else if( y % 4 == 0 ) totalDays += 366; // ����
			else totalDays += 365; // ���
		} // �۳����(12/31)�� ��� �ϼ� ���
		
		boolean bLeapYear = false; // ���
		if( year % 400 == 0 ) bLeapYear = true; // ����
		else if( year % 100 == 0 ) bLeapYear = false; // ���
		else if( year % 4 == 0 ) bLeapYear = true; // ����
		else bLeapYear = false; // ���
		
		// ������ ���������� �ϼ��� ������ ������� �߰�
		int[] daysInMonth = {
			0, 31, bLeapYear ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31	
		}; // 2���޸� �����̸� 29���̳� �ƴϳ�... 28�� ���
		for (int m = 1; m < month; m++) {
			totalDays += daysInMonth[m];
		}
		
		// ���� �̹��� 1�� �߰�
		totalDays++;
		// ��������� �Ͽ��Ϻ��� ���۵�.. 0 �Ͽ��� 1 ������ => 6 �����
		int yoil = totalDays % 7; // 0 ~ 6

		// ��� ��¥ ��ư�� ����...
		for (JToggleButton btnDay : btnDays) {
			btnDay.setText("");
			btnDay.setEnabled(false); // ��Ȱ��ȭ			
			btnDay.setBorder(new EmptyBorder(0,0,0,0));
		}
			
		//����*
		for (int day = 1; day <= daysInMonth[month]; day++) {
			String dayStr = String.valueOf(day).length() == 1 ? "0"+day : ""+day;
			JToggleButton  btnDay = btnDays[day+yoil-1];
			btnDay.setText(dayStr);
			ArrayList<String> pdList = pDBMgr.selectDepartureDateByCode(pd.CODE_LIST[1]);
			String dpYear;
			String dpMonth;
			String dpDate;
			for (int i = 0; i < pdList.size(); i++) {
				dpYear = pdList.get(i).substring(0, 4);
				dpMonth = pdList.get(i).substring(5, 7);
				dpDate = pdList.get(i).substring(8, 10);
				if(String.valueOf(year).equalsIgnoreCase(dpYear) && 
						(String.valueOf(month).length() == 1 ? "0"+""+month : ""+month).equalsIgnoreCase(dpMonth) 
						&& dayStr.equalsIgnoreCase(dpDate)) {
				if(pDBMgr.selectReservationNameByCode(pd.CODE_LIST[1]).get(i).getReservation() == 1)
					btnDay.setEnabled(true);
				}
			}
		}
		//
		
	}

}

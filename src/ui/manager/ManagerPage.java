package ui.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import db.ProductDBMgr;
import db.model.Product;
import ui.main.TourMainFrame;
import ui.manager.hotel.HotelDialog;
import ui.panel.combo.ProductAirAsianaPanel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.CardLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;

public class ManagerPage extends JFrame implements ItemListener{
	Product pd;
	private final int adultMinusChild = 200000;
	private final int babyPrice = 100000;
	private JPanel contentPane;
	public static JLabel lbOnedayHotel ,lbTwodayHotel, lbThreedayHotel, lbFourdayHotel;
	public static JLabel[]  lbDayHotels= {lbOnedayHotel, lbTwodayHotel, lbThreedayHotel, lbFourdayHotel};
	public static JTabbedPane pnSchedules;
	JLabel lbProduct;
	JLabel lbReservation;
	JRadioButton rdDKE, rdDOZ, rdDVJ, rdHKE, rdHOZ, rdHVJ, rdSKE, rdSOZ, rdSVJ;
	static String selectedCode = "DKE";
	JLabel lbCodeName;
	ProductDBMgr pDBMgr = new ProductDBMgr();
	JToggleButton[] btnDays;
	JToggleButton btnDay;
	String selectedDate = pDBMgr.selectDepartureDateByCode(selectedCode).get(0);
	int cYear;
	int cMonth;
	ManagerPage mgPg;
	String selImageDBPath1;
	String selImageDBPath2;
	String selImageDBPath3;
	JLabel lbPicture1;
	JLabel lbPicture2;
	JLabel lbPicture3;
	JPanel pnPictures;
	JRadioButton rbReservationTrue;
	JRadioButton rbReservationFalse;
	JRadioButton rbGuideTrue;
	JRadioButton rbGuideFalse;
	private JTextArea txtSchedule1, txtSchedule2, txtSchedule3, txtSchedule4, txtSchedule5;
	JTextArea[] txtScheduls = {txtSchedule1, txtSchedule2, txtSchedule3, txtSchedule4, txtSchedule5};
	
	
	
	private final ButtonGroup btnCodeGroup = new ButtonGroup();
	private JTextField txtProductName;
	public JTextField getTxtProductName() {
		return txtProductName;
	}
	private JTextField txtAdultPrice;
	private JTextField txtChildPrice;
	private JTextField txtBabyPrice;
	private final ButtonGroup btnReservationGroup = new ButtonGroup();
	private JTextField txtMinPeople;
	private JTextField txtMaxPeople;
	private final ButtonGroup btnGuideGroup = new ButtonGroup();
	private final ButtonGroup btnDayCountGroup = new ButtonGroup();
	private final ButtonGroup btnDateGroup = new ButtonGroup();
	private JTextField txtYear;
	private JTextField txtMonth;
	
//	ProductAirAsianaPanel pAA = new ProductAirAsianaPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerPage frame = new ManagerPage();
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public ManagerPage() {
		this.mgPg = this;
		HotelDialog hDlg = new HotelDialog();
		//수정*1
		ReservationManageDlg rDlg = new ReservationManageDlg(); 
		setTitle("\uAD00\uB9AC\uC790 \uD398\uC774\uC9C0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1565, 1071);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("\uAD00\uB9AC\uC790 \uD398\uC774\uC9C0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 50));
		panel.add(lblNewLabel);

		JPanel pnReservationProduct = new JPanel();
		pnReservationProduct.setBackground(Color.LIGHT_GRAY);
		panel.add(pnReservationProduct, BorderLayout.SOUTH);
		pnReservationProduct.setLayout(new GridLayout(0, 2, 0, 0));

		lbReservation = new JLabel("\uC608\uC57D\uD655\uC778");
		lbReservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbReservation.setForeground(Color.white);
				lbProduct.setForeground(Color.black);
				rDlg.setVisible(true);
				
			}
		});
		lbReservation.setHorizontalAlignment(SwingConstants.CENTER);
		lbReservation.setFont(new Font("굴림", Font.BOLD, 30));
		lbReservation.setBorder(new LineBorder(Color.blue, 2));
		pnReservationProduct.add(lbReservation);

		lbProduct = new JLabel("\uC0C1\uD488\uAD00\uB9AC");
		lbProduct.setForeground(Color.WHITE);
		lbProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbProduct.setForeground(Color.white);
				lbReservation.setForeground(Color.black);
			}
		});
		lbProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lbProduct.setFont(new Font("굴림", Font.BOLD, 30));
		lbProduct.setBorder(new LineBorder(Color.blue, 2));
		pnReservationProduct.add(lbProduct);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JPanel pnProductMain = new JPanel();
		scrollPane.setViewportView(pnProductMain);
		pnProductMain.setLayout(new BorderLayout(0, 0));

		JPanel pnSelectCode = new JPanel();
		pnSelectCode.setBackground(Color.CYAN);
		pnProductMain.add(pnSelectCode, BorderLayout.WEST);
		pnSelectCode.setLayout(new GridLayout(9, 0, 5, 5));

		rdDKE = new JRadioButton("\uB2E4\uB0AD / \uB300\uD55C\uD56D\uACF5(DKE)");
		rdDKE.setBackground(Color.LIGHT_GRAY);
		rdDKE.setFont(new Font("굴림", Font.BOLD, 12));
		rdDKE.setSelected(true);
		rdDKE.addItemListener(this);
		btnCodeGroup.add(rdDKE);
		pnSelectCode.add(rdDKE);

		rdDOZ = new JRadioButton("\uB2E4\uB0AD / \uC544\uC2DC\uC544\uB098(DOZ)");
		rdDOZ.setBackground(Color.LIGHT_GRAY);
		rdDOZ.setFont(new Font("굴림", Font.BOLD, 12));
		rdDOZ.addItemListener(this);
		btnCodeGroup.add(rdDOZ);
		pnSelectCode.add(rdDOZ);

		rdDVJ = new JRadioButton("\uB2E4\uB0AD / \uBE44\uC5E3\uC82F\uD56D\uACF5(DVJ)");
		rdDVJ.setBackground(Color.LIGHT_GRAY);
		rdDVJ.setFont(new Font("굴림", Font.BOLD, 12));
		rdDVJ.addItemListener(this);
		btnCodeGroup.add(rdDVJ);
		pnSelectCode.add(rdDVJ);

		rdHKE = new JRadioButton("\uD558\uB178\uC774 / \uB300\uD55C\uD56D\uACF5(HKE)");
		rdHKE.setBackground(Color.LIGHT_GRAY);
		rdHKE.setFont(new Font("굴림", Font.BOLD, 12));
		rdHKE.addItemListener(this);
		btnCodeGroup.add(rdHKE);
		pnSelectCode.add(rdHKE);

		rdHOZ = new JRadioButton("\uD558\uB178\uC774 / \uC544\uC2DC\uC544\uB098(HOZ)");
		rdHOZ.setBackground(Color.LIGHT_GRAY);
		rdHOZ.setFont(new Font("굴림", Font.BOLD, 12));
		rdHOZ.addItemListener(this);
		btnCodeGroup.add(rdHOZ);
		pnSelectCode.add(rdHOZ);

		rdHVJ = new JRadioButton("\uD558\uB178\uC774 / \uBE44\uC5E3\uC82F\uD56D\uACF5(HVJ)");
		rdHVJ.setBackground(Color.LIGHT_GRAY);
		rdHVJ.setFont(new Font("굴림", Font.BOLD, 12));
		rdHVJ.addItemListener(this);
		btnCodeGroup.add(rdHVJ);
		pnSelectCode.add(rdHVJ);

		rdSKE = new JRadioButton("\uD638\uCE58\uBBFC / \uB300\uD55C\uD56D\uACF5(SKE)");
		rdSKE.setBackground(Color.LIGHT_GRAY);
		rdSKE.setFont(new Font("굴림", Font.BOLD, 12));
		rdSKE.addItemListener(this);
		btnCodeGroup.add(rdSKE);
		pnSelectCode.add(rdSKE);

		rdSOZ = new JRadioButton("\uD638\uCE58\uBBFC / \uC544\uC2DC\uC544\uB098(SOZ)");
		rdSOZ.setBackground(Color.LIGHT_GRAY);
		rdSOZ.setFont(new Font("굴림", Font.BOLD, 12));
		rdSOZ.addItemListener(this);
		btnCodeGroup.add(rdSOZ);
		pnSelectCode.add(rdSOZ);

		rdSVJ = new JRadioButton("\uD638\uCE58\uBBFC / \uBE44\uC5E3\uC82F\uD56D\uACF5(SVJ)");
		rdSVJ.setBackground(Color.LIGHT_GRAY);
		rdSVJ.setFont(new Font("굴림", Font.BOLD, 12));
		rdSVJ.addItemListener(this);
		btnCodeGroup.add(rdSVJ);
		pnSelectCode.add(rdSVJ);

		JPanel pnEdit = new JPanel();
		pnProductMain.add(pnEdit, BorderLayout.CENTER);
		pnEdit.setLayout(new BorderLayout(0, 0));

		JPanel pnEditMain = new JPanel();
		pnEdit.add(pnEditMain, BorderLayout.NORTH);
		pnEditMain.setLayout(new GridLayout(1, 5, 0, 0));

		lbCodeName = new JLabel();
		lbCodeName.setForeground(Color.BLUE);
		lbCodeName.setFont(new Font("굴림", Font.BOLD, 20));
		pnEditMain.add(lbCodeName);
		
		JButton btnAddProductDate = new JButton("\uC0C1\uD488\uB0A0\uC9DC \uCD94\uAC00");
		btnAddProductDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddProductDate addDlg = new AddProductDate();
			addDlg.setVisible(true);
			}
		});
		pnEditMain.add(btnAddProductDate);

		JLabel lbProductName_1 = new JLabel("\uC0C1\uD488\uBA85 : ");
		lbProductName_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbProductName_1.setFont(new Font("굴림", Font.PLAIN, 20));
		pnEditMain.add(lbProductName_1);

		txtProductName = new JTextField();
		txtProductName.setFont(new Font("굴림", Font.PLAIN, 15));
		pnEditMain.add(txtProductName);
		txtProductName.setColumns(10);

		JButton btnProductName = new JButton("\uC0C1\uD488\uBA85 \uC218\uC815");
		btnProductName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pDBMgr.updateProductNameByCode(selectedCode, txtProductName.getText());
			}
		});
		btnProductName.setFont(new Font("굴림", Font.PLAIN, 15));
		pnEditMain.add(btnProductName);

		JPanel pn1 = new JPanel();
		pnEdit.add(pn1, BorderLayout.CENTER);
		pn1.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		pn1.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pnCalander = new JPanel();
		panel_1.add(pnCalander);
		pnCalander.setLayout(new BorderLayout(0, 0));
		
		JPanel pnCalTop = new JPanel();
		pnCalander.add(pnCalTop, BorderLayout.NORTH);
		
		JLabel lbYear = new JLabel("\uB144\uB3C4:");
		pnCalTop.add(lbYear);
		
		// 금월 표기
		Calendar cal = Calendar.getInstance();
		int tYear = cal.get(Calendar.YEAR);
		int tMonth = cal.get(Calendar.MONTH)+1;
		
		txtYear = new JTextField();
		txtYear.setColumns(4);
		txtYear.setText(""+tYear);
		pnCalTop.add(txtYear);
		
		JLabel lb = new JLabel("   ");
		pnCalTop.add(lb);
		
		JLabel lbMonth = new JLabel("\uC6D4:");
		pnCalTop.add(lbMonth);
		
		txtMonth = new JTextField();
		txtMonth.setColumns(2);
		txtMonth.setText(String.valueOf(tMonth));
		pnCalTop.add(txtMonth);
		
		JLabel lb1 = new JLabel("   ");
		pnCalTop.add(lb1);
		
		JPanel pnChangeCal = new JPanel();
		pnChangeCal.setBackground(UIManager.getColor("Button.background"));
		pnCalTop.add(pnChangeCal);
		
		JButton btnThisMonth = new JButton("");
		btnThisMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cYear = Integer.parseInt(
						txtYear.getText()	);
				cMonth = Integer.parseInt(
						txtMonth.getText()	);
				showGuiMonthCalendar(cYear, cMonth);			
			}
		});
		btnThisMonth.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Project\\icons\\accept.png"));
		btnThisMonth.setToolTipText("\uC6D4\uB2EC\uB825\uD45C\uC2DC");
		pnChangeCal.add(btnThisMonth);
		
		JButton btnPrevMonth = new JButton("");
		btnPrevMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mvYear = Integer.parseInt(
						txtYear.getText() );
				int mvMonth = Integer.parseInt(
						txtMonth.getText() );
				mvMonth--; 
				if( mvMonth == 0 ) { 
					mvMonth = 12;
					mvYear--;
					txtYear.setText(String.valueOf(mvYear));
				}
				txtMonth.setText(""+mvMonth);
				showGuiMonthCalendar(mvYear, mvMonth);
			}
		});
		btnPrevMonth.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Project\\icons\\arrow_left.png"));
		btnPrevMonth.setToolTipText("\uC9C0\uB09C\uB2EC \uD45C\uC2DC");
		pnChangeCal.add(btnPrevMonth);
		
		JButton btnNextMonth = new JButton("");
		btnNextMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mvYear = Integer.parseInt(
						txtYear.getText() );
				int mvMonth = Integer.parseInt(
						txtMonth.getText() );
				mvMonth++; 
				if( mvMonth == 13 ) {
					mvMonth = 1;
					mvYear++;
					txtYear.setText(String.valueOf(mvYear));
				}
				txtMonth.setText(""+mvMonth);
				showGuiMonthCalendar(mvYear, mvMonth);
			}
		});
		btnNextMonth.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Project\\icons\\arrow_right.png"));
		btnNextMonth.setToolTipText("\uB2E4\uC74C\uB2EC \uD45C\uC2DC");
		pnChangeCal.add(btnNextMonth);
		
		JPanel pnCalMain = new JPanel();
		pnCalander.add(pnCalMain, BorderLayout.CENTER);
		pnCalMain.setLayout(new GridLayout(7, 7, 0, 0));
		
		JLabel lbSunday = new JLabel("SUN");
		lbSunday.setHorizontalAlignment(SwingConstants.CENTER);
		lbSunday.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lbSunday.setForeground(Color.RED);
		pnCalMain.add(lbSunday);
		
		JLabel lbMonday = new JLabel("MON");
		lbMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lbMonday.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		pnCalMain.add(lbMonday);
		
		JLabel lbTuesday = new JLabel("TUE");
		lbTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		lbTuesday.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		pnCalMain.add(lbTuesday);
		
		JLabel lbWednesday = new JLabel("WED");
		lbWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		lbWednesday.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		pnCalMain.add(lbWednesday);
		
		JLabel lbThursday = new JLabel("THU");
		lbThursday.setHorizontalAlignment(SwingConstants.CENTER);
		lbThursday.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		pnCalMain.add(lbThursday);
		
		JLabel lbFriday = new JLabel("FRI");
		lbFriday.setHorizontalAlignment(SwingConstants.CENTER);
		lbFriday.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		pnCalMain.add(lbFriday);
		
		JLabel lbSaturday = new JLabel("SAT");
		lbSaturday.setHorizontalAlignment(SwingConstants.CENTER);
		lbSaturday.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lbSaturday.setForeground(Color.BLUE);
		pnCalMain.add(lbSaturday);
		
		
		// 42개의 JToggleButton 객체를 동적생성하여 배열로 등록
		final int BTN_LIMIT = 42;
		this.btnDays = new JToggleButton[BTN_LIMIT];
		for (int i = 0; i < btnDays.length; i++) {
			btnDay = new JToggleButton("");
			btnDay.setHorizontalAlignment(JToggleButton.CENTER);
			btnDays[i] = btnDay; // 배열에 등록 0 ~ 41
			pnCalMain.add(btnDay); // 그리드에 등록 7 ~ 48 (1,0) ~ (6,6)
			btnDateGroup.add(btnDay);
			// 날짜 선택으로 가격, 예약가능유무, 가이드 유무 불러오기
			btnDay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int chkDate = Integer.parseInt(e.getActionCommand());
					String strYear = txtYear.getText();
					String strMonth = txtMonth.getText();
					if( strMonth.length() == 1 ) strMonth = "0" + strMonth;
					String strDate = String.valueOf(chkDate);
					if( strDate.length() == 1 ) strDate = "0" + strDate;
					selectedDate = strYear + "-" + strMonth + "-" + strDate;
					txtAdultPrice.setText(String.valueOf(pDBMgr.selectPriceByCodeAndDate(selectedCode, selectedDate)));
					txtChildPrice.setText(String.valueOf
							(pDBMgr.selectPriceByCodeAndDate(selectedCode, selectedDate) - adultMinusChild));
					txtBabyPrice.setText(String.valueOf(babyPrice));
					txtMinPeople.setText(String.valueOf(pDBMgr.selectMinimumPeopleByCodeAndDate(selectedCode, selectedDate)));
					txtMaxPeople.setText(String.valueOf(pDBMgr.selectMaximumPeopleByCodeAndDate(selectedCode, selectedDate)));
					rbReservationFalse.setSelected(pDBMgr.selectReservationByCodeAndDPDay(selectedCode, selectedDate) == 0);
					rbReservationTrue.setSelected(pDBMgr.selectReservationByCodeAndDPDay(selectedCode, selectedDate) == 1);
					rbGuideFalse.setSelected(pDBMgr.selectGuideByCodeAndDPDay(selectedCode, selectedDate) == 0);
					rbGuideTrue.setSelected(pDBMgr.selectGuideByCodeAndDPDay(selectedCode, selectedDate) == 1);			
				}
			});
		}
		
		
		JPanel pnCollection = new JPanel();
		panel_1.add(pnCollection);
		pnCollection.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnPrice = new JPanel();
		pnCollection.add(pnPrice);
		pnPrice.setLayout(new BorderLayout(0, 0));

		JLabel lbPriceName = new JLabel("\uC0C1\uD488\uAC00 \uC218\uC815");
		lbPriceName.setFont(new Font("굴림", Font.PLAIN, 20));
		lbPriceName.setBorder(new LineBorder(Color.DARK_GRAY, 1));
		pnPrice.add(lbPriceName, BorderLayout.NORTH);

		JPanel pnSetPrice = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnSetPrice.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		pnPrice.add(pnSetPrice, BorderLayout.WEST);

		JLabel lbAdultPrice = new JLabel("\uC131\uC778 : ");
		lbAdultPrice.setFont(new Font("굴림", Font.PLAIN, 14));
		pnSetPrice.add(lbAdultPrice);

		txtAdultPrice = new JTextField();
		txtAdultPrice.setFont(new Font("굴림", Font.PLAIN, 14));
		pnSetPrice.add(txtAdultPrice);
		txtAdultPrice.setColumns(10);

		JLabel lbChildPrice = new JLabel("\uC544\uB3D9 : ");
		lbChildPrice.setFont(new Font("굴림", Font.PLAIN, 14));
		pnSetPrice.add(lbChildPrice);

		txtChildPrice = new JTextField();
		txtChildPrice.setEditable(false);
		txtChildPrice.setFont(new Font("굴림", Font.PLAIN, 14));
		pnSetPrice.add(txtChildPrice);
		txtChildPrice.setColumns(10);

		JLabel lbBabyPrice = new JLabel("\uC720\uC544 : ");
		lbBabyPrice.setFont(new Font("굴림", Font.PLAIN, 14));
		pnSetPrice.add(lbBabyPrice);

		txtBabyPrice = new JTextField();
		txtBabyPrice.setEditable(false);
		txtBabyPrice.setFont(new Font("굴림", Font.PLAIN, 14));
		pnSetPrice.add(txtBabyPrice);
		txtBabyPrice.setColumns(10);

		JButton btnEditPrice = new JButton("\uC694\uAE08 \uC218\uC815\uD558\uAE30");
		btnEditPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pDBMgr.updatePriceByCodeAndDpDate(selectedCode, selectedDate, Integer.parseInt(txtAdultPrice.getText()));
				txtChildPrice.setText(String.valueOf(Integer.parseInt(txtAdultPrice.getText()) - adultMinusChild));
			}
		});
		btnEditPrice.setFont(new Font("굴림", Font.PLAIN, 15));
		pnPrice.add(btnEditPrice, BorderLayout.EAST);

		JPanel pnReservation = new JPanel();
		pnCollection.add(pnReservation);
		pnReservation.setLayout(new BorderLayout(0, 0));

		JLabel lbReservationName = new JLabel("\uC608\uC57D \uAC00\uB2A5 \uC5EC\uBD80");
		lbReservationName.setFont(new Font("굴림", Font.PLAIN, 18));
		lbReservationName.setBorder(new LineBorder(Color.DARK_GRAY, 1));
		pnReservation.add(lbReservationName, BorderLayout.NORTH);

		JPanel pnReservationCheck = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnReservationCheck.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnReservation.add(pnReservationCheck, BorderLayout.CENTER);

		rbReservationTrue = new JRadioButton("\uC608\uC57D \uAC00\uB2A5");
		rbReservationTrue.setFont(new Font("굴림", Font.PLAIN, 18));
		btnReservationGroup.add(rbReservationTrue);
		pnReservationCheck.add(rbReservationTrue);

		rbReservationFalse = new JRadioButton("\uC608\uC57D \uBD88\uAC00\uB2A5");
		rbReservationFalse.setSelected(true);
		rbReservationFalse.setFont(new Font("굴림", Font.PLAIN, 18));
		btnReservationGroup.add(rbReservationFalse);
		pnReservationCheck.add(rbReservationFalse);
		
		JButton btnReservation = new JButton("\uC608\uC57D\uAC00\uB2A5\uC5EC\uBD80 \uC218\uC815\uD558\uAE30");
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pDBMgr.updateReservationByCodeAndDpDate
				(selectedCode, selectedDate, rbReservationTrue.isSelected() ? 1 : 0);
			}
		});
		pnReservationCheck.add(btnReservation);

		JPanel pnMinMaxPeople = new JPanel();
		pnCollection.add(pnMinMaxPeople);
		pnMinMaxPeople.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnMin = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnMin.getLayout();
		pnMin.setBorder(new LineBorder(Color.DARK_GRAY, 1));
		flowLayout_3.setAlignment(FlowLayout.LEFT);

		pnMinMaxPeople.add(pnMin);

		JLabel lbMinPeopleName = new JLabel("\uCD5C\uC18C \uCD9C\uBC1C\uC778\uC6D0");
		lbMinPeopleName.setFont(new Font("굴림", Font.PLAIN, 20));
		pnMin.add(lbMinPeopleName);

		txtMinPeople = new JTextField();
		txtMinPeople.setFont(new Font("굴림", Font.PLAIN, 20));
		pnMin.add(txtMinPeople);
		txtMinPeople.setColumns(10);

		JButton btnMinPeople = new JButton("\uCD5C\uC18C \uCD9C\uBC1C\uC778\uC6D0 \uC218\uC815");
		btnMinPeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pDBMgr.updateMinimumPeopleByCodeAndDpDate(selectedCode, selectedDate, Integer.parseInt(txtMinPeople.getText()));
			}
		});
		btnMinPeople.setFont(new Font("굴림", Font.PLAIN, 15));
		pnMin.add(btnMinPeople);

		JPanel pnMax = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) pnMax.getLayout();
		pnMax.setBorder(new LineBorder(Color.DARK_GRAY, 1));
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		pnMinMaxPeople.add(pnMax);

		JLabel lbMaxPeople = new JLabel("\uCD5C\uB300 \uC608\uC57D\uC778\uC6D0");
		lbMaxPeople.setFont(new Font("굴림", Font.PLAIN, 20));
		pnMax.add(lbMaxPeople);

		txtMaxPeople = new JTextField();
		txtMaxPeople.setFont(new Font("굴림", Font.PLAIN, 20));
		txtMaxPeople.setColumns(10);
		pnMax.add(txtMaxPeople);

		JButton btnMaxPeople = new JButton("\uCD5C\uB300 \uC608\uC57D\uC778\uC6D0 \uC218\uC815");
		btnMaxPeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pDBMgr.updateMaximumPeopleByCodeAndDpDate(selectedCode, selectedDate, Integer.parseInt(txtMaxPeople.getText()));
			}
		});
		btnMaxPeople.setFont(new Font("굴림", Font.PLAIN, 15));
		pnMax.add(btnMaxPeople);

		JPanel pnGuide = new JPanel();
		pnCollection.add(pnGuide);
		pnGuide.setLayout(new BorderLayout(0, 0));

		JLabel lbGuideName = new JLabel("\uAC00\uC774\uB4DC \uC720\uBB34");
		lbGuideName.setFont(new Font("굴림", Font.PLAIN, 18));
		lbGuideName.setBorder(new LineBorder(Color.darkGray, 1));
		pnGuide.add(lbGuideName, BorderLayout.NORTH);

		JPanel pnGuideCheck = new JPanel();
		FlowLayout fl_pnGuideCheck = (FlowLayout) pnGuideCheck.getLayout();
		fl_pnGuideCheck.setAlignment(FlowLayout.LEFT);
		pnGuide.add(pnGuideCheck, BorderLayout.CENTER);

		rbGuideTrue = new JRadioButton("\uAC00\uC774\uB4DC \uC788\uC74C");
		rbGuideTrue.setSelected(true);
		btnGuideGroup.add(rbGuideTrue);
		rbGuideTrue.setFont(new Font("굴림", Font.PLAIN, 18));
		pnGuideCheck.add(rbGuideTrue);

		rbGuideFalse = new JRadioButton("\uAC00\uC774\uB4DC \uC5C6\uC74C");
		btnGuideGroup.add(rbGuideFalse);
		rbGuideFalse.setFont(new Font("굴림", Font.PLAIN, 18));
		pnGuideCheck.add(rbGuideFalse);
		
		JButton btnGuide = new JButton("\uAC00\uC774\uB4DC\uC720\uBB34 \uC218\uC815\uD558\uAE30");
		btnGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pDBMgr.updateGuideByCodeAndDpDate
				(selectedCode, selectedDate, rbGuideTrue.isSelected() ? 1 : 0);
			}
		});
		pnGuideCheck.add(btnGuide);
		
		JPanel pnAirline = new JPanel();
		pnCollection.add(pnAirline);
		pnAirline.setLayout(new BorderLayout(0, 0));
		
		JLabel lbAirlinName = new JLabel("\uD56D\uACF5\uC0AC");
		lbAirlinName.setFont(new Font("굴림", Font.PLAIN, 18));
		pnAirline.add(lbAirlinName, BorderLayout.NORTH);
		lbAirlinName.setBorder(new LineBorder(Color.darkGray, 1));
		
		JButton btnNewButton_1 = new JButton("\uD56D\uACF5 \uC218\uC815\uD558\uAE30");
		pnAirline.add(btnNewButton_1, BorderLayout.EAST);
		
		JPanel pnAirlineMain = new JPanel();
		pnAirline.add(pnAirlineMain, BorderLayout.CENTER);
		pnAirlineMain.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setPreferredSize(new Dimension(20, 9));
		btnNewButton_2.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Project\\icons\\add.png"));
		pnAirlineMain.add(btnNewButton_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		pnAirlineMain.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(2, 4, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uCD9C\uBC1C\uC2DC\uAC04 : ");
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uCD9C\uAD6D \uD56D\uACF5\uD3B8\uBA85");
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_7 = new JLabel("\uB3C4\uCC29\uC2DC\uAC04 : ");
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("\uADC0\uAD6D \uD56D\uACF5\uD3B8\uBA85");
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_3.add(lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		pn1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		pnPictures = new JPanel();
		pnPictures.setBorder(new LineBorder(Color.black, 1));
		panel_2.add(pnPictures);
		pnPictures.setLayout(new GridLayout(0, 4, 0, 0));
		
		lbPicture1 = new JLabel("");
		lbPicture1.setSize(332, 221);
		lbPicture1.setBorder(new LineBorder(Color.blue, 1));
		pnPictures.add(lbPicture1);
		
		lbPicture2 = new JLabel("");
		lbPicture2.setSize(332, 221);
		lbPicture2.setBorder(new LineBorder(Color.blue, 1));
		pnPictures.add(lbPicture2);
		
		lbPicture3 = new JLabel("");
		lbPicture3.setSize(332, 221);
		lbPicture3.setBorder(new LineBorder(Color.blue, 1));
		pnPictures.add(lbPicture3);
		
		JPanel pnBtns = new JPanel();
		pnPictures.add(pnBtns);
		pnBtns.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		pnBtns.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnChangelb1 = new JButton("1\uBC88");
		btnChangelb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// OS 공통 다이얼로그 - 열기/저장/폰트/컬러...
				final String currentDirectoryPath 
					= "./projectIMG";
				JFileChooser openDlg 
					= new JFileChooser(currentDirectoryPath);
				int r = openDlg.showOpenDialog(mgPg);
				if( r == JFileChooser.APPROVE_OPTION ) {
					File selImgFile 
						= openDlg.getSelectedFile();
					selImageDBPath1 = selImgFile.getPath();
					lbPicture1.setToolTipText(selImageDBPath1);
					ImageIcon ic = new ImageIcon(selImageDBPath1);
					Image scaled = ic.getImage()
						.getScaledInstance(lbPicture1.getWidth(), lbPicture1.getHeight(), // icon scale
								Image.SCALE_FAST);
					ic.setImage(scaled);
					lbPicture1.setIcon(ic);
					lbPicture1.repaint();
					//
				} else { // Cancle, Errors..
					System.out.println("파일 못 열음.. 선택안함");
					lbPicture1.setText("no Image");
				}
			}	
		});
		btnChangelb1.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Project\\icons\\add.png"));
		panel_4.add(btnChangelb1);
		
		JButton btnChangelb2 = new JButton("2\uBC88");
		btnChangelb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// OS 공통 다이얼로그 - 열기/저장/폰트/컬러...
				final String currentDirectoryPath 
					= "./projectIMG";
				JFileChooser openDlg 
					= new JFileChooser(currentDirectoryPath);
				int r = openDlg.showOpenDialog(mgPg);
				if( r == JFileChooser.APPROVE_OPTION ) {
					File selImgFile 
						= openDlg.getSelectedFile();
					selImageDBPath2 = selImgFile.getPath();
					lbPicture2.setToolTipText(selImageDBPath2);
					ImageIcon ic = new ImageIcon(selImageDBPath2);
					Image scaled = ic.getImage()
						.getScaledInstance(lbPicture2.getWidth(), lbPicture2.getHeight(), // icon scale
								Image.SCALE_FAST);
					ic.setImage(scaled);
					lbPicture2.setIcon(ic);
					lbPicture2.repaint();
					//
				} else { // Cancle, Errors..
					System.out.println("파일 못 열음.. 선택안함");
					lbPicture2.setText("no Image");
				}
			}
		});
		btnChangelb2.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Project\\icons\\add.png"));
		panel_4.add(btnChangelb2);
		
		JButton btnChangelb3 = new JButton("3\uBC88");
		btnChangelb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// OS 공통 다이얼로그 - 열기/저장/폰트/컬러...
				final String currentDirectoryPath 
					= "./projectIMG";
				JFileChooser openDlg 
					= new JFileChooser(currentDirectoryPath);
				int r = openDlg.showOpenDialog(mgPg);
				if( r == JFileChooser.APPROVE_OPTION ) {
					File selImgFile 
						= openDlg.getSelectedFile();
					selImageDBPath3 = selImgFile.getPath();
					lbPicture3.setToolTipText(selImageDBPath3);
					ImageIcon ic = new ImageIcon(selImageDBPath3);
					Image scaled = ic.getImage()
						.getScaledInstance(lbPicture3.getWidth(), lbPicture3.getHeight(), // icon scale
								Image.SCALE_FAST);
					ic.setImage(scaled);
					lbPicture3.setIcon(ic);
					lbPicture3.repaint();
					//
				} else { // Cancle, Errors..
					System.out.println("파일 못 열음.. 선택안함");
					lbPicture3.setText("no Image");
				}
			}
		});
		btnChangelb3.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Project\\icons\\add.png"));
		panel_4.add(btnChangelb3);
		
		JButton btnEditPicture = new JButton("\uC0AC\uC9C4 \uC218\uC815\uD558\uAE30");
		btnEditPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pDBMgr.updatePicturePathByCode(selectedCode, selImageDBPath1, selImageDBPath2, selImageDBPath3);
			}
		});
		pnBtns.add(btnEditPicture);

		JPanel pnSchedule = new JPanel();
		pnSchedule.setLayout(new BorderLayout(0, 0));
		pnSchedule.setSize(1709, 219);
		panel_2.add(pnSchedule);
		
		JButton btnEditSchedule = new JButton("\uC77C\uC815 \uBCC0\uACBD");
		btnEditSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pDBMgr.updateScheduleByCodeAndDpDate(selectedCode, pnSchedules.getSelectedIndex()+1, 
						txtScheduls[pnSchedules.getSelectedIndex()].getText());
			}
		});
		pnSchedule.setLayout(new BorderLayout(0, 0));
		pnSchedule.add(btnEditSchedule, BorderLayout.SOUTH);
		pnSchedules = new JTabbedPane(JTabbedPane.TOP);
		pnSchedule.setSize(1709, 191);
		pnSchedule.add(pnSchedules, BorderLayout.CENTER);
		
		JPanel pnOneday = new JPanel();
		pnOneday.setToolTipText("1");
		pnOneday.setSize(1341, 167);
		pnSchedules.addTab("1\uC77C\uCC28", pnOneday);
		pnOneday.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setLocation(0, 25);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setSize(1332, 147);
		pnOneday.add(scrollPane_1);
		
		txtScheduls[0] = new JTextArea();
		txtScheduls[0].setText("");
		txtScheduls[0].setToolTipText("1\uC77C\uCC28 \uC2A4\uCF00\uC904");
		scrollPane_1.setViewportView(txtScheduls[0]);
		
		JPanel pnHotel1 = new JPanel();
		pnHotel1.setBounds(0, 0, 1332, 25);
		pnOneday.add(pnHotel1);
		pnHotel1.setLayout(new BorderLayout(0, 0));
		
		JButton btnEditHotel1 = new JButton("\uD638\uD154 \uBCC0\uACBD\uD558\uAE30");
		btnEditHotel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pDBMgr.updateHotelByCode(selectedCode, lbDayHotels[0].getText(), pnSchedules.getSelectedIndex()+1);
			}
		});
		pnHotel1.add(btnEditHotel1, BorderLayout.EAST);
		
		JPanel pnHotel1_1 = new JPanel();
		pnHotel1.add(pnHotel1_1, BorderLayout.CENTER);
		pnHotel1_1.setLayout(new BorderLayout(0, 0));
		
		lbDayHotels[0] = new JLabel("");
		pnHotel1_1.add(lbDayHotels[0], BorderLayout.CENTER);
		
		JLabel lbHotelName1_1 = new JLabel("\uD638\uD154\uBA85 : ");
		pnHotel1_1.add(lbHotelName1_1, BorderLayout.WEST);
		
		JButton btnChangeHotel_1 = new JButton("\uD638\uD154 \uCC3E\uC544\uBCF4\uAE30");
		btnChangeHotel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hDlg.setVisible(true);
			}
		});
		btnChangeHotel_1.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Project\\icons\\add.png"));
		pnHotel1.add(btnChangeHotel_1, BorderLayout.WEST);
		
		JPanel pnTwoday = new JPanel();
		pnTwoday.setToolTipText("2");
		pnTwoday.setSize(1341, 167);
		pnSchedules.addTab("2\uC77C\uCC28", null, pnTwoday, null);
		pnTwoday.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setLocation(0, 25);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setSize(1332, 147);
		pnTwoday.add(scrollPane_2);
		
		txtScheduls[1] = new JTextArea();
		txtScheduls[1].setToolTipText("2\uC77C\uCC28 \uC2A4\uCF00\uC904");
		scrollPane_2.setViewportView(txtScheduls[1]);
		
		JPanel pnHotel2 = new JPanel();
		pnHotel2.setBounds(0, 0, 1332, 25);
		pnTwoday.add(pnHotel2);
		pnHotel2.setLayout(new BorderLayout(0, 0));
		
		JButton btnChangeHotel_2 = new JButton("\uD638\uD154 \uCC3E\uC544\uBCF4\uAE30");
		btnChangeHotel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hDlg.setVisible(true);
			}
		});
		btnChangeHotel_2.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Project\\icons\\add.png"));
		pnHotel2.add(btnChangeHotel_2, BorderLayout.WEST);
		
		JPanel pnHotel2_1 = new JPanel();
		pnHotel2.add(pnHotel2_1, BorderLayout.CENTER);
		pnHotel2_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lbHotelName2_1 = new JLabel("\uD638\uD154\uBA85 : ");
		pnHotel2_1.add(lbHotelName2_1, BorderLayout.WEST);
		
		lbDayHotels[1] = new JLabel("");
		pnHotel2_1.add(lbDayHotels[1], BorderLayout.CENTER);
		
		JButton btnEditHotel2 = new JButton("\uD638\uD154 \uBCC0\uACBD\uD558\uAE30");
		btnEditHotel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pDBMgr.updateHotelByCode(selectedCode, lbDayHotels[1].getText(), pnSchedules.getSelectedIndex()+1);
			}
		});
		pnHotel2.add(btnEditHotel2, BorderLayout.EAST);
		
		JPanel pnThreeday = new JPanel();
		pnThreeday.setToolTipText("3");
		pnThreeday.setSize(1341, 167);
		pnSchedules.addTab("3\uC77C\uCC28", null, pnThreeday, null);
		pnThreeday.setLayout(null);
		
		JPanel pnHotel3 = new JPanel();
		pnHotel3.setBounds(0, 0, 1332, 25);
		pnThreeday.add(pnHotel3);
		pnHotel3.setLayout(new BorderLayout(0, 0));
		
		JButton btnChangeHotel_3 = new JButton("\uD638\uD154 \uCC3E\uC544\uBCF4\uAE30");
		btnChangeHotel_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hDlg.setVisible(true);
			}
		});

		btnChangeHotel_3.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Project\\icons\\add.png"));
		pnHotel3.add(btnChangeHotel_3, BorderLayout.WEST);
		
		JPanel pnHotel3_1 = new JPanel();
		pnHotel3.add(pnHotel3_1, BorderLayout.CENTER);
		pnHotel3_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lbHotelName3_1 = new JLabel("\uD638\uD154\uBA85 : ");
		pnHotel3_1.add(lbHotelName3_1, BorderLayout.WEST);
		
		lbDayHotels[2] = new JLabel("");
		pnHotel3_1.add(lbDayHotels[2], BorderLayout.CENTER);
		
		JButton btnEditHotel3 = new JButton("\uD638\uD154 \uBCC0\uACBD\uD558\uAE30");
		btnEditHotel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pDBMgr.updateHotelByCode(selectedCode, lbDayHotels[2].getText(), pnSchedules.getSelectedIndex()+1);
			}
		});
		pnHotel3.add(btnEditHotel3, BorderLayout.EAST);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setLocation(0, 25);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setSize(1332, 147);
		pnThreeday.add(scrollPane_3);
		
		txtScheduls[2] = new JTextArea();
		txtScheduls[2].setToolTipText("3\uC77C\uCC28 \uC2A4\uCF00\uC904");
		scrollPane_3.setViewportView(txtScheduls[2]);
		
		JPanel pnFourday = new JPanel();
		pnFourday.setToolTipText("4");
		pnFourday.setSize(1341, 167);
		pnSchedules.addTab("4\uC77C\uCC28", null, pnFourday, null);
		pnFourday.setLayout(null);
		
		JPanel pnHotel4 = new JPanel();
		pnHotel4.setBounds(0, 0, 1332, 25);
		pnFourday.add(pnHotel4);
		pnHotel4.setLayout(new BorderLayout(0, 0));
		
		JPanel pnHotel4_1 = new JPanel();
		pnHotel4.add(pnHotel4_1, BorderLayout.CENTER);
		pnHotel4_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lbHotelName4_1 = new JLabel("\uD638\uD154\uBA85 : ");
		pnHotel4_1.add(lbHotelName4_1, BorderLayout.WEST);
		
		lbDayHotels[3] = new JLabel("");
		pnHotel4_1.add(lbDayHotels[3], BorderLayout.CENTER);
		
		JButton btnChangeHotel_4 = new JButton("\uD638\uD154 \uCC3E\uC544\uBCF4\uAE30");
		btnChangeHotel_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hDlg.setVisible(true);
			}
		});
		btnChangeHotel_4.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Project\\icons\\add.png"));
		pnHotel4.add(btnChangeHotel_4, BorderLayout.WEST);
		
		JButton btnEditHotel4 = new JButton("\uD638\uD154 \uBCC0\uACBD\uD558\uAE30");
		btnEditHotel4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pDBMgr.updateHotelByCode(selectedCode, lbDayHotels[3].getText(), pnSchedules.getSelectedIndex()+1);
			}
		});
		pnHotel4.add(btnEditHotel4, BorderLayout.EAST);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setLocation(0, 25);
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_4.setSize(1332, 147);
		pnFourday.add(scrollPane_4);
		
		txtScheduls[3] = new JTextArea();
		txtScheduls[3].setToolTipText("4\uC77C\uCC28 \uC2A4\uCF00\uC904");
		scrollPane_4.setViewportView(txtScheduls[3]);
		
		JPanel pnFiveday = new JPanel();
		pnFiveday.setToolTipText("5");
		pnFiveday.setSize(1341, 167);
		pnSchedules.addTab("5\uC77C\uCC28", null, pnFiveday, null);
		pnFiveday.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setLocation(0, 0);
		pnFiveday.add(scrollPane_5);	
		scrollPane_5.setSize(1332, 172);
		
		txtScheduls[4] = new JTextArea();
		txtScheduls[4].setToolTipText("4\uC77C\uCC28 \uC2A4\uCF00\uC904");
		scrollPane_5.setViewportView(txtScheduls[4]);
	}



	// 선택된 코드 라디오 버튼으로 코드 추출
	public void itemStateChanged(ItemEvent e) {
		if (rdDKE.isSelected()) {
			selectedCode = Product.CODE_LIST[0];
			lbCodeName.setText(rdDKE.getText());
			txtProductName.setText(pDBMgr.selectProducNameByCode(selectedCode));
			selImageDBPath1 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_1();
			selImageDBPath2 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_2();
			selImageDBPath3 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_3();
			ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(0));
			Image scaled1 = ic1.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic1.setImage(scaled1);
			lbPicture1.setText("");
			lbPicture1.setIcon(ic1);
			ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(1));
			Image scaled2 = ic2.getImage() 
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic2.setImage(scaled2);
			lbPicture2.setText("");
			lbPicture2.setIcon(ic2);	
			ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(2));
			Image scaled3 = ic3.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic3.setImage(scaled3);
			lbPicture3.setText("");
			lbPicture3.setIcon(ic3);
			for (int i = 0; i < lbDayHotels.length; i++) {
				lbDayHotels[i].setText(pDBMgr.selectHotelByCode(selectedCode).get(i));
			}
			for (int i = 0; i < txtScheduls.length; i++) {
				txtScheduls[i].setText(pDBMgr.selectScheduleProductByCode(selectedCode, i+1)
						.get(0));
			}
			showGuiMonthCalendar(cYear, cMonth);
		} 	else if (rdDOZ.isSelected()) {
			selectedCode = Product.CODE_LIST[1];
			lbCodeName.setText(rdDOZ.getText());
			txtProductName.setText(pDBMgr.selectProducNameByCode(selectedCode));
			selImageDBPath1 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_1();
			selImageDBPath2 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_2();
			selImageDBPath3 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_3();
			ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(0));
			Image scaled1 = ic1.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic1.setImage(scaled1);
			lbPicture1.setText("");
			lbPicture1.setIcon(ic1);
			ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(1));
			Image scaled2 = ic2.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic2.setImage(scaled2);
			lbPicture2.setText("");
			lbPicture2.setIcon(ic2);	
			ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(2));
			Image scaled3 = ic3.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic3.setImage(scaled3);
			lbPicture3.setText("");
			lbPicture3.setIcon(ic3);
			for (int i = 0; i < lbDayHotels.length; i++) {
				lbDayHotels[i].setText(pDBMgr.selectHotelByCode(selectedCode).get(i));
			}
			for (int i = 0; i < txtScheduls.length; i++) {
				txtScheduls[i].setText(pDBMgr.selectScheduleProductByCode(selectedCode, i+1)
						.get(0));
			}
			showGuiMonthCalendar(cYear, cMonth);
		} else if (rdDVJ.isSelected()) {
			selectedCode = Product.CODE_LIST[2];
			lbCodeName.setText(rdDVJ.getText());
			txtProductName.setText(pDBMgr.selectProducNameByCode(selectedCode));
			selImageDBPath1 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_1();
			selImageDBPath2 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_2();
			selImageDBPath3 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_3();
			ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(0));
			Image scaled1 = ic1.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic1.setImage(scaled1);
			lbPicture1.setText("");
			lbPicture1.setIcon(ic1);
			ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(1));
			Image scaled2 = ic2.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic2.setImage(scaled2);
			lbPicture2.setText("");
			lbPicture2.setIcon(ic2);	
			ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(2));
			Image scaled3 = ic3.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic3.setImage(scaled3);
			lbPicture3.setText("");
			lbPicture3.setIcon(ic3);
			for (int i = 0; i < lbDayHotels.length; i++) {
				lbDayHotels[i].setText(pDBMgr.selectHotelByCode(selectedCode).get(i));
			}
			for (int i = 0; i < txtScheduls.length; i++) {
				txtScheduls[i].setText(pDBMgr.selectScheduleProductByCode(selectedCode, i+1)
						.get(0));
			}
			showGuiMonthCalendar(cYear, cMonth);
		} else if (rdHKE.isSelected()) {
			selectedCode = Product.CODE_LIST[3];
			lbCodeName.setText(rdHKE.getText());
			txtProductName.setText(pDBMgr.selectProducNameByCode(selectedCode));
			selImageDBPath1 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_1();
			selImageDBPath2 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_2();
			selImageDBPath3 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_3();
			ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(0));
			Image scaled1 = ic1.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic1.setImage(scaled1);
			lbPicture1.setText("");
			lbPicture1.setIcon(ic1);
			ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(1));
			Image scaled2 = ic2.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic2.setImage(scaled2);
			lbPicture2.setText("");
			lbPicture2.setIcon(ic2);	
			ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(2));
			Image scaled3 = ic3.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic3.setImage(scaled3);
			lbPicture3.setText("");
			lbPicture3.setIcon(ic3);
			for (int i = 0; i < lbDayHotels.length; i++) {
				lbDayHotels[i].setText(pDBMgr.selectHotelByCode(selectedCode).get(i));
			}
			for (int i = 0; i < txtScheduls.length; i++) {
				txtScheduls[i].setText(pDBMgr.selectScheduleProductByCode(selectedCode, i+1)
						.get(0));
			}
			showGuiMonthCalendar(cYear, cMonth);
		} else if (rdHOZ.isSelected()) {
			selectedCode = Product.CODE_LIST[4];
			lbCodeName.setText(rdHOZ.getText());
			txtProductName.setText(pDBMgr.selectProducNameByCode(selectedCode));
			selImageDBPath1 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_1();
			selImageDBPath2 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_2();
			selImageDBPath3 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_3();
			ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(0));
			Image scaled1 = ic1.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic1.setImage(scaled1);
			lbPicture1.setText("");
			lbPicture1.setIcon(ic1);
			ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(1));
			Image scaled2 = ic2.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic2.setImage(scaled2);
			lbPicture2.setText("");
			lbPicture2.setIcon(ic2);	
			ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(2));
			Image scaled3 = ic3.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic3.setImage(scaled3);
			lbPicture3.setText("");
			lbPicture3.setIcon(ic3);
			for (int i = 0; i < lbDayHotels.length; i++) {
				lbDayHotels[i].setText(pDBMgr.selectHotelByCode(selectedCode).get(i));
			}
			for (int i = 0; i < txtScheduls.length; i++) {
				txtScheduls[i].setText(pDBMgr.selectScheduleProductByCode(selectedCode, i+1)
						.get(0));
			}
			showGuiMonthCalendar(cYear, cMonth);
		} else if (rdHVJ.isSelected()) {
			selectedCode = Product.CODE_LIST[5];
			lbCodeName.setText(rdHVJ.getText());
			txtProductName.setText(pDBMgr.selectProducNameByCode(selectedCode));
			selImageDBPath1 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_1();
			selImageDBPath2 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_2();
			selImageDBPath3 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_3();
			ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(0));
			Image scaled1 = ic1.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic1.setImage(scaled1);
			lbPicture1.setText("");
			lbPicture1.setIcon(ic1);
			ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(1));
			Image scaled2 = ic2.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic2.setImage(scaled2);
			lbPicture2.setText("");
			lbPicture2.setIcon(ic2);	
			ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(2));
			Image scaled3 = ic3.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic3.setImage(scaled3);
			lbPicture3.setText("");
			lbPicture3.setIcon(ic3);
			for (int i = 0; i < lbDayHotels.length; i++) {
				lbDayHotels[i].setText(pDBMgr.selectHotelByCode(selectedCode).get(i));
			}
			for (int i = 0; i < txtScheduls.length; i++) {
				txtScheduls[i].setText(pDBMgr.selectScheduleProductByCode(selectedCode, i+1)
						.get(0));
			}
			showGuiMonthCalendar(cYear, cMonth);
		} else if (rdSKE.isSelected()) {
			selectedCode = Product.CODE_LIST[6];
			lbCodeName.setText(rdSKE.getText());
			txtProductName.setText(pDBMgr.selectProducNameByCode(selectedCode));
			selImageDBPath1 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_1();
			selImageDBPath2 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_2();
			selImageDBPath3 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_3();
			ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(0));
			Image scaled1 = ic1.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic1.setImage(scaled1);
			lbPicture1.setText("");
			lbPicture1.setIcon(ic1);
			ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(1));
			Image scaled2 = ic2.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic2.setImage(scaled2);
			lbPicture2.setText("");
			lbPicture2.setIcon(ic2);	
			ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(2));
			Image scaled3 = ic3.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic3.setImage(scaled3);
			lbPicture3.setText("");
			lbPicture3.setIcon(ic3);
			for (int i = 0; i < lbDayHotels.length; i++) {
				lbDayHotels[i].setText(pDBMgr.selectHotelByCode(selectedCode).get(i));
			}
			for (int i = 0; i < txtScheduls.length; i++) {
				txtScheduls[i].setText(pDBMgr.selectScheduleProductByCode(selectedCode, i+1)
						.get(0));
			}
			showGuiMonthCalendar(cYear, cMonth);
		} else if (rdSOZ.isSelected()) {
			selectedCode = Product.CODE_LIST[7];
			lbCodeName.setText(rdSOZ.getText());
			txtProductName.setText(pDBMgr.selectProducNameByCode(selectedCode));
			selImageDBPath1 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_1();
			selImageDBPath2 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_2();
			selImageDBPath3 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_3();
			ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(0));
			Image scaled1 = ic1.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic1.setImage(scaled1);
			lbPicture1.setText("");
			lbPicture1.setIcon(ic1);
			ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(1));
			Image scaled2 = ic2.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic2.setImage(scaled2);
			lbPicture2.setText("");
			lbPicture2.setIcon(ic2);	
			ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(2));
			Image scaled3 = ic3.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic3.setImage(scaled3);
			lbPicture3.setText("");
			lbPicture3.setIcon(ic3);
			for (int i = 0; i < lbDayHotels.length; i++) {
				lbDayHotels[i].setText(pDBMgr.selectHotelByCode(selectedCode).get(i));
			}
			for (int i = 0; i < txtScheduls.length; i++) {
				txtScheduls[i].setText(pDBMgr.selectScheduleProductByCode(selectedCode, i+1)
						.get(0));
			}
			showGuiMonthCalendar(cYear, cMonth);
		} else if (rdSVJ.isSelected()) {
			selectedCode = Product.CODE_LIST[8];
			lbCodeName.setText(rdSVJ.getText());
			txtProductName.setText(pDBMgr.selectProducNameByCode(selectedCode));
			selImageDBPath1 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_1();
			selImageDBPath2 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_2();
			selImageDBPath3 = pDBMgr.selectPicturesProductByCode(selectedCode).getPicturePath_3();
			ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(0));
			Image scaled1 = ic1.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic1.setImage(scaled1);
			lbPicture1.setText("");
			lbPicture1.setIcon(ic1);
			ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(1));
			Image scaled2 = ic2.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic2.setImage(scaled2);
			lbPicture2.setText("");
			lbPicture2.setIcon(ic2);	
			ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(selectedCode).get(2));
			Image scaled3 = ic3.getImage()
				.getScaledInstance(334, 221, // icon scale
						Image.SCALE_FAST);
			ic3.setImage(scaled3);
			lbPicture3.setText("");
			lbPicture3.setIcon(ic3);
			for (int i = 0; i < lbDayHotels.length; i++) {
				lbDayHotels[i].setText(pDBMgr.selectHotelByCode(selectedCode).get(i));
			}
			for (int i = 0; i < txtScheduls.length; i++) {
				txtScheduls[i].setText(pDBMgr.selectScheduleProductByCode(selectedCode, i+1)
						.get(0));
			}
			showGuiMonthCalendar(cYear, cMonth);
		}
	}

	// 달력 메소드
	public void showGuiMonthCalendar(int year, int month) {
			
			int totalDays = 0; // 이번달의 1일까지의 총일수??
			
			// 년도 계산으로 총일 수 계산
			for (int y = 1; y < year; y++) {
				if( y % 400 == 0 ) totalDays += 366; // 윤년
				else if( y % 100 == 0 ) totalDays += 365; // 평년
				else if( y % 4 == 0 ) totalDays += 366; // 윤년
				else totalDays += 365; // 평년
			} // 작년까지(12/31)의 모든 일수 계산
			
			boolean bLeapYear = false; // 평년
			if( year % 400 == 0 ) bLeapYear = true; // 윤년
			else if( year % 100 == 0 ) bLeapYear = false; // 평년
			else if( year % 4 == 0 ) bLeapYear = true; // 윤년
			else bLeapYear = false; // 평년
			
			// 올해의 전월까지의 일수를 월단위 계산으로 추가
			int[] daysInMonth = {
				0, 31, bLeapYear ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31	
			}; // 2월달만 윤년이면 29일이냐 아니냐... 28일 평년
			for (int m = 1; m < month; m++) {
				totalDays += daysInMonth[m];
			}
			
			// 올해 이번달 1일 추가
			totalDays++;
			// 서양식으로 일요일부터 시작됨.. 0 일요일 1 월요일 => 6 토요일
			int yoil = totalDays % 7; // 0 ~ 6
			// 모든 날짜 버튼을 리셋...
			for (JToggleButton btnDay : btnDays) {
				btnDay.setText("");
				btnDay.setEnabled(false); //비활성화
				btnDay.setBorder(new EmptyBorder(0,0,0,0));
			}	
			//
			for (int day = 1; day <= daysInMonth[month]; day++) {
				String dayStr = String.valueOf(day).length() == 1 ? "0"+day : ""+day;
				JToggleButton  btnDay = btnDays[day+yoil-1];
				btnDay.setText(dayStr);
				ArrayList<String> pdList = pDBMgr.selectDepartureDateByCode(selectedCode);
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
						btnDay.setEnabled(true);
					}
				}
			}
		}
	
}



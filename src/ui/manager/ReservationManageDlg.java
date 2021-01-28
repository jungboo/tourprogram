package ui.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import db.model.Admin;
import db.AdminDBMgr;
import ui.main.TourMainFrame2;
//import ui.member.MemberAdminDialog;
import java.awt.BorderLayout;

public class ReservationManageDlg extends JDialog {


	int check;
	JCheckBox chkBox;
	private JPanel contentPane;
	private JTable tableInfos;
	ArrayList<Admin> adList;
//	MemberAdminDialog adDlg;
	ReservationManageDlg ReservManageDlg;
	TourMainFrame2 frm;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	//MemberAdminDialog dlg
	public ReservationManageDlg() {
		this.ReservManageDlg=this;
//		this.adDlg = dlg;

		setBounds(100, 100, 1016, 666);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\uAD00\uB9AC\uC790\uD398\uC774\uC9C0");
		lblNewLabel.setForeground(SystemColor.info);
		lblNewLabel.setBackground(SystemColor.info);
		lblNewLabel.setFont(new Font("휴먼매직체", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tableInfos = new JTable();
		tableInfos.setFillsViewportHeight(true);
		tableInfos.setBackground(SystemColor.activeCaption);
		tableInfos.setForeground(Color.BLACK);
		tableInfos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableInfos.setFont(new Font("휴먼매직체", Font.PLAIN, 17));
		tableInfos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\uC0C1\uD488\uCF54\uB4DC", "\uC608\uC57D\uB0A0\uC9DC", "\uCD9C\uBC1C\uC77C", "\uC774\uB984", "인원수", "전화번호", "통화여부"
			}
		));
		tableInfos.setCellSelectionEnabled(true);
		tableInfos.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tableInfos);
		
		JButton btnRefresh = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showInfosTableFromDB();
			}
		});
		contentPane.add(btnRefresh, BorderLayout.NORTH);
		
		JButton button = new JButton("\uD655\uC778");
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
		contentPane.add(button, BorderLayout.SOUTH);
	}
	
	public void showInfosTableFromDB() {
		final String[] columnNames = {
			"상품코드", "예약날짜", "출발일", "이름", 
			"인원수", "전화번호","통화여부"};		
		// DB
		AdminDBMgr mgr = new AdminDBMgr();
		//ArrayList<Food> fdList = mgr.getAllFoods();
		adList = mgr.getAllInfos();		

		if( adList == null || adList.isEmpty() )			
			return;
		
		Object[][] data = new Object[adList.size()][columnNames.length];
		for (int i = 0; i < adList.size(); i++) { // i행
			Admin ad = adList.get(i);
			data[i][0] = ad.getCode();
			data[i][1] = ad.getReservDay();
			data[i][2] = ad.getStartDay();
			data[i][3] = ad.getName();
			data[i][4] = ad.getPeoples();
			data[i][5] = ad.getCellPhone();
			data[i][6] = ad.getCallCheck();
//			check = data[i][6];

		}
		
		DefaultTableModel dtm = 
				new DefaultTableModel(data, 
						columnNames);
		tableInfos.setModel(dtm);
	}

}
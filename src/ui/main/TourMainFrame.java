package ui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ui.panel.AirlinePanel;
import ui.panel.CityPanel;
import ui.panel.combo.ProductAirAsianaPanel;
import ui.panel.combo.ProductAirKorPanel;
import ui.panel.combo.ProductAirLCCPanel;
import ui.panel.combo.ProductCityDanangPanel;
import ui.panel.combo.ProductCityHanoiPanel;
import ui.panel.combo.ProductCityHochiminPanel;
import ui.panel.product.DanangAsiana;
import ui.panel.product.DanangKor;
import ui.panel.product.DanangLCC;
import ui.panel.product.HanoiAsiana;
import ui.panel.product.HanoiKor;
import ui.panel.product.HanoiLCC;
import ui.panel.product.HochiminAsiana;
import ui.panel.product.HochiminKor;
import ui.panel.product.HochiminLCC;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TourMainFrame extends JFrame {

	private JPanel contentPane;
	CityPanel pnCity;
	AirlinePanel pnAirline;
	JLabel lbCity;
	JLabel lbAirline;
	int mainPictureCount;
	String[] mainPictures = {
		"./images/danang/DanangGoldenBridge.jpg", "./images/hanoi/HalongbayMain1.jpg", "./images/hochimin/HochiminCityhall.jpg"	
	};
	public JPanel pnMainCenter;
	public static JScrollPane scrollPane;
	public ProductCityDanangPanel pnDanang;
	public ProductCityHanoiPanel pnHanoi;
	public ProductCityHochiminPanel pnHochimin;
	public ProductAirKorPanel pnKor;
	public ProductAirAsianaPanel pnAsiana;
	public ProductAirLCCPanel pnLCC;
	public JComboBox comboAirline;
	public JComboBox comboCity;
	public DanangKor pnDnKor;
	public DanangAsiana pnDnAsiana;
	public DanangLCC pnDnLCC;
	public HanoiKor pnHnKor;
	public HanoiAsiana pnHnAsiana;
	public HanoiLCC pnHnLCC;
	public HochiminKor pnHcKor;
	public HochiminAsiana pnHcAsiana;
	public HochiminLCC pnHcLCC;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TourMainFrame frame = new TourMainFrame();
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
	public TourMainFrame() {
		setTitle("\uC7A1\uC544\uBCA0\uD2B8\uB0A8 \uC5EC\uD589\uC0AC");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\\uD504\uC81D\uC0AC\uC9C4\\\uB85C\uACE01.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\\uD504\uC81D\uC0AC\uC9C4\\\uCEA1\uCC98.PNG"));
		lbLogo.setBounds(12, 10, 194, 155);
		contentPane.add(lbLogo);
		
		JLabel lbMainName = new JLabel("");
		lbMainName.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\\uD504\uC81D\uC0AC\uC9C4\\\uAE00\uAF34.PNG"));
		lbMainName.setFont(new Font("CookieRun", Font.BOLD, 50));
		lbMainName.setHorizontalAlignment(SwingConstants.CENTER);
		lbMainName.setBounds(218, 40, 702, 103);
		contentPane.add(lbMainName);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 153, 255), 3));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setBackground(Color.BLACK);
		panel.setBounds(12, 175, 960, 49);
		contentPane.add(panel);
		
		pnCity = new CityPanel();
		pnAirline = new AirlinePanel();
		lbCity = new JLabel("\uC5EC\uD589\uC9C0");
		lbCity.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				pnMenuCity.setVisible(true);
//				pnMenuAirline.setVisible(false);
//				pnMenuCity.add(pnCity, BorderLayout.CENTER);
//				lbCity.setForeground(new Color(105, 200, 230));
//				
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
////				pnMenuCity.setVisible(false);
//				lbCity.setForeground(Color.white);
//			}
		
		});
		lbCity.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 25));
		lbCity.setForeground(Color.WHITE);
		lbCity.setBorder(new LineBorder(new Color(252, 248, 118), 2));
		panel.add(lbCity);
		
		comboCity = new JComboBox();
		comboCity.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 20));
		comboCity.setModel(new DefaultComboBoxModel(new String[] {" ", "\uB2E4\uB0AD", "\uD558\uB178\uC774", "\uD638\uCE58\uBBFC"}));
		comboCity.setSelectedIndex(0);
		comboCity.setMaximumRowCount(4);
		panel.add(comboCity);
		
		JLabel lblNewLabel_3 = new JLabel("   ");
		panel.add(lblNewLabel_3);
		
		lbAirline = new JLabel("\uD56D\uACF5\uC0AC");
		lbAirline.addMouseListener(new MouseAdapter() {
//			int s = -1;
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				s = 1;
//				pnMenuAirline.setVisible(true);
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				pnMenuAirline.setVisible(true);
//				pnMenuCity.setVisible(false);
//				pnMenuAirline.add(pnAirline, BorderLayout.CENTER);
//				lbAirline.setForeground(new Color(105, 200, 230));
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
////				if( s == -1 ) {
////					pnMenuAirline.setVisible(false);
////				}
//				lbAirline.setForeground(Color.white);
//			}
		});
		lbAirline.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 25));
		lbAirline.setForeground(Color.WHITE);
		lbAirline.setBorder(new LineBorder(new Color(252, 248, 118), 2));
		panel.add(lbAirline);
		
		comboAirline = new JComboBox();
		comboAirline.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 20));
		comboAirline.setModel(new DefaultComboBoxModel(new String[] {" ", "\uB300\uD55C\uD56D\uACF5", "\uC544\uC2DC\uC544\uB098", "\uC800\uAC00\uD56D\uACF5"}));
		comboAirline.setSelectedIndex(0);
		comboAirline.setMaximumRowCount(4);
		panel.add(comboAirline);
		
		pnDanang = new ProductCityDanangPanel();
		pnHanoi = new ProductCityHanoiPanel();
		pnHochimin = new ProductCityHochiminPanel();
		pnKor = new ProductAirKorPanel();
		pnAsiana = new ProductAirAsianaPanel();
		pnLCC = new ProductAirLCCPanel();
		pnDnKor = new DanangKor();
		pnDnAsiana = new DanangAsiana();
		pnDnLCC = new DanangLCC();
		pnHnKor = new HanoiKor();
		pnHnAsiana = new HanoiAsiana();
		pnHnLCC = new HanoiLCC();
		pnHcKor = new HochiminKor();
		pnHcAsiana = new HochiminAsiana();
		pnHcLCC = new HochiminLCC();
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( comboCity.getSelectedIndex() == 0 && comboAirline.getSelectedIndex() == 0 )
					scrollPane.setViewportView(pnMainCenter);
				if( comboCity.getSelectedIndex() == 1 && comboAirline.getSelectedIndex() == 0 )
					scrollPane.setViewportView(pnDanang);
				if( comboCity.getSelectedIndex() == 2 && comboAirline.getSelectedIndex() == 0 )
					scrollPane.setViewportView(pnHanoi);
				if( comboCity.getSelectedIndex() == 3 && comboAirline.getSelectedIndex() == 0 )
					scrollPane.setViewportView(pnHochimin);
				if( comboCity.getSelectedIndex() == 0 && comboAirline.getSelectedIndex() == 1 )
					scrollPane.setViewportView(pnKor);
				if( comboCity.getSelectedIndex() == 0 && comboAirline.getSelectedIndex() == 2 )
					scrollPane.setViewportView(pnAsiana);
				if( comboCity.getSelectedIndex() == 0 && comboAirline.getSelectedIndex() == 3 )
					scrollPane.setViewportView(pnLCC);
				if( comboCity.getSelectedIndex() == 1 && comboAirline.getSelectedIndex() == 1 )
					scrollPane.setViewportView(pnDnKor);
				if( comboCity.getSelectedIndex() == 1 && comboAirline.getSelectedIndex() == 2 )
					scrollPane.setViewportView(pnDnAsiana);
				if( comboCity.getSelectedIndex() == 1 && comboAirline.getSelectedIndex() == 3 )
					scrollPane.setViewportView(pnDnLCC);
				if( comboCity.getSelectedIndex() == 2 && comboAirline.getSelectedIndex() == 1 )
					scrollPane.setViewportView(pnHnKor);
				if( comboCity.getSelectedIndex() == 2 && comboAirline.getSelectedIndex() == 2 )
					scrollPane.setViewportView(pnHnAsiana);
				if( comboCity.getSelectedIndex() == 2 && comboAirline.getSelectedIndex() == 3 )
					scrollPane.setViewportView(pnHnLCC);
				if( comboCity.getSelectedIndex() == 3 && comboAirline.getSelectedIndex() == 1 )
					scrollPane.setViewportView(pnHcKor);
				if( comboCity.getSelectedIndex() == 3 && comboAirline.getSelectedIndex() == 2 )
					scrollPane.setViewportView(pnHcAsiana);
				if( comboCity.getSelectedIndex() == 3 && comboAirline.getSelectedIndex() == 3 )
					scrollPane.setViewportView(pnHcLCC);
			}
		});
		btnNewButton.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 20));
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("                                         ");
		panel.add(lblNewLabel_2);
		
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 22));
		panel.add(btnLogin);
		
		JLabel label = new JLabel("   ");
		panel.add(label);
		
		JButton btnJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnJoin.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 22));
		panel.add(btnJoin);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBounds(12, 234, 960, 531);
		contentPane.add(pnCenter);
		pnCenter.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnCenter.add(scrollPane);
		
		pnMainCenter = new JPanel();
		scrollPane.setViewportView(pnMainCenter);
		pnMainCenter.setLayout(new BorderLayout(20, 0));
		
		JPanel pnMainImages = new JPanel();
		pnMainCenter.add(pnMainImages, BorderLayout.CENTER);
		pnMainImages.setLayout(new BorderLayout(0, 0));
		
		JLabel lbMainImage = new JLabel("        ");
		pnMainImages.add(lbMainImage, BorderLayout.CENTER);
		mainPictureCount = 0;
		new Thread() {
			public void run() {
				while(true) {
					lbMainImage.setIcon(new ImageIcon(
							mainPictures[mainPictureCount++]
										));
					mainPictureCount = mainPictureCount == 3 ? 0 : mainPictureCount; 
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}					
		}.start();
		
		
		JPanel panel_2 = new JPanel();
		pnMainCenter.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("   ");
		panel_1.add(lblNewLabel);
		
		JPanel pnBest = new JPanel();
		panel_2.add(pnBest, BorderLayout.CENTER);
		
		JLabel lbBestItem = new JLabel("");
		lbBestItem.setSize(450, 300);
		ImageIcon ic = new ImageIcon("C:/dev2020/java_ws/FirstTeamProject/images/danang/DanangGoldenBridge.jpg");
		Image scaled = ic.getImage().getScaledInstance(lbBestItem.getWidth(),
				lbBestItem.getHeight(), Image.SCALE_SMOOTH);
		ic.setImage(scaled);
		pnBest.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		lbBestItem.setIcon(ic);
		pnBest.add(lbBestItem);
		
		JLabel lblNewLabel_1 = new JLabel("          ");
		pnBest.add(lblNewLabel_1);
		
		JTextArea txtBestDescription = new JTextArea();
		txtBestDescription.setSize(450, 300);
		pnBest.add(txtBestDescription);
		
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(Color.WHITE);
		pnSouth.setBounds(12, 775, 960, 176);
		contentPane.add(pnSouth);
		pnSouth.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel pnMainNum = new JPanel();
		pnSouth.add(pnMainNum);
		
		JLabel lbMainNum = new JLabel("\uB300\uD45C\uBC88\uD638");
		lbMainNum.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼", Font.BOLD, 25));
		pnMainNum.add(lbMainNum);
		
		JLabel lnPhoneNum = new JLabel("0000-0000");
		lnPhoneNum.setForeground(new Color(0, 153, 204));
		lnPhoneNum.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼", Font.BOLD, 35));
		pnMainNum.add(lnPhoneNum);
		
		JPanel pnWork = new JPanel();
		pnSouth.add(pnWork);
		pnWork.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lbWork1 = new JLabel("\uC5C5\uBB34\uC2DC\uAC04");
		lbWork1.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼", Font.BOLD, 20));
		pnWork.add(lbWork1);
		
		JLabel lbWork2 = new JLabel("\uC8FC\uB9D0 \uBC0F \uACF5\uD734\uC77C \uD734\uBB34");
		lbWork2.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼", Font.PLAIN, 16));
		pnWork.add(lbWork2);
		
		JLabel lbWork3 = new JLabel("\uD3C9\uC77C 09: ~ 18:00");
		lbWork3.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼", Font.PLAIN, 16));
		pnWork.add(lbWork3);
		
		JLabel lbName = new JLabel("\uC7A1\uC544\uBCA0\uD2B8\uB0A8 \uC5EC\uD589\uC0AC(\uC8FC)");
		lbName.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼", Font.PLAIN, 20));
		pnSouth.add(lbName);
		
		JLabel lbCEO = new JLabel("\uB300\uD45C\uC774\uC0AC: \uAE40\uC815\uBD80");
		lbCEO.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼", Font.PLAIN, 20));
		pnSouth.add(lbCEO);
		
		JTextArea txtMail = new JTextArea();
		txtMail.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼", Font.PLAIN, 20));
		txtMail.setText("           \uBB38\uC758\uBA54\uC77C: \r\n\r\n     rupert5@naver,com");
		pnSouth.add(txtMail);
		
		JTextArea txtAdrress = new JTextArea();
		txtAdrress.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼", Font.PLAIN, 20));
		txtAdrress.setText("\uC8FC\uC18C : \uC11C\uC6B8\uC2DC \uC131\uACF5\uAD6C \r\n\uC655\uC2ED\uB9AC\uB85C 303 4\uCE35\r\n\uC655\uC2ED\uB9AC\uC5ED 10\uBC88\uCD9C\uAD6C \uB3C4\uBCF4 1\uBD84");
		pnSouth.add(txtAdrress);
		
		JTextArea txtFax = new JTextArea();
		txtFax.setFont(new Font("ÈÞ¸ÕÆíÁöÃ¼", Font.PLAIN, 20));
		txtFax.setText("\r\nFAX : 02-000-0000");
		pnSouth.add(txtFax);
		
		JPanel pnAdmin = new JPanel();
		pnSouth.add(pnAdmin);
		pnAdmin.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel(" ");
		lblNewLabel_6.setFont(new Font("±¼¸²", Font.PLAIN, 23));
		pnAdmin.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JLabel lblNewLabel_7 = new JLabel(" ");
		lblNewLabel_7.setFont(new Font("±¼¸²", Font.PLAIN, 23));
		pnAdmin.add(lblNewLabel_7, BorderLayout.SOUTH);
		
	}
}

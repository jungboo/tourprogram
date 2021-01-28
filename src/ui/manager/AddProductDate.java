package ui.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import db.ProductDBMgr;
import db.model.Product;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AddProductDate extends JDialog {
	AddProductDate dialog;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCode;
	private JTextField txtPrice;
	private JTextField txtDPDate;
	private JSpinner spnMinPeople;
	private JSpinner spnMaxPeople;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddProductDate dialog = new AddProductDate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddProductDate() {
		ProductDBMgr pDBMgr = new ProductDBMgr();
		ManagerPage mgrPage = new ManagerPage();
		this.dialog = this;
		setTitle("\uAD00\uB9AC\uC790 \uD398\uC774\uC9C0 \uC0C1\uD488 \uB0A0\uC9DC\uB4F1\uB85D");
		setBounds(100, 100, 462, 417);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("\uAD00\uB9AC\uC790 \uC0C1\uD488\uB0A0\uC9DC \uB4F1\uB85D");
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(5, 2, 0, 0));
			{
				JLabel lbCode = new JLabel("\uC0C1\uD488\uCF54\uB4DC :");
				lbCode.setFont(new Font("굴림", Font.PLAIN, 15));
				lbCode.setHorizontalAlignment(SwingConstants.CENTER);
				lbCode.setBorder(new LineBorder(Color.black, 1));
				panel.add(lbCode);
			}
			{
				txtCode = new JTextField();
				txtCode.setEditable(false);
				txtCode.setFont(new Font("굴림", Font.BOLD, 15));
				txtCode.setHorizontalAlignment(SwingConstants.CENTER);
				txtCode.setText(mgrPage.selectedCode);
				panel.add(txtCode);
				txtCode.setColumns(10);
			}
			{
				JLabel lbPrice = new JLabel("\uC0C1\uD488 (\uC131\uC778)\uAC00\uACA9 : ");
				lbPrice.setFont(new Font("굴림", Font.PLAIN, 15));
				lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
				lbPrice.setBorder(new LineBorder(Color.black, 1));
				panel.add(lbPrice);
			}
			{
				txtPrice = new JTextField();
				txtPrice.setForeground(Color.LIGHT_GRAY);
				txtPrice.setFont(new Font("굴림", Font.BOLD, 15));
				txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
				txtPrice.setText("가격을 입력하세요 (숫자)");
				txtPrice.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						
						if( txtPrice.getText().equals("가격을 입력하세요 (숫자)"))
							txtPrice.setText("");
						txtPrice.setForeground(Color.black);
					}
					@Override
					public void focusLost(FocusEvent e) {
						if( txtPrice.getText().isEmpty() ) {
							txtPrice.setText("가격을 입력하세요 (숫자)");
							txtPrice.setForeground(Color.LIGHT_GRAY);
						}
					}
				});
				panel.add(txtPrice);
				txtPrice.setColumns(10);
			}
			{
				JLabel lbDPDate = new JLabel("\uCD9C\uBC1C\uB0A0\uC9DC : ");
				lbDPDate.setFont(new Font("굴림", Font.PLAIN, 15));
				lbDPDate.setHorizontalAlignment(SwingConstants.CENTER);
				lbDPDate.setBorder(new LineBorder(Color.black, 1));
				panel.add(lbDPDate);
			}
			{
				txtDPDate = new JTextField();
				txtDPDate.setForeground(Color.LIGHT_GRAY);
				txtDPDate.setFont(new Font("굴림", Font.BOLD, 15));
				txtDPDate.setHorizontalAlignment(SwingConstants.CENTER);
				txtDPDate.setText("추가 날짜 입력(ex: yyyy-mm-dd)");
				txtDPDate.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						if( txtDPDate.getText().equals("추가 날짜 입력(ex: yyyy-mm-dd)") )
							txtDPDate.setText("");
						txtDPDate.setForeground(Color.black);
					}
					@Override
					public void focusLost(FocusEvent e) {
						if( txtDPDate.getText().isEmpty())
							txtDPDate.setText("추가 날짜 입력(ex: yyyy-mm-dd)");
						txtDPDate.setForeground(Color.LIGHT_GRAY);
					}
				});
				txtDPDate.setColumns(10);
				panel.add(txtDPDate);
			}
			{
				JLabel lbMinPeople = new JLabel("\uCD5C\uC18C \uCD9C\uBC1C \uC778\uC6D0 : ");
				lbMinPeople.setFont(new Font("굴림", Font.PLAIN, 15));
				lbMinPeople.setHorizontalAlignment(SwingConstants.CENTER);
				lbMinPeople.setBorder(new LineBorder(Color.black, 1));
				panel.add(lbMinPeople);
			}
			{
				spnMinPeople = new JSpinner();
				spnMinPeople.setModel(new SpinnerNumberModel(new Integer(6), null, null, new Integer(1)));
				panel.add(spnMinPeople);
			}
			{
				JLabel lbMaxPeople = new JLabel("\uCD5C\uB300 \uC608\uC57D \uC778\uC6D0 : ");
				lbMaxPeople.setFont(new Font("굴림", Font.PLAIN, 15));
				lbMaxPeople.setHorizontalAlignment(SwingConstants.CENTER);
				lbMaxPeople.setBorder(new LineBorder(Color.black, 1));
				panel.add(lbMaxPeople);
			}
			{
				spnMaxPeople = new JSpinner();
				spnMaxPeople.setModel(new SpinnerNumberModel(new Integer(12), null, null, new Integer(1)));
				panel.add(spnMaxPeople);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uC0C1\uD488 \uB0A0\uC9DC \uB4F1\uB85D");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String airCode = txtCode.getText().substring(1,3);
						String areaCode = txtCode.getText().substring(0,1);
						pDBMgr.sameProductAddDayCount(txtCode.getText(), 
								codeToAir(airCode), codeToArea(areaCode), pDBMgr.selectProducNameByCode(txtCode.getText()),
								Integer.parseInt(txtPrice.getText()), 
								txtDPDate.getText(), (int)spnMinPeople.getValue(), (int)spnMaxPeople.getValue());
						dialog.setVisible(false);
						dialog.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
				
	}
	
	public int codeToAir(String code) {
		if( code.equalsIgnoreCase("KE")) return 0; 
		else if( code.equalsIgnoreCase("OZ")) return 1;
		else if( code.equalsIgnoreCase("VJ")) return 2;
		else return 3;
	}
	
	public int codeToArea(String code) {
		if( code.equalsIgnoreCase("D")) return 0; 
		else if( code.equalsIgnoreCase("H")) return 1;
		else if( code.equalsIgnoreCase("S")) return 2;
		else return 3;		
	}

}

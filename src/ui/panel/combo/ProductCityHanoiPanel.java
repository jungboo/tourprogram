package ui.panel.combo;

import javax.swing.JPanel;

import db.ProductDBMgr;
import db.model.Product;
import ui.manager.ManagerPage;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

public class ProductCityHanoiPanel extends JPanel {
	public JLabel lbHanoiImage1;
	public JLabel lbHanoiImage2;
	public JLabel lbHanoiImage3;
	public JLabel lbHanoi1;
	public JLabel lbHanoiPr1;
	public JLabel lbHanoi2;
	public JLabel lbHanoiPr2;
	public JLabel lbHanoi3;
	public JLabel lbHanoiPr3;
	
	public ProductCityHanoiPanel() {
		//¼öÁ¤*
		ManagerPage mgPg = new ManagerPage();
		ProductDBMgr pDBMgr = new ProductDBMgr();
		Product pd = new Product();
		//
		setBackground(Color.WHITE);
		setLayout(null);
		
		lbHanoiImage1 = new JLabel("");
		lbHanoiImage1.setBounds(12, 10, 251, 151);
		//¼öÁ¤*
		ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[3]).get(0));
		//
		Image scaled1 = ic1.getImage().getScaledInstance(lbHanoiImage1.getWidth(),
				lbHanoiImage1.getHeight(), Image.SCALE_FAST);
		ic1.setImage(scaled1);
		lbHanoiImage1.setIcon(ic1);
		add(lbHanoiImage1);
		
		lbHanoiImage2 = new JLabel("");
		lbHanoiImage2.setBounds(12, 181, 251, 151);
		//¼öÁ¤*
		ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[4]).get(0));
		//
		Image scaled2 = ic2.getImage().getScaledInstance(lbHanoiImage2.getWidth(),
				lbHanoiImage2.getHeight(), Image.SCALE_FAST);
		ic2.setImage(scaled2);
		lbHanoiImage2.setIcon(ic2);
		add(lbHanoiImage2);
		
		lbHanoiImage3 = new JLabel("");
		lbHanoiImage3.setBounds(12, 354, 251, 151);
		//¼öÁ¤*
		ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[5]).get(0));
		//
		Image scaled3 = ic3.getImage().getScaledInstance(lbHanoiImage3.getWidth(),
				lbHanoiImage3.getHeight(), Image.SCALE_FAST);
		ic3.setImage(scaled3);
		lbHanoiImage3.setIcon(ic3);
		add(lbHanoiImage3);
		
		lbHanoi1 = new JLabel("");
		lbHanoi1.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHanoi1.setBounds(288, 11, 678, 35);
		//¼öÁ¤*
		lbHanoi1.setText(pDBMgr.selectProducNameByCode(pd.CODE_LIST[3]));
		//
		add(lbHanoi1);
		
		lbHanoiPr1 = new JLabel("");
		lbHanoiPr1.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHanoiPr1.setBounds(288, 56, 92, 35);
		//¼öÁ¤*
		lbHanoiPr1.setText(String.valueOf(pDBMgr.selectMinPriceByCode(pd.CODE_LIST[3])));
		//
		add(lbHanoiPr1);
		
		JLabel label_6 = new JLabel("\uC6D0~");
		label_6.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		label_6.setBounds(388, 56, 92, 35);
		add(label_6);
		
		JLabel label_7 = new JLabel("\uC5EC\uD589\uAE30\uAC04: 3\uBC155\uC77C");
		label_7.setForeground(Color.GRAY);
		label_7.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_7.setBounds(288, 101, 678, 25);
		add(label_7);
		
		JLabel label_8 = new JLabel("\uCD9C\uBC1C \uAC00\uB2A5 \uAE30\uAE34: 2021.01.01 ~ 2021.03.31\r\n");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_8.setBounds(288, 136, 678, 25);
		add(label_8);
		
		lbHanoi2 = new JLabel("");
		lbHanoi2.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHanoi2.setBounds(288, 182, 678, 35);
		//¼öÁ¤*
		lbHanoi2.setText(pDBMgr.selectProducNameByCode(pd.CODE_LIST[4]));
		//
		add(lbHanoi2);
		
		lbHanoiPr2 = new JLabel("");
		lbHanoiPr2.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHanoiPr2.setBounds(288, 227, 92, 35);
		//¼öÁ¤*
		lbHanoiPr2.setText(String.valueOf(pDBMgr.selectMinPriceByCode(pd.CODE_LIST[4])));
		//
		add(lbHanoiPr2);
		
		JLabel label_9 = new JLabel("\uC6D0~");
		label_9.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		label_9.setBounds(388, 227, 92, 35);
		add(label_9);
		
		JLabel label_10 = new JLabel("\uC5EC\uD589\uAE30\uAC04: 3\uBC155\uC77C");
		label_10.setForeground(Color.GRAY);
		label_10.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_10.setBounds(288, 272, 678, 25);
		add(label_10);
		
		JLabel label_11 = new JLabel("\uCD9C\uBC1C \uAC00\uB2A5 \uAE30\uAE34: 2021.01.01 ~ 2021.03.31\r\n");
		label_11.setForeground(Color.GRAY);
		label_11.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_11.setBounds(288, 307, 678, 25);
		add(label_11);
		
		lbHanoi3 = new JLabel("");
		lbHanoi3.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHanoi3.setBounds(288, 355, 678, 35);
		//¼öÁ¤*
		lbHanoi3.setText(pDBMgr.selectProducNameByCode(pd.CODE_LIST[5]));
		//
		add(lbHanoi3);
		
		lbHanoiPr3 = new JLabel("");
		lbHanoiPr3.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHanoiPr3.setBounds(288, 400, 92, 35);
		//¼öÁ¤*
		lbHanoiPr3.setText(String.valueOf(pDBMgr.selectMinPriceByCode(pd.CODE_LIST[5])));
		//
		add(lbHanoiPr3);
		
		JLabel label_14 = new JLabel("\uC6D0~");
		label_14.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		label_14.setBounds(388, 400, 92, 35);
		add(label_14);
		
		JLabel label_15 = new JLabel("\uC5EC\uD589\uAE30\uAC04: 3\uBC155\uC77C");
		label_15.setForeground(Color.GRAY);
		label_15.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_15.setBounds(288, 445, 678, 25);
		add(label_15);
		
		JLabel label_16 = new JLabel("\uCD9C\uBC1C \uAC00\uB2A5 \uAE30\uAE34: 2021.01.01 ~ 2021.03.31\r\n");
		label_16.setForeground(Color.GRAY);
		label_16.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_16.setBounds(288, 480, 678, 25);
		add(label_16);
		
	}
}

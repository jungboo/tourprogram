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

public class ProductCityDanangPanel extends JPanel {
	public JLabel lbDanangImage1;
	public JLabel lbDanangImage2;
	public JLabel lbDanangImage3;
	public JLabel lbDanang1;
	public JLabel lbDanangPr1;
	public JLabel lbDanang2;
	public JLabel lbDanangPr2;
	public JLabel lbDanang3;
	public JLabel lbDanangPr3;
	
	public ProductCityDanangPanel() {
		//¼öÁ¤*
		ManagerPage mgPg = new ManagerPage();
		ProductDBMgr pDBMgr = new ProductDBMgr();
		Product pd = new Product();
		//
		setBackground(Color.WHITE);
		setLayout(null);
		
		lbDanangImage1 = new JLabel("");
		lbDanangImage1.setBounds(12, 10, 251, 151);
		//¼öÁ¤*
		ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[0]).get(0));
		//
		Image scaled1 = ic1.getImage().getScaledInstance(lbDanangImage1.getWidth(),
				lbDanangImage1.getHeight(), Image.SCALE_FAST);
		ic1.setImage(scaled1);
		lbDanangImage1.setIcon(ic1);
		add(lbDanangImage1);
		
		lbDanangImage2 = new JLabel("");
		lbDanangImage2.setBounds(12, 181, 251, 151);
		//¼öÁ¤*
		ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[1]).get(0));
		//
		Image scaled2 = ic2.getImage().getScaledInstance(lbDanangImage2.getWidth(),
				lbDanangImage2.getHeight(), Image.SCALE_FAST);
		ic2.setImage(scaled2);
		lbDanangImage2.setIcon(ic2);
		add(lbDanangImage2);
		
		lbDanangImage3 = new JLabel("");
		lbDanangImage3.setBounds(12, 354, 251, 151);
		//¼öÁ¤*
		ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[2]).get(0));
		//
		Image scaled3 = ic3.getImage().getScaledInstance(lbDanangImage3.getWidth(),
				lbDanangImage3.getHeight(), Image.SCALE_FAST);
		ic3.setImage(scaled3);
		lbDanangImage3.setIcon(ic3);
		add(lbDanangImage3);
		
		lbDanang1 = new JLabel("");
		lbDanang1.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbDanang1.setBounds(287, 10, 678, 35);
		//¼öÁ¤*
		lbDanang1.setText(pDBMgr.selectProducNameByCode(pd.CODE_LIST[0]));
		//
		add(lbDanang1);
		
		JLabel label_2 = new JLabel("\uC5EC\uD589\uAE30\uAC04: 3\uBC155\uC77C");
		label_2.setForeground(Color.GRAY);
		label_2.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_2.setBounds(287, 100, 678, 25);
		add(label_2);
		
		JLabel label_3 = new JLabel("\uCD9C\uBC1C \uAC00\uB2A5 \uAE30\uAE34: 2021.01.01 ~ 2021.03.31\r\n");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_3.setBounds(287, 135, 678, 25);
		add(label_3);
		
		JLabel label_1 = new JLabel("\uC6D0~");
		label_1.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		label_1.setBounds(387, 55, 92, 35);
		add(label_1);
		
		lbDanangPr1 = new JLabel("");
		lbDanangPr1.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbDanangPr1.setBounds(287, 55, 92, 35);
		//¼öÁ¤*
		lbDanangPr1.setText(String.valueOf(pDBMgr.selectMinPriceByCode(pd.CODE_LIST[0])));
		//
		add(lbDanangPr1);
		
		lbDanang2 = new JLabel("");
		lbDanang2.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbDanang2.setBounds(287, 181, 678, 35);
		//¼öÁ¤*
		lbDanang2.setText(pDBMgr.selectProducNameByCode(pd.CODE_LIST[1]));
		//
		add(lbDanang2);
		
		JLabel label_6 = new JLabel("\uC6D0~");
		label_6.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		label_6.setBounds(387, 226, 92, 35);
		add(label_6);
		
		lbDanangPr2 = new JLabel("");
		lbDanangPr2.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbDanangPr2.setBounds(287, 226, 92, 35);
		//¼öÁ¤*
		lbDanangPr2.setText(String.valueOf(pDBMgr.selectMinPriceByCode(pd.CODE_LIST[1])));
		//
		add(lbDanangPr2);
		
		JLabel label_8 = new JLabel("\uC5EC\uD589\uAE30\uAC04: 3\uBC155\uC77C");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_8.setBounds(287, 271, 678, 25);
		add(label_8);
		
		JLabel label_9 = new JLabel("\uCD9C\uBC1C \uAC00\uB2A5 \uAE30\uAE34: 2021.01.01 ~ 2021.03.31\r\n");
		label_9.setForeground(Color.GRAY);
		label_9.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_9.setBounds(287, 306, 678, 25);
		add(label_9);
		
		lbDanang3 = new JLabel("");
		lbDanang3.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbDanang3.setBounds(287, 354, 678, 35);
		//¼öÁ¤*
		lbDanang3.setText(pDBMgr.selectProducNameByCode(pd.CODE_LIST[2]));
		//
		add(lbDanang3);
		
		lbDanangPr3 = new JLabel("");
		lbDanangPr3.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbDanangPr3.setBounds(287, 399, 92, 35);
		//¼öÁ¤*
		lbDanangPr3.setText(String.valueOf(pDBMgr.selectMinPriceByCode(pd.CODE_LIST[2])));
		//
		add(lbDanangPr3);
		
		JLabel label_12 = new JLabel("\uC6D0~");
		label_12.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		label_12.setBounds(387, 399, 92, 35);
		add(label_12);
		
		JLabel label_13 = new JLabel("\uC5EC\uD589\uAE30\uAC04: 3\uBC155\uC77C");
		label_13.setForeground(Color.GRAY);
		label_13.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_13.setBounds(287, 444, 678, 25);
		add(label_13);
		
		JLabel label_14 = new JLabel("\uCD9C\uBC1C \uAC00\uB2A5 \uAE30\uAE34: 2021.01.01 ~ 2021.03.31\r\n");
		label_14.setForeground(Color.GRAY);
		label_14.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_14.setBounds(287, 479, 678, 25);
		add(label_14);

	}
}

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

public class ProductCityHochiminPanel extends JPanel {
	public JLabel lbHochiminImage1;
	public JLabel lbHochiminImage2;
	public JLabel lbHochiminImage3;
	public JLabel lbHochimin1;
	public JLabel lbHochiminPr1;
	public JLabel lbHochimin2;
	public JLabel lbHochiminPr2;
	public JLabel lbHochimin3;
	public JLabel lbHochiminPr3;
	
	public ProductCityHochiminPanel() {
		//¼öÁ¤*
		ManagerPage mgPg = new ManagerPage();
		ProductDBMgr pDBMgr = new ProductDBMgr();
		Product pd = new Product();
		//

		setBackground(Color.WHITE);
		setLayout(null);
		
		lbHochiminImage1 = new JLabel("");
		lbHochiminImage1.setBounds(12, 10, 251, 151);
		//¼öÁ¤*
		ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[6]).get(0));
		//
		Image scaled1 = ic1.getImage().getScaledInstance(lbHochiminImage1.getWidth(),
				lbHochiminImage1.getHeight(), Image.SCALE_FAST);
		ic1.setImage(scaled1);
		lbHochiminImage1.setIcon(ic1);
		add(lbHochiminImage1);
		
		lbHochiminImage2 = new JLabel("");
		lbHochiminImage2.setBounds(12, 181, 251, 151);
		//¼öÁ¤*
		ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[7]).get(0));
		//
		Image scaled2 = ic2.getImage().getScaledInstance(lbHochiminImage2.getWidth(),
				lbHochiminImage2.getHeight(), Image.SCALE_FAST);
		ic2.setImage(scaled2);
		lbHochiminImage2.setIcon(ic2);
		add(lbHochiminImage2);
		
		lbHochiminImage3 = new JLabel("");
		lbHochiminImage3.setBounds(12, 354, 251, 151);
		//¼öÁ¤*
		ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[8]).get(0));
		//
		Image scaled3 = ic3.getImage().getScaledInstance(lbHochiminImage3.getWidth(),
				lbHochiminImage3.getHeight(), Image.SCALE_FAST);
		ic3.setImage(scaled3);
		lbHochiminImage3.setIcon(ic3);
		add(lbHochiminImage3);
		
		lbHochimin1 = new JLabel("");
		lbHochimin1.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHochimin1.setBounds(287, 10, 678, 35);
		//¼öÁ¤*
		lbHochimin1.setText(pDBMgr.selectProducNameByCode(pd.CODE_LIST[6]));
		//
		add(lbHochimin1);
		
		lbHochiminPr1 = new JLabel("");
		lbHochiminPr1.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHochiminPr1.setBounds(287, 55, 92, 35);
		//¼öÁ¤*
		lbHochiminPr1.setText(String.valueOf(pDBMgr.selectMinPriceByCode(pd.CODE_LIST[6])));
		//
		add(lbHochiminPr1);
		
		JLabel label_2 = new JLabel("\uC6D0~");
		label_2.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		label_2.setBounds(387, 55, 92, 35);
		add(label_2);
		
		JLabel label_3 = new JLabel("\uC5EC\uD589\uAE30\uAC04: 3\uBC155\uC77C");
		label_3.setForeground(Color.GRAY);
		label_3.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_3.setBounds(287, 100, 678, 25);
		add(label_3);
		
		JLabel label_4 = new JLabel("\uCD9C\uBC1C \uAC00\uB2A5 \uAE30\uAE34: 2021.01.01 ~ 2021.03.31\r\n");
		label_4.setForeground(Color.GRAY);
		label_4.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_4.setBounds(287, 135, 678, 25);
		add(label_4);
		
		lbHochimin2 = new JLabel("");
		lbHochimin2.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHochimin2.setBounds(287, 182, 678, 35);
		//¼öÁ¤*
		lbHochimin2.setText(pDBMgr.selectProducNameByCode(pd.CODE_LIST[7]));
		//
		add(lbHochimin2);
		
		lbHochiminPr2 = new JLabel("");
		lbHochiminPr2.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHochiminPr2.setBounds(287, 227, 92, 35);
		//¼öÁ¤*
		lbHochiminPr2.setText(String.valueOf(pDBMgr.selectMinPriceByCode(pd.CODE_LIST[7])));
		//
		add(lbHochiminPr2);
		
		JLabel label_7 = new JLabel("\uC6D0~");
		label_7.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		label_7.setBounds(387, 227, 92, 35);
		add(label_7);
		
		JLabel label_8 = new JLabel("\uC5EC\uD589\uAE30\uAC04: 3\uBC155\uC77C");
		label_8.setForeground(Color.GRAY);
		label_8.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_8.setBounds(287, 272, 678, 25);
		add(label_8);
		
		JLabel label_9 = new JLabel("\uCD9C\uBC1C \uAC00\uB2A5 \uAE30\uAE34: 2021.01.01 ~ 2021.03.31\r\n");
		label_9.setForeground(Color.GRAY);
		label_9.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_9.setBounds(287, 307, 678, 25);
		add(label_9);
		
		lbHochimin3 = new JLabel("");
		lbHochimin3.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHochimin3.setBounds(287, 355, 678, 35);
		//¼öÁ¤*
		lbHochimin3.setText(pDBMgr.selectProducNameByCode(pd.CODE_LIST[8]));
		//
		add(lbHochimin3);
		
		lbHochiminPr3 = new JLabel("");
		lbHochiminPr3.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHochiminPr3.setBounds(287, 400, 92, 35);
		//¼öÁ¤*
		lbHochiminPr3.setText(String.valueOf(pDBMgr.selectMinPriceByCode(pd.CODE_LIST[8])));
		//
		add(lbHochiminPr3);
		
		JLabel label_12 = new JLabel("\uC6D0~");
		label_12.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		label_12.setBounds(387, 400, 92, 35);
		add(label_12);
		
		JLabel label_13 = new JLabel("\uC5EC\uD589\uAE30\uAC04: 3\uBC155\uC77C");
		label_13.setForeground(Color.GRAY);
		label_13.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_13.setBounds(287, 445, 678, 25);
		add(label_13);
		
		JLabel label_14 = new JLabel("\uCD9C\uBC1C \uAC00\uB2A5 \uAE30\uAE34: 2021.01.01 ~ 2021.03.31\r\n");
		label_14.setForeground(Color.GRAY);
		label_14.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_14.setBounds(287, 480, 678, 25);
		add(label_14);

	}
}

package ui.panel.combo;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

import db.ProductDBMgr;
import db.model.Product;
import ui.main.TourMainFrame;
import ui.manager.ManagerPage;
import ui.panel.product.DanangAsiana;

public class ProductAirAsianaPanel extends JPanel {
	public JLabel lbDanangImage;
	public JLabel lbHanoiImage;
	public JLabel lbHochiminImage;
	public JLabel lbDanang;
	public JLabel lbDanangPr;
	public JLabel lbHanoi;
	public JLabel lbHanoiPr;
	public JLabel lbHochimin;
	public JLabel lbHochiminPr;
	public DanangAsiana pnDn;

	
	public ProductAirAsianaPanel() {
		//¼öÁ¤*
		ProductDBMgr pDBMgr = new ProductDBMgr();
		Product pd = new Product();
		//
		setBackground(Color.WHITE);
		setLayout(null);
		
		
//		pnDn = new DanangAsiana();
		lbDanangImage = new JLabel("");
		lbDanangImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TourMainFrame.scrollPane.setViewportView(pnDn);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbDanangImage.setBorder(new LineBorder(new Color(51, 153, 255), 2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbDanangImage.setBorder(new LineBorder(new Color(51, 153, 255), 0));
			}
		});
		lbDanangImage.setBounds(12, 10, 251, 151);
		//¼öÁ¤*
		ImageIcon ic1 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[1]).get(0));
		//
		Image scaled1 = ic1.getImage().getScaledInstance(lbDanangImage.getWidth(),
				lbDanangImage.getHeight(), Image.SCALE_FAST);
		ic1.setImage(scaled1);
		lbDanangImage.setIcon(ic1);
		add(lbDanangImage);
		
		lbHanoiImage = new JLabel("");
		lbHanoiImage.setBounds(12, 181, 251, 151);
		//¼öÁ¤*
		ImageIcon ic2 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[4]).get(0));
		//
		Image scaled2 = ic2.getImage().getScaledInstance(lbHanoiImage.getWidth(),
				lbHanoiImage.getHeight(), Image.SCALE_FAST);
		ic2.setImage(scaled2);
		lbHanoiImage.setIcon(ic2);
		add(lbHanoiImage);
		
		lbHochiminImage = new JLabel("");
		lbHochiminImage.setBounds(12, 354, 251, 151);
		//¼öÁ¤*
		ImageIcon ic3 = new ImageIcon(pDBMgr.selectPicturesByCode(pd.CODE_LIST[7]).get(0));
		//
		Image scaled3 = ic3.getImage().getScaledInstance(lbHochiminImage.getWidth(),
				lbHochiminImage.getHeight(), Image.SCALE_FAST);
		ic3.setImage(scaled3);
		lbHochiminImage.setIcon(ic3);
		add(lbHochiminImage);
		
		lbDanang = new JLabel("");
		lbDanang.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbDanang.setBounds(287, 10, 678, 35);
		//¼öÁ¤*
		lbDanang.setText(pDBMgr.selectProducNameByCode(pd.CODE_LIST[1]));
		//
		add(lbDanang);
		
		lbDanangPr = new JLabel("");
		lbDanangPr.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbDanangPr.setBounds(287, 55, 92, 35);
		//¼öÁ¤*
		lbDanangPr.setText(String.valueOf(pDBMgr.selectMinPriceByCode(pd.CODE_LIST[1])));
		//
		add(lbDanangPr);
		
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
		
		lbHanoi = new JLabel();
		lbHanoi.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHanoi.setBounds(287, 182, 678, 35);
		//¼öÁ¤*
		lbHanoi.setText(pDBMgr.selectProducNameByCode(pd.CODE_LIST[4]));
		//
		add(lbHanoi);
		
		lbHanoiPr = new JLabel();
		lbHanoiPr.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHanoiPr.setBounds(287, 227, 92, 35);
		//¼öÁ¤*
		lbHanoiPr.setText(String.valueOf(pDBMgr.selectMinPriceByCode(pd.CODE_LIST[4])));
		//
		add(lbHanoiPr);
		
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
		
		JLabel label_5 = new JLabel("\uCD9C\uBC1C \uAC00\uB2A5 \uAE30\uAE34: 2021.01.01 ~ 2021.03.31\r\n");
		label_5.setForeground(Color.GRAY);
		label_5.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_5.setBounds(287, 480, 678, 25);
		add(label_5);
		
		JLabel label_10 = new JLabel("\uC5EC\uD589\uAE30\uAC04: 3\uBC155\uC77C");
		label_10.setForeground(Color.GRAY);
		label_10.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.PLAIN, 14));
		label_10.setBounds(287, 445, 678, 25);
		add(label_10);
		
		lbHochiminPr = new JLabel();
		lbHochiminPr.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHochiminPr.setBounds(287, 400, 92, 35);
		//¼öÁ¤*
		lbHochiminPr.setText(String.valueOf(pDBMgr.selectMinPriceByCode(pd.CODE_LIST[7])));
		//
		add(lbHochiminPr);
		
		lbHochimin = new JLabel();
		lbHochimin.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		lbHochimin.setBounds(287, 355, 678, 35);
		//¼öÁ¤*
		lbHochimin.setText(pDBMgr.selectProducNameByCode(pd.CODE_LIST[7]));
		//
		add(lbHochimin);
		
		JLabel label_13 = new JLabel("\uC6D0~");
		label_13.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 18));
		label_13.setBounds(387, 400, 92, 35);
		add(label_13);

	}
}

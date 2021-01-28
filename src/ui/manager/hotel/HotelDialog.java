package ui.manager.hotel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import deta.db.HotelDBMgr;
import deta.model.Hotel;
import ui.manager.AddProductDate;
import ui.manager.ManagerPage;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HotelDialog extends JDialog {
	HotelDialog hDlg;
	private final JPanel contentPanel = new JPanel();
	private JTable tableHotels;
	ArrayList<Hotel> htList;
	JComboBox comboCity;
	
	public static void main(String[] args) {
		try {
			HotelDialog dialog = new HotelDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HotelDialog() {
		this.hDlg = this;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				contentPanel.add(panel, BorderLayout.NORTH);
				{
					comboCity = new JComboBox();
					comboCity.setModel(new DefaultComboBoxModel(new String[] {"\uB2E4\uB0AD", "\uD558\uB178\uC774", "\uD638\uCE58\uBBFC"}));
					comboCity.setSelectedIndex(0);
					panel.add(comboCity);
				}
				{
					JButton okButton = new JButton("\uC870\uD68C");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String dn = "�ٳ�";
							String hn = "�ϳ���";
							String hc = "ȣġ��";
							if( comboCity.getSelectedIndex() == 0 ) 
								showFoodTableFromDB(dn);
							if( comboCity.getSelectedIndex() == 1 ) 
								showFoodTableFromDB(hn);
							if( comboCity.getSelectedIndex() == 2 ) 
								showFoodTableFromDB(hc);
							
						}
					});
					panel.add(okButton);
					okButton.setActionCommand("OK");
					getRootPane().setDefaultButton(okButton);
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				contentPanel.add(scrollPane, BorderLayout.CENTER);
				{
					tableHotels = new JTable();
					scrollPane.setViewportView(tableHotels);
					setDummyDataToTable();
					
				}
			}
			setDummyDataToTable();
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnEditHotel = new JButton("\uD638\uD154 \uC218\uC815\uD558\uAE30");
				btnEditHotel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int row = tableHotels.getSelectedRow();
						Object hotel = tableHotels.getValueAt(row, 1);
						ManagerPage.lbDayHotels[ManagerPage.pnSchedules.getSelectedIndex()].setText(String.valueOf(hotel));
						hDlg.setVisible(false);
						hDlg.dispose();
					}
				});
				buttonPane.add(btnEditHotel);
			}
		}
	}

	public void setDummyDataToTable() {
		final String[] columnNames = {
				"����", "ȣ�ڸ�"
			};
		Object[][] data = {
				{"�ٳ�", "�ٳ�ȣ��"},
				{"�ϳ���", "�ϳ���ȣ��"},
				{"ȣġ��", "ȣġ��ȣ��"}
			};	
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		tableHotels.setModel(dtm);
	}
	
	public void showFoodTableFromDB(String ct) {
		final String[] columnNames = {
				"����", "ȣ�ڸ�"
			};
		// DB
		ui.manager.hotel.HotelDBMgr mgr = new ui.manager.hotel.HotelDBMgr();
		htList = mgr.selectCityHotels(ct);
		if( htList == null || htList.isEmpty() ) 
			return;

		Object[][] data 
			= new Object[htList.size()][columnNames.length];
		for (int i = 0; i < htList.size(); i++) { // i��
			Hotel ht = htList.get(i);
			data[i][0] = ht.getCity();
			data[i][1] = ht.getName();
		}
		
		DefaultTableModel dtm = 
				new DefaultTableModel(data, 
						columnNames);
		tableHotels.setModel(dtm);
	}
	
}

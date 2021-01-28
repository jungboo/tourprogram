package ui.manager.hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import deta.model.Hotel;
import util.db.OracleDBUtil;

public class HotelDBMgr {
	
	
	public HotelDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	public Connection conn;
	
	// ��� ���ڵ� ��ȸ���ϱ�
	public void printAllHotels() {
		if( conn != null ) {
			ArrayList<Hotel> htList = new ArrayList<>(); 
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from hotels"; // ��ɾ� �����ϸ� �÷��� ���� ��ȸ �� ���� ����
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					String name = rs.getString("name");
					String city = rs.getString("city");
					Date checkin = rs.getDate("checkin");
					Date checkout = rs.getDate("checkout");
					String schedule = rs.getString("schedule");
					
					Hotel ht = new Hotel(name, city, checkin, checkout, schedule);
					htList.add(ht);
					System.out.println(ht);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("��� ü���� ����!");
		}
	}
	
	// ������ ���� ���ڵ� ��ȸ �� ����(sql ��ɾ�� �÷� �з�����)
	public ArrayList<Hotel> selectCityHotels(String ct) {
		if( conn != null ) {
			ArrayList<Hotel> htList = new ArrayList<>(); 
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from hotels where city = '"+ ct +"'"; // ��ɾ� �����ϸ� �÷��� ���� ��ȸ �� ���� ����
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					String name = rs.getString("name");
					String city = rs.getString("city");
					Date checkin = rs.getDate("checkin");
					Date checkout = rs.getDate("checkout");
					String schedule = rs.getString("schedule");
					
					Hotel ht = new Hotel(name, city, checkin, checkout, schedule);
					htList.add(ht);
				}
				return htList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("��� ü���� ����!");
		}
		return null;
	}
	
	// ��� ���ڵ� ��ȸ �� ����(sql ��ɾ�� �÷� �з�����)
		public ArrayList<Hotel> selectAllHotels() {
			if( conn != null ) {
				ArrayList<Hotel> htList = new ArrayList<>(); 
				try {
					Statement stmt = conn.createStatement();
					String sql = "select * from hotels"; // ��ɾ� �����ϸ� �÷��� ���� ��ȸ �� ���� ����
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						String name = rs.getString("name");
						String city = rs.getString("city");
						Date checkin = rs.getDate("checkin");
						Date checkout = rs.getDate("checkout");
						String schedule = rs.getString("schedule");
						
						Hotel ht = new Hotel(name, city, checkin, checkout, schedule);
						htList.add(ht);
					}
					return htList;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("��� ü���� ����!");
			}
			return null;
		}
	
	// ���ο� ȣ�� �߰�
	public boolean insertNewHotel(String name, String city, String checkin,
			String checkout, String schedule) {
		if( conn != null ) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "insert into hotels values('" + name + "', "
						+ "'" + city + "', TO_DATE('" + checkin + "', 'YYYY-MM-DD'), "
						+ "TO_DATE('" + checkout + "', 'YYYY-MM-DD')"
						+ ", '" + schedule + "')";
				int r = stmt.executeUpdate(sql);
				if( r == 1 ) {
					System.out.println(" - ȣ�� ���ڵ� �߰� ����!");
					return true;
				} else {
					System.out.println(" - ȣ�� ���ڵ� �߰� ����!!");
				}
			} catch (SQLException e) {
				System.out.println(name + " ȣ�� ���ڵ� �߰� ���� - SQL ����.");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	// ������ ������Ʈ
	public void updateHotelSchedule(String checkin, String checkout, String schedule,
			String name, String city) {
		if( conn != null ) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "UPDATE HOTELS SET checkin = TO_DATE('" + checkin + "', 'YYYY-MM-DD'),"
						+ " checkout = TO_DATE('" + checkout + "', 'YYYY-MM-DD'), schedule = '" + schedule + "'"  
						+ " where name = '" + name + "' and city = '" + city + "'";
				int r = stmt.executeUpdate(sql);
				if( r == 1 ) {
					System.out.println(name + " ���ڵ� ���� ����!");
				} else {
					System.out.println(name + " ���ڵ� ���� ����!!");
				}
			} catch (SQLException e) {
				System.out.println("���� ����!! - SQL ����");
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		HotelDBMgr htMgr = new HotelDBMgr();
		System.out.println("DB ������...");
		
		// 1. ��� ���ڵ� ���� �� ���
//		printAllHotels();
		
		// 2. ���� �� ��ȸ ������
//		ArrayList<Hotel> htList = selectAllHotels();
//		if( htList != null && !htList.isEmpty() ) {
//			for (Hotel ht : htList) {
//				System.out.println(ht.getName());
//				System.out.println(ht.getCheckin());
//			}
//		}
		
		// 3. ���ڵ� �߰� ������
//		insertNewHotel("�ٳ�ȣ��", "�ٳ�", "2020-10-31", "2020-11-01", "1night");
		
		// 4. ȣ�� ������ ����
		
//		htMgr.updateHotelSchedule("2020-10-30", "2020-10-31", "2night", "�ٳ�ȣ��", "�ٳ�");
		
	}
}

package deta.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import deta.model.Hotel;
import deta.model.TourCity;
import util.db.OracleDBUtil;

public class TourCityDBMgr {
	public TourCityDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	
	public Connection conn;
	
	// ��ü ������ ��ȸ�� ����
	public void printAllTourCity() {
		if( conn != null ) {
			ArrayList<TourCity> tcList = new ArrayList<>(); 
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from tour_city"; // ��ɾ� �����ϸ� �÷��� ���� ��ȸ �� ���� ����
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					String name = rs.getString("name");
					String schedule = rs.getString("schedule");
					String representativeTourism = rs.getString("representativeTourism");
					String vehicle = rs.getString("vehicle");
					
					TourCity tc = new TourCity(name, schedule, representativeTourism, vehicle);
					tcList.add(tc);
					System.out.println(tc);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("��� ü���� ����!");
		}
	}
	
	// Ư�� �÷����� ��ȸ �� ����(���۵Ǵ��� �𸣰��� ���� Ȯ�� �ʿ�)
	public ArrayList<TourCity> selectOneTourCity(String values, String values2, String select) {
		if( conn != null ) {
			ArrayList<TourCity> tcList = new ArrayList<>(); 
			try {
				Statement stmt = conn.createStatement();
				String sql = "select "+values+" from tour_city where "+values2+" = '"+select+"'"; // ��ɾ� �����ϸ� �÷��� ���� ��ȸ �� ���� ����
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					String name = rs.getString("name");
					String schedule = rs.getString("schedule");
					String representativeTourism = rs.getString("representativeTourism");
					String vehicle = rs.getString("vehicle");
					
					TourCity tc = new TourCity(name, schedule, representativeTourism, vehicle);
					tcList.add(tc);
					return tcList;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("��� ü���� ����!");
		}
		return null;
	}
	
	// �ϳ��� ������ �߰�
	public boolean insertNewHotel(String name, String schedule, String representativeTourism,
			String vehicle) {
		if( conn != null ) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "insert into tour_city values("
						+ "'"+name+"', '"+schedule+"', '"+representativeTourism+"', '"+vehicle+"')";
				int r = stmt.executeUpdate(sql);
				if( r == 1 ) {
					System.out.println(" - ������ ���ڵ� �߰� ����!");
					return true;
				} else {
					System.out.println(" - ������ ���ڵ� �߰� ����!!");
				}
			} catch (SQLException e) {
				System.out.println(name + "������ ���ڵ� �߰� ���� - SQL ����.");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	// ������ ����(������)
	public void updateHotelSchedule(String schedule, String name, String representativeTourism) {
		if( conn != null ) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "UPDATE TOUR_CITY SET schedule = '"+ schedule +"' where name = '" + name + "'"
						+ " and REPRESENTATIVE_TOURISM = '" + representativeTourism + "'"; 
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
		TourCityDBMgr tc = new TourCityDBMgr();
//		boolean b = tc.insertNewHotel("ȣġ��", "1night", "ȣġ�λ��", "bus");
//		tc.updateHotelSchedule("2night", "ȣġ��", "ȣġ�λ��");
	}
}



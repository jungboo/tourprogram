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
	
	// 모든 레코드 조회만하기
	public void printAllHotels() {
		if( conn != null ) {
			ArrayList<Hotel> htList = new ArrayList<>(); 
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from hotels"; // 명령어 변경하면 컬럼에 따라서 조회 후 저장 가능
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
			System.out.println("통신 체널이 없음!");
		}
	}
	
	// 지역명에 따른 레코드 조회 후 저장(sql 명령어로 컬럼 분류가능)
	public ArrayList<Hotel> selectCityHotels(String ct) {
		if( conn != null ) {
			ArrayList<Hotel> htList = new ArrayList<>(); 
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from hotels where city = '"+ ct +"'"; // 명령어 변경하면 컬럼에 따라서 조회 후 저장 가능
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
			System.out.println("통신 체널이 없음!");
		}
		return null;
	}
	
	// 모든 레코드 조회 후 저장(sql 명령어로 컬럼 분류가능)
		public ArrayList<Hotel> selectAllHotels() {
			if( conn != null ) {
				ArrayList<Hotel> htList = new ArrayList<>(); 
				try {
					Statement stmt = conn.createStatement();
					String sql = "select * from hotels"; // 명령어 변경하면 컬럼에 따라서 조회 후 저장 가능
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
				System.out.println("통신 체널이 없음!");
			}
			return null;
		}
	
	// 새로운 호텔 추가
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
					System.out.println(" - 호텔 레코드 추가 성공!");
					return true;
				} else {
					System.out.println(" - 호텔 레코드 추가 실패!!");
				}
			} catch (SQLException e) {
				System.out.println(name + " 호텔 레코드 추가 실패 - SQL 예외.");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	// 스케줄 업데이트
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
					System.out.println(name + " 레코드 수정 성공!");
				} else {
					System.out.println(name + " 레코드 수정 실패!!");
				}
			} catch (SQLException e) {
				System.out.println("수정 실패!! - SQL 예외");
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		HotelDBMgr htMgr = new HotelDBMgr();
		System.out.println("DB 접속중...");
		
		// 1. 모든 레코드 저장 후 출력
//		printAllHotels();
		
		// 2. 저장 후 조회 성공함
//		ArrayList<Hotel> htList = selectAllHotels();
//		if( htList != null && !htList.isEmpty() ) {
//			for (Hotel ht : htList) {
//				System.out.println(ht.getName());
//				System.out.println(ht.getCheckin());
//			}
//		}
		
		// 3. 레코드 추가 성공함
//		insertNewHotel("다낭호텔", "다낭", "2020-10-31", "2020-11-01", "1night");
		
		// 4. 호텔 스케줄 변경
		
//		htMgr.updateHotelSchedule("2020-10-30", "2020-10-31", "2night", "다낭호텔", "다낭");
		
	}
}

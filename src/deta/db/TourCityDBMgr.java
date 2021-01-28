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
	
	// 전체 여행지 조회후 저장
	public void printAllTourCity() {
		if( conn != null ) {
			ArrayList<TourCity> tcList = new ArrayList<>(); 
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from tour_city"; // 명령어 변경하면 컬럼에 따라서 조회 후 저장 가능
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
			System.out.println("통신 체널이 없음!");
		}
	}
	
	// 특정 컬럼으로 조회 후 저장(동작되는지 모르겠음 추후 확인 필요)
	public ArrayList<TourCity> selectOneTourCity(String values, String values2, String select) {
		if( conn != null ) {
			ArrayList<TourCity> tcList = new ArrayList<>(); 
			try {
				Statement stmt = conn.createStatement();
				String sql = "select "+values+" from tour_city where "+values2+" = '"+select+"'"; // 명령어 변경하면 컬럼에 따라서 조회 후 저장 가능
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
			System.out.println("통신 체널이 없음!");
		}
		return null;
	}
	
	// 하나의 관광지 추가
	public boolean insertNewHotel(String name, String schedule, String representativeTourism,
			String vehicle) {
		if( conn != null ) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "insert into tour_city values("
						+ "'"+name+"', '"+schedule+"', '"+representativeTourism+"', '"+vehicle+"')";
				int r = stmt.executeUpdate(sql);
				if( r == 1 ) {
					System.out.println(" - 관광지 레코드 추가 성공!");
					return true;
				} else {
					System.out.println(" - 관광지 레코드 추가 실패!!");
				}
			} catch (SQLException e) {
				System.out.println(name + "관광지 레코드 추가 실패 - SQL 예외.");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	// 관광지 수정(스케줄)
	public void updateHotelSchedule(String schedule, String name, String representativeTourism) {
		if( conn != null ) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "UPDATE TOUR_CITY SET schedule = '"+ schedule +"' where name = '" + name + "'"
						+ " and REPRESENTATIVE_TOURISM = '" + representativeTourism + "'"; 
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
		TourCityDBMgr tc = new TourCityDBMgr();
//		boolean b = tc.insertNewHotel("호치민", "1night", "호치민사원", "bus");
//		tc.updateHotelSchedule("2night", "호치민", "호치민사원");
	}
}



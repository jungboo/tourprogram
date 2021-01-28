package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.model.Admin;
import db.model.Product;
import util.db.OracleDBUtil;

public class AdminDBMgr {
	
public Connection conn;
	
	public AdminDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	
	
	public ArrayList<Admin> getAllInfos() {
		if( conn != null ) {
			try {
				ArrayList<Admin> infoList = new ArrayList<>();
				String sql = "select * from reservation order by call_check asc";
						
				Statement stmt = conn.createStatement();				
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Admin Ad = new Admin(
							rs.getString("code"),
							rs.getDate("reservDay"),
							rs.getDate("startDay"),
							rs.getString("name"),
							rs.getInt("peoples"),
							rs.getString("cellphone"),
							rs.getInt("call_check"));// ���ƿ�
					
					infoList.add(Ad);
				}
				//
				System.out.println("���� �ο���: " + infoList.size());
				return infoList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	//�����ư���� ����Ʈ ������Ʈ
	public boolean updateReservationList(String code, java.util.Date reservDay, String strStartDay, String name, int peoples, String cellPhone) {
		if (code == null || code.isEmpty()) {
			System.out.println("�ڵ�� ����");
			return false;
		} else if (reservDay == null ) {
			System.out.println("��¥ ����");
			return false;
		} else if (strStartDay == null ) {
			System.out.println("���డ�ɿ��� ����");
			return false;
		}else if (name == null || name.isEmpty() ) {
			System.out.println("�̸� ����");
			return false;
		}else if (peoples == 0 ) {
			System.out.println("�ο��� ����");
			return false;
		}else if (cellPhone == null || cellPhone.isEmpty()) {
			System.out.println("�ڵ�����ȣ ����");
			return false;
		}
		if (this.conn != null) {
			try {
				
				String sql = "insert into reservation values(?, ?, ?, ?, ?, ?, 0)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				Date sqlReservDay = new java.sql.Date(reservDay.getTime());
				pstmt.setDate(2, sqlReservDay);
				Date sqlStartDay = Date.valueOf(strStartDay);
				pstmt.setDate(3, sqlStartDay);
				pstmt.setString(4, name);
				pstmt.setInt(5, peoples);
				pstmt.setString(6, cellPhone);
				int r = pstmt.executeUpdate();
				System.out.println(r + "���� �� ���� �����Ϸ�");
				return true;
			} catch (SQLException e) {
				System.out.println("���� ����Ʈ ������Ʈ ����!");
				e.printStackTrace();
			} 

		}
		return false;
	}

}

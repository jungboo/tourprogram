package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import db.model.Product;

public class ProductDBMgr {

	public Connection conn; // DBMS ������ �����ϴ� ��� ��ü
	private static final String user = "TRAVLE_PRODUCT";
	private static final String password = "1234";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";

	public static void main(String[] args) {
		ProductDBMgr pdm = new ProductDBMgr();

//		pdm.sameProductAddDayCount("DKE", Product.KE, Product.DAD, 799000, "2020-05-08", 6, 12);

//		pdm.sameProductAddMonth("SVJ", Product.VJ, Product.SGN, 599000, 6, 12, "202101");

//		pdm.selectAllProduct();

//		pdm.selectProductByCode("DKE");

//		pdm.selectProductByAirline(Product.OZ);

//		pdm.selectProductByArea(Product.DAD);

//		pdm.updateProductNameByCode("SVJ", "ȣġ���� VJ��");
//		
//		pdm.updatePriceByCodeAndDpDate("HKE", "2021-05-05", 399000);
//		
//		pdm.updateReservationByCodeAndDpDate("HKE", "2021-05-05", 1);

//		pdm.updateGuideByCodeAndDpDate("HKE", "2021-05-05", 0);

//		pdm.updateMinimumPeopleByCodeAndDpDate("HKE", "2021-05-05", 8);

//		pdm.updateMaximumPeopleByCodeAndDpDate("HKE", "2021-05-05", 20);

//		pdm.updateScheduleByCodeAndDpDate("HKE", "2021-05-05", 1, "ȣ�ڿ��� �޽�");

//		pdm.updateRateNameByCode("DKE", 4.0f);

//		ArrayList<Product> pdList = pdm.selectReservationNameByCode("DOZ");
//		System.out.println(pdList.size());
//		for (Product res : pdList) {
//			System.out.println(res);
//		}
		
		ArrayList<String> pdList1 = pdm.selectHotelByCode("DKE");
		for (String res : pdList1) {
			System.out.println(res);
		}
		
//		System.out.println(pdm.selectDepartureDateByCode("DKE"));
		
//		ArrayList<String> pdList = pdm.selectDepartureDateByCode("DKE");
//		String year;
//		String month;
//		String date;
//		for (int i = 0; i < pdList.size(); i++) {
//			year = pdList.get(i).substring(0, 4);
//			month = pdList.get(i).substring(5, 7);
//			date = pdList.get(i).substring(8, 10);
//			System.out.println(year);
//			System.out.println(month);
//			System.out.println(date);
//		}
		
		
		
		pdm.endConnection();

	}

	// �����ڿ��� ����� ����
	public ProductDBMgr() {
		beginConnection();
	}

	// ��� ���� �¾�
	public void beginConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println("Oracle ����̹� �ε� ����!!! ");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����!!");
			e.printStackTrace();
		}
	}

	public void endConnection() {
		try {
			conn.close();
			System.out.println("DB ���� ����!");
		} catch (SQLException e) {
			System.out.println("DB ���� ����!");
			e.printStackTrace();
		}
	}

	// �ű� ��ǰ ���ڵ忡 �߰��ϱ�(��¥ �Է½� yyyy-mm-dd)
	public boolean insertNewProduct(String code, int airlineNum, int areaNum, String productName, int price, String departureDate,
			int minimumPeople, int maximumPeople, int dayCount) {
		if (this.conn != null) {
			try {
				Statement stmt = this.conn.createStatement();
				String sql = "insert into product values('" + code + "','" + Product.AREA_LIST[areaNum] + "', '"
						+ Product.AIRLINE_LIST[airlineNum] + "', '"+ productName +"', " + price + ", TO_DATE('" + departureDate + "', "
						+ "'YYYY-MM-DD ') ," + minimumPeople + ", " + maximumPeople + ", 0,  1, '0.0'," + dayCount
						+ ",'', '' , '', '','')";
				int r = stmt.executeUpdate(sql);
				if (r == 1) { // 1�� ���ڵ� �߰� ����
					System.out.println("code ���ڵ� �߰� ���� - " + code);
					return true;
				} else {
					System.out.println("code ���ڵ� �߰� ���� - " + code);
				}
			} catch (SQLException e) {
				System.out.println(code + " ������ ���ڵ� �߰� ����! - SQL ����.");
				e.printStackTrace();
			}

		}
		return false;
	}

	// ���ϻ�ǰ ������ �߰��ϱ�(�űԻ�ǰ �޼ҵ� �ʿ�)(��¥ �Է½� yyyy-mm-dd)
	public void sameProductAddDayCount(String code, int airlineNum, int areaNum, String productName, int price, String departureDate,
			int minimumPeople, int maximumPeople) {
		ProductDBMgr pdm = new ProductDBMgr();
		for (int i = 1; i <= Product.getMaxDaycount(); i++) {
			pdm.insertNewProduct(code, airlineNum, areaNum, productName, price, departureDate, minimumPeople, maximumPeople, i);
		}
	}

	// ���� ��ǰ ���� ����(��¥ �Է½� yyyymm)
//	public void sameProductAddMonth(String code, int airlineNum, int areaNum, int price, int minimumPeople,
//			int maximumPeople, String yyyymm) {
//		ProductDBMgr pdm = new ProductDBMgr();
//		int year = 0;
//		int month = 0;
//		int i = 0;
//		String departureDate;
//		year = Integer.parseInt(yyyymm.substring(0, 4));
//		month = Integer.parseInt(yyyymm.substring(4, 6));
//		if (month > 0 && month < 13) {
//			switch (month) {
//			case 1:	case 3:	case 5:	case 7:	case 8:	case 10:	case 12:
//				i = 31;
//				break;
//			case 2:
//				i = 28;
//				break;
//			case 4:	case 6:	case 9:	case 11:
//				i = 30;
//				break;
//			default:
//				i = -1;
//			}
//			for (int day = 1; day <= i; day++) {
//				departureDate = year + "-" + month + "-" + day;
//				pdm.sameProductAddDayCount(code, airlineNum, areaNum, price, departureDate, minimumPeople,
//						maximumPeople);
//			}
//		} else {
//			System.out.println("�Էµ� month ����!" + month);
//		}
//
//	}

	// ��ǰ ��ü ���ڵ� ��ȸ�ϱ�
	public ArrayList<Product> selectAllProduct() {
		if (this.conn != null) {
			ArrayList<Product> pdList = new ArrayList<>();

			String sql = "select * from product order by departure_date asc";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String code = rs.getString("code");
					String area = rs.getString("area");
					int areaNum = 0;
					for (int i = 0; i < Product.AREA_LIST.length; i++) {
						if( Product.AREA_LIST[i].equals(area) ) {
						areaNum = i;
						break;}
					}
					String airline = rs.getString("airline");
					int airlineNum = 0;
					for (int i = 0; i < Product.AIRLINE_LIST.length; i++) {
						if(Product.AIRLINE_LIST[i].equals(airline)) {
						airlineNum = i;
						break;}
					}
					String productName = rs.getString("productname");
					int price = rs.getInt("price");
					Date departureDate = rs.getDate("departure_date"); // **
					int minimumPeople = rs.getInt("MINIMUM_PEOPLE");
					int maximumPeople = rs.getInt("MAXIMUM_PEOPLE");
					int reservation = rs.getInt("RESERVATION");
					int guide = rs.getInt("GUIDE");
					float rate = rs.getFloat("rate");
					int dayCount = rs.getInt("DAYCOUNT");
					String schedule = rs.getString("SCHEDULE");
					String picturePath_1 = rs.getString("picture_path_1");
					String picturePath_2 = rs.getString("picture_path_2");
					String picturePath_3 = rs.getString("picture_path_3");
					String hotel = rs.getString("hotel");

					Product pd = new Product(code, airlineNum, areaNum, productName, price, departureDate,
							minimumPeople, maximumPeople, reservation, guide, rate, dayCount, schedule, picturePath_1,
							picturePath_2, picturePath_3, hotel);

					pdList.add(pd);
				}
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				return pdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// ���������� ���ڵ� ��ȸ�ϱ�
	public ArrayList<Product> selectProductByRate() {
		if (this.conn != null) {
			ArrayList<Product> pdList = new ArrayList<>();

			String sql = "select * from product order by rate desc";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String area = rs.getString("area");
					int areaNum = 0;
					for (int i = 0; i < Product.AREA_LIST.length; i++) {
						if(Product.AREA_LIST[i].equals(area)) {
						areaNum = i;
						break;}
					}
					String airline = rs.getString("airline");
					int airlineNum = 0;
					for (int i = 0; i < Product.AIRLINE_LIST.length; i++) {
						if(Product.AIRLINE_LIST[i].equals(airline)) {
						airlineNum = i;
						break;}
					}
					String code = rs.getString("code");
					String productName = rs.getString("productname");
					int price = rs.getInt("price");
					Date departureDate = rs.getDate("departure_date");
					int minimumPeople = rs.getInt("MINIMUM_PEOPLE");
					int maximumPeople = rs.getInt("MAXIMUM_PEOPLE");
					int reservation = rs.getInt("RESERVATION");
					int guide = rs.getInt("GUIDE");
					float rate = rs.getFloat("rate");
					int dayCount = rs.getInt("DAYCOUNT");
					String schedule = rs.getString("SCHEDULE");
					String picturePath_1 = rs.getString("picture_path_1");
					String picturePath_2 = rs.getString("picture_path_2");
					String picturePath_3 = rs.getString("picture_path_3");
					String hotel = rs.getString("hotel");

					Product pd = new Product(code, airlineNum, areaNum, productName, price, departureDate,
							minimumPeople, maximumPeople, reservation, guide, rate, dayCount, schedule, picturePath_1,
							picturePath_2, picturePath_3, hotel);
					pdList.add(pd);
				}
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				return pdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// ��ǰ �ڵ�� ���ڵ� ��ȸ�ϱ�
	public ArrayList<Product> selectProductByCode(String code) {
		if (code == null || code.isEmpty()) {
			System.out.println(code + " ����");
			return null;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = new ArrayList<>();

			String sql = "select * from product where code = '" + code + "'order by departure_date asc, daycount asc";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String area = rs.getString("area");
					int areaNum = 0;
					for (int i = 0; i < Product.AREA_LIST.length; i++) {
						if(Product.AREA_LIST[i].equals(area)) {
						areaNum = i;
						break;}
					}
					String airline = rs.getString("airline");
					int airlineNum = 0;
					for (int i = 0; i < Product.AIRLINE_LIST.length; i++) {
						if(Product.AIRLINE_LIST[i].equals(airline)) {
						airlineNum = i;
						break;}
					}
					String productName = rs.getString("productname");
					int price = rs.getInt("price");
					Date departureDate = rs.getDate("departure_date");
					int minimumPeople = rs.getInt("MINIMUM_PEOPLE");
					int maximumPeople = rs.getInt("MAXIMUM_PEOPLE");
					int reservation = rs.getInt("RESERVATION");
					int guide = rs.getInt("GUIDE");
					float rate = rs.getFloat("rate");
					int dayCount = rs.getInt("DAYCOUNT");
					String schedule = rs.getString("SCHEDULE");
					String picturePath_1 = rs.getString("picture_path_1");
					String picturePath_2 = rs.getString("picture_path_2");
					String picturePath_3 = rs.getString("picture_path_3");
					String hotel = rs.getString("hotel");

					Product pd = new Product(code, airlineNum, areaNum, productName, price, departureDate,
							minimumPeople, maximumPeople, reservation, guide, rate, dayCount, schedule, picturePath_1,
							picturePath_2, picturePath_3, hotel);
					pdList.add(pd);
				}
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				return pdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// ��ǰ�ڵ�� ��߰��ɳ�¥ ��ȸ�ϱ�
	public ArrayList<Product> selectDepartureDateProductByCode(String code) {
		if (code == null || code.isEmpty()) {
			System.out.println(code + " ����");
			return null;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = new ArrayList<>();

			String sql = "select departure_date from product where code = '" + code + "' order by departure_date asc";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					
					Date departureDate = rs.getDate("departure_date");

					Product pd = new Product(code, departureDate);
					pdList.add(pd);
				}
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				return pdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// ��ǰ�ڵ�, ������ ������ ��ȸ�ϱ�
	public ArrayList<String> selectScheduleProductByCode(String code, int dayCount) {
		if (code == null || code.isEmpty()) {
			System.out.println(code + " ����");
			return null;
		}
		if (this.conn != null) {
			ArrayList<String> pdList = new ArrayList<>();

			String sql = "select schedule from product where code = '" + code + "' and dayCount = "+ dayCount +
					" order by departure_date asc";
			
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					
					String schedule = rs.getString("schedule");

					pdList.add(schedule);
				}
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				return pdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// ��ǰ �ڵ�,��߳�¥�� ���ڵ� ��ȸ�ϱ�
	public ArrayList<Product> selectProductByCodeAndDate(String code, String dPDate) {
		if (code == null || code.isEmpty()) {
			System.out.println(code + " ����");
			return null;
		}
		if (dPDate == null || dPDate.isEmpty()) {
			System.out.println(dPDate + " ����");
			return null;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = new ArrayList<>();

			String sql = "select * from product where code = '" + code + "' and departure_date = '" + dPDate + "'";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String area = rs.getString("area");
					int areaNum = 0;
					for (int i = 0; i < Product.AREA_LIST.length; i++) {
						if(Product.AREA_LIST[i].equals(area)) {
						areaNum = i;
						break;}
					}
					String airline = rs.getString("airline");
					int airlineNum = 0;
					for (int i = 0; i < Product.AIRLINE_LIST.length; i++) {
						if(Product.AIRLINE_LIST[i].equals(airline)) {
						airlineNum = i;
						break;}
					}
					String productName = rs.getString("productname");
					int price = rs.getInt("price");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date departureDate = null;
					try {
						departureDate = sdf.parse(dPDate);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					int minimumPeople = rs.getInt("MINIMUM_PEOPLE");
					int maximumPeople = rs.getInt("MAXIMUM_PEOPLE");
					int reservation = rs.getInt("RESERVATION");
					int guide = rs.getInt("GUIDE");
					float rate = rs.getFloat("rate");
					int dayCount = rs.getInt("DAYCOUNT");
					String schedule = rs.getString("SCHEDULE");
					String picturePath_1 = rs.getString("picture_path_1");
					String picturePath_2 = rs.getString("picture_path_2");
					String picturePath_3 = rs.getString("picture_path_3");
					String hotel = rs.getString("hotel");

					Product pd = new Product(code, airlineNum, areaNum, productName, price, departureDate,
							minimumPeople, maximumPeople, reservation, guide, rate, dayCount, schedule, picturePath_1,
							picturePath_2, picturePath_3, hotel);
					pdList.add(pd);
				}
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				return pdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// ��ǰ �ڵ�� ��߳�¥(String) ��ȸ�ϱ�
	public ArrayList<String> selectDepartureDateByCode(String code) {
		ArrayList<String> DepartureDate = new ArrayList<>();
		ArrayList<String> resultDate = new ArrayList<>();
		if (code == null) {
			System.out.println(code + "�ڵ����");
			return null;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = selectDepartureDateProductByCode(code);
			for (int i = 0; i < pdList.size(); i++) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				DepartureDate.add(sdf.format(pdList.get(i).getDepartureDate()));
				for (int j = 0; j < DepartureDate.size(); j++) {
					if(!resultDate.contains(DepartureDate.get(j))) {
						resultDate.add(DepartureDate.get(j));}
				}
				
			}
			return resultDate;
		}
		return null;
	}
	
	// ��ǰ �ڵ�, ��߳�¥�� ���డ��(int) ��ȸ�ϱ�
	public int selectReservationByCodeAndDPDay(String code, String dPDate) {
			int reservation = 0;
			if (code == null) {
				System.out.println(code + " ����");
				return 3;
			}
			if (this.conn != null) {
				ArrayList<Product> pdList = selectProductByCodeAndDate(code, dPDate);
				reservation = pdList.get(0).getReservation();
				return reservation;
			}
			return 3;
		}
		
		// ��ǰ �ڵ�, ��߳�¥�� ���̵�(int) ��ȸ�ϱ�
	public int selectGuideByCodeAndDPDay(String code, String dPDate) {
		int guide = 0;
		if (code == null) {
			System.out.println(code + " ����");
			return 3;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = selectProductByCodeAndDate(code, dPDate);
			guide = pdList.get(0).getGuide();
			return guide;
		}
		return 3;
	}
	
	// ��ǰ �ڵ�� ��ǰ��(String) ��ȸ�ϱ�
	public String selectProducNameByCode(String code) {
		String productNames = "";
		if (code == null) {
			System.out.println(code + " ����");
			return null;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = selectProductByCode(code);
			productNames = pdList.get(0).getProductName();
			return productNames;
		}
		return null;
	}
	
	// �ڵ�� ��߳�¥, ���డ�ɿ��η��ڵ� ��ȸ�ϱ�
	public ArrayList<Product> selectReservationNameByCode(String code) {
		if (code == null || code.isEmpty()) {
		System.out.println(code + " ����");
		return null;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = new ArrayList<>();
			String sql = "select departure_date, reservation from product where daycount = 1 and "
					+ "code = '"+ code +"' order by departure_date asc";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Date departureDate = rs.getDate("departure_date");
					int reservation = rs.getInt("reservation");
					Product pd = new Product(departureDate, reservation);
					pdList.add(pd);
					}
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				return pdList;
			} catch (SQLException e) {
				e.printStackTrace();
				}
			}

		return null;
	}
		
	// ��ǰ �ڵ�� �������ڵ� ��ȸ�ϱ�
	public Product selectPicturesProductByCode(String code) {
		if (code == null || code.isEmpty()) {
			System.out.println(code + " ����");
			return null;
		}
		if (this.conn != null) {
			Product picture = null;
			String sql = "select picture_path_1, picture_path_2, picture_path_3 from product where code = '" + code + "'  and daycount = 1";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String picturePath_1 = rs.getString("picture_path_1");
					String picturePath_2 = rs.getString("picture_path_2");
					String picturePath_3 = rs.getString("picture_path_3");
					
					picture = new Product(code, picturePath_1, picturePath_2, picturePath_3);
				}
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				return picture;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// ��ǰ �ڵ�� �ּұݾ� ��ȸ�ϱ�
	public int selectMinPriceByCode(String code) {
		int minPrice = 0;
		if (code == null || code.isEmpty()) {
			System.out.println(code + " ����");
			return 0;
		}
		if (this.conn != null) {
			String sql = "select min(price) from product where code = '" + code + "'";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					minPrice = rs.getInt("MIN(PRICE)");
				}
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				return minPrice;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	// ��ǰ �ڵ�� ����(String) ��ȸ�ϱ�
	public ArrayList<String> selectPicturesByCode(String code) {
		ArrayList<String> picturs = new ArrayList<>();
		if (code == null) {
			System.out.println(code + "�ڵ����");
			return null;
		}
		if (this.conn != null) {
			Product pics = selectPicturesProductByCode(code);
			picturs.add(pics.getPicturePath_1());
			picturs.add(pics.getPicturePath_2());
			picturs.add(pics.getPicturePath_3());
			
			return picturs;
		}
		return null;
	}
	
	// ��ǰ �ڵ�� ȣ��(String) ��ȸ�ϱ�
		public ArrayList<String> selectHotelByCode(String code) {
			ArrayList<String> hotels = new ArrayList<>();
			if (code == null) {
				System.out.println(code + "�ڵ����");
				return null;
			}
			if (this.conn != null) {
				ArrayList<Product> hotel = selectProductByCode(code);
				for (int i = 0; i < hotel.size(); i++) {
					hotels.add(hotel.get(i).getHotel());
				}
				return hotels;
			}
			return null;
		}
	
	// ��ǰ �ڵ�, ��߳�¥�� ��ǰ����(int) ��ȸ�ϱ�
	public int selectPriceByCodeAndDate(String code, String dPDate) {
		int adultPrice = 0;
		if (code == null) {
			System.out.println(code + " �ڵ����");
			return 0;
		}
		if (dPDate == null) {
			System.out.println(dPDate + " ��¥����");
			return 0;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = selectProductByCodeAndDate(code, dPDate);
			adultPrice = pdList.get(0).getPrice();
			return adultPrice;
		}
		return 0;
	}
	

	// ��ǰ �ڵ�, ��߳�¥�� �ּ�����ο� ��ȸ�ϱ�
	public int selectMinimumPeopleByCodeAndDate(String code, String dPDate) {
		int adultPrice = 0;
		if (code == null) {
			System.out.println(code + " �ڵ����");
			return 0;
		}
		if (dPDate == null) {
			System.out.println(dPDate + " ��¥����");
			return 0;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = selectProductByCodeAndDate(code, dPDate);
			adultPrice = pdList.get(0).getMinimumPeople();
			return adultPrice;
		}
		return 0;
	}

	// ��ǰ �ڵ�, ��߳�¥�� �ִ뿹���ο� ��ȸ�ϱ�
	public int selectMaximumPeopleByCodeAndDate(String code, String dPDate) {
		int adultPrice = 0;
		if (code == null) {
			System.out.println(code + " �ڵ����");
			return 0;
		}
		if (dPDate == null) {
			System.out.println(dPDate + " ��¥����");
			return 0;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = selectProductByCodeAndDate(code, dPDate);
			adultPrice = pdList.get(0).getMaximumPeople();
			return adultPrice;
		}
		return 0;
	}

	
	// �װ����� ���ڵ� ��ȸ�ϱ�
	public ArrayList<Product> selectProductByAirline(int airlineNum) {
		if (airlineNum < 0 || airlineNum >= Product.AIRLINE_LIST.length) {
			System.out.println(airlineNum + " �װ� ��ȣ ����");
			return null;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = new ArrayList<>();

			String sql = "select * from product where airline = '" + Product.AIRLINE_LIST[airlineNum] + "'";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String code = rs.getString("code");
					String area = rs.getString("area");
					int areaNum = 0;
					for (int i = 0; i < Product.AREA_LIST.length; i++) {
						if(Product.AREA_LIST[i].equals(area)) {
						areaNum = i;
						break;}
					}
					String productName = rs.getString("productname");
					int price = rs.getInt("price");
					Date departureDate = rs.getDate("departure_date");
					int minimumPeople = rs.getInt("MINIMUM_PEOPLE");
					int maximumPeople = rs.getInt("MAXIMUM_PEOPLE");
					int reservation = rs.getInt("RESERVATION");
					int guide = rs.getInt("GUIDE");
					float rate = rs.getFloat("rate");
					int dayCount = rs.getInt("DAYCOUNT");
					String schedule = rs.getString("SCHEDULE");
					String picturePath_1 = rs.getString("picture_path_1");
					String picturePath_2 = rs.getString("picture_path_2");
					String picturePath_3 = rs.getString("picture_path_3");
					String hotel = rs.getString("hotel");

					Product pd = new Product(code, airlineNum, areaNum, productName, price, departureDate,
							minimumPeople, maximumPeople, reservation, guide, rate, dayCount, schedule, picturePath_1,
							picturePath_2, picturePath_3, hotel);
					pdList.add(pd);
				}
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				return pdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// �������� ���ڵ� ��ȸ�ϱ�
	public ArrayList<Product> selectProductByArea(int areaNum) {
		if (areaNum < 0 || areaNum >= Product.AIRLINE_LIST.length) {
			System.out.println(areaNum + " ���� ��ȣ ����");
			return null;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = new ArrayList<>();

			String sql = "select * from product where area = '" + Product.AREA_LIST[areaNum] + "'";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String code = rs.getString("code");
					String airline = rs.getString("airline");
					int airlineNum = 0;
					for (int i = 0; i < Product.AIRLINE_LIST.length; i++) {
						if(Product.AIRLINE_LIST[i].equals(airline)) {
						airlineNum = i;
						break;}
					}
					String productName = rs.getString("productname");
					int price = rs.getInt("price");
					Date departureDate = rs.getDate("departure_date");
					int minimumPeople = rs.getInt("MINIMUM_PEOPLE");
					int maximumPeople = rs.getInt("MAXIMUM_PEOPLE");
					int reservation = rs.getInt("RESERVATION");
					int guide = rs.getInt("GUIDE");
					float rate = rs.getFloat("rate");
					int dayCount = rs.getInt("DAYCOUNT");
					String schedule = rs.getString("SCHEDULE");
					String picturePath_1 = rs.getString("picture_path_1");
					String picturePath_2 = rs.getString("picture_path_2");
					String picturePath_3 = rs.getString("picture_path_3");
					String hotel = rs.getString("hotel");

					Product pd = new Product(code, airlineNum, areaNum, productName, price, departureDate,
							minimumPeople, maximumPeople, reservation, guide, rate, dayCount, schedule, picturePath_1,
							picturePath_2, picturePath_3, hotel);
					pdList.add(pd);
				}
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				return pdList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// ��ǰ �ڵ�� ���õ� ���ڵ� ���� �����ϱ�(�ڵ�� �빮�� �ʼ�)
	public boolean updateRateNameByCode(String code, float rate) {
		if (code == null || code.isEmpty()) {
			System.out.println("�ڵ� ����");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set rate = ? where code = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setFloat(1, rate);
				pstmt.setString(2, code);
				int r = pstmt.executeUpdate();
				System.out.println(r + "���� ���� ���� �Ϸ�");
				return true;
			} catch (SQLException e) {
				System.out.printf("%s �ڵ� ����(%f) ������Ʈ ����! - SQL ����.\n", code, rate);
				e.printStackTrace();
			}
		}
		return false;
		
	}

	// ��ǰ �ڵ�� ���õ� ���ڵ� ��ǰ�� �����ϱ�(�ڵ�� �빮�� �ʼ�)
	public boolean updateProductNameByCode(String code, String productName) {
		if (code == null || code.isEmpty()) {
			System.out.println("�ڵ� ����");
			return false;
		}
		if (productName == null || productName.isEmpty()) {
			System.out.println("��ǰ�� ����");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set productname = ? where code = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, productName);
				pstmt.setString(2, code);
				int r = pstmt.executeUpdate();
				System.out.println(r + "���� ��ǰ�� ���� �Ϸ�");
				return true;
			} catch (SQLException e) {
				System.out.printf("%s �ڵ� ��ǰ��(%s) ������Ʈ ����! - SQL ����.\n", code, productName);
				e.printStackTrace();
			}

		}
		return false;
	}

	// ��ǰ �ڵ�� ���õ� ���ڵ� ���� �����ϱ�(�ڵ�� �빮�� �ʼ�)
	public boolean updatePicturePathByCode(String code, String picturePath_1,
											String picturePath_2,String picturePath_3) {
		if (code == null || code.isEmpty()) {
			System.out.println("�ڵ� ����");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set picture_path_1 = ?, picture_path_2 = ?, picture_path_3 = ? where code = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, picturePath_1);
				pstmt.setString(2, picturePath_2);
				pstmt.setString(3, picturePath_3);
				pstmt.setString(4, code);
				int r = pstmt.executeUpdate();
				System.out.println(r + "���� ���� ���� �Ϸ�");
				return true;
			} catch (SQLException e) {
				System.out.printf("%s �ڵ� ���� ������Ʈ ����! - SQL ����.\n", code);
				e.printStackTrace();
			}

		}
		return false;
	}
	
	// ��ǰ �ڵ�� ȣ�� �����ϱ�(�ڵ�� �빮�� �ʼ�)
		public boolean updateHotelByCode(String code, String hotel, int dayCount) {
			if (code == null || code.isEmpty()) {
				System.out.println("�ڵ� ����");
				return false;
			}
			if (this.conn != null) {
				try {
					String sql = "update product set hotel = ? where code = ? and daycount = ?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, hotel);
					pstmt.setString(2, code);
					pstmt.setInt(3, dayCount);
					int r = pstmt.executeUpdate();
					System.out.println(r + "���� ȣ�� ���� �Ϸ�");
					return true;
				} catch (SQLException e) {
					System.out.printf("%s �ڵ� ȣ�� ������Ʈ ����! - SQL ����.\n", code);
					e.printStackTrace();
				}

			}
			return false;
		}
	
	// ��ǰ �ڵ�, ��¥�� ���õ� ���ڵ� ���� �����ϱ�(�ڵ�� �빮�� �ʼ�, ��¥ yyyy-mm-dd)
	public boolean updatePriceByCodeAndDpDate(String code, String departureDate, int price) {
		if (code == null || code.isEmpty()) {
			System.out.println("�ڵ�� ����");
			return false;
		} else if (departureDate == null) {
			System.out.println("��¥ ����");
			return false;
		} else if (price < 0) {
			System.out.println("��� ����");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set price = " + price + " where code = '" + code + "' "
						+ "and departure_date = '" + departureDate + "'";
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				System.out.println(r + "���� �� ���� �����Ϸ�");
				return true;
			} catch (SQLException e) {
				System.out.println(code + "�ڵ�" + departureDate + "��¥ ���ݼ��� ����! - SQL ����.");
				e.printStackTrace();
			}

		}
		return false;
	}

	// ��ǰ �ڵ�, ��¥�� ���õ� ���ڵ� ���ɿ��� �����ϱ�(�ڵ�� �빮�� �ʼ�, ��¥ yyyy-mm-dd)
	public boolean updateReservationByCodeAndDpDate(String code, String departureDate, int reservation) {
		if (code == null || code.isEmpty()) {
			System.out.println("�ڵ�� ����");
			return false;
		} else if (departureDate == null) {
			System.out.println("��¥ ����");
			return false;
		} else if (reservation < 0 || reservation > 1) {
			System.out.println("���డ�ɿ��� ����");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set reservation = " + reservation + " where code = '" + code + "' "
						+ "and departure_date = '" + departureDate + "'";
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				System.out.println(r + "���� �� ���డ�ɿ��� �����Ϸ�");
				return true;
			} catch (SQLException e) {
				System.out.println(code + "�ڵ�" + reservation + "���డ�ɿ��� ���� ����! - SQL ����.");
				e.printStackTrace();
			}

		}
		return false;
	}

	// ��ǰ �ڵ�, ��¥�� ���õ� ���ڵ� ���̵忩�� �����ϱ�(�ڵ�� �빮�� �ʼ�, ��¥ yyyy-mm-dd)
	public boolean updateGuideByCodeAndDpDate(String code, String departureDate, int guide) {
		if (code == null || code.isEmpty()) {
			System.out.println("�ڵ�� ����");
			return false;
		} else if (departureDate == null) {
			System.out.println("��¥ ����");
			return false;
		} else if (guide < 0 || guide > 1) {
			System.out.println("���̵� ���� ����");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set guide = " + guide + " where code = '" + code + "' "
						+ "and departure_date = '" + departureDate + "'";
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				System.out.println(r + "���� �� ���̵忩�� �����Ϸ�");
				return true;
			} catch (SQLException e) {
				System.out.println(code + "�ڵ�" + guide + "���̵忩�� ���� ����! - SQL ����.");
				e.printStackTrace();
			}

		}
		return false;
	}

	// ��ǰ �ڵ�, ��¥�� ���õ� ���ڵ� �ּ�����ο� �����ϱ�(�ڵ�� �빮�� �ʼ�, ��¥ yyyy-mm-dd)
	public boolean updateMinimumPeopleByCodeAndDpDate(String code, String departureDate, int minimumPeople) {
		if (code == null || code.isEmpty()) {
			System.out.println("�ڵ�� ����");
			return false;
		}
		if (departureDate == null) {
			System.out.println("��¥ ����");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set minimum_people = " + minimumPeople + " where code = '" + code + "' "
						+ "and departure_date = '" + departureDate + "'";
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				System.out.println(r + "���� �� �ּ� ����ο� �����Ϸ�");
				return true;
			} catch (SQLException e) {
				System.out.println(code + "�ڵ�" + minimumPeople + "�ּ�����ο� ���� ����! - SQL ����.");
				e.printStackTrace();
			}

		}
		return false;
	}

	// ��ǰ �ڵ�, ��¥�� ���õ� ���ڵ� �ִ뿹���ο� �����ϱ�(�ڵ�� �빮�� �ʼ�, ��¥ yyyy-mm-dd)
	public boolean updateMaximumPeopleByCodeAndDpDate(String code, String departureDate, int maximumPeople) {
		if (code == null || code.isEmpty()) {
			System.out.println("�ڵ�� ����");
			return false;
		}
		if (departureDate == null) {
			System.out.println("��¥ ����");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set maximum_people = " + maximumPeople + " where code = '" + code + "' "
						+ "and departure_date = '" + departureDate + "'";
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				System.out.println(r + "���� �� �ִ� �����ο� �����Ϸ�");
				return true;
			} catch (SQLException e) {
				System.out.println(code + "�ڵ�" + maximumPeople + "�ִ뿹���ο� ���� ����! - SQL ����.");
				e.printStackTrace();
			}

		}
		return false;
	}

	// ��ǰ �ڵ�� ���õ� ���ڵ� ������ �����ϱ�(�ڵ�� �빮�� �ʼ�, ��¥ yyyy-mm-dd)
	public boolean updateScheduleByCodeAndDpDate(String code, int dayCount, String schedule) {
		if (code == null || code.isEmpty()) {
			System.out.println("�ڵ�� ����");
			return false;
		} else if (schedule == null) {
			System.out.println("���� ����");
			return false;
		} else if (dayCount < 0 || dayCount > 5) {
			System.out.println("���� ����");
			return false;
		}
		if (this.conn != null) {
			try {
				if( schedule.contains("'") ) {
					schedule = schedule.replace("'", "''");
				}
				
				String sql = "update product set schedule = '" + schedule + "' where code = '" + code + "' "
						+" and daycount = " + dayCount;
				System.out.println(sql);
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				System.out.println(r + "���� �� ���� �����Ϸ�");
//				String sql = "update product set schedule = ? where code = ? and daycount = ?";
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, schedule);
//				pstmt.setString(2, code);
//				pstmt.setInt(3, dayCount);
//				int r = pstmt.executeUpdate();
//				System.out.println(r + "���� �� ���� �����Ϸ�");
				return true;
			} catch (SQLException e) {
				System.out.println(code + "�ڵ�" + dayCount + "���� ���� ���� ����! - SQL ����.");
				e.printStackTrace();
			}

		}
		return false;
	}

}

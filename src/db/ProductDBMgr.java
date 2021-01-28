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

	public Connection conn; // DBMS 서버와 접속하는 통로 객체
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

//		pdm.updateProductNameByCode("SVJ", "호치민을 VJ로");
//		
//		pdm.updatePriceByCodeAndDpDate("HKE", "2021-05-05", 399000);
//		
//		pdm.updateReservationByCodeAndDpDate("HKE", "2021-05-05", 1);

//		pdm.updateGuideByCodeAndDpDate("HKE", "2021-05-05", 0);

//		pdm.updateMinimumPeopleByCodeAndDpDate("HKE", "2021-05-05", 8);

//		pdm.updateMaximumPeopleByCodeAndDpDate("HKE", "2021-05-05", 20);

//		pdm.updateScheduleByCodeAndDpDate("HKE", "2021-05-05", 1, "호텔에서 휴식");

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

	// 생성자에서 통신을 연결
	public ProductDBMgr() {
		beginConnection();
	}

	// 통신 연결 셋업
	public void beginConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println("Oracle 드라이버 로드 실패!!! ");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패!!");
			e.printStackTrace();
		}
	}

	public void endConnection() {
		try {
			conn.close();
			System.out.println("DB 종료 성공!");
		} catch (SQLException e) {
			System.out.println("DB 종료 실패!");
			e.printStackTrace();
		}
	}

	// 신규 상품 레코드에 추가하기(날짜 입력시 yyyy-mm-dd)
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
				if (r == 1) { // 1개 레코드 추가 성공
					System.out.println("code 레코드 추가 성공 - " + code);
					return true;
				} else {
					System.out.println("code 레코드 추가 실패 - " + code);
				}
			} catch (SQLException e) {
				System.out.println(code + " 내용의 레코드 추가 실패! - SQL 예외.");
				e.printStackTrace();
			}

		}
		return false;
	}

	// 동일상품 일차별 추가하기(신규상품 메소드 필요)(날짜 입력시 yyyy-mm-dd)
	public void sameProductAddDayCount(String code, int airlineNum, int areaNum, String productName, int price, String departureDate,
			int minimumPeople, int maximumPeople) {
		ProductDBMgr pdm = new ProductDBMgr();
		for (int i = 1; i <= Product.getMaxDaycount(); i++) {
			pdm.insertNewProduct(code, airlineNum, areaNum, productName, price, departureDate, minimumPeople, maximumPeople, i);
		}
	}

	// 동일 상품 월별 세팅(날짜 입력시 yyyymm)
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
//			System.out.println("입력된 month 오류!" + month);
//		}
//
//	}

	// 상품 전체 레코드 조회하기
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

	// 평점순으로 레코드 조회하기
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

	// 상품 코드로 레코드 조회하기
	public ArrayList<Product> selectProductByCode(String code) {
		if (code == null || code.isEmpty()) {
			System.out.println(code + " 오류");
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
	
	// 상품코드로 출발가능날짜 조회하기
	public ArrayList<Product> selectDepartureDateProductByCode(String code) {
		if (code == null || code.isEmpty()) {
			System.out.println(code + " 오류");
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
	
	// 상품코드, 일차로 스케줄 조회하기
	public ArrayList<String> selectScheduleProductByCode(String code, int dayCount) {
		if (code == null || code.isEmpty()) {
			System.out.println(code + " 오류");
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

	// 상품 코드,출발날짜로 레코드 조회하기
	public ArrayList<Product> selectProductByCodeAndDate(String code, String dPDate) {
		if (code == null || code.isEmpty()) {
			System.out.println(code + " 오류");
			return null;
		}
		if (dPDate == null || dPDate.isEmpty()) {
			System.out.println(dPDate + " 오류");
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

	// 상품 코드로 출발날짜(String) 조회하기
	public ArrayList<String> selectDepartureDateByCode(String code) {
		ArrayList<String> DepartureDate = new ArrayList<>();
		ArrayList<String> resultDate = new ArrayList<>();
		if (code == null) {
			System.out.println(code + "코드오류");
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
	
	// 상품 코드, 출발날짜로 예약가능(int) 조회하기
	public int selectReservationByCodeAndDPDay(String code, String dPDate) {
			int reservation = 0;
			if (code == null) {
				System.out.println(code + " 오류");
				return 3;
			}
			if (this.conn != null) {
				ArrayList<Product> pdList = selectProductByCodeAndDate(code, dPDate);
				reservation = pdList.get(0).getReservation();
				return reservation;
			}
			return 3;
		}
		
		// 상품 코드, 출발날짜로 가이드(int) 조회하기
	public int selectGuideByCodeAndDPDay(String code, String dPDate) {
		int guide = 0;
		if (code == null) {
			System.out.println(code + " 오류");
			return 3;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = selectProductByCodeAndDate(code, dPDate);
			guide = pdList.get(0).getGuide();
			return guide;
		}
		return 3;
	}
	
	// 상품 코드로 상품명(String) 조회하기
	public String selectProducNameByCode(String code) {
		String productNames = "";
		if (code == null) {
			System.out.println(code + " 오류");
			return null;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = selectProductByCode(code);
			productNames = pdList.get(0).getProductName();
			return productNames;
		}
		return null;
	}
	
	// 코드로 출발날짜, 예약가능여부레코드 조회하기
	public ArrayList<Product> selectReservationNameByCode(String code) {
		if (code == null || code.isEmpty()) {
		System.out.println(code + " 오류");
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
		
	// 상품 코드로 사진레코드 조회하기
	public Product selectPicturesProductByCode(String code) {
		if (code == null || code.isEmpty()) {
			System.out.println(code + " 오류");
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
	
	// 상품 코드로 최소금액 조회하기
	public int selectMinPriceByCode(String code) {
		int minPrice = 0;
		if (code == null || code.isEmpty()) {
			System.out.println(code + " 오류");
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
	
	// 상품 코드로 사진(String) 조회하기
	public ArrayList<String> selectPicturesByCode(String code) {
		ArrayList<String> picturs = new ArrayList<>();
		if (code == null) {
			System.out.println(code + "코드오류");
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
	
	// 상품 코드로 호텔(String) 조회하기
		public ArrayList<String> selectHotelByCode(String code) {
			ArrayList<String> hotels = new ArrayList<>();
			if (code == null) {
				System.out.println(code + "코드오류");
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
	
	// 상품 코드, 출발날짜로 상품가격(int) 조회하기
	public int selectPriceByCodeAndDate(String code, String dPDate) {
		int adultPrice = 0;
		if (code == null) {
			System.out.println(code + " 코드오류");
			return 0;
		}
		if (dPDate == null) {
			System.out.println(dPDate + " 날짜오류");
			return 0;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = selectProductByCodeAndDate(code, dPDate);
			adultPrice = pdList.get(0).getPrice();
			return adultPrice;
		}
		return 0;
	}
	

	// 상품 코드, 출발날짜로 최소출발인원 조회하기
	public int selectMinimumPeopleByCodeAndDate(String code, String dPDate) {
		int adultPrice = 0;
		if (code == null) {
			System.out.println(code + " 코드오류");
			return 0;
		}
		if (dPDate == null) {
			System.out.println(dPDate + " 날짜오류");
			return 0;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = selectProductByCodeAndDate(code, dPDate);
			adultPrice = pdList.get(0).getMinimumPeople();
			return adultPrice;
		}
		return 0;
	}

	// 상품 코드, 출발날짜로 최대예약인원 조회하기
	public int selectMaximumPeopleByCodeAndDate(String code, String dPDate) {
		int adultPrice = 0;
		if (code == null) {
			System.out.println(code + " 코드오류");
			return 0;
		}
		if (dPDate == null) {
			System.out.println(dPDate + " 날짜오류");
			return 0;
		}
		if (this.conn != null) {
			ArrayList<Product> pdList = selectProductByCodeAndDate(code, dPDate);
			adultPrice = pdList.get(0).getMaximumPeople();
			return adultPrice;
		}
		return 0;
	}

	
	// 항공으로 레코드 조회하기
	public ArrayList<Product> selectProductByAirline(int airlineNum) {
		if (airlineNum < 0 || airlineNum >= Product.AIRLINE_LIST.length) {
			System.out.println(airlineNum + " 항공 번호 오류");
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

	// 지역으로 레코드 조회하기
	public ArrayList<Product> selectProductByArea(int areaNum) {
		if (areaNum < 0 || areaNum >= Product.AIRLINE_LIST.length) {
			System.out.println(areaNum + " 지역 번호 오류");
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

	// 상품 코드로 선택된 레코드 평점 수정하기(코드명 대문자 필수)
	public boolean updateRateNameByCode(String code, float rate) {
		if (code == null || code.isEmpty()) {
			System.out.println("코드 오류");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set rate = ? where code = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setFloat(1, rate);
				pstmt.setString(2, code);
				int r = pstmt.executeUpdate();
				System.out.println(r + "개의 평점 수정 완료");
				return true;
			} catch (SQLException e) {
				System.out.printf("%s 코드 평점(%f) 업데이트 실패! - SQL 예외.\n", code, rate);
				e.printStackTrace();
			}
		}
		return false;
		
	}

	// 상품 코드로 선택된 레코드 상품명 수정하기(코드명 대문자 필수)
	public boolean updateProductNameByCode(String code, String productName) {
		if (code == null || code.isEmpty()) {
			System.out.println("코드 오류");
			return false;
		}
		if (productName == null || productName.isEmpty()) {
			System.out.println("상품명 오류");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set productname = ? where code = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, productName);
				pstmt.setString(2, code);
				int r = pstmt.executeUpdate();
				System.out.println(r + "개의 상품명 수정 완료");
				return true;
			} catch (SQLException e) {
				System.out.printf("%s 코드 상품명(%s) 업데이트 실패! - SQL 예외.\n", code, productName);
				e.printStackTrace();
			}

		}
		return false;
	}

	// 상품 코드로 선택된 레코드 사진 수정하기(코드명 대문자 필수)
	public boolean updatePicturePathByCode(String code, String picturePath_1,
											String picturePath_2,String picturePath_3) {
		if (code == null || code.isEmpty()) {
			System.out.println("코드 오류");
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
				System.out.println(r + "개의 사진 수정 완료");
				return true;
			} catch (SQLException e) {
				System.out.printf("%s 코드 사진 업데이트 실패! - SQL 예외.\n", code);
				e.printStackTrace();
			}

		}
		return false;
	}
	
	// 상품 코드로 호텔 수정하기(코드명 대문자 필수)
		public boolean updateHotelByCode(String code, String hotel, int dayCount) {
			if (code == null || code.isEmpty()) {
				System.out.println("코드 오류");
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
					System.out.println(r + "개의 호텔 수정 완료");
					return true;
				} catch (SQLException e) {
					System.out.printf("%s 코드 호텔 업데이트 실패! - SQL 예외.\n", code);
					e.printStackTrace();
				}

			}
			return false;
		}
	
	// 상품 코드, 날짜로 선택된 레코드 가격 수정하기(코드명 대문자 필수, 날짜 yyyy-mm-dd)
	public boolean updatePriceByCodeAndDpDate(String code, String departureDate, int price) {
		if (code == null || code.isEmpty()) {
			System.out.println("코드명 오류");
			return false;
		} else if (departureDate == null) {
			System.out.println("날짜 오류");
			return false;
		} else if (price < 0) {
			System.out.println("요금 오류");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set price = " + price + " where code = '" + code + "' "
						+ "and departure_date = '" + departureDate + "'";
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				System.out.println(r + "개의 행 가격 수정완료");
				return true;
			} catch (SQLException e) {
				System.out.println(code + "코드" + departureDate + "날짜 가격수정 실패! - SQL 예외.");
				e.printStackTrace();
			}

		}
		return false;
	}

	// 상품 코드, 날짜로 선택된 레코드 가능여부 수정하기(코드명 대문자 필수, 날짜 yyyy-mm-dd)
	public boolean updateReservationByCodeAndDpDate(String code, String departureDate, int reservation) {
		if (code == null || code.isEmpty()) {
			System.out.println("코드명 오류");
			return false;
		} else if (departureDate == null) {
			System.out.println("날짜 오류");
			return false;
		} else if (reservation < 0 || reservation > 1) {
			System.out.println("예약가능여부 오류");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set reservation = " + reservation + " where code = '" + code + "' "
						+ "and departure_date = '" + departureDate + "'";
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				System.out.println(r + "개의 행 예약가능여부 수정완료");
				return true;
			} catch (SQLException e) {
				System.out.println(code + "코드" + reservation + "예약가능여부 수정 실패! - SQL 예외.");
				e.printStackTrace();
			}

		}
		return false;
	}

	// 상품 코드, 날짜로 선택된 레코드 가이드여부 수정하기(코드명 대문자 필수, 날짜 yyyy-mm-dd)
	public boolean updateGuideByCodeAndDpDate(String code, String departureDate, int guide) {
		if (code == null || code.isEmpty()) {
			System.out.println("코드명 오류");
			return false;
		} else if (departureDate == null) {
			System.out.println("날짜 오류");
			return false;
		} else if (guide < 0 || guide > 1) {
			System.out.println("가이드 여부 오류");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set guide = " + guide + " where code = '" + code + "' "
						+ "and departure_date = '" + departureDate + "'";
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				System.out.println(r + "개의 행 가이드여부 수정완료");
				return true;
			} catch (SQLException e) {
				System.out.println(code + "코드" + guide + "가이드여부 수정 실패! - SQL 예외.");
				e.printStackTrace();
			}

		}
		return false;
	}

	// 상품 코드, 날짜로 선택된 레코드 최소출발인원 수정하기(코드명 대문자 필수, 날짜 yyyy-mm-dd)
	public boolean updateMinimumPeopleByCodeAndDpDate(String code, String departureDate, int minimumPeople) {
		if (code == null || code.isEmpty()) {
			System.out.println("코드명 오류");
			return false;
		}
		if (departureDate == null) {
			System.out.println("날짜 오류");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set minimum_people = " + minimumPeople + " where code = '" + code + "' "
						+ "and departure_date = '" + departureDate + "'";
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				System.out.println(r + "개의 행 최소 출발인원 수정완료");
				return true;
			} catch (SQLException e) {
				System.out.println(code + "코드" + minimumPeople + "최소출발인원 수정 실패! - SQL 예외.");
				e.printStackTrace();
			}

		}
		return false;
	}

	// 상품 코드, 날짜로 선택된 레코드 최대예약인원 수정하기(코드명 대문자 필수, 날짜 yyyy-mm-dd)
	public boolean updateMaximumPeopleByCodeAndDpDate(String code, String departureDate, int maximumPeople) {
		if (code == null || code.isEmpty()) {
			System.out.println("코드명 오류");
			return false;
		}
		if (departureDate == null) {
			System.out.println("날짜 오류");
			return false;
		}
		if (this.conn != null) {
			try {
				String sql = "update product set maximum_people = " + maximumPeople + " where code = '" + code + "' "
						+ "and departure_date = '" + departureDate + "'";
				Statement stmt = conn.createStatement();
				int r = stmt.executeUpdate(sql);
				System.out.println(r + "개의 행 최대 예약인원 수정완료");
				return true;
			} catch (SQLException e) {
				System.out.println(code + "코드" + maximumPeople + "최대예약인원 수정 실패! - SQL 예외.");
				e.printStackTrace();
			}

		}
		return false;
	}

	// 상품 코드로 선택된 레코드 스케줄 수정하기(코드명 대문자 필수, 날짜 yyyy-mm-dd)
	public boolean updateScheduleByCodeAndDpDate(String code, int dayCount, String schedule) {
		if (code == null || code.isEmpty()) {
			System.out.println("코드명 오류");
			return false;
		} else if (schedule == null) {
			System.out.println("일정 오류");
			return false;
		} else if (dayCount < 0 || dayCount > 5) {
			System.out.println("일차 오류");
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
				System.out.println(r + "개의 행 일정 수정완료");
//				String sql = "update product set schedule = ? where code = ? and daycount = ?";
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, schedule);
//				pstmt.setString(2, code);
//				pstmt.setInt(3, dayCount);
//				int r = pstmt.executeUpdate();
//				System.out.println(r + "개의 행 일정 수정완료");
				return true;
			} catch (SQLException e) {
				System.out.println(code + "코드" + dayCount + "일차 일정 수정 실패! - SQL 예외.");
				e.printStackTrace();
			}

		}
		return false;
	}

}

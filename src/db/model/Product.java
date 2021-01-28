package db.model;

import java.util.Arrays;
import java.util.Date;

public class Product {
	private String code; //��ǰ�ڵ�
	private int price; // ����
	private Date departureDate; // �����
	private int minimumPeople; // �ּ�����ο�
	private int maximumPeople; // �ִ뿹���ο�
	private int reservation; // ���� ���ɿ��� 0 �Ұ���, 1����
	private float rate; // ����
	private int guide; // ���̵����� 0 ����, 1 ����
	private String airline; // �װ���
	private String area; // ����
	private String productName; // ��ǰ��
	private int dayCount; // ����
	private String schedule; // ����ǥ
	private String picturePath_1; // �������
	private String picturePath_2; // �������
	private String picturePath_3; // �������
	private String hotel;
	
	public static final int DAD = 0; // �ٳ� �װ��ڵ�
	public static final int HAN = 1; // �ϳ��� �װ��ڵ�
	public static final int SGN = 2; // ȣġ�� �װ��ڵ�
	
	public static final int KE = 0; // �����װ� �װ��ڵ�
	public static final int OZ = 1; // �ƽþƳ� �װ��ڵ�
	public static final int VJ = 2; // ���� �װ��ڵ�
	
	private static final int MAX_DAYCOUNT = 5;
	
	public static final String[] CODE_LIST = {"DKE", "DOZ", "DVJ",
											  "HKE", "HOZ", "HVJ",
											  "SKE", "SOZ", "SVJ",};
	public static final String[] AREA_LIST = {"�ٳ�", "�ϳ���", "ȣġ��"};
	public static final String[] AIRLINE_LIST = {"�����װ�", "�ƽþƳ�", "����"};
	
	public Product() {}
	
	public Product(String code, String picturePath_1, String picturePath_2, String picturePath_3) {
		super();
		this.code = code;
		this.picturePath_1 = picturePath_1;
		this.picturePath_2 = picturePath_2;
		this.picturePath_3 = picturePath_3;
	}

	public Product(String code, Date departureDate) {
		super();
		this.code = code;
		this.departureDate = departureDate;
	}
		
	public Product(Date departureDate, int reservation) {
		super();
		this.departureDate = departureDate;
		this.reservation = reservation;
	}

	public Product(String code, Date departureDate, int reservation) {
		super();
		this.code = code;
		this.departureDate = departureDate;
		this.reservation = reservation;
	}

	public Product(String code, int price) {
		super();
		this.code = code;
		this.price = price;
	}

	public Product(String code, int airlineNum, int areaNum, 
			int price, Date departureDate, int minimumPeople, int maximumPeople, int dayCount) {
		this(code, airlineNum, areaNum, "", price, departureDate, 
				minimumPeople, maximumPeople, 0, 1, 0.0f, dayCount, "", "", "", "", "");
	}	
		
	public Product(String code, int airlineNum, int areaNum, String productName, 
			int price, Date departureDate, int minimumPeople, int maximumPeople, int reservation,
			int guide, float rate, int dayCount, String schedule) {
		this(code, airlineNum, areaNum, productName, price, departureDate, 
				minimumPeople, maximumPeople, reservation, guide, rate, dayCount, schedule, "", "", "", "");
	}
	
	public Product(String code, int airlineNum, int areaNum, String productName, 
			int price, Date departureDate, int minimumPeople, int maximumPeople, int reservation,
			int guide, float rate, int dayCount, String schedule, 
			String picturePath_1, String picturePath_2, String picturePath_3, String hotel) {
		super();
		this.code = code;
		this.airline = AIRLINE_LIST[airlineNum];
		this.area = AREA_LIST[areaNum];
		this.productName = productName;
		this.price = price;
		this.departureDate = departureDate;
		this.minimumPeople = minimumPeople;
		this.maximumPeople = maximumPeople;
		this.reservation = reservation;
		this.guide = guide;
		this.rate = rate;
		this.dayCount = dayCount;
		this.schedule = schedule;
		this.picturePath_1 = picturePath_1;
		this.picturePath_2 = picturePath_2;
		this.picturePath_3 = picturePath_3;
		this.hotel = hotel;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public int getMinimumPeople() {
		return minimumPeople;
	}

	public void setMinimumPeople(int minimumPeople) {
		this.minimumPeople = minimumPeople;
	}

	public int getMaximumPeople() {
		return maximumPeople;
	}

	public void setMaximumPeople(int maximumPeople) {
		this.maximumPeople = maximumPeople;
	}

	public int getReservation() {
		return reservation;
	}

	public void setReservation(int reservation) {
		this.reservation = reservation;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getGuide() {
		return guide;
	}

	public void setGuide(int guide) {
		this.guide = guide;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getDayCount() {
		return dayCount;
	}

	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	public static int getMaxDaycount() {
		return MAX_DAYCOUNT;
	}
	
	public String getPicturePath_1() {
		return picturePath_1;
	}

	public void setPicturePath_1(String picturePath_1) {
		this.picturePath_1 = picturePath_1;
	}

	public String getPicturePath_2() {
		return picturePath_2;
	}

	public void setPicturePath_2(String picturePath_2) {
		this.picturePath_2 = picturePath_2;
	}

	public String getPicturePath_3() {
		return picturePath_3;
	}

	public void setPicturePath_3(String picturePath_3) {
		this.picturePath_3 = picturePath_3;
	}
	
	

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", price=" + price + ", departureDate=" + departureDate + ", minimumPeople="
				+ minimumPeople + ", maximumPeople=" + maximumPeople + ", reservation=" + reservation + ", rate=" + rate
				+ ", guide=" + guide + ", airline=" + airline + ", area=" + area + ", productName=" + productName
				+ ", dayCount=" + dayCount + ", schedule=" + schedule + "]";
	}

	
	
	
}



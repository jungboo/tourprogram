package db.model;

import java.util.Date;

public class Admin {
	
	private String code;
	private Date reservDay;
	private Date startDay;
	private String name;
	private int peoples;
	private String cellPhone;
	private int callCheck;

	
	public Admin() {
		
	}
	
	public Admin(String code, Date reservDay, Date startDay, String name, int peoples, String cellPhone) {
		this(code, reservDay, startDay, name, peoples, cellPhone, 0);
	}

	public Admin(String code, Date reservDay, Date startDay, String name, int peoples, String cellPhone,
			int callCheck) {
		super();
		this.code = code;
		this.reservDay = reservDay;
		this.startDay = startDay;
		this.name = name;
		this.peoples = peoples;
		this.cellPhone = cellPhone;
		this.callCheck = callCheck;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Date getReservDay() {
		return reservDay;
	}


	public void setReservDay(Date reservDay) {
		this.reservDay = reservDay;
	}


	public Date getStartDay() {
		return startDay;
	}


	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPeoples() {
		return peoples;
	}


	public void setPeoples(int peoples) {
		this.peoples = peoples;
	}


	public String getCellPhone() {
		return cellPhone;
	}


	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}


	public int getCallCheck() {
		return callCheck;
	}


	public void setCallCheck(int callCheck) {
		this.callCheck = callCheck;
	}


	@Override
	public String toString() {
		return "Admin [code=" + code + ", reservDay=" + reservDay + ", startDay=" + startDay + ", name=" + name
				+ ", peoples=" + peoples + ", cellPhone=" + cellPhone + ", callCheck=" + callCheck + "]";
	}
	
	
	
	
	
}
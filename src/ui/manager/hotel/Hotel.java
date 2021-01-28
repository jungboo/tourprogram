package ui.manager.hotel;

import java.util.Date;

public class Hotel {
	
	public static final String DEF_SCHEDULE = "1night";
	
	private String name;
	private String city;
	private Date checkin;
	private Date checkout;
	private String schedule;
	
	public Hotel() {}

	public Hotel(String name, String city, Date checkin, Date checkout) {
		this(name, city, checkin, checkout, DEF_SCHEDULE);
	}
	
	public Hotel(String name, String city, Date checkin, Date checkout, String schedule) {
		super();
		this.name = name;
		this.city = city;
		this.checkin = checkin;
		this.checkout = checkout;
		this.schedule = schedule;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return  name + "/" + city + "\n" + "checkin= " + checkin + ", checkout= " + checkout
				+ ", schedule= " + schedule;
	}
	
	
}

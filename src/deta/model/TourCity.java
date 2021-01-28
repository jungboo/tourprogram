package deta.model;

public class TourCity {
	public static final String DEF_SCHEDULE = "1night";
	public static final String DEF_VEHICLE = "bus";
	
	private String name;
	private String schedule;
	private String representativeTourism;
	private String vehicle;
	
	public TourCity() {}

	public TourCity(String name, String representativeTourism) {
		this(name, DEF_SCHEDULE, representativeTourism, DEF_VEHICLE);
	}
	
	public TourCity(String name, String schedule, String representativeTourism, String vehicle) {
		super();
		this.name = name;
		this.schedule = schedule;
		this.representativeTourism = representativeTourism;
		this.vehicle = vehicle;
	}
	
	@Override
	public String toString() {
		return name + ", " + schedule + ", 대표 관광지: " + representativeTourism
				+ ", 이동수단: " + vehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getRepresentativeTourism() {
		return representativeTourism;
	}

	public void setRepresentativeTourism(String representativeTourism) {
		representativeTourism = representativeTourism;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	
	
	
}

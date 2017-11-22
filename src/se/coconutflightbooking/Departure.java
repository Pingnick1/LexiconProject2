package se.coconutflightbooking;

public class Departure {
	private String departureID;
	private AirPlane airPlane;
	private Integer firstClassTicketPrice;
	private Integer economyClassTicketPrice;
	
	public Departure(String departureID, AirPlane airPlane, Integer firstClassTicketPrice,
			Integer economyClassTicketPrice) {
		super();
		this.departureID = departureID;
		this.airPlane = airPlane;
		this.firstClassTicketPrice = firstClassTicketPrice;
		this.economyClassTicketPrice = economyClassTicketPrice;
	}

	public String getDepartureID() {
		return departureID;
	}

	public void setDepartureID(String departureID) {
		this.departureID = departureID;
	}

	public AirPlane getAirPlaneBoundToDeparture() {
		return this.airPlane;
	}

	public void setAirPlaneToDeparture(AirPlane airPlane) {
		this.airPlane = airPlane;
	}

	public Integer getFirstClassTicketPrice() {
		return firstClassTicketPrice;
	}

	public void setFirstClassTicketPrice(Integer firstClassTicketPrice) {
		this.firstClassTicketPrice = firstClassTicketPrice;
	}

	public Integer getEconomyClassTicketPrice() {
		return economyClassTicketPrice;
	}

	public void setEconomyClassTicketPrice(Integer economyClassTicketPrice) {
		this.economyClassTicketPrice = economyClassTicketPrice;
	}

	@Override
	public String toString() {
		return "Departure [departureID=" + departureID + ", airPlane=" + airPlane + ", firstClassTicketPrice="
				+ firstClassTicketPrice + ", economyClassTicketPrice=" + economyClassTicketPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departureID == null) ? 0 : departureID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Departure other = (Departure) obj;
		if (departureID == null) {
			if (other.departureID != null) {
				return false;
			}
		} else if (!departureID.equals(other.departureID)) {
			return false;
		}
		return true;
	}
	
	
}

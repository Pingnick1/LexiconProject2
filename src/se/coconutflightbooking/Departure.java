package se.coconutflightbooking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Departure {
	private String departureID;
	private String destinationName;
	private LocalDateTime departureDateTime;
	private AirPlane airPlane;
	private Integer firstClassTicketPrice;
	private Integer economyClassTicketPrice;
	//String str = "1986-04-08 12:30";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE

	public Departure(String departureID, LocalDateTime departureDateTime, String destination, AirPlane airPlane, Integer firstClassTicketPrice, Integer economyClassTicketPrice) {
		super();
		this.departureID = departureID;
		this.destinationName = destination;
		this.departureDateTime = departureDateTime;
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




	public String getDestinationName() {
		return destinationName;
	}




	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}




	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}




	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
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
		return "DepartureID: "+ departureID + ", Date: " + this.departureDateTime.toString() + " Destination: " + this.destinationName + ", AirPlane: " + airPlane + ", firstClassTicketPrice="
				+ firstClassTicketPrice + ", economyClassTicketPrice=" + economyClassTicketPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departureDateTime == null) ? 0 : departureDateTime.hashCode());
		result = prime * result + ((departureID == null) ? 0 : departureID.hashCode());
		result = prime * result + ((destinationName == null) ? 0 : destinationName.hashCode());
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
		if (departureDateTime == null) {
			if (other.departureDateTime != null) {
				return false;
			}
		} else if (!departureDateTime.equals(other.departureDateTime)) {
			return false;
		}
		if (departureID == null) {
			if (other.departureID != null) {
				return false;
			}
		} else if (!departureID.equals(other.departureID)) {
			return false;
		}
		if (destinationName == null) {
			if (other.destinationName != null) {
				return false;
			}
		} else if (!destinationName.equals(other.destinationName)) {
			return false;
		}
		return true;
	}



	
	
	
}

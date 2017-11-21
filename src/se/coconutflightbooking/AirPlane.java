package se.coconutflightbooking;

public class AirPlane {
	String airPlaneID;
	Integer nrOfEconomcSeats=5;
	Integer nrOfFirstClass=5;
	AirPlaneStatus airPlaneStatus;
	
	
	public AirPlane(String airPlaneID, Integer nrOfEconomcSeats, Integer nrOfFirstClass, AirPlaneStatus airPlaneStatus) {
		super();
		this.airPlaneID = airPlaneID;
		this.nrOfEconomcSeats = nrOfEconomcSeats;
		this.nrOfFirstClass = nrOfFirstClass;
		this.airPlaneStatus = airPlaneStatus;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TESt mer
	}



	public String getAirPlaneID() {
		return airPlaneID;
	}



	public void setAirPlaneID(String airPlaneID) {
		this.airPlaneID = airPlaneID;
	}



	public Integer getNrOfEconomcSeats() {
		return nrOfEconomcSeats;
	}



	public void setNrOfEconomcSeats(Integer nrOfEconomcSeats) {
		this.nrOfEconomcSeats = nrOfEconomcSeats;
	}



	public Integer getNrOfFirstClass() {
		return nrOfFirstClass;
	}



	public void setNrOfFirstClass(Integer nrOfFirstClass) {
		this.nrOfFirstClass = nrOfFirstClass;
	}


	public AirPlaneStatus getAirPlaneStatus() {
		return airPlaneStatus;
	}



	public void setAirPlaneStatus(AirPlaneStatus airPlaneStatus) {
		this.airPlaneStatus = airPlaneStatus;
	}



	@Override
	public String toString() {
		return "AirPlane [airPlaneID=" + airPlaneID + ", nrOfEconomcSeats=" + nrOfEconomcSeats + ", nrOfFirstClass="
				+ nrOfFirstClass + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airPlaneID == null) ? 0 : airPlaneID.hashCode());
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
		AirPlane other = (AirPlane) obj;
		if (airPlaneID == null) {
			if (other.airPlaneID != null) {
				return false;
			}
		} else if (!airPlaneID.equals(other.airPlaneID)) {
			return false;
		}
		return true;
	}
	
	

}
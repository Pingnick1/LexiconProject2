package se.coconutflightbooking;

public class AirPlane {
	String airPlaneID;
	String name;
	Integer nrOfEconomcSeats=5;
	Integer nrOfFirstClass=5;
	AirPlaneStatus airPlaneStatus;
	
	
	public AirPlane(String airPlaneID, Integer nrOfEconomcSeats, Integer nrOfFirstClass, AirPlaneStatus airPlaneStatus) {
		super();
		this.airPlaneID = airPlaneID;
		this.name = "NoName";
		this.nrOfEconomcSeats = nrOfEconomcSeats;
		this.nrOfFirstClass = nrOfFirstClass;
		this.airPlaneStatus = airPlaneStatus;
	}

	public AirPlane(String airPlaneID, String name, Integer nrOfEconomcSeats, Integer nrOfFirstClass, AirPlaneStatus airPlaneStatus) {
		super();
		this.airPlaneID = airPlaneID;
		this.name = name;
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



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airPlaneID == null) ? 0 : airPlaneID.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nrOfEconomcSeats == null) ? 0 : nrOfEconomcSeats.hashCode());
		result = prime * result + ((nrOfFirstClass == null) ? 0 : nrOfFirstClass.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirPlane other = (AirPlane) obj;
		if (airPlaneID == null) {
			if (other.airPlaneID != null)
				return false;
		} else if (!airPlaneID.equals(other.airPlaneID))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nrOfEconomcSeats == null) {
			if (other.nrOfEconomcSeats != null)
				return false;
		} else if (!nrOfEconomcSeats.equals(other.nrOfEconomcSeats))
			return false;
		if (nrOfFirstClass == null) {
			if (other.nrOfFirstClass != null)
				return false;
		} else if (!nrOfFirstClass.equals(other.nrOfFirstClass))
			return false;
		return true;
	}



	
	
	

}
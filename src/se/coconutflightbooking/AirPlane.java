package se.coconutflightbooking;

public class AirPlane {
	String airPlaneID;
	Integer nrOfEconomcSeats=5;
	Integer nrOfFirstClass=5;
	
	
	
	public AirPlane(String airPlaneID, Integer nrOfEconomcSeats, Integer nrOfFirstClass) {
		super();
		this.airPlaneID = airPlaneID;
		this.nrOfEconomcSeats = nrOfEconomcSeats;
		this.nrOfFirstClass = nrOfFirstClass;
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



	@Override
	public String toString() {
		return "AirPlane [airPlaneID=" + airPlaneID + ", nrOfEconomcSeats=" + nrOfEconomcSeats + ", nrOfFirstClass="
				+ nrOfFirstClass + "]";
	}
	
	

}
package se.coconutflightbooking;

import java.util.ArrayList;
import java.util.List;

public class AirPlaneListHandler {
	List<AirPlane> ourAirPlaneList = new ArrayList<AirPlane>();

	public List<AirPlane> getOurAirPlaneList() {
		return ourAirPlaneList;
	}

	public void setOurAirPlaneList(List<AirPlane> ourAirPlaneList) {
		this.ourAirPlaneList = ourAirPlaneList;
	}
	
	
	public AirPlane findAirPlane(String airPlanID){
		
		return null;
	}

	@Override
	public String toString() {
		StringBuilder returnString = new StringBuilder();
		for(AirPlane plane : this.ourAirPlaneList) {
			returnString.append("AirPlaneListHandler: " + plane + "\n");
		}
		return returnString.toString();
	}
	
	public boolean addAirPlane(AirPlane newAirPlane) {
		return this.ourAirPlaneList.add(newAirPlane);
		
	}
	
	
}

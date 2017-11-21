package se.coconutflightbooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AirPlaneListHandler {
	HashMap<String, AirPlane> ourAirPlaneList = new HashMap<String, AirPlane>();

	public HashMap<String, AirPlane> getOurAirPlaneList() {
		return ourAirPlaneList;
	}

	public void setOurAirPlaneList(HashMap<String, AirPlane> ourAirPlaneList) {
		this.ourAirPlaneList = ourAirPlaneList;
	}
	
	
	public AirPlane getAirPlane(String airPlanID) throws AirPlaneNotFoundException{
		if(this.ourAirPlaneList.containsKey(airPlanID)) {
			return this.ourAirPlaneList.get(airPlanID);
		}
		else
			throw new  AirPlaneNotFoundException();
	}

	@Override
	public String toString() {
		StringBuilder returnString = new StringBuilder();
		for(AirPlane airPlane : this.ourAirPlaneList.values()) {
			
			returnString.append("AirPlaneListHandler: " + airPlane + "\n");
		}
		return returnString.toString();
	}
	
	public boolean addAirPlane(AirPlane newAirPlane) {

		if(this.ourAirPlaneList.containsKey(newAirPlane.getAirPlaneID())) {
			System.out.println("Airplane " + newAirPlane.getAirPlaneID() + " finns redan i vår flotta!");
			return false;
		}
		else {
			this.ourAirPlaneList.put(newAirPlane.getAirPlaneID(), newAirPlane);
			AirPlane result = this.ourAirPlaneList.get(newAirPlane.getAirPlaneID());
		
			if(result.equals(newAirPlane)) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean removeAirPlaneFromList(AirPlane removeAirPlane) {
		if(this.ourAirPlaneList.containsKey(removeAirPlane.getAirPlaneID())) {
			this.ourAirPlaneList.remove(removeAirPlane.getAirPlaneID());
			// TODO Remove from DB
			return true;
		}
		else
			return false;
	}
	
	public boolean addAirPlaneToDB(AirPlane newAirPlane) {
	
		return false;
	}
	
	public boolean removeAirPlaneFromDB(AirPlane newAirPlane) {
		
		return false;
	}
	
	public boolean retrieveAirPlaneListFromDB() {
		return false;
	}
	
	
}

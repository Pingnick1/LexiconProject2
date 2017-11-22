package se.coconutflightbooking;

import java.time.LocalDateTime;
import java.util.HashMap;

import se.coconutflightbooking.exceptions.DepartureAlreadyExistInListException;
import se.coconutflightbooking.exceptions.DepartureNotFoundException;

public class DepartureListHandler {
	HashMap<String, Departure> departureList = new HashMap<String, Departure>();
	String prefixDepartureID = "DDD00";
	
	public static void main(String[] args) {

	}
	
	public String getNextUniqueDepartureID() {
		StringBuilder newName = new StringBuilder();
		int nextDepartureIdSuffix = this.departureList.size() + 1;
			
		boolean isUniqueName = false;
		do {
			if(newName.length()>0)
				newName.delete(0, newName.length()-1);
			
			newName.append(this.prefixDepartureID);
			newName.append(nextDepartureIdSuffix);
			
			if(!this.departureIdExistInList(newName.toString() ) ){
				//System.out.println("Nytt namn: " + newName.toString());
				isUniqueName = true;	
			}	
		}while(!isUniqueName);
		
		//System.out.println("Nytt namn: " + newName.toString());
		return newName.toString();
	}
	
	
	public String getPrefixDepartureID() {
		return prefixDepartureID;
	}

	public void setPrefixDepartureID(String prefixDepartureID) {
		this.prefixDepartureID = prefixDepartureID;
	}

	public boolean departureIdExistInList(String departureID) {
		if(this.departureList.containsKey(departureID)) {
			return true;
		}
		else
			return false;
	}
	
	
	public boolean addDeparture(Departure newDeparture) throws DepartureAlreadyExistInListException{
		if(!this.departureList.containsKey(newDeparture.getDepartureID())) {
			this.departureList.put(newDeparture.getDepartureID(), newDeparture);
			
			Departure result = this.departureList.get(newDeparture.getDepartureID());
			
			if(result.equals(newDeparture)) {
				return true;
			}
			else {
				return false;
			}
		}
		else
			throw new DepartureAlreadyExistInListException();
	}
	
	public boolean addDeparture(LocalDateTime departureDateTime, String destination, AirPlane airPlane, Integer firstClassTicketPrice, Integer economyClassTicketPrice)  {
		String departureID = this.getNextUniqueDepartureID();
		Departure newDeparture = new Departure(departureID, departureDateTime, destination, airPlane, firstClassTicketPrice, economyClassTicketPrice);
		this.departureList.put(newDeparture.getDepartureID(), newDeparture);
		
		Departure result = this.departureList.get(newDeparture.getDepartureID());
		
		if(result.equals(newDeparture)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean addDeparture(String departureID, LocalDateTime departureDateTime, String destination, AirPlane airPlane, Integer firstClassTicketPrice, Integer economyClassTicketPrice) throws DepartureAlreadyExistInListException  {
		Departure newDeparture = new Departure(departureID, departureDateTime, destination, airPlane, firstClassTicketPrice, economyClassTicketPrice);
		
		if(this.addDeparture(newDeparture))
			return true;						
		else
			return false;
	}
	
	
	
	
	public Departure getDeparture(String DepartureID) throws DepartureNotFoundException{
		if(this.departureList.containsKey(DepartureID)) {
			return this.departureList.get(DepartureID);
		}
		else
			throw new  DepartureNotFoundException();
	}	
	
	
	public HashMap<String, Departure> getDepartureList() {
		return departureList;
	}


	public boolean setDepartureList(HashMap<String, Departure> departureList) {
		this.departureList = departureList;
		if(this.departureList.equals(departureList))
			return true;
		else
			return false;
		
	}


	/**
	 * 
	 * @return Number of departures in list.
	 */
	public int size() {
		return this.departureList.size();
	}
	
	public boolean removeDepartureFromList(Departure removeDeparture) throws DepartureNotFoundException{
		if(this.departureList.containsKey(removeDeparture.getDepartureID())) {
			if(this.departureList.remove(removeDeparture.getDepartureID()) != null)
				return true;
			else
				return false;
			// TODO Remove from DB
		}
		else
			throw new DepartureNotFoundException();
	}
	
	private boolean addDepartureToDB(Departure newDeparture) {
		// TODO Fix addDepartureToDB
		return false;
	}
	
	private boolean removeDepartureFromDB(Departure newDeparture) {
		// TODO Fix removeDepartureFromDB
		return false;
	}
	
	private boolean retrieveAirPlaneListFromDB() {
		return false;
	}


	@Override
	public String toString() {
		StringBuilder returnString = new StringBuilder();
		returnString.append("DepartureListHandler:\n");
		int i=0;
		for(Departure departureItem : this.departureList.values()) {
			returnString.append(++i + ": " + departureItem + "\n");
		}
		return returnString.toString();
		
	}
	
	

}

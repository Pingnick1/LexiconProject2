package se.coconutflightbooking;

import java.util.HashMap;

import se.coconutflightbooking.exceptions.DepartureAlreadyExistInListException;
import se.coconutflightbooking.exceptions.DepartureNotFoundException;

public class DepartureListHandler {
	HashMap<String, Departure> departureList = new HashMap<String, Departure>();
	String prefixDepartureID = "CCN00";
	//int listCounter;
	
	public static void main(String[] args) {
		StringBuilder returnString = new StringBuilder();
		DepartureListHandler testHandler = new DepartureListHandler();
		String prefixDepartureID = "CCN00";
		
		int nextDepartureIdSuffix = testHandler.size()+1;
		
		do {
			returnString = new StringBuilder();
			
			returnString.append(prefixDepartureID);
			returnString.append(nextDepartureIdSuffix);
		}while(testHandler.departureIdExistInList(returnString.toString()));
		
		System.out.println(returnString.toString());


	}
	
	private String UniqueDepartureIdGenerator() {
		StringBuilder returnString = new StringBuilder();
		int nextDepartureIdSuffix = this.departureList.size()+1;
		
		
		
		do {
			returnString = new StringBuilder();
			
			returnString.append(this.prefixDepartureID);
			returnString.append(nextDepartureIdSuffix);
		}while(this.departureIdExistInList(returnString.toString()));
		
		return returnString.toString();
		
		
		
		

		return returnString.toString();
	}
	
	private boolean departureIdExistInList(String departureID) {
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

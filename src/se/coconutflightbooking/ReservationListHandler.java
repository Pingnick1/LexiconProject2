package se.coconutflightbooking;

import java.time.LocalDateTime;
import java.util.HashMap;

import se.coconutflightbooking.exceptions.ReservationAlreadyExistInListException;
import se.coconutflightbooking.exceptions.ReservationNotFoundException;

public class ReservationListHandler {
	HashMap<String, Reservation> reservationList = new HashMap<String, Reservation>();
	String prefixReservationID = "RRR00";
	
	
	
	public Reservation getReservation(String reservationID) throws ReservationNotFoundException{
		if(this.reservationList.containsKey(reservationID)) {
			return this.reservationList.get(reservationID);
		}
		else
			throw new  ReservationNotFoundException();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNextUniqueReservationID() {
		StringBuilder newName = new StringBuilder();
		int nextDepartureIdSuffix = this.reservationList.size() + 1;
			
		boolean isUniqueName = false;
		do {
			if(newName.length()>0)
				newName.delete(0, newName.length()-1);
			
			newName.append(this.prefixReservationID);
			newName.append(nextDepartureIdSuffix);
			
			if(!this.reservationIdExistInList(newName.toString() ) ){
				//System.out.println("Nytt namn: " + newName.toString());
				isUniqueName = true;	
			}	
		}while(!isUniqueName);
		
		//System.out.println("Nytt namn: " + newName.toString());
		return newName.toString();
	}
	
	/**
	 * 
	 * @param reservationID
	 * @return
	 */
	public boolean reservationIdExistInList(String reservationID) {
		if(this.reservationList.containsKey(reservationID)) {
			return true;
		}
		else
			return false;
	}
	
	/**
	 * 
	 * @param newReservation
	 * @return true if successful, else false
	 * @throws ReservationAlreadyExistInListException
	 */
	public boolean addReservation(Reservation newReservation) throws ReservationAlreadyExistInListException{
		if(!this.reservationList.containsKey(newReservation.getReservationID())) {
			this.reservationList.put(newReservation.getReservationID(), newReservation);
			
			Reservation result = this.reservationList.get(newReservation.getReservationID());
			
			if(result.equals(newReservation)) {
				return true;
			}
			else {
				return false;
			}
		}
		else
			throw new ReservationAlreadyExistInListException();
	}
	
	/**
	 * 
	 * @param customer
	 * @param departure
	 * @param ticketType
	 * @param ticketCost
	 * @return true if successful, else false
	 */
	/*
	public boolean addReservation(LocalDateTime reservationDateTime, String customer, Departure departure, TicketType ticketType, Integer ticketCost)  {
		String reservationID = this.getNextUniqueReservationID();
		Reservation newReservation = new Reservation(reservationID, reservationDateTime, customer, departure, ticketType, ticketCost);
		this.reservationList.put(newReservation.getReservationID(), newReservation);
		
		Reservation result = this.reservationList.get(newReservation.getReservationID());
		
		if(result.equals(newReservation)) {
			return true;
		}
		else {
			return false;
		}
	}
	*/
	
	
	
	
	/**
	 * 
	 * @param customer
	 * @param departure
	 * @param ticketType
	 * @param ticketCost
	 * @return
	 */
	public boolean addReservation(String customer, Departure departure, TicketType ticketType, Integer ticketCost)  {
		String reservationID = this.getNextUniqueReservationID();
		LocalDateTime reservationDateTime = LocalDateTime.now(); 
		Reservation newReservation = new Reservation(reservationID, reservationDateTime, customer, departure, ticketType, ticketCost);
		this.reservationList.put(newReservation.getReservationID(), newReservation);
		
		Reservation result = this.reservationList.get(newReservation.getReservationID());
		
		if(result.equals(newReservation)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param reservationID
	 * @param customer
	 * @param departure
	 * @param ticketType
	 * @param ticketCost
	 * @return true if successful, else false
	 * @throws ReservationAlreadyExistInListException
	 */
	public boolean addReservation(String reservationID, LocalDateTime reservationDateTime, String customer, Departure departure, TicketType ticketType, Integer ticketCost) throws ReservationAlreadyExistInListException  {
		Reservation newReservation = new Reservation(reservationID, reservationDateTime, customer, departure, ticketType, ticketCost);
		
		if(this.addReservation(newReservation))
			return true;						
		else
			return false;
	}
	

	/**
	 * 
	 * @return Number of reservations in the list
	 */
	public int size() {
		return this.reservationList.size();
	}
	
	/**
	 * @return the reservationList
	 */
	public HashMap<String, Reservation> getReservationList() {
		return reservationList;
	}

	/**
	 * @param reservationList the reservationList to set
	 */
	public void setReservationList(HashMap<String, Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	/**
	 * @return the prefixReservationID
	 */
	public String getPrefixReservationID() {
		return prefixReservationID;
	}

	/**
	 * @param prefixReservationID the prefixReservationID to set
	 */
	public void setPrefixReservationID(String prefixReservationID) {
		this.prefixReservationID = prefixReservationID;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

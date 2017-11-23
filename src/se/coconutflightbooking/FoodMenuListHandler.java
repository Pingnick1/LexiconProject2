package se.coconutflightbooking;

import java.util.HashMap;

public class FoodMenuListHandler {

	HashMap<String, FoodMenuItem> ourFoodMenuList = new HashMap<String, FoodMenuItem>();

	public HashMap<String, FoodMenuItem> getFoodMenuList() {
		return ourFoodMenuList;
	}
	
	public HashMap<String, FoodMenuItem> getFoodMenuListEconomyClass(){
		HashMap<String, FoodMenuItem> economyClassFoodMenuList = new HashMap<String, FoodMenuItem>();
		// TODO
		for(FoodMenuItem foodMenuItem  : this.ourFoodMenuList.values()) {
			if(!foodMenuItem.getIsFirstClass()) {
				economyClassFoodMenuList.put(foodMenuItem.foodMenuID, foodMenuItem);
			}
		}
		return economyClassFoodMenuList;
	}
	
	public HashMap<String, FoodMenuItem> getFoodMenuListFirstClass(){
		// TODO
		HashMap<String, FoodMenuItem> firstClassFoodMenuList = new HashMap<String, FoodMenuItem>();
		
		for(FoodMenuItem foodMenuItem  : this.ourFoodMenuList.values()) {
			if(foodMenuItem.getIsFirstClass()) {
				firstClassFoodMenuList.put(foodMenuItem.foodMenuID, foodMenuItem);
			}
		}
		return firstClassFoodMenuList;
	}

	public void setOurFoodMenuList(HashMap<String, FoodMenuItem> ourFoodMenuList) {
		this.ourFoodMenuList = ourFoodMenuList;
	}
	
	
	public FoodMenuItem getFoodMenuItem(String foodMenuID) throws FoodMenuItemNotFoundException{
		if(this.ourFoodMenuList.containsKey(foodMenuID)) {
			return this.ourFoodMenuList.get(foodMenuID);
		}
		else
			throw new  FoodMenuItemNotFoundException();
	}

	@Override
	public String toString() {
		StringBuilder returnString = new StringBuilder();
		for(FoodMenuItem foodMenuID : this.ourFoodMenuList.values()) {
			
			returnString.append("FoodMenuListHandler: " + foodMenuID + "\n");
		}
		return returnString.toString();
	}
	
	public boolean addFoodMenuItem(FoodMenuItem newFoodMenuItem) {

		if(this.ourFoodMenuList.containsKey(newFoodMenuItem.getfoodMenuID())) {
			System.out.println("Menyval " + newFoodMenuItem.getfoodMenuID() + " finns redan i vår meny!");
			return false;
		}
		else {
			this.ourFoodMenuList.put(newFoodMenuItem.getfoodMenuID(), newFoodMenuItem);
			FoodMenuItem result = this.ourFoodMenuList.get(newFoodMenuItem.getfoodMenuID());
		
			if(result.equals(newFoodMenuItem)) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean removeFoodMenuItemFromList(FoodMenuItem removeFoodMenuItem) {
		if(this.ourFoodMenuList.containsKey(removeFoodMenuItem.getfoodMenuID())) {
			this.ourFoodMenuList.remove(removeFoodMenuItem.getfoodMenuID());
			// TODO Remove from DB
			return true;
		}
		else
			return false;
	}
	
	
	private boolean addFoodMenuItemToDB(FoodMenuItem newFoodMenuItem) {
	
		return false;
	}
	
	private boolean removeFoodMenuItemFromDB(FoodMenuItem removeFoodMenuItem) {
		
		return false;
	}
	
	private boolean retrieveFoodMenuListFromDB() {
		return false;
	}
	
	
}

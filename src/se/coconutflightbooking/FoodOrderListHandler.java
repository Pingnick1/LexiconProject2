package se.coconutflightbooking;

import java.util.HashMap;


public class FoodOrderListHandler {

    //private static final String newFoodOrderItem = null;
    HashMap<String, FoodOrderItem> ourFoodOrderList = new HashMap<String, FoodOrderItem>();

    public HashMap<String, FoodOrderItem> getOurFoodOrderList() {
        return ourFoodOrderList;
    }

    public void setOurFoodOrderList(HashMap<String, FoodOrderItem> ourFoodOrderList) {
        this.ourFoodOrderList = ourFoodOrderList;
    }

    public void setOurFoodOrderItemList(HashMap<String, FoodOrderItem> ourFoodOrderItemList) {
    }

    public HashMap<String, FoodOrderItem> getFoodOrderListEconomyClass() {
        HashMap<String, FoodOrderItem> economyClassFoodOrderList = new HashMap<String, FoodOrderItem>();

        for (FoodOrderItem foodOrderItem : this.ourFoodOrderList.values()) {
            if (!foodOrderItem.getIsFirstClass()) {
                economyClassFoodOrderList.put(foodOrderItem.getFoodOrderItemID(), foodOrderItem);
            }
        }
        return economyClassFoodOrderList;
    }

    public HashMap<String, FoodOrderItem> getFoodOrderListFirstClass() {

        HashMap<String, FoodOrderItem> firstClassFoodOrderList = new HashMap<String, FoodOrderItem>();

        for (FoodOrderItem foodOrderItem : this.ourFoodOrderList.values()) {
            if (foodOrderItem.getIsFirstClass()) {
                firstClassFoodOrderList.put(foodOrderItem.getFoodOrderItemID(), foodOrderItem);
            }
        }
        return firstClassFoodOrderList;
    }

    public FoodOrderItem getFoodOrderItem(String foodOrderItemID) throws FoodOrderItemNotFoundException {
        if (this.ourFoodOrderList.containsKey(foodOrderItemID)) {
            return this.ourFoodOrderList.get(foodOrderItemID);
        } else
            throw new FoodOrderItemNotFoundException();
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (FoodOrderItem foodOrderItemID : this.ourFoodOrderList.values()) {

            returnString.append("FoodOrderListHandler: " + foodOrderItemID + "\n");
        }
        return returnString.toString();
    }


    public boolean addFoodOrderItem(FoodOrderItem newFoodOrderItem) {

        if (this.ourFoodOrderList.containsKey(newFoodOrderItem.getFoodOrderItemID())) {
            System.out.println("Menyval " + newFoodOrderItem.getFoodOrderItemID() + " finns redan i vår Order!");
            return false;
        } else {
            this.ourFoodOrderList.put(newFoodOrderItem.getFoodOrderItemID(), newFoodOrderItem);
            FoodOrderItem result = this.ourFoodOrderList.get(newFoodOrderItem.getFoodOrderItemID());

            if (result.equals(newFoodOrderItem)) {
                return true;
            } else {
                return false;
            }
        }
    }


    //
    public boolean removeFoodMenuItemFromList(FoodOrderItem removeFoodOrderItem) {
        if (this.ourFoodOrderList.containsKey(removeFoodOrderItem.getFoodOrderItemID())) {
            this.ourFoodOrderList.remove(removeFoodOrderItem.getFoodOrderItemID());

            return true;
        } else
            return false;
    }


    private boolean addFoodOrderItemToDB(FoodOrderItem newFoodOrderItem) {

        return false;
    }

    private boolean removeFoodOrderItemFromDB(FoodOrderItem removeFoodOrderItem) {

        return false;
    }

    @SuppressWarnings("unused")
    private boolean retrieveFoodOrderListFromDB() {
        return false;
    }


}

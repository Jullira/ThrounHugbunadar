/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

/**
 *
 * @author gretabjorg
 */
public class Hotel {
    private final String name;
    private final String address;
    private final String city;
    private final int areaCode;
    private final String description;
    private final String pictures;
    private final int grade;
    private final int starRating;
    private final boolean swimmingPool;
    private final boolean breakfast;
    private final boolean wiFi;
    private final boolean handicapFacilities;
    private final boolean gym;
    private final int hotelID;
    private final String roomTableName;
    private final String reviewTableName;

    public Hotel(String name, String address, String city, int areaCode, String description, String pictures, int grade, int starRating, boolean swimmingPool, boolean breakfast, boolean wiFi, boolean handicapFacilities, boolean gym, int hotelID, String roomTableName, String reviewTableName) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.areaCode = areaCode;
        this.description = description;
        this.pictures = pictures;
        this.grade = grade;
        this.starRating = starRating;
        this.swimmingPool = swimmingPool;
        this.breakfast = breakfast;
        this.wiFi = wiFi;
        this.handicapFacilities = handicapFacilities;
        this.gym = gym;
        this.hotelID = hotelID;
        this.roomTableName = roomTableName;
        this.reviewTableName = reviewTableName;
    }
    
    public String getAddress() {
        return address;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public String getPictures() {
        return pictures;
    }

    public int getGrade() {
        return grade;
    }

    public int getStarRating() {
        return starRating;
    }

    public boolean isSwimmingPool() {
        return swimmingPool;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public boolean isWiFi() {
        return wiFi;
    }

    public boolean isHandicapFacilities() {
        return handicapFacilities;
    }

    public boolean isGym() {
        return gym;
    }

    public int getHotelID() {
        return hotelID;
    }

    public String getRoomTableName() {
        return roomTableName;
    }

    public String getReviewTableName() {
        return reviewTableName;
    }


}


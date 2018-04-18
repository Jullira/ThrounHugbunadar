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
    private String name;
    private String address;
    private String city;
    private int areaCode;
    private String description;
    private String picturesSmall;
    private String picturesLarge;
    private double grade;
    private int starRating;
    private boolean swimmingPool;
    private boolean breakfast;
    private boolean wiFi;
    private  boolean handicapFacilities;
    private boolean gym;
    private int price;
    private int hotelID;
    private String roomTableName;
    private String reviewTableName;

    
    
    public void newHotel(String name, String address, String city, int areaCode, String description, String picturesSmall, String picturesLarge, double grade, int starRating, boolean swimmingPool, boolean breakfast, boolean wiFi, boolean handicapFacilities, boolean gym, int price, int hotelID, String roomTableName, String reviewTableName) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.areaCode = areaCode;
        this.description = description;
        this.picturesSmall = picturesSmall;
        this.picturesLarge = picturesLarge;
        this.grade = grade;
        this.starRating = starRating;
        this.swimmingPool = swimmingPool;
        this.breakfast = breakfast;
        this.wiFi = wiFi;
        this.handicapFacilities = handicapFacilities;
        this.gym = gym;
        this.price = price;
        this.hotelID = hotelID;
        this.roomTableName = roomTableName;
        this.reviewTableName = reviewTableName;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }

    public int getAreaCode() {
        return areaCode;
    }
    
    public String getDescription() {
        return description;
    }

    public String getPicturesSmall() {
        return picturesSmall;
    }

    public String getPicturesLarge() {
        return picturesLarge;
    }

    public double getGrade() {
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

    public int getPrice() {
        return price;
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


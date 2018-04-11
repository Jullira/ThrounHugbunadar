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
public class Booking {
   
    // Information about the booking
    private String hotel;
    private int startDate;
    private int endDate;
    private int adultGuests;
    private int childrenGuests;
    
    // Information about the costumer
    private String fullName;
    private String address;
    private int zipCode;
    private String city;
    private String phoneNumber; 
    private String email;

    public Booking(String hotel, int startDate, int endDate, int adultGuests, int childrenGuests, String fullName, String address, int zipCode, String city, String phoneNumber, String email) {
        this.hotel = hotel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adultGuests = adultGuests;
        this.childrenGuests = childrenGuests;
        this.fullName = fullName;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
   
    public String getHotel() {
        return hotel;
    }

    public int getStartDate() {
        return startDate;
    }

    public int getEndDate() {
        return endDate;
    }
    
    public int getAdultGuests() {
        return adultGuests;
    }

    public int getChildrenGuests() {
        return childrenGuests;
    }
    
    
    public String getFullName() {
        return fullName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getZipCode() {
        return zipCode;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getEmail() {
    return email;
    }
}

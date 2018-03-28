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
    
    private Account user;
    private Hotel hotel;
    private int startDate;
    private int endDate;
    private int roomNumber;

    public Booking(Account user, Hotel hotel, int startDate, int endDate, int roomNumber) {
        this.user = user;
        this.hotel = hotel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
    }

    public Account getUser() {
        return user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public int getStartDate() {
        return startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    
    
    
    
}

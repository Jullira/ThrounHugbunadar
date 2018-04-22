/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import vinnsla.Booking;
import vinnsla.DatabaseConnection;

/**
 *
 * @author gretabjorg
 */
public class BookingController {
    
    private ArrayList<String[]> dataBookingList = new ArrayList<>();
    private ArrayList<Booking> bookingList = new ArrayList<>();
    private String[] selectedString = new String[12];
    
    public ArrayList<Booking> newBooking(Booking nyBokun) {
        DatabaseConnection dc = new DatabaseConnection();
        dataBookingList = dc.openConnection(nyBokun);
        
        for(int i = 0; i < dataBookingList.size(); i++) {
            selectedString = dataBookingList.get(i);
            
            Booking selectedBooking = new Booking();
            selectedBooking.newBooking(
                    selectedString[0],
                    Integer.parseInt(selectedString[1]),
                    selectedString[2],
                    selectedString[3],
                    Integer.parseInt(selectedString[4]),
                    selectedString[5],
                    "address",
                    210,
                    "city",
                    "country",
                    "phoneNumber",
                    "email");

            bookingList.add(selectedBooking);
        }
        
        
        return bookingList;
    }
    
}

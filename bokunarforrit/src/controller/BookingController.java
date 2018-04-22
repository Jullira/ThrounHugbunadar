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
    
   private ArrayList<Booking> bookingList = new ArrayList<>();
    
    public ArrayList<Booking> newBooking(Booking nyBokun) {
        DatabaseConnection dc = new DatabaseConnection(); 
        dc.openConnection(nyBokun);
        bookingList.add(nyBokun);
      
        return bookingList;
    }
    
}

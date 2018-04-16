/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import vinnsla.Booking;
import vinnsla.DatabaseConnection;

/**
 *
 * @author gretabjorg
 */
public class BookingController {
    
    // Þetta á ekki að vera void endilega, vorum ekki með neina skilgreiningu í UML-inu okkar
    
    /*public void openBooking() {
    }*/
    
    /*public void cancelBooking() {
    }*/
    
    public void newBooking(Booking nybokun) {
        DatabaseConnection dc = new DatabaseConnection();
        //dc.openConnection(nybokun);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import vinnsla.DatabaseConnection;
import vinnsla.leit;
import bokunarforrit.FXMLDocumentController;
import static java.lang.reflect.Array.set;
import java.util.ArrayList;
import vinnsla.Hotel;
/**
 *
 * @author gretabjorg
 */
public class SearchController {
    
    private ArrayList<String[]> dataHotelList = new ArrayList<>();
    private ArrayList<Hotel> hotelList = new ArrayList<>(); 
    //private Hotel selectedHotel = new Hotel();
    private String[] selectedString = new String[13];
    
    
    public ArrayList<Hotel> searchHotels(leit nyleit) {
        DatabaseConnection dc = new DatabaseConnection();
        dataHotelList = dc.openConnection(nyleit);
        
        int j = 0; 
        for(int i = 0; i < dataHotelList.size(); i++) {
            selectedString = dataHotelList.get(i);
            Hotel selectedHotel = new Hotel();
            selectedHotel.newHotel(selectedString[0], selectedString[1], 
            selectedString[2], Integer.parseInt(selectedString[3]), 
            selectedString[4], selectedString[5], 
            Double.parseDouble("5"), 
            Integer.parseInt(selectedString[7]), 
            Boolean.parseBoolean(selectedString[8]), 
            Boolean.parseBoolean(selectedString[9]), 
            Boolean.parseBoolean(selectedString[10]), 
            Boolean.parseBoolean(selectedString[11]), 
            Boolean.parseBoolean(selectedString[12]),
            1,
            "revow",
            "review");
            hotelList.add(selectedHotel);
            j++;
        }
        return hotelList;
    }

}
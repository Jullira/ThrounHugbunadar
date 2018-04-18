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
    private String[] selectedString = new String[15];
    
    
    public ArrayList<Hotel> searchHotels(leit nyleit) {
        DatabaseConnection dc = new DatabaseConnection();
        dataHotelList = dc.openConnection(nyleit);
            
        int j = 0; 
        for(int i = 0; i < dataHotelList.size(); i++) {
            selectedString = dataHotelList.get(i);
            boolean wifi, pool, breakfast, handicap, gym; 
            wifi = selectedString[8].equals("1"); 
            pool = selectedString[9].equals("1"); 
            breakfast = selectedString[10].equals("1"); 
            handicap = selectedString[11].equals("1"); 
            gym = selectedString[12].equals("1");
            
            Hotel selectedHotel = new Hotel();
            selectedHotel.newHotel(
                    selectedString[0], 
                    selectedString[1], 
                    selectedString[2], 
                    Integer.parseInt(selectedString[3]), 
                    selectedString[4], 
                    selectedString[5], 
                    selectedString[13], 
                    Double.parseDouble("5"), 
                    Integer.parseInt(selectedString[7]), 
                    wifi, 
                    pool, 
                    breakfast, 
                    handicap, 
                    gym,
                    Integer.parseInt(selectedString[14]),
                    1, 
                    "roomTableName",
                    "reviewTableName");
            hotelList.add(selectedHotel);
            j++;
        }
        return hotelList;
    }

}
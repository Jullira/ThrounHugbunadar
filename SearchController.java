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
    private Hotel selectedHotel = new Hotel();
    private String[] selectedString = new String[13];
    //private String[] arr = new String[11]; //gæti komið out of bounds error
    
    
    public void searchHotels(leit nyleit) {
        DatabaseConnection dc = new DatabaseConnection();
        dataHotelList = dc.openConnection(nyleit);
        
        
        for(int i = 0; i < dataHotelList.size(); i++) {
            selectedString = dataHotelList.get(i);
            //for(int j = 0; j<12; j++){
            //   arr[j] = "f";//strengjavinnsla    
            //}
            selectedHotel.newHotel(selectedString[0], selectedString[1], 
                    selectedString[2], Integer.parseInt(selectedString[3]), 
                    selectedString[4], selectedString[5], 
                    Double.parseDouble(selectedString[6]), 
                    Integer.parseInt(selectedString[7]), 
                    Boolean.parseBoolean(selectedString[8]), 
                    Boolean.parseBoolean(selectedString[9]), 
                    Boolean.parseBoolean(selectedString[10]), 
                    Boolean.parseBoolean(selectedString[11]), 
                    Boolean.parseBoolean(selectedString[12]), ...);
            hotelList.set(i, selectedHotel);
            //hotelList.set(i, selectedHotel.newHotel(dataHotelList.get(i, [0]),dataHotelList.get(i, [1]),dataHotelList.get(i, [2]),dataHotelList.get(i, [3]),dataHotelList.get(i, [4]),dataHotelList.get(i, [5]),dataHotelList.get(i, [6]),dataHotelList.get(i, [7]),dataHotelList.get(i, [8]),dataHotelList.get(i, [9]),dataHotelList.get(i, [10]),dataHotelList.get(i, [11]),dataHotelList.get(i, [12])));   
        }
        //return hotelList;
    }

    /*public Hotel makeHotelObject(String Name, String Address, String City, 
                                int AreaCode, String Description, String Pictures, 
                                float Grade, int StarRating, boolean SwimmingPool, 
                                boolean Brekfast, boolean WiFi, boolean HandicapFacilities, 
                                boolean Gym) {

        return 0;
    }*/
    
}
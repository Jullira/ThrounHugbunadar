/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gretabjorg
 */
public class DatabaseConnection {
    
    private String table;
    //private arraylist<String> commands;
    
    public ArrayList<String> makeQueryString(leit nyLeit){
        ArrayList<String> results = new ArrayList<>();
        
        String searchStringText = nyLeit.getSearchString().replaceAll("\\s+","");
        String [] startDateParts = nyLeit.getStartDate().split("-");
        String startYear = startDateParts[0];
        String startMonth = startDateParts[1];
        String startDay;
        if(!"10".equals(startDateParts[2])){
            startDay = startDateParts[2].replaceFirst("0", "");
        }
        else {
            startDay = startDateParts[2];
        }
        
        String [] endDateParts = nyLeit.getEndDate().split("-");
        String endYear = endDateParts[0];
        String endMonth = endDateParts[1];
        String endDay = endDateParts[2];
        
        int persons = nyLeit.getAdultGuests() + nyLeit.getChildrenGuests();
        
        
        System.out.println(
            nyLeit.getSearchString() + 
            nyLeit.getStartDate() + 
            nyLeit.getEndDate() + 
            nyLeit.getAdultGuests() + 
            nyLeit.getChildrenGuests());
        
        String query = "SELECT RoomNumber FROM " + searchStringText + "RoomsAvailable" + startMonth + "19" + " WHERE RoomSize = " + persons + " AND Date" + startDay + " = 1";
        System.out.println(query);
        DatabaseConnection dc = new DatabaseConnection();
        results = dc.openConnection(query);
        
        return results;
    }
    
    /**
     * Opnar tengingu við gagnagrunn.
     * @param query 
     */
    public ArrayList<String> openConnection(String query) {
        ArrayList<String> results = new ArrayList<>();
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:dev7.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Tenging Virk");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String output = rs.getString("Name");
                System.out.println(output);
                results.add(output);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn !=null) {
                    //Lokum tengingunni ef hún átti sér stað.
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return results;
    }
    
}

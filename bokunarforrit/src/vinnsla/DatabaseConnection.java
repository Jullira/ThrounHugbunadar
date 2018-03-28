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

/**
 *
 * @author gretabjorg
 */
public class DatabaseConnection {
    
    private String table;
    //private arraylist<String> commands;
    
    /**
     * Opnar tengingu við gagnagrunn.
     * @param a 
     */
    public void openConnection(leit nyLeit) {
            
        String searchStringText = nyLeit.getSearchString().replaceAll("\\s+","");
        String [] startDateParts = nyLeit.getStartDate().split("-");
        String startYear = startDateParts[0];
        String startMonth = startDateParts[1];
        String startDay;
        if(startDateParts[2] != "10"){
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
        dc.openConnection(query);
        
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:dev6.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Tenging Virk");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString("Name"));
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
    }
    
}

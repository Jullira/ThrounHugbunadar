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
    public void openConnection(String a) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:dev6.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Tenging Virk");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(a);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gretabjorg
 */
public class DatabaseConnection {
    
    private String table;
    private ArrayList<String> commands;
    Connection conn;
    
    public ArrayList<String> runCommands(String stmt) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:dev6.db");
        ArrayList<String> results = new ArrayList<>();

        PreparedStatement p = conn.prepareStatement(stmt);
        p.clearParameters();
        ResultSet r = p.executeQuery();
        while(r.next())
        {
            String output = r.getString(1);
            results.add(output);
        }
        r.close();
	conn.close();
        return results;
    }
        
}

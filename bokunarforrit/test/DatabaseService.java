
import vinnsla.DatabaseConnection;
import vinnsla.leit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gretabjorg
 */
public interface DatabaseService {
    
    // Kallar í DatabaceConnectionMock
    
    public void DatabaseConnectionMock(leit nyleit) {
        DatabaseConnectionMock dcm = new DatabaseConnectionMock();
        dcm.makeQueryString(nyleit);
    } 
    
    public void DatabaseConnection(leit nyleit) {
        DatabaseConnection dc = new DatabaseConnection();
        dc.makeQueryString(nyleit);
    }
}

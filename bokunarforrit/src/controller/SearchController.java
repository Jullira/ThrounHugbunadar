/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import vinnsla.DatabaseConnection;
import vinnsla.leit;
import bokunarforrit.FXMLDocumentController;

/**
 *
 * @author gretabjorg
 */
public class SearchController {
    
    public void searchHotels(leit nyleit){
        DatabaseConnection dc = new DatabaseConnection();
        dc.openConnection(nyleit);
        
    }
    
}
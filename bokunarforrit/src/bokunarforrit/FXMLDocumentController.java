/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokunarforrit;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import vinnsla.leit;
import controller.SearchController;
import java.util.ArrayList;
import vinnsla.Hotel;

/**
 *
 * @author birgi
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private ImageView banner;
    @FXML
    private TextField searchString;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private ComboBox<String> guests;
    @FXML
    private Button searchButton;
    
    private leit nyLeit = new leit();
    private SearchController newSController = new SearchController();
    
    private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    
    private final ObservableList<String> stringNumList = FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        guests.setItems(stringNumList);
    }

    @FXML
    private void searchStringAction(MouseEvent event) {
    }

    @FXML
    private void searchButtonAction(ActionEvent event) throws IOException {
        String searchStringText = searchString.getText();
        String startDateString = dateToString(startDate);
        String endDateString = dateToString(endDate);
        int guestsInt = Integer.parseInt(guests.getValue());
        
        nyLeit.newSearch(searchStringText, startDateString, endDateString, guestsInt);
        hotelList = newSController.searchHotels(nyLeit);
        newLeitPage(event);
        
        
        
        System.out.println(
            nyLeit.getSearchString() + 
            nyLeit.getStartDate() + 
            nyLeit.getEndDate() + 
            nyLeit.getGuests());
    }
    
    private String dateToString(DatePicker date) {
        LocalDate ld = date.getValue();
        return ld.toString();
    }
    
    private void newLeitPage(ActionEvent event) throws IOException {        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("leitarNid.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        
        LeitarNidController display = loader.getController();
        display.setHotelList(hotelList);
        
        stage.show();
    }
    
}

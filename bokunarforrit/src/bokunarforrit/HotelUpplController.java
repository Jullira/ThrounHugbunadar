/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokunarforrit;

import controller.SearchController;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vinnsla.Hotel;
import vinnsla.leit;

/**
 * FXML Controller class
 *
 * @author birgi
 */
public class HotelUpplController implements Initializable {

    @FXML
    private ImageView banner;
    @FXML
    private ImageView hotelImage;
    @FXML
    private Text hotelName;
    @FXML
    private Label hotelInfo;
    @FXML
    private TextField searchString;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private ComboBox<String> guests;
    @FXML
    private Label fromDateLabel;
    @FXML
    private Label toDateLabel;
    @FXML
    private Label numGuestsLabel;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private Button bookButton;
    
    //private LeitarNidController lnc = new LeitarNidController();
    private String currStartDate, currEndDate, currGuests;
    private ArrayList<Hotel> hotelList = new ArrayList<>();
    private int hotelNum;
    private Hotel selectedHotel = new Hotel();
    private leit nyLeit = new leit();
    private SearchController newSController = new SearchController();
    private String startDateString, endDateString;
    private final ObservableList<String> stringNumList = FXCollections.observableArrayList("0","1","2","3","4");
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        guests.setItems(stringNumList);
    }    
    
    public void setSelectedHotel(Hotel selectedHotel) {
        this.selectedHotel = selectedHotel;
        Image image = new Image("https://media-cdn.tripadvisor.com/media/photo-s/04/30/37/14/black-pearl-reykjavik.jpg");
        hotelImage.setImage(image);
        hotelName.setText(selectedHotel.getName());
        hotelInfo.setText(selectedHotel.getDescription());
    }

    public void setHotelNum(int hotelNum) {
        this.hotelNum = hotelNum;
    }
    
    public void setSearchInfo(String startDate, String endDate, String guests) {
        this.currStartDate = startDate;
        this.currEndDate = endDate;
        this.currGuests = guests;
        fromDateLabel.setText(currStartDate);
        toDateLabel.setText(currEndDate);
        if (guests.equals(1)) {
            numGuestsLabel.setText(currGuests + " gestur");
        } else {
            numGuestsLabel.setText(currGuests + " gestir");
        }
    }
    
     private void newBookingScene( ActionEvent event) throws IOException {
        bookButtonAction(event);
    }
     
    @FXML
    private void bookButtonAction(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("bokunUppl.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        
        BokunUpplController display = loader.getController();
        display.setSearchInfo(currStartDate, currEndDate, currGuests);
        display.setHotelName(selectedHotel.getName());
        
        stage.show();
    }
    
    @FXML
    private void searchButtonAction(ActionEvent event) throws IOException {
        String searchStringText = searchString.getText();
        startDateString = dateToString(startDate);
        endDateString = dateToString(endDate);
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
        display.setSearchInfo(startDateString, endDateString, guests.getValue());
        
        
        stage.show();
    }
    
}

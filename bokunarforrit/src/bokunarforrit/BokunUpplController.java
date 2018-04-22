/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokunarforrit;

import controller.BookingController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vinnsla.Booking;
import vinnsla.Hotel;
import vinnsla.leit;

/**
 * FXML Controller class
 *
 * @author birgi
 */
public class BokunUpplController implements Initializable {

    @FXML
    private ImageView banner;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField adressTextField;
    @FXML
    private TextField postCodeTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField countryTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private Text hotelNafn;
    @FXML
    private Label fromDateLabel;
    @FXML
    private Label toDateLabel;
    @FXML
    private Label numGuestsLabel;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private Text errorMessage;

    private String currStartDate, currEndDate, currGuests, currHotelName, totalPrice;
    private Booking nyBokun = new Booking();
    private BookingController newBController = new BookingController();
    //private ArrayList<Booking> bookingList = new ArrayList<>();
    private Hotel hotelhotel = new Hotel();
    private leit leitleit = new leit();
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    // work in progress, for Booking part
    /*public ArrayList<Booking> getBookingList() {
        return bookingList;
    }*/
  
    
    @FXML
    private void confirmHandler(ActionEvent event) throws IOException{
        if (nameTextField.getText().isEmpty()) {
            errorMessage.setVisible(true);
        } else {
        
         // work in progress, for Booking part
        /*String hotel = hotelNafn.getText();
        int areaCode = hotelhotel.getAreaCode();
        String startDate = leitleit.getStartDate();
        String endDate = leitleit.getEndDate();
        int Guests = leitleit.getGuests();
        String fullName = nameTextField.getText();
        String address = adressTextField.getText();
        int zipCode = 10;
        String city = cityTextField.getText();
        String country = countryTextField.getText();
        String phoneNumber = phoneNumberTextField.getText(); 
        String email = emailTextField.getText();
        
        nyBokun.newBooking(hotel, areaCode, startDate, endDate, Guests, fullName, address, zipCode, city, country, phoneNumber, email);
        bookingList = newBController.newBooking(nyBokun);
        
        System.out.println(nyBokun.getHotel() + 
                           nyBokun.getAreaCode() +
                           nyBokun.getStartDate() +
                           nyBokun.getEndDate() +
                           nyBokun.getGuests() +
                           nyBokun.getFullName() +
                           nyBokun.getAddress() +
                           nyBokun.getZipCode() +
                           nyBokun.getCity() +
                           nyBokun.getCountry() +
                           nyBokun.getPhoneNumber() +
                           nyBokun.getEmail());*/
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("stadfesting.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        
        StadfestingController display = loader.getController();
        display.setHotelName(currHotelName);
        
        ((Node)event.getSource()).getScene().getWindow().hide();
        stage.setMaximized(true);
        stage.show();
        }
    }
    
    // seting booking information
    public void setSearchInfo(String startDate, String endDate, String guests, String totalPrice) {
        this.currStartDate = startDate;
        this.currEndDate = endDate;
        this.currGuests = guests;
        this.totalPrice = totalPrice;
        fromDateLabel.setText(currStartDate);
        toDateLabel.setText(currEndDate);
        totalPriceLabel.setText(totalPrice + "kr");
        if (guests.equals("1")) {
            numGuestsLabel.setText(currGuests + " gestur");
        } else {
            numGuestsLabel.setText(currGuests + " gestir");
        }
    }
    
    public void setHotelName(String hotelName) {
        this.currHotelName = hotelName;
        hotelNafn.setText(currHotelName);
    }
    
}

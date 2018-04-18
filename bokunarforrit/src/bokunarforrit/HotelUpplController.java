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
import javafx.scene.Node;
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
import javafx.scene.layout.VBox;
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
    @FXML
    private VBox hotelBox;
    
    //private LeitarNidController lnc = new LeitarNidController();
    private String currStartDate, currEndDate, currGuests;
    private String startDateString, endDateString;
    private String totalPriceString;
    private ArrayList<Hotel> hotelList = new ArrayList<>();
    private int hotelNum;
    private Hotel selectedHotel = new Hotel();
    private leit nyLeit = new leit();
    private SearchController newSController = new SearchController();
    private int numDays;
    private final ObservableList<String> stringNumList = FXCollections.observableArrayList("0","1","2","3","4");
    @FXML
    private ImageView wifiTrue;
    @FXML
    private ImageView wifiFalse;
    @FXML
    private ImageView poolTrue;
    @FXML
    private ImageView poolFalse;
    @FXML
    private ImageView breakfastTrue;
    @FXML
    private ImageView breakfastFalse;
    @FXML
    private ImageView handicapTrue;
    @FXML
    private ImageView handicapFalse;
    @FXML
    private ImageView gymTrue;
    @FXML
    private ImageView gymFalse;
    @FXML
    private ImageView star1;
    @FXML
    private ImageView star2;
    @FXML
    private ImageView star3;
    @FXML
    private ImageView star4;
    @FXML
    private ImageView star5;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        guests.setItems(stringNumList);
        //hotelImage.fitWidthProperty().bind(hotelBox.widthProperty());
    }    
    
    public void setSelectedHotel(Hotel selectedHotel) {
        this.selectedHotel = selectedHotel;
        Image image = new Image(selectedHotel.getPicturesLarge());
        //Image image = new Image("https://media-cdn.tripadvisor.com/media/photo-s/04/30/37/14/black-pearl-reykjavik.jpg");
        hotelImage.setImage(image);
        hotelName.setText(selectedHotel.getName());
        hotelInfo.setText(selectedHotel.getDescription());
        setFilters();
        setStars();
        //hotelImage.setFitWidth(hotelBox.getWidth());
    }

    public void setHotelNum(int hotelNum) {
        this.hotelNum = hotelNum;
    }
    
    public void setSearchInfo(String startDate, String endDate, String guests, String totalPriceString) {
        setDates(startDate, endDate);
        this.currGuests = guests;
        this.numDays = numDays;
        fromDateLabel.setText(currStartDate);
        toDateLabel.setText(currEndDate);
        if (guests.equals("1")) {
            numGuestsLabel.setText(currGuests + " gestur");
        } else {
            numGuestsLabel.setText(currGuests + " gestir");
        }
        totalPriceLabel.setText(totalPriceString + "kr");
        this.totalPriceString = totalPriceString;
    }
    
    private void setDates(String start, String end) {
        String string = start;
        String[] parts = start.split("-");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];
        switch (month) {
            case "01": month = "janúar";
                break;
            case "02": month = "febrúar";
                break;
            case "03": month = "mars";
                break;
            case "04": month = "apríl";
                break;
            case "05": month = "maí";
                break;
            case "06": month = "júní";
                break;
            case "07": month = "júlí";
                break;
            case "08": month = "ágúst";
                break;
            case "09": month = "september";
                break;
            case "10": month = "október";
                break;
            case "11": month = "nóvember";
                break;
            case "12": month = "desember";
                break;
        }
        this.currStartDate = day + "." + month + " " + year;
        string = end;
        parts = end.split("-");
        year = parts[0];
        month = parts[1];
        day = parts[2];
        switch (month) {
            case "01": month = "janúar";
                break;
            case "02": month = "febrúar";
                break;
            case "03": month = "mars";
                break;
            case "04": month = "apríl";
                break;
            case "05": month = "maí";
                break;
            case "06": month = "júní";
                break;
            case "07": month = "júlí";
                break;
            case "08": month = "ágúst";
                break;
            case "09": month = "september";
                break;
            case "10": month = "október";
                break;
            case "11": month = "nóvember";
                break;
            case "12": month = "desember";
                break;
        }
        this.currEndDate = day + "." + month + " " + year;
    }
    
     private void newBookingScene( ActionEvent event) throws IOException { // EEYYYYYYÐÐÐÐÐAÐAAAAA?????????
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
        display.setSearchInfo(currStartDate, currEndDate, currGuests, totalPriceString);
        display.setHotelName(selectedHotel.getName());
        
        ((Node)event.getSource()).getScene().getWindow().hide();
        stage.setMaximized(true);
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
    
    private void setFilters() {
        if (selectedHotel.isWiFi()) {
            wifiTrue.setVisible(true);
            wifiTrue.setFitWidth(30);
        } else {
            wifiFalse.setVisible(true);
            wifiFalse.setFitWidth(30);
        }
        
        if (selectedHotel.isSwimmingPool()) {
            poolTrue.setVisible(true);
            poolTrue.setFitWidth(30);
        } else {
            poolFalse.setVisible(true);
            poolFalse.setFitWidth(30);
        }
        
        if (selectedHotel.isBreakfast()) {
            breakfastTrue.setVisible(true);
            breakfastTrue.setFitWidth(30);
        } else {
            breakfastFalse.setVisible(true);
            breakfastFalse.setFitWidth(30);
        }
        
        if (selectedHotel.isHandicapFacilities()) {
            handicapTrue.setVisible(true);
            handicapTrue.setFitWidth(30);
        } else {
            handicapFalse.setVisible(true);
            handicapFalse.setFitWidth(30);
        }
        
        if (selectedHotel.isGym()) {
            gymTrue.setVisible(true);
            gymTrue.setFitWidth(30);
        } else {
            gymTrue.setVisible(true);
            gymTrue.setFitWidth(30);
        }
    }
    
    private void setStars() {
        int stars = selectedHotel.getStarRating();
        switch(stars) {
            case 1: star1.setFitWidth(30);
                    break;
            case 2: star1.setFitWidth(30); 
                    star2.setFitWidth(30);
                    break;
            case 3: star1.setFitWidth(30); 
                    star2.setFitWidth(30); 
                    star3.setFitWidth(30);
                    break;
            case 4: star1.setFitWidth(30); 
                    star2.setFitWidth(30);
                    star3.setFitWidth(30); 
                    star4.setFitWidth(30);
                    break;
            case 5: star1.setFitWidth(30); 
                    star2.setFitWidth(30);
                    star3.setFitWidth(30);
                    star4.setFitWidth(30); 
                    star5.setFitWidth(30);
                    break;
            }
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
        display.setSearchInfo(startDateString, endDateString, guests.getValue(), numDays);
        display.setHotelList(hotelList);
        
        ((Node)event.getSource()).getScene().getWindow().hide();
        stage.setMaximized(true);
        stage.show();
    }
    
    @FXML
    private void bannerClicked(MouseEvent event) throws IOException {
        newHomePage(event);
    }
    
    public void newHomePage(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        
        ((Node)event.getSource()).getScene().getWindow().hide();
        stage.setMaximized(true);
        stage.show();
    }
    
}

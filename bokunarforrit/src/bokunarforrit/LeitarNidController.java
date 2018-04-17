/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokunarforrit;

import controller.SearchController;
import java.io.IOException;
import javafx.geometry.Insets;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vinnsla.Hotel;
import vinnsla.leit;

/**
 * FXML Controller class
 *
 * @author Birgir Snorrason
 */
public class LeitarNidController implements Initializable {

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
    private ImageView star1;
    @FXML
    private ImageView star2;
    @FXML
    private ImageView star3;
    @FXML
    private ImageView star4;
    @FXML
    private ImageView star5;
    @FXML
    private VBox hotelVbox;
    @FXML
    private CheckBox wifiCB;
    @FXML
    private CheckBox poolCB;
    @FXML
    private CheckBox handicapCB;
    @FXML
    private CheckBox gymCB;
    
    private int numOfClickedHotel;
    private leit nyLeit = new leit();
    private SearchController newSController = new SearchController();
    private ArrayList<Hotel> hotelList = new ArrayList<>();
    private Hotel selectedHotel = new Hotel();
    private String currStartDate, currEndDate, currGuests;
    private String startDateString, endDateString;
    private int currStarRating = 0;
    
    private final ObservableList<String> stringNumList = FXCollections.observableArrayList("0","1","2","3","4");
    @FXML
    private CheckBox breakfastCB;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        guests.setItems(stringNumList);
    }
    
    private void newHotelHBox(int hotelNum) {
        selectedHotel = hotelList.get(hotelNum);
            Text hotelText = new Text(selectedHotel.getName());
            Label hotelInfo = new Label(selectedHotel.getDescription());
            hotelInfo.setWrapText(true);
            hotelInfo.setMaxWidth(300);
            VBox vboxHotel = new VBox();
            VBox.setMargin(hotelText, new Insets(10,10,10,10));
            VBox.setMargin(hotelInfo, new Insets(0,10,10,10));
            vboxHotel.getChildren().addAll(hotelText, hotelInfo);
            /*
            Image imgage = new Image(selectedHotel.getPictures());
            ImageView img = new ImageView(imgage);
            */
            ImageView img = new ImageView("https://media-cdn.tripadvisor.com/media/photo-s/04/30/37/14/black-pearl-reykjavik.jpg");
            
            img.setFitWidth(200);
            img.setFitHeight(150);
            HBox hbox = new HBox();
            hbox.getChildren().addAll(vboxHotel, img);
            HBox.setMargin(img, new Insets(10,10,10,10));
            hbox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
             + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
             + "-fx-border-radius: 2;" + "-fx-border-color: lightgreen;");
            newHBoxHandler(hbox, hotelNum);
            hotelVbox.getChildren().addAll(hbox);
    }
    
    private void newHBoxHandler(HBox hbox, int hotelNum) {
        numOfClickedHotel = hotelNum;
        selectedHotel = hotelList.get(hotelNum);
        hbox.setOnMouseClicked((MouseEvent event) -> {
            try {
                newHotelPage(hotelNum, event);
            } catch (IOException ex) {
                Logger.getLogger(LeitarNidController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void newHotelPage(int hotelNum, MouseEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("hotelUppl.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        
        HotelUpplController display = loader.getController();
        display.setSelectedHotel(hotelList.get(hotelNum));
        display.setSearchInfo(currStartDate, currEndDate, currGuests);
        
        stage.show();
        
    }

    public void setHotelList(ArrayList<Hotel> hotelList) {
        this.hotelList = hotelList;
        int n = hotelList.size();
        for (int i=0; i<n; i++) {
            newHotelHBox(i);
        }
    }
    
    private void filterHotelList() {
        for (int i=0; i<hotelList.size(); i++) {
            if (wifiCB.isSelected() && hotelList.get(i).isWiFi()==false) {
            } else if (poolCB.isSelected() && hotelList.get(i).isSwimmingPool()==false) {
            } else if (breakfastCB.isSelected() && hotelList.get(i).isBreakfast()==false) {
            } else if (handicapCB.isSelected() && hotelList.get(i).isHandicapFacilities()==false) {
            } else if (gymCB.isSelected() && hotelList.get(i).isGym()==false) {
            } else if (currStarRating > hotelList.get(i).getStarRating()) {
            } else {
                newHotelHBox(i);
            }
        }
    }
    
    public void setSearchInfo(String startDate, String endDate, String guests) {
        this.currStartDate = startDate;
        this.currEndDate = endDate;
        this.currGuests = guests;
    }
    
    public ArrayList<Hotel> getHotelList() {
        return hotelList;
    }
    
    public int getNumOfClickedHotel() {
        return numOfClickedHotel;
    }

    @FXML
    private void star1MouseClicked(MouseEvent event) {
        star1.setOpacity(1);
        star2.setOpacity(0.3);
        star3.setOpacity(0.3);
        star4.setOpacity(0.3);
        star5.setOpacity(0.3);
        currStarRating = 1;
        hotelVbox.getChildren().clear();
        filterHotelList();
    }

    @FXML
    private void star2MouseClicked(MouseEvent event) {
        star1.setOpacity(1);
        star2.setOpacity(1);
        star3.setOpacity(0.3);
        star4.setOpacity(0.3);
        star5.setOpacity(0.3);
        currStarRating = 2;
        hotelVbox.getChildren().clear();
        filterHotelList();
    }
    
    @FXML
    private void star3MouseClicked(MouseEvent event) {
        star1.setOpacity(1);
        star2.setOpacity(1);
        star3.setOpacity(1);
        star4.setOpacity(0.3);
        star5.setOpacity(0.3);
        currStarRating = 3;
        hotelVbox.getChildren().clear();
        filterHotelList();
    }

    @FXML
    private void star4MouseClicked(MouseEvent event) {
        star1.setOpacity(1);
        star2.setOpacity(1);
        star3.setOpacity(1);
        star4.setOpacity(1);
        star5.setOpacity(0.3);
        currStarRating = 4;
        hotelVbox.getChildren().clear();
        filterHotelList();
    }

    @FXML
    private void star5MouseClicked(MouseEvent event) {
        star1.setOpacity(1);
        star2.setOpacity(1);
        star3.setOpacity(1);
        star4.setOpacity(1);
        star5.setOpacity(1);
        currStarRating = 5;
        hotelVbox.getChildren().clear();
        filterHotelList();
    }   

    @FXML
    private void bannerClicked(MouseEvent event) throws IOException {
        newHomePage(event);
    }
    
    public void newHomePage(MouseEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homePageScene);
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

    @FXML
    private void wifiHandler(ActionEvent event) {
        hotelVbox.getChildren().clear();
        filterHotelList();
    }

    @FXML
    private void poolHandler(ActionEvent event) {
        hotelVbox.getChildren().clear();
        filterHotelList();
    }

    @FXML
    private void breakfastHandler(ActionEvent event) {
        hotelVbox.getChildren().clear();
        filterHotelList();
    }

    @FXML
    private void handicapHandler(ActionEvent event) {
        hotelVbox.getChildren().clear();
        filterHotelList();
    }

    @FXML
    private void gymHandler(ActionEvent event) {
        hotelVbox.getChildren().clear();
        filterHotelList();
    }

}

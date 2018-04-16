/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokunarforrit;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import vinnsla.Hotel;

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
    private ComboBox<?> guests;
    @FXML
    private Button searchButton;
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
    private ArrayList<Hotel> hotelList = new ArrayList<>();
    private int hotelNum;
    private Hotel selectedHotel = new Hotel();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(selectedHotel.getDescription());
        //hotelList = lnc.getHotelList();
        //hotelNum = lnc.getNumOfClickedHotel();
        //selectedHotel = hotelList.get(hotelNum);
        //Image image = new Image(selectedHotel.getPictures());
        //hotelImage.setImage(image);
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
    
    @FXML
    private void bookButtonAction(ActionEvent event) {
    }
    
}

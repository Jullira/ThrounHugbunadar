/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokunarforrit;

import java.io.IOException;
import javafx.geometry.Insets;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vinnsla.Hotel;

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
    private Button searchButton;
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
    
    private int numOfClickedHotel;
    private ArrayList<Hotel> hotelList = new ArrayList<>();
    //private Hotel Hotel1 = new Hotel();
    //private Hotel Hotel2 = new Hotel();
    //private Hotel Hotel3 = new Hotel();
    //private Hotel Hotel4 = new Hotel();
    private Hotel selectedHotel = new Hotel();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    /*
    private void createFakeHotelList() {
        Hotel1.newHotel("name", "address", "city", 101, "description", "https://media-cdn.tripadvisor.com/media/photo-s/04/30/37/14/black-pearl-reykjavik.jpg", 10 ,5, true, true, true, true, true, 1, "roomTableName", "reviewTableName");
        hotelList.add(Hotel1);
        Hotel2.newHotel("name", "address", "city", 101, "description", "https://media-cdn.tripadvisor.com/media/photo-s/04/30/37/14/black-pearl-reykjavik.jpg", 10 ,5, true, true, true, true, true, 1, "roomTableName", "reviewTableName");
        hotelList.add(Hotel2);
        Hotel3.newHotel("name", "address", "city", 101, "description", "https://media-cdn.tripadvisor.com/media/photo-s/04/30/37/14/black-pearl-reykjavik.jpg", 10 ,5, true, true, true, true, true, 1, "roomTableName", "reviewTableName");
        hotelList.add(Hotel3);
        Hotel4.newHotel("name", "address", "city", 101, "description", "https://media-cdn.tripadvisor.com/media/photo-s/04/30/37/14/black-pearl-reykjavik.jpg", 10 ,5, true, true, true, true, true, 1, "roomTableName", "reviewTableName");
        hotelList.add(Hotel4);
    }
    */
    
    private void newHotelHBox(int hotelNum) {
        System.out.print(hotelList.get(0));
        selectedHotel = hotelList.get(hotelNum);
            Text hotelText = new Text(selectedHotel.getName());
            Label hotelInfo = new Label(selectedHotel.getDescription());
            hotelInfo.setWrapText(true);
            hotelInfo.setMaxWidth(300);
            VBox vboxHotel = new VBox();
            VBox.setMargin(hotelText, new Insets(10,10,10,10));
            VBox.setMargin(hotelInfo, new Insets(0,10,10,10));
            vboxHotel.getChildren().addAll(hotelText, hotelInfo);
            //ImageView img = new ImageView(selectedHotel.getPictures());
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
                newHotelScene(hotelNum, event);
            } catch (IOException ex) {
                Logger.getLogger(LeitarNidController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void newHotelScene(int hotelNum, MouseEvent event) throws IOException {
        //System.out.println("newHotelScene #" + hotelNum);
        newHotelPage(event);
    }
    
    private void newHotelPage(MouseEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("hotelUppl.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        
        HotelUpplController display = loader.getController();
        display.setSelectedHotel(selectedHotel);
        System.out.print(selectedHotel.getName());
        
        stage.show();
        /*
        Parent homePage = FXMLLoader.load(getClass().getResource("hotelUppl.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homePageScene);
        stage.show();
*/
        
    }

    public void setHotelList(ArrayList<Hotel> hotelList) {
        this.hotelList = hotelList;
        int n = hotelList.size();
        for (int i=0; i<n; i++) {
            newHotelHBox(i);
            System.out.println(hotelList.get(i).getName() + "aa");
        }
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
    }

    @FXML
    private void star2MouseClicked(MouseEvent event) {
        star1.setOpacity(1);
        star2.setOpacity(1);
        star3.setOpacity(0.3) ;
        star4.setOpacity(0.3);
        star5.setOpacity(0.3);
    }
    
    @FXML
    private void star3MouseClicked(MouseEvent event) {
        star1.setOpacity(1);
        star2.setOpacity(1);
        star3.setOpacity(1);
        star4.setOpacity(0.3);
        star5.setOpacity(0.3);
    }

    @FXML
    private void star4MouseClicked(MouseEvent event) {
        star1.setOpacity(1);
        star2.setOpacity(1);
        star3.setOpacity(1);
        star4.setOpacity(1);
        star5.setOpacity(0.3);
    }

    @FXML
    private void star5MouseClicked(MouseEvent event) {
        star1.setOpacity(1);
        star2.setOpacity(1);
        star3.setOpacity(1);
        star4.setOpacity(1);
        star5.setOpacity(1);
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

}

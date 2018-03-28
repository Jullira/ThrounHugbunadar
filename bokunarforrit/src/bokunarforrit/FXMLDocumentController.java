/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokunarforrit;

import controller.SearchController;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vinnsla.leit;
import vinnsla.DatabaseConnection;

/**
 *
 * @author birgi
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField searchString;
    @FXML
    private ImageView banner;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private Button searchButton;
    @FXML
    private Text errorMessage;
    @FXML
    private ComboBox<String> adults;
    @FXML
    private ComboBox<String> children;
    
    
    private leit nyLeit = new leit();
    
    private SearchController newSController = new SearchController();
    
    private final ObservableList<String> stringNumList = FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        adults.setItems(stringNumList);
        children.setItems(stringNumList);
    }

    @FXML
    private void searchButtonAction(ActionEvent event) throws IOException {
        if (searchString.getText() == null || searchString.getText().trim().isEmpty()) {
            errorMessage.setText("Þú verður að fylla út í leitarstrenginn kjáni");
            return;
        }
        if (startDate.getValue() == null || endDate.getValue() == null) {
            errorMessage.setText("Þú verður að fylla út í dagsettningarnar kjáni");
            return;
        }
        if (adults.getValue() == null || children.getValue() == null) {
            errorMessage.setText("Þú verður að fylla út fjölda fólks kjáni");
            return;
        }
        
        String searchStringText = searchString.getText();
        String startDateString = dateToString(startDate);
        String endDateString = dateToString(endDate);
        int adultInt = Integer.parseInt(adults.getValue());
        int childrenInt = Integer.parseInt(children.getValue());
        int persons = adultInt + childrenInt;
        
        nyLeit.newSearch(searchStringText, startDateString, endDateString, adultInt, childrenInt);
        newLeitPage(event);
        
        newSController.searchHotels(nyLeit);
        
    }
    

    @FXML
    private void searchStringAction(MouseEvent event) {
        searchString.setText("");
    }

    @FXML
    private void bannerMouseClick(MouseEvent event) throws IOException {
        newHomePage(event);
    }
    
    private String dateToString(DatePicker date) {
        LocalDate ld = date.getValue();
        return ld.toString();
    }
    
    public void newHomePage(MouseEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homePageScene);
        stage.show();
    }
    
    public void newLeitPage(ActionEvent event) throws IOException {
        Parent leitarNidParent = FXMLLoader.load(getClass().getResource("leitarNid.fxml"));
        Scene leitarNidScene = new Scene(leitarNidParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(leitarNidScene);
        stage.show();
        
        //vinnuTextiLeit.setText(nyLeit.getSearchString());
    }
    
    
    
}

import controller.SearchController;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import vinnsla.leit;

public class SearchControllerTest {
    
    private String startDate;
    private String endDate;
    private int adultGuests;
    private int childrenGuests;
    private String searchString;
    leit nyLeit = new leit();
    private SearchController sController = new SearchController();
    
    @Before
    public void setUp() {
        startDate = "2019-04-04";
        endDate = "2019-04-12";
        adultGuests = 2;
        childrenGuests = 2;
        searchString = "Hotel Borg";
    }
    
    @After
    public void tearDown() {
        startDate = null;
        endDate = null;
        adultGuests = null;
        childrenGuests = null;
        searchString = null;
    }
    
    // profad med rettum gognum
    @Test
    public void testCorrect() {
        setUp();
        nyLeit.newSearch(searchString, startDate, endDate, adultGuests, childrenGuests);
        sController.searchHotels(nyLeit);        
        tearDown();
    }
    
    // leitarstrengur passar engan veginn vid hotel
    @Test
    public void testSearchString() {
        setUp();
        
        searchString = "lfkdjgnis";
        nyLeit.newSearch(searchString, startDate, endDate, adultGuests, childrenGuests);
        sController.searchHotels(nyLeit);
        tearDown();
        
        setUp();
        
        searchString = "Ö$%FDS123&&&&&";
        nyLeit.newSearch(searchString, startDate, endDate, adultGuests, childrenGuests);
        sController.searchHotels(nyLeit);
        tearDown();
        
        setUp();
        
        searchString = "Shanghai";
        nyLeit.newSearch(searchString, startDate, endDate, adultGuests, childrenGuests);
        sController.searchHotels(nyLeit);
        tearDown();
        
    }
    
    // fjoldi meiri en 24 eða minna en 1
    // eða 0
    @Test
    public void testPersons() {
        setUp();
        
        adultGuests = 15;
        childrenGuests = 20;
        nyLeit.newSearch(searchString, startDate, endDate, adultGuests, childrenGuests);
        sController.searchHotels(nyLeit);
        tearDown();
        
        setUp();
        
        adultGuests = 0;
        childrenGuests = 0;
        nyLeit.newSearch(searchString, startDate, endDate, adultGuests, childrenGuests);
        sController.searchHotels(nyLeit);
        tearDown();
    }
    
    // Dagsetning fyrir 01.01.2019
    @Test
    public void testEarlyStartDate() {
        setUp();
        
        startDate = "2018-04-04";
        nyLeit.newSearch(searchString, startDate, endDate, adultGuests, childrenGuests);
        sController.searchHotels(nyLeit);
        tearDown();
    }
    
    // Dagsetning eftir 31.12.2019
    @Test
    public void testLateEndDate() {
        setUp();
        
        endDate = "2020-04-04";
        nyLeit.newSearch(searchString, startDate, endDate, adultGuests, childrenGuests);
        sController.searchHotels(nyLeit);
        tearDown();
    }
    
}


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gretabjorg
 */
public class DatabaseConnectionMock {
    
    private String searchString;
    private String startDate;
    private String endDate;
    private int adultGuests;
    private int childrenGuests;
    private int persons;
    private ArrayList<String> results = new ArrayList<>();
    
    public ArrayList<String> DatabaseConnectionMock(String searchString, String startDate, String endDate, int adultGuests, int childrenGuests) {
        this.searchString = searchString;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adultGuests = adultGuests;
        this.childrenGuests = childrenGuests;
        this.persons = this.adultGuests + this.childrenGuests;
    
        //Test 1:

        if (this.persons <= 0)
        {
            results.add("Number of guests must be greater than zero.");
            return this.results;
        }
    
        if (this.persons > 24)
        {
            this.results.add("Number of guests exceeds hotel capacity.");
            return results;
        }
        
        //Test 2:

        if (this.startDate == "2018-04-04")
        {
            this.results.add("This date has passed.");
            return this.results;
        }

        if (this.endDate == "2020-04-04")
        {
            this.results.add("This date has not been opened for booking yet.");
            return this.results;
        }

        //Test 3:

        if (this.searchString == "lfkdjgnis" || this.searchString == "Ö$%FDS123&&&&&" || this.searchString == "Shanghai")
        {
            this.results.add("No hotel found with this name or similar.");
            return this.results;
        }
        
        if (this.searchString == "Hotel Borg" && this.persons == 4 && this.startDate == "2019-04-04" && this.endDate == "2019-04-12")
        {
            this.results.add("Hotel Borg 1");
            this.results.add("Hotel Borg 2");
            this.results.add("Hotel Borg 3");
        }
        
        return this.results;
    }    
}

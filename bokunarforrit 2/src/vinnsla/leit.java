/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;


/**
 *
 * @author birgi
 */
public class leit {
    private String searchString;
    private String startDate;
    private String endDate;
    private int adultGuests;
    private int childrenGuests;
    
    public void newSearch(String searchString, String startDate, String endDate, int adultGuests, int childrenGuests) {
        this.searchString = searchString;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adultGuests = adultGuests;
        this.childrenGuests = childrenGuests;
    }

    public String getSearchString() {
        return searchString;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getAdultGuests() {
        return adultGuests;
    }

    public int getChildrenGuests() {
        return childrenGuests;
    }
}

    
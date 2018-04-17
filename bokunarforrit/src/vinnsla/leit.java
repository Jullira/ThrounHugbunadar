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
    private int guests;
    private static String staticStartDate;
    private static String staticEndDate;
    private static int staticGuests;
    
    public void newSearch(String searchString, String startDate, String endDate, int guests) {
        this.searchString = searchString;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guests = guests;
        leit.staticGuests = guests;
        leit.staticEndDate = endDate;
        leit.staticStartDate = startDate;
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

    public int getGuests() {
        return guests;
    }

    public static String getStaticStartDate() {
        return staticStartDate;
    }

    public static String getStaticEndDate() {
        return staticEndDate;
    }

    public static int getStaticGuests() {
        return staticGuests;
    }
    
}

    
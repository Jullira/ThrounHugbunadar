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
    
    private String startDate;
    private String endDate;
    private int adultGuests;
    private int childrenGuests;
    private int persons;
    
    public DatabaseConnectionMock(String startDate, String endDate, int adultGuests, int childrenGuests, int persons) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.adultGuests = adultGuests;
        this.childrenGuests = childrenGuests;
        this.persons = persons;
    }

    
//Próf 1:

/*if (persons <= 0)
{
    results.add("Number of guests must be greater than zero.");
    return results;
}

if (persons > 24)
{
    results.add("Number of guests exceeds hotel capacity.");
    return results;
}*/

//Próf 2:

/*if (startDate == "of snemma")
{
    results.add("This date has passed.");
    return results;
}

if (endDate == "of seint")
{
    results.add("This date has not been opened for booking yet.");
    return results;
}*/

//Próf 3:

/*if (searchString == "Grinvucesmnr")
{
    results.add("No hotel found with this name or similar.");
    return results;
}*/

//Próf 4:


/*if (areaCode != 105)
{
    results.add("No hotel found in this area.");
    return results;
}*/


    
}

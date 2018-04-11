/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gretabjorg
 */
public class DatabaseConnection {
    
    private final ArrayList<String> hotels = new ArrayList<>();
    private final ArrayList<String> cities = new ArrayList<>();
    private final ArrayList<Integer> postCodes = new ArrayList<>();
    
    public DatabaseConnection()
    {
        // Create manually, for now, the list of hotels, this will be improved
        // once the option to create hotels is implemented
        hotels.add("Hlemmur Square");
        hotels.add("HlemmurSquare");
        hotels.add("Hotel Borg");
        hotels.add("Hótel Borg");
        hotels.add("HotelBorg");
        hotels.add("HótelBorg");
        hotels.add("Black Pearl Apartment Hotel");
        hotels.add("BlackPearlApartmentHotel");
        hotels.add("Akureyri Backpackers");
        hotels.add("AkureyriBackpackers");
        hotels.add("Icelandair Hotel Akureyri");
        hotels.add("IcelandairHotelAkureyri");
        hotels.add("Guesthouse Olga");
        hotels.add("GuesthouseOlga");
        hotels.add("Black Beach Suites");
        hotels.add("BlackBeachSuites");
        hotels.add("Hotel Isafjordur");
        hotels.add("Hótel Ísafjörður");
        hotels.add("HotelIsafjordur");
        hotels.add("HótelÍsafjörður");
        hotels.add("Puffin Nest Capsule Hostel");
        hotels.add("PuffinNestCapsuleHostel");
        hotels.add("Hotel Ork");
        hotels.add("Hótel Örk");
        hotels.add("HotelOrk");
        hotels.add("HótelÖrk");
        
        // Create the list of cities that could have a hotel
        cities.add("Reykjavik");
        cities.add("Reykjavík");
        cities.add("Kopavogur");
        cities.add("Kópavogur");
        cities.add("Seltjarnarnes");
        cities.add("Vogar");
        cities.add("Garðabær");
        cities.add("Gardabaer");
        cities.add("Hafnarfjordur");
        cities.add("Hafnarfjörður");
        cities.add("Reykjanesbaer");
        cities.add("Reykjanesbær");
        cities.add("Grindavik");
        cities.add("Grindavík");
        cities.add("Sandgerdi");
        cities.add("Sandgerði");
        cities.add("Gardur");
        cities.add("Garður");
        cities.add("Mosfellsbaer");
        cities.add("Mosfellsbær");
        cities.add("Kjos");
        cities.add("Kjós");
        cities.add("Akranes");
        cities.add("Borgarnes");
        cities.add("Reykholt");
        cities.add("Stykkisholmur");
        cities.add("Stykkishólmur");
        cities.add("Flatey");
        cities.add("Grundarfjordur");
        cities.add("Grundarfjörður");
        cities.add("Olafsvik");
        cities.add("Ólafsvík");
        cities.add("Snaefellsbaer");
        cities.add("Snæfellsbær");
        cities.add("Hellissandur");
        cities.add("Budardalur");
        cities.add("Búðardalur");
        cities.add("Reykholahreppur");
        cities.add("Reykhólahreppur");
        cities.add("Isafjordur");
        cities.add("Ísafjörður");
        cities.add("Hnifsdalur");
        cities.add("Hnífsdalur");
        cities.add("Bolungarvik");
        cities.add("Bolungarvík");
        cities.add("Sudavik");
        cities.add("Súðavík");
        cities.add("Flateyri");
        cities.add("Sudureyri");
        cities.add("Suðureyri");
        cities.add("Patreksfjordur");
        cities.add("Patreksfjörður");
        cities.add("Talknafjordur");
        cities.add("Tálknafjörður");
        cities.add("Bildudalur");
        cities.add("Bíldudalur");
        cities.add("Thingeyri");
        cities.add("Þingeyri");
        cities.add("Stadur");
        cities.add("Staður");
        cities.add("Holmavik");
        cities.add("Hólmavík");
        cities.add("Drangsnes");
        cities.add("Arneshreppur");
        cities.add("Árneshreppur");
        cities.add("Hvammstangi");
        cities.add("Blonduos");
        cities.add("Blönduós");
        cities.add("Skagastrond");
        cities.add("Skagaströnd");
        cities.add("Saudarkrokur");
        cities.add("Sauðárkrókur");
        cities.add("Varmahlid");
        cities.add("Varmahlíð");
        cities.add("Hofsos");
        cities.add("Hofsós");
        cities.add("Fljot");
        cities.add("Fljót");
        cities.add("Siglufjordur");
        cities.add("Siglufjörður");
        cities.add("Akureyri");
        cities.add("Grenivik");
        cities.add("Grenivík");
        cities.add("Grimsey");
        cities.add("Grímsey");
        cities.add("Dalvik");
        cities.add("Dalvík");
        cities.add("Olafsfjordur");
        cities.add("Ólafsfjörður");
        cities.add("Hrisey");
        cities.add("Hrísey");
        cities.add("Husavik");
        cities.add("Húsavík");
        cities.add("Fossholl");
        cities.add("Fosshóll");
        cities.add("Laugar");
        cities.add("Myvatn");
        cities.add("Mývatn");
        cities.add("Kopasker");
        cities.add("Kópasker");
        cities.add("Kopaskeri");
        cities.add("Kópaskeri");
        cities.add("Raufarhofn");
        cities.add("Raufarhöfn");
        cities.add("Thorshofn");
        cities.add("Þórshöfn");
        cities.add("Bakkafjordur");
        cities.add("Bakkafjörður");
        cities.add("Vopnafjordur");
        cities.add("Vopnafjörður");
        cities.add("Egilsstadir");
        cities.add("Egilsstaðir");
        cities.add("Seydisfjordur");
        cities.add("Seyðisfjörður");
        cities.add("Mjoifjordur");
        cities.add("Mjóifjörður");
        cities.add("Borgarfjordur eystri");
        cities.add("Borgarfjörður eystri");
        cities.add("Reydarfjordur");
        cities.add("Reyðarfjörður");
        cities.add("Eskifjordur");
        cities.add("Eskifjörður");
        cities.add("Neskaupstadur");
        cities.add("Neskaupstaður");
        cities.add("Faskrudsfjordur");
        cities.add("Fáskrúðsfjörður");
        cities.add("Stodvarfjordur");
        cities.add("Stöðvarfjörður");
        cities.add("Breiddalsvik");
        cities.add("Breiðdalsvík");
        cities.add("Djupivogur");
        cities.add("Djúpivogur");
        cities.add("Hofn");
        cities.add("Höfn");
        cities.add("Oraefi");
        cities.add("Öræfi");
        cities.add("Selfoss");
        cities.add("Hveragerdi");
        cities.add("Hveragerði");
        cities.add("Thorlakshofn");
        cities.add("Þorlákshöfn");
        cities.add("Olfus");
        cities.add("Ölfus");
        cities.add("Eyrarbakki");
        cities.add("Stokkseyri");
        cities.add("Laugarvatn");
        cities.add("Fludir");
        cities.add("Flúðir");
        cities.add("Hella");
        cities.add("Hvolsvollur");
        cities.add("Hvolsvöllur");
        cities.add("Vik");
        cities.add("Vík");
        cities.add("Kirkjubaejarklaustur");
        cities.add("Kirkjubæjarklaustur");
        cities.add("Vestmannaeyjar");
    }
    
    private String makeQueryString(leit nyLeit){
        String query = "SELECT ";
        String searchStringText = nyLeit.getSearchString().replaceAll("\\s+","");
        String [] startDateParts = nyLeit.getStartDate().split("-");
        String startYear = startDateParts[0];
        String startMonth = startDateParts[1];
        String startDay;
        if(!"10".equals(startDateParts[2])){
            startDay = startDateParts[2].replaceFirst("0", "");
        }
        else {
            startDay = startDateParts[2];
        }
        
        String [] endDateParts = nyLeit.getEndDate().split("-");
        String endYear = endDateParts[0];
        String endMonth = endDateParts[1];
        String endDay = endDateParts[2];
        
        int persons = nyLeit.getAdultGuests() + nyLeit.getChildrenGuests();
        
        
        System.out.println(
            nyLeit.getSearchString() + 
            nyLeit.getStartDate() + 
            nyLeit.getEndDate() + 
            nyLeit.getAdultGuests() + 
            nyLeit.getChildrenGuests());
        
        boolean searchHotelName = false;
        for (int i = 0; i < hotels.size(); i++)
        {
            searchHotelName = checkContains(nyLeit.getSearchString(), hotels.get(i), searchHotelName);
        }
        
        if (searchHotelName)
        {
            // Temporary "hardcoded" SELECT command to have a placeholder while
            // other parts are worked on, only checks for start date and returns
            // the room numbers
            query = "SELECT RoomNumber FROM " + searchStringText + "RoomsAvailable" + startMonth + "19" + " WHERE RoomSize = " + persons + " AND Date" + startDay + " = 1;";
        }
        else
        {
            query += "Name, AreaCode FROM Hotels WHERE ";
            
            for (int i = 0; i < cities.size(); i++)
            {
                if (checkContains(nyLeit.getSearchString(), cities.get(i), false))
                {
                    switch (i) {
                        case 0: case 1:
                            postCodes.add(101);
                            postCodes.add(103);
                            postCodes.add(104);
                            postCodes.add(105);
                            postCodes.add(107);
                            postCodes.add(108);
                            postCodes.add(109);
                            postCodes.add(110);
                            postCodes.add(111);
                            postCodes.add(112);
                            postCodes.add(113);
                            postCodes.add(116);
                            break;
                        case 2: case 3:
                            postCodes.add(200);
                            postCodes.add(201);
                            postCodes.add(203);
                            break;
                        case 4:
                            postCodes.add(170);
                            break;
                        case 5:
                            postCodes.add(190);
                            break;
                        case 6: case 7:
                            postCodes.add(210);
                            postCodes.add(225);
                            break;
                        case 8: case 9:
                            postCodes.add(220);
                            postCodes.add(221);
                            break;
                        case 10: case 11:
                            postCodes.add(230);
                            postCodes.add(233);
                            postCodes.add(235);
                            postCodes.add(260);
                            break;
                        case 12: case 13:
                            postCodes.add(240);
                            break;
                        case 14: case 15:
                            postCodes.add(245);
                            break;
                        case 16: case 17:
                            postCodes.add(250);
                            break;
                        case 18: case 19:
                            postCodes.add(270);
                            postCodes.add(271);
                            break;
                        case 20: case 21:
                            postCodes.add(276);
                            break;
                        case 22:
                            postCodes.add(300);
                            postCodes.add(301);
                            break;
                        case 23:
                            postCodes.add(310);
                            break;
                        case 24:
                            postCodes.add(320);
                            break;
                        case 25: case 26:
                            postCodes.add(340);
                            break;
                        case 27:
                            postCodes.add(345);
                            break;
                        case 28: case 29:
                            postCodes.add(350);
                            break;
                        case 30: case 31:
                            postCodes.add(355);
                            break;
                        case 32: case 33:
                            postCodes.add(356);
                            break;
                        case 34:
                            postCodes.add(360);
                            break;
                        case 35: case 36:
                            postCodes.add(370);
                            postCodes.add(371);
                            break;
                        case 37: case 38:
                            postCodes.add(380);
                            break;
                        case 39: case 40:
                            postCodes.add(400);
                            postCodes.add(401);
                            break;
                        case 41: case 42:
                            postCodes.add(410);
                            break;
                        case 43: case 44:
                            postCodes.add(415);
                            break;
                        case 45: case 46:
                            postCodes.add(420);
                            break;
                        case 47:
                            postCodes.add(425);
                            break;
                        case 48: case 49:
                            postCodes.add(430);
                            break;
                        case 50: case 51:
                            postCodes.add(450);
                            postCodes.add(451);
                            break;
                        case 52: case 53:
                            postCodes.add(460);
                            break;
                        case 54: case 55:
                            postCodes.add(465);
                            break;
                        case 56: case 57:
                            postCodes.add(470);
                            postCodes.add(471);
                            break;
                        case 58: case 59:
                            postCodes.add(500);
                            break;
                        case 60: case 61:
                            postCodes.add(510);
                            postCodes.add(512);
                            break;
                        case 62:
                            postCodes.add(520);
                            break;
                        case 63: case 64:
                            postCodes.add(524);
                            break;
                        case 65:
                            postCodes.add(530);
                            postCodes.add(531);
                            break;
                        case 66: case 67:
                            postCodes.add(540);
                            postCodes.add(541);
                            break;
                        case 68: case 69:
                            postCodes.add(545);
                            break;
                        case 70: case 71:
                            postCodes.add(550);
                            postCodes.add(551);
                            break;
                        case 72: case 73:
                            postCodes.add(560);
                            break;
                        case 74: case 75:
                            postCodes.add(565);
                            postCodes.add(566);
                            break;
                        case 76: case 77:
                            postCodes.add(570);
                            break;
                        case 78: case 79:
                            postCodes.add(580);
                            break;
                        case 80:
                            postCodes.add(600);
                            postCodes.add(601);
                            postCodes.add(602);
                            postCodes.add(603);
                            break;
                        case 81: case 82:
                            postCodes.add(610);
                            break;
                        case 83: case 84:
                            postCodes.add(611);
                            break;
                        case 85: case 86:
                            postCodes.add(620);
                            postCodes.add(621);
                            break;
                        case 87: case 88:
                            postCodes.add(625);
                            break;
                        case 89: case 90:
                            postCodes.add(630);
                            break;
                        case 91: case 92:
                            postCodes.add(640);
                            postCodes.add(641);
                            break;
                        case 93: case 94:
                            postCodes.add(645);
                            break;
                        case 95:
                            postCodes.add(650);
                            break;
                        case 96: case 97:
                            postCodes.add(660);
                            break;
                        case 98: case 99: case 100: case 101:
                            postCodes.add(670);
                            postCodes.add(671);
                            break;
                        case 102: case 103:
                            postCodes.add(675);
                            break;
                        case 104: case 105:
                            postCodes.add(680);
                            postCodes.add(681);
                            break;
                        case 106: case 107:
                            postCodes.add(685);
                            break;
                        case 108: case 109:
                            postCodes.add(690);
                            break;
                        case 110: case 111:
                            postCodes.add(700);
                            postCodes.add(701);
                            break;
                        case 112: case 113:
                            postCodes.add(710);
                            break;
                        case 114: case 115:
                            postCodes.add(715);
                            break;
                        case 116: case 117:
                            postCodes.add(720);
                            break;
                        case 118: case 119:
                            postCodes.add(730);
                            break;
                        case 120: case 121:
                            postCodes.add(735);
                            break;
                        case 122: case 123:
                            postCodes.add(740);
                            break;
                        case 124: case 125:
                            postCodes.add(750);
                            break;
                        case 126: case 127:
                            postCodes.add(755);
                            break;
                        case 128: case 129:
                            postCodes.add(760);
                            break;
                        case 130: case 131:
                            postCodes.add(765);
                            break;
                        case 132: case 133:
                            postCodes.add(780);
                            postCodes.add(781);
                            break;
                        case 134: case 135:
                            postCodes.add(785);
                            break;
                        case 136:
                            postCodes.add(800);
                            postCodes.add(801);
                            break;
                        case 137: case 138:
                            postCodes.add(810);
                            break;
                        case 139: case 140:
                            postCodes.add(815);
                            break;
                        case 141: case 142:
                            postCodes.add(816);
                            break;
                        case 143:
                            postCodes.add(820);
                            break;
                        case 144:
                            postCodes.add(825);
                            break;
                        case 145:
                            postCodes.add(840);
                            break;
                        case 146: case 147:
                            postCodes.add(845);
                            break;
                        case 148:
                            postCodes.add(850);
                            postCodes.add(851);
                            break;
                        case 149: case 150:
                            postCodes.add(860);
                            postCodes.add(861);
                            break;
                        case 151: case 152:
                            postCodes.add(870);
                            postCodes.add(871);
                            break;
                        case 153: case 154:
                            postCodes.add(880);
                            break;
                        case 155:
                            postCodes.add(900);
                            break;
                    }
                }
            }
            
            if (!postCodes.isEmpty())
            {
                for (int i = 0; i < postCodes.size(); i++)
                {
                    query += ("AreaCode = " + postCodes.get(i));
                    if (i < postCodes.size() - 1)
                    {
                        query += " OR ";
                    }
                }
                // Missing here is the check for available rooms at the requested
                // dates at each hotel, this will be added soon, hardcode end to
                // SELECT statement until then
                query += ";";
            }
            else
            {
                // Same as above, here will be a check for room availability at
                // each hotel that meets the search criteria for each requested
                // date
            }
        }
        
        System.out.println(query);
        return query;
    }
    
    private boolean checkContains(String a, String b, boolean check)
    {
        if (check)
        {
            return true;
        }
        else if (a.contains(b))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Opnar tengingu við gagnagrunn.
     * @param query 
     */
    public ArrayList<String> openConnection(leit nyLeit) {
        String query = makeQueryString(nyLeit);
        ArrayList<String> results = new ArrayList<>();
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:dev8.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Tenging Virk");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String output = rs.getString(1);
                System.out.println(output);
                results.add(output);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn !=null) {
                    //Lokum tengingunni ef hún átti sér stað.
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return results;
    }
    
}

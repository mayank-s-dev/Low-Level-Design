package MovieTicketBooking;

import MovieTicketBooking.Enums.City;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    int threaterId;
    String address;
    City city;
    List<Screen> screenList = new ArrayList<>();
    List<Show> showsList = new ArrayList<>();

    public int getThreaterId() {
        return threaterId;
    }

    public void setThreaterId(int theatreId) {
        this.threaterId = theatreId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public List<Show> getShowsList() {
        return showsList;
    }

    public void setShowsList(List<Show> showsList) {
        this.showsList = showsList;
    }

}

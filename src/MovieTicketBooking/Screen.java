package MovieTicketBooking;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    int screenId;
    List<Seat> seatsList = new ArrayList<>();

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<Seat> seatsList) {
        this.seatsList = seatsList;
    }


}

package CarRental;

import CarRental.Product.Vehicle;
import CarRental.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int storeId;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location storeLocation;
    List<Reservation> reservations = new ArrayList<>();

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        return vehicleInventoryManagement.getVehicles();
    }

    public void setVehicles(List<Vehicle> vehicleList){
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicleList);
    }

    public Reservation createReservation(User user, Vehicle vehicle){
        Reservation reservation = new Reservation();
        reservation.createReservation(user, vehicle);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationId){
        // take out the reservation from reservation list and call the complete reservation method in reservation, as we did to create new reservation
        return true;
    }
}

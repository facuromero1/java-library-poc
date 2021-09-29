package repo;

import model.Reservation;
import model.User;

import java.util.ArrayList;

public class ReservationRepo {

    private ArrayList<Reservation> reservations;

    public ReservationRepo() {
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        if (reservation != null) {
            reservations.add(reservation);
        }

    }

    public ArrayList<Reservation> getUserReservations(User user) {
        ArrayList<Reservation> result = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getUser().equals(user)) {
                result.add(reservation);
            }
        }
        return result;
    }

}

package app.repo;

import app.model.Reservation;

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

    public Reservation getReservation(String name, String lastname) {
        for (Reservation reservation : reservations) {
            if (reservation.getUser().getName().equals(name) && reservation.getUser().getLastname().equals(lastname)) {
                return reservation;
            }
        }

        return null;
    }


}


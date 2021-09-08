package app.service;

import app.model.Book;
import app.model.Reservation;
import app.model.User;
import app.repo.ReservationRepo;

import java.util.ArrayList;

public class ReservationService {
    private ReservationRepo reservationRepo;

    public ReservationService() {
        this.reservationRepo = new ReservationRepo();
    }

    public void createReservation(String nameUser, String lastname, String nameBook, String author, int year) {
        User user = new User(nameUser, lastname);
        Book book = new Book(nameBook, author, year);

        Reservation reservation = new Reservation(book, user);
        reservationRepo.addReservation(reservation);
    }

    public ArrayList searchReservations(String name, String lastname) {
        ArrayList<Reservation> userReservation = new ArrayList<>();
        Reservation reserva = reservationRepo.getReservation(name, lastname);
        userReservation.add(reserva);

        return userReservation;
    }
}





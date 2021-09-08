package app.service;

import app.model.Book;
import app.model.Reservation;
import app.model.User;
import app.repo.ReservationRepo;
import app.repo.UserRepo;

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

    public ArrayList<Reservation> searchReservations(String name, String lastname) {
        User user = new User (name,lastname);
        return reservationRepo.getUserReservations(user);
    }
}





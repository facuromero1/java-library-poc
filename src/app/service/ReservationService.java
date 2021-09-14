package app.service;

import app.model.Book;
import app.model.Reservation;
import app.model.User;
import app.repo.ReservationRepo;


import java.util.ArrayList;

public class ReservationService {

    private ReservationRepo reservationRepo;
    private UserService userService;
    private BookService bookService;


    public ReservationService(UserService userService, BookService bookService) {
        this.reservationRepo = new ReservationRepo();
        this.userService = userService;
        this.bookService = bookService;

    }

    public String createReservation(String nameUser, String lastname, String nameBook, String author, int year) {
        User user = userService.getUser(nameUser, lastname);
        Book book = bookService.getBook(nameBook, author, year);
        if (user != null && book != null) {
            Reservation reservation = new Reservation(book, user);
            reservationRepo.addReservation(reservation);
        }
        return "Your reservation has been create";
    }

    public ArrayList<Reservation> searchReservations(String name, String lastname) {
        User user = userService.getUser(name, lastname);
        if (user != null) {
            return reservationRepo.getUserReservations(userService.getUser(name, lastname));
        }
        return null;
    }
}

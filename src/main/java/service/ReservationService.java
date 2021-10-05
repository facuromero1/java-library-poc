package service;

import model.Book;
import model.Reservation;
import model.User;
import repo.ReservationRepo;


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

    public String createReservation(int userId, String nameBook,String author,int isbn) {
        User user = userService.getUser(userId);
        Book book = bookService.getBookReservation(nameBook,author,isbn);

        if (user != null && book != null  && reservationRepo.checkBookReservation(book)) {
            Reservation reservation = new Reservation(book, user);
            reservationRepo.addReservation(reservation);
            return "Your reservation has been create";
        }
        return "User or book not found";
    }

    public ArrayList<Reservation> searchReservations(int id) {
        User user = userService.getUser(id);
        if (user != null) {
            return reservationRepo.getUserReservations(user);
        }
        return null;
    }
}

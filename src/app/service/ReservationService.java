package app.service;

import java.util.Scanner;

import app.model.Book;
import app.model.Reservation;
import app.model.User;
import app.repo.ReservationRepo;
import app.repo.UserRepo;

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
        Scanner sn = new Scanner(System.in);
        int option;
        if (userService.userExists(nameUser, lastname) && bookService.bookExists(nameBook, author, year)) {
            User user = new User(nameUser, lastname);
            Book book = new Book(nameBook, author, year);
            Reservation reservation = new Reservation(book, user);
            reservationRepo.addReservation(reservation);
            System.out.println("you reservation has been create");
        } else if (!userService.userExists(nameUser, lastname) && bookService.bookExists(nameBook, author, year)) {
            System.out.println("User not found");
            System.out.println("Do you wish create it");
            System.out.println("1-YES");
            System.out.println("2-NO");
            option = sn.nextInt();
            if (option == 1) {
                userService.createUser(nameUser, lastname);
                User user = new User(nameUser, lastname);
                Book book = new Book(nameBook, author, year);
                Reservation reservation = new Reservation(book, user);
                reservationRepo.addReservation(reservation);
            }
            System.out.println("you reservation has been create");
        }

        return "Finish";
    }

    public ArrayList<Reservation> searchReservations(String name, String lastname) {
        boolean validationUserReservation = userService.userExists(name, lastname);
        if (validationUserReservation) {
            User user = new User(name, lastname);
            return reservationRepo.getUserReservations(user);
        }
        return null;
    }
}

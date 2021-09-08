package app;

import app.model.Book;
import app.model.Reservation;
import app.model.User;
import app.repo.ReservationRepo;
import app.service.BookService;
import app.service.ReservationService;
import app.service.UserService;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {


        UserService userService = new UserService();
        BookService bookService = new BookService();
        ReservationService reservationService = new ReservationService();

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int option;
        while (!salir) {
            System.out.println("1. Create user");
            System.out.println("2. Create book");
            System.out.println("3. Create reservation");
            System.out.println("4. See reservations ");
            System.out.println("5. Find book");
            System.out.println("6. Exit ");
            System.out.println("Type number of your option");
            option = sn.nextInt();

            switch (option) {

                case 1:
                    System.out.println("type name: ");
                    String name = sn.next();
                    System.out.println("type lastname: ");
                    String lastname = sn.next();
                    userService.createUser(name, lastname);
                    break;

                case 2:
                    System.out.println("enter name of book:");
                    String bookName = sn.next();
                    System.out.println("enter name of author:");
                    String author = sn.next();
                    System.out.println("enter book year:");
                    int yearBook = sn.nextInt();
                    bookService.createBook(bookName, author, yearBook);
                    break;
                case 3:
                    System.out.println("type name of user");
                    String userNameReservation = sn.next();
                    System.out.println("type lastname of user");
                    String userLastnameReservation = sn.next();
                    boolean userFound = userService.userExists(userNameReservation, userLastnameReservation);

                    System.out.println("type name of book");
                    String nameBookReservation = sn.next();
                    System.out.println("type name of author");
                    String nameAuthorBookReservation = sn.next();
                    System.out.println("type year of book");
                    int yearBookReservation = sn.nextInt();
                    boolean bookFound = bookService.bookExists(nameBookReservation, nameAuthorBookReservation, yearBookReservation);

                    if (userFound && bookFound) {
                        reservationService.createReservation(userNameReservation, userLastnameReservation, nameBookReservation, nameAuthorBookReservation, yearBookReservation);
                        System.out.println("reservation has been created");
                    } else {
                        if (!userFound) {
                            System.out.println("User not found");
                            System.out.println("do you want to create it?");
                            System.out.println("1 YES");
                            System.out.println("2 NO");
                            option = sn.nextInt();
                            switch (option) {
                                case 1:
                                    userService.createUser(userNameReservation, userLastnameReservation);
                                case 2:
                                    continue;
                            }
                        }
                    }

                    break;

                case 4:
                    System.out.println("type name of user");
                    String userNameFound = sn.next();
                    System.out.println("type lastname of user");
                    String userLastnameFound = sn.next();
                    boolean validationUserReservation = userService.userExists(userNameFound, userLastnameFound);
                    if (validationUserReservation) {
                        System.out.println(reservationService.searchReservations(userNameFound, userLastnameFound));

                    }
                    else {
                        System.out.println("This user don't have reservations");
                    }


                    break;

                case 5:
                    System.out.println("enter name of book:");
                    String nameFoundBook = sn.next();
                    System.out.println("enter name of author:");
                    String authorFoundBook = sn.next();
                    System.out.println("enter year of book");
                    int yearFoundBook = sn.nextInt();
                    Book book = bookService.foundBook(nameFoundBook, authorFoundBook, yearFoundBook);
                    System.out.println(book);
                    if (book == null){
                        System.out.println("book not found");

                    }
                    break;

                case 6:
                    System.out.println("Good Bye");
                    salir = true;

            }
        }
    }

}











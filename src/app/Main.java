package app;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Reserva> reservas = new ArrayList<>();


        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("1. Create user");
            System.out.println("2. Add book");
            System.out.println("3. Make reservation");
            System.out.println("4. See reservation ");
            System.out.println("5. Exit ");

            System.out.println("Type number of your opcion");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    User user = getUser(sn);
                    users.add(user);
                    break;


                case 2:
                    Book book = getBook(sn);
                    books.add(book);
                    break;


                case 3:
                    System.out.println("type name of user");
                    String userNameReservation = sn.next();
                    System.out.println("type lastname of user");
                    String userLastnameReservation = sn.next();
                    System.out.println("type name of book");
                    String nameBookReservation = sn.next();
                    System.out.println("type name of author");
                    String nameAuthorBook = sn.next();
                    System.out.println("type year of book");
                    int yearbook = sn.nextInt();

                    User usuarioEncontrado = userExists(userNameReservation, userLastnameReservation, users);
                    Book libroEncontrado = bookExists(nameBookReservation, nameAuthorBook, yearbook, books);

                    if (usuarioEncontrado == null) {
                        System.out.println("User not found \n");
                        System.out.println("Do you wish to create a user? \n");
                        System.out.println("1- Yes \n");
                        System.out.println("2- No \n");

                        int option = sn.nextInt();
                        if (option == 1) {
                            User newUser = getUser(sn);
                            users.add(newUser);
                        }
                    }

                    if (libroEncontrado == null) {
                        System.out.println("Book not found \n");
                        System.out.println("Do you wish to create a Book? \n");
                        System.out.println("1- Yes \n");
                        System.out.println("2- No \n");

                        int option = sn.nextInt();
                        if (option == 1) {
                            Book newBook = getBook(sn);
                            books.add(newBook);
                        }
                    }

                    if (libroEncontrado != null && usuarioEncontrado != null) {
                        Reserva newReservation = new Reserva(libroEncontrado, usuarioEncontrado);
                        reservas.add(newReservation);
                        System.out.println("Your reservation has been create");
                    }
                    break;


                case 4:
                    System.out.println("type name of user");
                    String userNameFound = sn.next();
                    System.out.println("type lastname of user");
                    String userLastnameFound = sn.next();

                    ArrayList<Reserva> reservationFound = searchReservation(userNameFound, userLastnameFound, reservas);
                    System.out.println(reservationFound);
                    break;


                case 5:
                    System.out.println("Good Bye");
                    salir = true;

            }
        }
    }


    private static User getUser(Scanner sn) {
        System.out.println("type name: ");
        String name = sn.next();
        System.out.println("type lastname: ");
        String lastname = sn.next();
        return new User(name, lastname);
    }

    private static Book getBook(Scanner sn) {
        System.out.println("enter name of book:");
        String bookName = sn.next();
        System.out.println("enter name of author:");
        String author = sn.next();
        System.out.println("enter book year:");
        int yearBook = sn.nextInt();
        return new Book(bookName, author, yearBook);
    }


    public static User userExists(String name, String lastname, ArrayList<User> users) {
        for (User user : users) {
            if (user.equals(name, lastname)) {
                return user;
            }
        }
        return null;
    }


    public static Book bookExists(String name, String author, int year, ArrayList<Book> books) {
        for (Book book : books) {
            if (book.equals(name, author, year)) {
                return book;
            }
        }
        System.out.println("Book not found");
        return null;
    }

    public static ArrayList<Reserva> searchReservation(String name, String lastname, ArrayList<Reserva> reservas) {
        ArrayList<Reserva> userReservation = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getUser().getName().equals(name) && reserva.getUser().getLastname().equals(lastname)) {
                userReservation.add(reserva);
            }
        }
        return userReservation;

    }


    public static Reserva reservationExist(Book book, User user, ArrayList<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            if (reserva.equals(book, user)) {
                return reserva;
            }
        }
        System.out.println("This user dont have reservations");
        return null;
    }
}











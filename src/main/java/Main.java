import service.BookService;
import service.ReservationService;
import service.UserService;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        UserService userService = new UserService();
        BookService bookService = new BookService();
        ReservationService reservationService = new ReservationService(userService, bookService);
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int option;
        userService.createUser("facundo","romero",40405174);
        bookService.createBook("naruto","facu",1997,1912415935);

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
                    System.out.println("type DNI");
                    int id = sn.nextInt();

                    userService.createUser(name, lastname,id);
                    break;

                case 2:
                    System.out.println("enter name of book:");
                    String bookName = sn.next();
                    System.out.println("enter name of author:");
                    String author = sn.next();
                    System.out.println("enter book year:");
                    int yearBook = sn.nextInt();
                    System.out.println("enter isbn number:");
                    int isbnBook = sn.nextInt();


                    bookService.createBook(bookName, author, yearBook,isbnBook);
                    break;

                case 3:
                    System.out.println("type dni of user");
                    int userId = sn.nextInt();
                    System.out.println("type name of book");
                    String nameBookReservation = sn.next();
                    System.out.println("type isbn of book");
                    int isbnBookReservation = sn.nextInt();

                    String result = reservationService.createReservation(userId,nameBookReservation,isbnBookReservation);
                    System.out.println(result);
                    break;

                case 4:
                    System.out.println("type dni of user");
                    int userIdFound = sn.nextInt();

                    System.out.println(reservationService.searchReservations(userIdFound));
                    break;

                case 5:
                    System.out.println("enter name of book:");
                    String nameFoundBook = sn.next();
                    System.out.println("enter isbn of book:");
                    int isbnFoundBook = sn.nextInt();

                    System.out.println(bookService.findBook(nameFoundBook,isbnFoundBook));
                    break;

                case 6:
                    System.out.println("good bye");
                    salir = true;

            }
        }
    }

}

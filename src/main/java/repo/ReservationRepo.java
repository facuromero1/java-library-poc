package repo;

import model.Reservation;
import model.User;
import model.Book;


import java.util.ArrayList;

public class ReservationRepo {

    private ArrayList<Book> books;
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

    public boolean reservationExist(Book book) {
        for (Reservation reservation : reservations) {
            if (reservation.getBook().getIsbn() == book.getIsbn()) {
                return false;
            }
        }
        return true;

    }
    public ArrayList<Book> getBookReservation(String name, String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book i : books) {
            if (i.getName().equals(name) && i.getAuthor().equals(author)) {
                result.add(i);
            }
        }
        return null;

    }

}

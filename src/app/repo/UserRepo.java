package app.repo;

import app.model.User;

import java.util.ArrayList;

public class UserRepo {

    private ArrayList<User> users;

    public UserRepo() {
        this.users = new ArrayList<>();
    }


    public void addUser(User user) {
        if (user != null) {
            users.add(user);
        }
    }

    public User getUser(String name, String lastname) {
        for (User user : users) {
            if (user.equals(name, lastname)) {
                return user;
            }
        }
        return null;
    }
}

package repo;

import model.User;

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

    public User getUser(int id) {
        for (User user : users) {
            if (user.getId() == (id)) {
                return user;
            }
        }
        return null;
    }
}

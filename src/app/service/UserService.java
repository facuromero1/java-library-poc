package app.service;

import app.model.User;
import app.repo.UserRepo;

public class UserService {

    private UserRepo userRepo;

    public UserService() {
        this.userRepo = new UserRepo();
    }

    public void createUser(String name, String lastname) {
        User user = new User(name, lastname);
        userRepo.addUser(user);
    }

    public User getUser(String name, String lastname) {
        return userRepo.getUser(name, lastname);

    }
}

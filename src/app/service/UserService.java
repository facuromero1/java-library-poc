package app.service;

import app.model.User;
import app.repo.UserRepo;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    private UserRepo userRepo;

    public UserService() {
        this.userRepo = new UserRepo();
    }

    public void createUser(String name, String lastname) {
        User user = new User(name, lastname);
        userRepo.addUser(user);
    }

    public boolean userExists(String name, String lastname) {
        User user = userRepo.getUser(name, lastname);
        return user != null;
    }


}

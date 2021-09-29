package service;

import model.User;
import repo.UserRepo;

public class UserService {

    private UserRepo userRepo;

    public UserService() {
        this.userRepo = new UserRepo();
    }

    public void createUser(String name, String lastname,int id) {
        User user = new User(name, lastname,id);
        userRepo.addUser(user);
    }

    public User getUser(int id) {
        return userRepo.getUser(id);

    }
}

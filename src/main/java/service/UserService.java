package main.java.service;

import main.java.model.Review;
import main.java.model.User;

import java.util.List;

/**
 * Created by ychen4 on 5/11/2017.
 */
public interface UserService {

    List<User> listAllUsers();

    User getUserById(int id);

    User updateUser(User user);

    User deleteReview(int id);

    User createUser(User user);

}

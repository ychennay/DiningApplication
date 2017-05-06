package main.java.dao;

import main.java.model.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ychen4 on 5/5/2017.
 */
@EnableScan
public interface UserDao extends CrudRepository<User, String> {

    List<User> findByFirstName(String firstName);

}
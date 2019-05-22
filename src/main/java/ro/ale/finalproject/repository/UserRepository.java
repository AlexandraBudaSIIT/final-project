package ro.ale.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ale.finalproject.model.User;

/**
 * The UserRepository interface allows to access the information stored in the data base
 *
 * @author Alexandra Buda
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    // retrieve a user associated with a username
    User findByUsername(String username);
}

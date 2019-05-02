package ro.ale.finalproject.repository;

import org.springframework.data.repository.CrudRepository;
import ro.ale.finalproject.model.User;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String username);
}

package ro.ale.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ale.finalproject.model.Role;

/**
 * The RoleRepository interface allows to access the information stored in the data base
 *
 * @author Alexandra Buda
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {

}

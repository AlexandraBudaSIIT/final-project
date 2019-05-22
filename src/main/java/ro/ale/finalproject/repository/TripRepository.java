package ro.ale.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.ale.finalproject.model.Trip;

import java.util.List;

/**
 * The TripRepository interface allows to access the information stored in the data base
 *
 * @author Alexandra Buda
 */
@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

   // retrieve a trip associated with a tripName
    Trip findByTripName (String tripName);

    // retrieve a trip associated with a userId
    @Query(value="select * from trips where user_id=:value", nativeQuery = true)
    List<Trip> findTripByUser(@Param("value") int userId);
}

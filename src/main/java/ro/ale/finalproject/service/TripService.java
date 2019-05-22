package ro.ale.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.ale.finalproject.model.Trip;
import ro.ale.finalproject.repository.TripRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * TripService class provide service for registering a trip
 *
 * @author Alexandra Buda
 */
@Service
public class TripService {

    @Autowired
    TripRepository tripRepository;

    public Trip findByTripName (String tripName){
        return tripRepository.findByTripName(tripName);
    }

    public void saveTrip(Trip trip){
        tripRepository.save(trip);
    }

    public void savePhoto (MultipartFile imageFile) throws Exception{
        //save the uploaded file to this folder
        String folder = System.getProperty("user.dir") + "/src/main/resources/static/photos/";

        // Get the file and save it
       byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder, imageFile.getOriginalFilename());
        Files.write(path,bytes);
    }

    public List<Trip> findTripByUser(int userId){
        return tripRepository.findTripByUser(userId);
    }

    public void removeTripById(Integer id){
        tripRepository.deleteById(id);
    }

}

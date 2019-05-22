package ro.ale.finalproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The Trip class for storing trips,
 * by creating a Trip entity that is mapped to a database table
 *
 * @author Alexandra Buda
 */
@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int tripId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name ="user_id", nullable = false)
    private User user;

    private String tripName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTo;

    private String impression;

    private String firstPhoto;

    private String firstPhotoDescription;

    private String firstPhotoDetail;

    private String secondPhoto;

    private String secondPhotoDescription;

    private String secondPhotoDetail;


    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }

    public String getFirstPhoto() {
        return firstPhoto;
    }

    public void setFirstPhoto(String firstPhoto) {
        this.firstPhoto = firstPhoto;
    }

    public String getFirstPhotoDescription() {
        return firstPhotoDescription;
    }

    public void setFirstPhotoDescription(String firstPhotoDescription) {
        this.firstPhotoDescription = firstPhotoDescription;
    }

    public String getFirstPhotoDetail() {
        return firstPhotoDetail;
    }

    public void setFirstPhotoDetail(String firstPhotoDetail) {
        this.firstPhotoDetail = firstPhotoDetail;
    }

    public String getSecondPhoto() {
        return secondPhoto;
    }

    public void setSecondPhoto(String secondPhoto) {
        this.secondPhoto = secondPhoto;
    }

    public String getSecondPhotoDescription() {
        return secondPhotoDescription;
    }

    public void setSecondPhotoDescription(String secondPhotoDescription) {
        this.secondPhotoDescription = secondPhotoDescription;
    }

    public String getSecondPhotoDetail() {
        return secondPhotoDetail;
    }

    public void setSecondPhotoDetail(String secondPhotoDetail) {
        this.secondPhotoDetail = secondPhotoDetail;
    }
}

package ro.ale.finalproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min = 2, max = 30, message = "Try with at least 2 characters")
    @Column(name = "firstname")
    private String firstName;

    @Size(min = 2, max = 30, message = "Try with at least 2 characters")
    @Column(name = "lastname")
    private String lastName;

    @Size(min = 3, max = 30, message = "Try with at least 3 characters")
    @NotBlank
    private String username;

    @Size(min = 8, max = 30, message = "Try with at least 8 characters")
    @NotBlank
    private String password;

    @Size(min = 2, max = 30, message = "Try with at least 2 characters")
    private String city;

    @Size(min = 2, max = 30, message = "Try with at least 2 characters")
    private String address;

    @Size(min = 10, max = 10, message = "Please enter a valid phone number")
    private int phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}

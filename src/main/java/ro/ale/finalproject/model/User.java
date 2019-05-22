package ro.ale.finalproject.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * The User class for storing users,
 * by creating a User entity that is mapped to a database table
 *
 * @author Alexandra Buda
 */
@Entity
@Table(name = "users")
@Valid
public class User {


    private int id;

    @Size(min = 2, max = 30, message = "Try with at least 2 characters")
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 2, max = 30, message = "Try with at least 2 characters")
    @Column(name = "last_name")
    private String lastName;

    @Size(message = "eroare")
    @NotBlank
    private String username;

    @Size(message = "eroare")
    @NotBlank
    private String password;

    @Size(min = 2, max = 30, message = "Try with at least 2 characters")
    private String city;

    @Size(min = 2, max = 30, message = "Try with at least 2 characters")
    private String address;


    private int phone;

    private Set<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

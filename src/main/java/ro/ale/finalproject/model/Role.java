package ro.ale.finalproject.model;

import javax.persistence.*;
import java.util.Set;

/**
 * The Role class for storing users role,
 * by creating a Role entity that is mapped to a database table
 *
 * @author Alexandra Buda
 */
@Entity
@Table(name = "roles")
public class Role {


    private int id;
    @Column(name = "rolename")
    private String rolename;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

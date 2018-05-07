package main.crud.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public User() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public User(int id, String name, String email, String password) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setRole("user");
    }

    @SuppressWarnings("UnusedDeclaration")
    public User(String name, String email, String password) {
        this.setId(-1);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setRole("user");
    }

    @SuppressWarnings("UnusedDeclaration")
    public User(int id, String name, String email, String password, String role) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setRole(role);
    }

    @SuppressWarnings("UnusedDeclaration")
    public User(String name, String email, String password, String role) {
        this.setId(-1);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setRole(role);
    }

    public String getRole() { return this.role; }

    public void setRole(String role) { this.role = role; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public boolean validParametrs(){
        return (name.isEmpty() || password.isEmpty() || email.isEmpty() || role.isEmpty());
    }
}
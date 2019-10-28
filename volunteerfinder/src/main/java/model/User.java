package model;

import java.util.Date;


public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String hash;
    private String confirmPass;
    private Date date;

    public User() {
    }

    public User(int id, String firstName, String lastName, String email, Date date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.date = date;

    }

    public User(int id, String firstName, String lastName, String email, Date date, String hash) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.date = date;
        this.hash = hash;
    }

    public User(String firstName, String lastName, String email, String password, String confirmPass, Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hash = password;
        this.confirmPass = confirmPass;
        this.date = date;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String password) {
        this.hash = password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

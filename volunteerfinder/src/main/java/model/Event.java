package model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Blob;
import java.util.Set;


public class Event {

    private int id;
    private String name;
    private String description;

    private byte[] Image;

    private int amountOfPeopleNeeded;
    private Company company;
    private Set<User> users;

    public Event() {
    }

    public Event(int id, String name, String description, byte[] image, int amountOfPeopleNeeded, Company company, Set<User> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        Image = image;
        this.amountOfPeopleNeeded = amountOfPeopleNeeded;
        this.company = company;
        this.users = users;
    }

    public Event(String name, String description, byte[] image, int amountOfPeopleNeeded, Company company, Set<User> users) {
        this.name = name;
        this.description = description;
        Image = image;
        this.amountOfPeopleNeeded = amountOfPeopleNeeded;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }

    public int getAmountOfPeopleNeeded() {
        return amountOfPeopleNeeded;
    }

    public void setAmountOfPeopleNeeded(int amountOfPeopleNeeded) {
        this.amountOfPeopleNeeded = amountOfPeopleNeeded;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

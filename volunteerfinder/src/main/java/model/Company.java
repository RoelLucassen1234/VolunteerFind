package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Blob;
import java.util.List;
import java.util.Set;

public class Company {

    private int id;
    private String name;
    private String description;
    private byte[] image;
    @JsonBackReference
    private Set<Event> events;

    public Company() {
    }

    public Company(String name, String description, byte[] image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Company(int id, String name, String description, Set<Event> events, byte[] image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.events = events;
        this.image = image;
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

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

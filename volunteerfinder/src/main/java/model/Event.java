package model;

import com.fasterxml.jackson.annotation.*;

import java.util.Set;

//@Entity
//@Table(name="event")

public class Event {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="id")
    private int id;

    //    @Column(name="name")
    private String name;
    //    @Column(name="description")
    private String description;
    //    @Column(name = "image", columnDefinition = "longblob")
    private byte[] Image;

    //    @ManyToOne
//    @Column(name="description")
    @JsonManagedReference
    private Company company;

    //    @ManyToMany
    @JsonManagedReference
    private Set<User> users;

    //    @Column(name="numberOfPeople")
    private int totalAmountOfPeople;

    public Event() {
    }

    public Event(int id, String name, String description, byte[] image, Company company, Set<User> users, int numberOfPeople) {
        this.id = id;
        this.name = name;
        this.description = description;
        Image = image;
        this.totalAmountOfPeople = numberOfPeople;
        this.company = company;
        this.users = users;
    }

    public Event(String name, String description, byte[] image, Company company, Set<User> users, int numberOfPeople) {
        this.name = name;
        this.description = description;
        Image = image;
        this.company = company;
        this.users = users;
        this.totalAmountOfPeople = numberOfPeople;
    }

    public int getTotalAmountOfPeople() {
        return totalAmountOfPeople;
    }

    public void setTotalAmountOfPeople(int numberOfPeople) {
        this.totalAmountOfPeople = numberOfPeople;
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

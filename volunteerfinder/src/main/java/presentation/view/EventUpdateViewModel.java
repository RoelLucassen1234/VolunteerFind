package presentation.view;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import model.Company;
import model.User;

import java.util.Set;

public class EventUpdateViewModel {

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

    private Company company;

    //    @ManyToMany

    private Set<User> users;

    //    @Column(name="numberOfPeople")
    private int totalAmountOfPeople;

    public EventUpdateViewModel(int id, String name, String description, byte[] image, Company company, Set<User> users, int totalAmountOfPeople) {
        this.id = id;
        this.name = name;
        this.description = description;
        Image = image;
        this.company = company;
        this.users = users;
        this.totalAmountOfPeople = totalAmountOfPeople;
    }

    public EventUpdateViewModel() {
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

    public int getTotalAmountOfPeople() {
        return totalAmountOfPeople;
    }

    public void setTotalAmountOfPeople(int totalAmountOfPeople) {
        this.totalAmountOfPeople = totalAmountOfPeople;
    }
}

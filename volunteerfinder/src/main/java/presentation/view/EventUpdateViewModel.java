package presentation.view;

import model.Company;
import model.User;

import java.util.Set;

public class EventUpdateViewModel {
    private int id;
    private String name;
    private String description;

    private byte[] Image;

    private int amountOfPeopleNeeded;
    private int companyId;
    private Set<Integer> usersToRemove;
    private Set<Integer> usersToAdd;

    public EventUpdateViewModel(int id, String name, String description, byte[] image, int amountOfPeopleNeeded, int companyId, Set<Integer> usersToRemove, Set<Integer> usersToAdd) {
        this.id = id;
        this.name = name;
        this.description = description;
        Image = image;
        this.amountOfPeopleNeeded = amountOfPeopleNeeded;
        this.companyId = companyId;
        this.usersToRemove = usersToRemove;
        this.usersToAdd = usersToAdd;
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

    public int getAmountOfPeopleNeeded() {
        return amountOfPeopleNeeded;
    }

    public void setAmountOfPeopleNeeded(int amountOfPeopleNeeded) {
        this.amountOfPeopleNeeded = amountOfPeopleNeeded;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Set<Integer> getUsersToRemove() {
        return usersToRemove;
    }

    public void setUsersToRemove(Set<Integer> usersToRemove) {
        this.usersToRemove = usersToRemove;
    }

    public Set<Integer> getUsersToAdd() {
        return usersToAdd;
    }

    public void setUsersToAdd(Set<Integer> usersToAdd) {
        this.usersToAdd = usersToAdd;
    }
}

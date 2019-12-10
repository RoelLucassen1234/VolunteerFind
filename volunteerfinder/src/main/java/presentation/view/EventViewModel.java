package presentation.view;

import model.Company;

public class EventViewModel
{
    private String name;
    private String description;

    private byte[] Image;

    private int companyId;
private int numberOfPeople;
    public EventViewModel() {
    }

    public EventViewModel(String name, String description, byte[] image,  int companyId, int numberOfPeople) {
        this.name = name;
        this.description = description;
        Image = image;
this.numberOfPeople = numberOfPeople;
        this.companyId = companyId;
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

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}

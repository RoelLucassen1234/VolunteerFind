package logic;

public class Factory {
    public static UserLogic getUserLogic(){return new UserLogic();}
    public static CompanyLogic getCompanyLogic(){return new CompanyLogic();}
}

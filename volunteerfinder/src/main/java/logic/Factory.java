package logic;

import dal.CompanyData;
import dal.EventData;
import dal.UserData;
import interfaces.ICompanyData;
import interfaces.IEventData;
import interfaces.IUserData;

public class Factory {
    public static UserLogic getUserLogic(){
        IUserData iUserData = new UserData();
        return new UserLogic(iUserData);}
    public static CompanyLogic getCompanyLogic(){
        ICompanyData iCompanyData = new CompanyData();
        return new CompanyLogic(iCompanyData);}
    public static EventLogic getEventLogic(){
        IEventData iEventData = new EventData();
        return new EventLogic(iEventData);}
}

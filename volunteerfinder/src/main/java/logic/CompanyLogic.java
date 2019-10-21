package logic;

import dal.CompanyData;
import model.Company;
import model.User;

public class CompanyLogic {
    private CompanyData companyData = new CompanyData();

    public boolean postUser(Company company){
        if (company != null){
            if (company.getImage() != null && company.getName().length() > 2){
                return companyData.addCompany(company);
            }
        }
        return false;
    }
    public Company getCompany(int companyId){
        return companyData.getCompany(companyId);
    }
    public boolean deleteCompany(int companyId){
        return companyData.removeCompany(companyId);
    }

    public boolean updateCompany(Company company){
        return companyData.updateCompany(company);  }
}

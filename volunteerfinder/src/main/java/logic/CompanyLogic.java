package logic;

import dal.CompanyData;
import interfaces.ICompanyData;
import model.Company;
import model.User;

public class CompanyLogic {
    private ICompanyData companyData;

    public CompanyLogic(ICompanyData companyData) {
        this.companyData = companyData;
    }

    public boolean postCompany(Company company){
        if (company != null){
            if (company.getName() != null && company.getName().length() > 2)
            if (company.getImage() != null && company.getName().length() > 2 && company.getDescription() != null && company.getDescription().length() > 2){
                return companyData.addCompany(company);
            }
        }
        return false;
    }
    public Company getCompany(int companyId){
        return companyData.getCompany(companyId);
    }

    public boolean deleteCompany(int companyId){ return companyData.removeCompany(companyId); }

    public boolean updateCompany(Company company){
        return companyData.updateCompany(company);  }
}

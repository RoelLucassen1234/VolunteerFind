package interfaces;

import model.Company;

public interface ICompanyData {
    boolean addCompany(Company company);
    boolean updateCompany(Company company);
    boolean removeCompany(int companyId);
    Company getCompany(int companyId);
}

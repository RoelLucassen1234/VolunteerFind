package dal;

import model.Company;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompanyData {

    /* Method to CREATE an employee in the database */
    public boolean addCompany(Company company) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.factory.openSession()) {
            transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
            return true;
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateCompany(Company company){
        Transaction transaction = null;
        try (Session session =  HibernateConfig.factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(company);
            transaction.commit();
            return true;
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeCompany(int companyId) {
        Transaction transaction = null;
        try (Session session =  HibernateConfig.factory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(session.get(User.class, companyId));
            transaction.commit();
            return true;
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public Company getCompany(int companyId){
        Transaction transaction = null;
        try(Session session = HibernateConfig.factory.openSession()){
            transaction = session.beginTransaction();
            return session.get(Company.class, companyId);
        }
        catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }
}

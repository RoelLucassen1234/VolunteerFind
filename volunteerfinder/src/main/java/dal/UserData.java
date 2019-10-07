package dal;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserData {
    /* Method to CREATE an employee in the database */
    public boolean addUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.factory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
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


    public boolean updateChair(User user){
        Transaction transaction = null;
        try (Session session =  HibernateConfig.factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
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

    public boolean removeUser(int userId) {
        Transaction transaction = null;
        try (Session session =  HibernateConfig.factory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(session.get(User.class, userId));
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

    public User getUser(int userId){
        Transaction transaction = null;
        try(Session session = HibernateConfig.factory.openSession()){
            transaction = session.beginTransaction();
            return session.get(User.class, userId);
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

package dal;

import interfaces.IUserData;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserData implements IUserData {
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


    public boolean updateUser(User user){
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

    public User getUserById(int userId){
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


    public User getUserByEmail(String email){
        Transaction transaction = null;
        try(Session session = HibernateConfig.factory.openSession()){
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM User where email = :email");
            query.setString("email", email);

            User user = (User)query.uniqueResult();
            if (user == null)
                return null;

            return user;
        }
        catch (Exception e){
            System.out.println(e);
            if (transaction != null){
                transaction.rollback();
            }
            return null;
        }
    }
    public User getUserBySession(String sessionToken){
        Transaction transaction = null;
        try(Session session = HibernateConfig.factory.openSession()){
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM User where sessionToken = :sessionToken");
            query.setString("sessionToken", sessionToken);

            User user = (User)query.uniqueResult();
            if (user == null)
                return null;

            return user;
        }
        catch (Exception e){
            System.out.println(e);
            if (transaction != null){
                transaction.rollback();
            }
            return null;
        }
    }
}

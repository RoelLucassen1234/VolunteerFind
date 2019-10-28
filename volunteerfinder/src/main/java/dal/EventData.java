package dal;

import interfaces.IEventData;
import model.Company;
import model.Event;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EventData implements IEventData {
    /* Method to CREATE an employee in the database */
    public boolean addEvent(Event event) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.factory.openSession()) {
            transaction = session.beginTransaction();
            session.save(event);
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


    public boolean updateEvent(Event event){
        Transaction transaction = null;
        try (Session session =  HibernateConfig.factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(event);
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

    public boolean removeEvent(int eventId) {
        Transaction transaction = null;
        try (Session session =  HibernateConfig.factory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(session.get(Event.class, eventId));
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

    public Event getEvent(int eventId){
        Transaction transaction = null;
        try(Session session = HibernateConfig.factory.openSession()){
            transaction = session.beginTransaction();
            return session.get(Event.class, eventId);
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

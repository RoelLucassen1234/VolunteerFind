package interfaces;

import model.Event;

public interface IEventData {
    Event getEvent(int eventId);
    boolean removeEvent(int eventId);
    boolean updateEvent(Event event);
    boolean addEvent(Event event);
}

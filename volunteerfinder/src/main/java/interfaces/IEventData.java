package interfaces;

import model.Event;

import java.util.List;

public interface IEventData {
    Event getEvent(int eventId);
    boolean removeEvent(int eventId);
    boolean updateEvent(Event event);
    boolean addEvent(Event event);
    List<Event> getEvents();
}

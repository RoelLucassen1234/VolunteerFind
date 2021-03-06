package logic;

import dal.EventData;
import interfaces.IEventData;
import model.Event;
import presentation.view.EventUpdateViewModel;

import java.util.List;

public class EventLogic {

    IEventData eventData;

    public EventLogic(IEventData eventData) {
        this.eventData = eventData;
    }

    public boolean postEvent(Event event) {
        if (event != null) {
            if (event.getImage() != null && event.getCompany() != null) {
             String description = event.getDescription();
                if (description != null && description.length() > 5)
                    if (event.getName() != null && event.getName().length() > 2)
                return eventData.addEvent(event);
            }
        }
        return false;
    }

    public Event getEvent(int eventId) {
        return eventData.getEvent(eventId);
    }

    public boolean deleteEvent(int eventId) {
        return eventData.removeEvent(eventId);
    }

    public boolean updateCompany(EventUpdateViewModel updatedEvent) {
        Event event = eventData.getEvent(updatedEvent.getId());

        if (updatedEvent.getDescription() != null)
        event.setDescription(updatedEvent.getDescription());
        if (updatedEvent.getImage() != null)
            event.setImage(updatedEvent.getImage());
        if (updatedEvent.getName() != null && updatedEvent.getName() != event.getName())
            event.setName(updatedEvent.getName());

        if (updatedEvent.getCompany().getId() != 0 && updatedEvent.getCompany().getId() != event.getCompany().getId())
            event.setCompany(Factory.getCompanyLogic().getCompany(updatedEvent.getCompany().getId()));

       event.setUsers(updatedEvent.getUsers());

        return eventData.updateEvent(event);
    }

    public List<Event> getEvents() {
        return eventData.getEvents();
    }
}



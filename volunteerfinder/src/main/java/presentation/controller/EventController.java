package presentation.controller;

import logic.Factory;
import model.Company;
import model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import presentation.view.EventUpdateViewModel;
import presentation.view.EventViewModel;

import java.io.Console;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @PostMapping("")
    public ResponseEntity postEvent(@RequestBody EventViewModel eventViewModel) {
        Company company = Factory.getCompanyLogic().getCompany(eventViewModel.getCompanyId());
        System.out.println(eventViewModel.getCompanyId());

        Event event = new Event(eventViewModel.getName(), eventViewModel.getDescription(),eventViewModel.getImage(),company, null);
        if (Factory.getEventLogic().postEvent(event))
            return ResponseEntity.status(200).body("uploaded event to the database");
        return ResponseEntity.status(400).body("Something went Wrong");
    }

    @GetMapping("/{eventId}")
    public ResponseEntity getEvent(@PathVariable int eventId) {

        Event event = Factory.getEventLogic().getEvent(eventId);
        if (event != null) {
            return ResponseEntity.ok(event);
        }
        return ResponseEntity.status(400).body("event does not exist.");
    }
    @GetMapping("/events")
    public ResponseEntity getAllEvents() {

        List<Event> events = Factory.getEventLogic().getEvents();
        if (events != null) {
            return ResponseEntity.ok(events);
        }
        return ResponseEntity.status(400).body("event does not exist.");
    }


    @PutMapping("{eventId}")
    public ResponseEntity updateEvent(@RequestBody EventUpdateViewModel eventUpdateViewModel) {

           if (Factory.getEventLogic().updateCompany(eventUpdateViewModel)) {
            return ResponseEntity.ok("update succeeded");
        }
        return ResponseEntity.status(400).body("event could not be updated.");
    }

    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity deleteEvent(@PathVariable int eventId) {
        if (Factory.getEventLogic().deleteEvent(eventId)) {
            return ResponseEntity.ok("event was deleted");
        }
        return ResponseEntity.status(400).body("event was not deleted or never existed in the first place");
    }
}

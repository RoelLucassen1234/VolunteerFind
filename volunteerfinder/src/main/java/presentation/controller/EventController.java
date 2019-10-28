package presentation.controller;

import logic.Factory;
import model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import presentation.view.EventUpdateViewModel;
import presentation.view.EventViewModel;

@RestController
@RequestMapping("/event")
public class EventController {
    @PostMapping("")
    public ResponseEntity postEvent(@RequestBody EventViewModel eventViewModel) {
        Event event = new Event(eventViewModel.getName(), eventViewModel.getDescription(),eventViewModel.getImage(),eventViewModel.getAmountOfPeopleNeeded(),Factory.getCompanyLogic().getCompany(eventViewModel.getCompanyId()), null);
        if (Factory.getEventLogic().postEvent(event))
            return ResponseEntity.status(200).body("uploaded event to the database");
        return ResponseEntity.status(400).body("Something went Wrong");
    }

    @GetMapping("/events/{eventId}")
    public ResponseEntity getEvent(@PathVariable int eventId) {

        Event event = Factory.getEventLogic().getEvent(eventId);
        if (event != null) {
            return ResponseEntity.ok(event);
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

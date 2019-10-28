package roellucassen.com.example.volunteerfinder;


import interfaces.IEventData;
import logic.EventLogic;
import model.Company;
import model.Event;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EventLogicTest {
    private EventLogic eventLogic;
    private Event event;
    private int companyId;

    @Before
    public void before() {
        IEventData iEventData = mock(IEventData.class);

        companyId = 2131;
        Company company = new Company();
company.setId(companyId);

        eventLogic = new EventLogic(iEventData);
        event = new Event();
        event.setName("Test01");
        event.setDescription("This is a test");
        event.setId(123);

        event.setImage(new byte[3]);
        event.setCompany(company);

        when(iEventData.addEvent(Mockito.any())).thenReturn(true);
        when(iEventData.updateEvent(Mockito.any())).thenReturn(true);
        when(iEventData.getEvent(event.getId())).thenReturn(this.event);
        // when(iCompanyData.removeCompany(Mockito.any())).thenReturn(true);
    }


    @Test
    public void testIfEventCanBeAdded() {
        Assert.assertTrue(eventLogic.postEvent(this.event));
    }

    @Test
    public void testifEventCanBeAddedWithoutImage() {
        this.event.setImage(null);
        Assert.assertFalse(eventLogic.postEvent(this.event));
    }

    @Test
    public void testifEventCanBeAddedWithBadName() {
        this.event.setName("s");
        Assert.assertFalse(eventLogic.postEvent(this.event));
        this.event.setName(null);
        Assert.assertFalse(eventLogic.postEvent(this.event));
    }

    @Test
    public void testIfYouCanPostNullDescription() {
        this.event.setDescription(null);
        Assert.assertFalse(eventLogic.postEvent(this.event));

    }

    @Test
    public void testIfYouCanPostWithCompanyNull() {
        this.event.setCompany(null);
        Assert.assertFalse(eventLogic.postEvent(this.event));
    }

    @Test
    public void testIfYouCanPostNull() {
        Assert.assertFalse(eventLogic.postEvent(null));
    }


}

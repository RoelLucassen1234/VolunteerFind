package roellucassen.com.example.volunteerfinder;


import interfaces.IUserData;
import logic.UserLogic;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserLogicTest {
    private UserLogic eventLogic;
    private User user;
    private int userId;
    private String password;
    private String confirmPassword;

    @Before
    public void before() {
        IUserData iEventData = mock(IUserData.class);

        userId = 2131;
        user = new User();
        user.setId(userId);
        user.setFirstName("John");
        user.setLastName("Wick");
        user.setDate(new Date());
        user.setEmail("IGotMyRevenge@johnwick.com");

        password = "12345";
        confirmPassword = "12345";
        user.setHash(password);
        user.setConfirmPass(confirmPassword);



        eventLogic = new UserLogic(iEventData);

        when(iEventData.addUser(Mockito.any())).thenReturn(true);
        when(iEventData.updateUser(Mockito.any())).thenReturn(true);
        when(iEventData.getUser(user.getId())).thenReturn(this.user);
        // when(iCompanyData.removeCompany(Mockito.any())).thenReturn(true);
    }


    @Test
    public void testIfEventCanBeAdded() {
        Assert.assertTrue(eventLogic.postUser(this.user));
    }

    @Test
    public void testifUserWithNoPassCanBeAdded() {
        user.setConfirmPass(null);
        user.setHash(null);
        Assert.assertFalse(eventLogic.postUser(this.user));
    }

    @Test
    public void testifUserWitDifferentPasswordsCanBeAdded() {
        user.setConfirmPass("123");
        user.setHash("1234");
        Assert.assertFalse(eventLogic.postUser(this.user));
    }

    @Test
    public void testifEventCanBeAddedWithFirstName() {
        this.user.setFirstName("s");
        Assert.assertFalse(eventLogic.postUser(this.user));
        this.user.setFirstName(null);
        Assert.assertFalse(eventLogic.postUser(this.user));
    }

    @Test
    public void testifEventCanBeAddedWithLastName() {
        this.user.setLastName("s");
        Assert.assertFalse(eventLogic.postUser(this.user));
        this.user.setLastName(null);
        Assert.assertFalse(eventLogic.postUser(this.user));

    }

    @Test
    public void testIfYouCanPostWithEmailNull() {
       user.setEmail(null);

        Assert.assertFalse(eventLogic.postUser(this.user));
    }

    @Test
    public void testIfYouCanPostNull() {
        Assert.assertFalse(eventLogic.postUser(null));
    }


}

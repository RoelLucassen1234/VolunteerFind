package roellucassen.com.example.volunteerfinder;


import interfaces.ICompanyData;
import logic.CompanyLogic;
import model.Company;
import model.Event;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompanyLogicTest {
    private CompanyLogic companyLogic;
    private Company company;
    private int companyId;

    @Before
    public void before() {
        ICompanyData iCompanyData = mock(ICompanyData.class);
        Set<Event> events = new HashSet<>();
        companyId = 5;

        companyLogic = new CompanyLogic(iCompanyData);
        company = new Company();
        company.setName("Test01");
        company.setDescription("This is a test");
        company.setId(companyId);

        company.setImage(new byte[3]);
        company.setEvents(events);

        when(iCompanyData.addCompany(Mockito.any())).thenReturn(true);
        when(iCompanyData.updateCompany(Mockito.any())).thenReturn(true);
        when(iCompanyData.getCompany(company.getId())).thenReturn(this.company);
       // when(iCompanyData.removeCompany(Mockito.any())).thenReturn(true);
    }

    @Test
    public void testIfCompanyCanBeAdded(){
        Assert.assertTrue(companyLogic.postCompany(this.company));
    }

    @Test
    public void testifCompanyCanBeAddedWithoutImage(){
        this.company.setImage(null);
        Assert.assertFalse(companyLogic.postCompany(this.company));
    }
    @Test
    public void testifCompanyCanBeAddedWithBadName(){
        this.company.setName("s");
        Assert.assertFalse(companyLogic.postCompany(this.company));
        this.company.setName(null);
        Assert.assertFalse(companyLogic.postCompany(this.company));
    }

    @Test
    public void testIfYouCanPostNullDescription(){
        this.company.setDescription(null);
        Assert.assertFalse(companyLogic.postCompany(this.company));

    }

    @Test
    public void testIfYouCanPostWithEventNull(){
        this.company.setEvents(null);
        Assert.assertTrue(companyLogic.postCompany(this.company));
    }
    @Test
    public void testIfYouCanPostNull(){
        Assert.assertFalse(companyLogic.postCompany(null));
    }


}

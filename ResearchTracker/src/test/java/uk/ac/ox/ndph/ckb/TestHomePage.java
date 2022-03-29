package uk.ac.ox.ndph.ckb;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage
{
    private WicketTester tester;

    @BeforeEach
    public void setUp()
    {
        tester = new WicketTester(new RTApplication());
    }
// https://stackoverflow.com/questions/70258881/wicket-9-unit-testing-mockito-httpsession
    @Test
    public void userPageRendersSuccessfully()
    {
        System.out.println("Testing userPageRendersSuccessfully ");
        tester.getHttpSession().setAttribute("userName", "User set via tests");
        tester.getRequest().setAttribute("userName", "User set via tests");
        //start and render the test page
        System.out.println("Uesr name in session:" + tester.getHttpSession().getAttribute("userName"));
        tester.startPage(UserPage.class);
        //assert rendered page class
        tester.assertRenderedPage(UserPage.class);
        tester.assertModelValue("txtUserName", "User set via tests");
        System.out.println("Complete testing userPageRendersSuccessfully ");
    }
}

package hooks;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks 
{
	@Before
    public void setUp() {
        BaseTest.initializeDriver();
    }

    @After
    public void tearDown() {
        BaseTest.quitDriver();
    }

}

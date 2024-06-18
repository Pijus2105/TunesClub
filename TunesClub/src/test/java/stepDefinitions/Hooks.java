package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import managers.FileReaderManager;
import utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	TestContext testContext;
	    WebDriver driver;

	    public Hooks(TestContext context) {
	        testContext = context;
	    }

	    /*
	      This is the fetch will be Driver & URL. FileReaderManager will be call for object of URL of configReader file. 
	      and singleton object create in singleton class
	     */
	    @Before
	    public void setUp() {
	        driver = testContext.getDriverManager().getDriver();
	        driver.get(FileReaderManager.getInstance().getConfigReader().getUrl());
	    }

	    @After
	    public void tearDown(Scenario scenario) {

	        if(scenario.isFailed()) {
	            try {
	                byte[] screenshot = ((TakesScreenshot)testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
	                scenario.attach(screenshot, "image/png", "screenshot");
	            } catch (WebDriverException noSupportScreenshot) {
	                System.err.println(noSupportScreenshot.getMessage());
	            }
	        }
	       // testContext.getDriverManager().closeDriver();
	    }


}

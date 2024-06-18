package utils;

import managers.AllDriverManager;
import managers.PageObjectManager;


public class TestContext {
	
	private final AllDriverManager driverManager;
	private final PageObjectManager pageObject;
	private ScenarioContext scenario;
	
	public  TestContext() {
		driverManager = new AllDriverManager();
		pageObject = new PageObjectManager(driverManager.getDriver());
		scenario = new ScenarioContext();
	}
	
	public AllDriverManager getDriverManager() {
        return driverManager;
    }
	
	 public PageObjectManager getPageObjectManager() {
	        return pageObject;
	    	
	    }
	 public ScenarioContext getScenarioContext() {
	        return scenario;
	    }

}

/*
 * This class will call for test required
 */

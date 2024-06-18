package managers;

import org.openqa.selenium.WebDriver;


import pageObject.SpotifyMarketingPackage;



public class PageObjectManager {
	
	private final WebDriver driver;
	 private SpotifyMarketingPackage spotify;
	 
	 public PageObjectManager(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	 public SpotifyMarketingPackage getspotify() 
	 {
	       return (spotify == null) ? spotify = new SpotifyMarketingPackage(driver) : spotify;
		 
		 
	 }

}

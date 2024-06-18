package managers;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	
	public AllDriverManager() {
		
		//Enums so because create difference constructor
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
		
	}
	
	//Create method for driver
	private WebDriver createLocalDriver() {
		
		switch(driverType) {
		
		case CHROME:
			WebDriverManager.chromedriver().setup();
          ChromeOptions chromeOptions = new ChromeOptions();
          System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
          chromeOptions.addArguments("webdriver.chrome.driver", "C:\\Users\\Elphill\\eclipse-workspace\\TunesClub\\src\\main\\resources\\driverFactory\\chromedriver.exe");
           // System.setProperty("webdriver.chrome.driver", "C:\\Users\\Elphill\\eclipse-workspace\\MusicPromo\\src\\main\\resources\\Driver\\chromedriver.exe");
          //chromeOptions.addArguments("--headless", "--window-size=1644,868"); 
          driver = new ChromeDriver(chromeOptions);
                 
            
            break;
            
		case FIREFOX:
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            
            driver = new FirefoxDriver(firefoxOptions);
            
		}
		
		
		
		 long timeouts = FileReaderManager.getInstance().getConfigReader().getTime();
		
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		 driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	     return driver;
	}
	
	//Create a constructor for a remote driver
    //Remote webdriver is not implemented	

	private WebDriver createRemoteDriver() {
        throw new RuntimeException("Remote web driver is not yet implemented");
    }
	
	
	//Because we don't want to use another
	private WebDriver createDriver() {
        switch (environmentType) {
        
        //if get the local driver, then will be pass and break
            case lOCAL:
            	driver = createLocalDriver();
                break;
                
        //Otherwise will come to remote driver        
            case REMOTE:
            	driver = createRemoteDriver();
                
        }
        return driver;
    }
	
	
	
	//Create a constructor for get driver. if driver is null so will use create driver. then return driver
	public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

//    public void closeDriver() {
//        driver.close();
//        driver.quit();
//    }
}

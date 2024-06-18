package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SpotifyMarketingPackage {

	public WebDriver driver;
	public SpotifyMarketingPackage(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	
	@FindBy(xpath = "(//input[@type='email'])[1]")
	private WebElement SpotifyMarketingPackageemail;
	
	
	public void SpotifyMarketingemail(String emailPackage) {
		SpotifyMarketingPackageemail.isEnabled();
		SpotifyMarketingPackageemail.sendKeys(emailPackage);
	}

}

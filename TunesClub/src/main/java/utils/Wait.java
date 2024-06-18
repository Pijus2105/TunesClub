package utils;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Wait {
	

	private static void until(WebDriver driver, Long timeOutInSeconds, Function<WebDriver, Boolean> waitCondition) {
        WebDriverWait Wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            Wait.until(waitCondition);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void untilAjaxCallIsDone(WebDriver driver, Long timeOutInSeconds) {
        until(driver, timeOutInSeconds, (function) -> {
            Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
            if (!isJqueryCallDone) 
            System.out.println("jQuery call is in progress");
            return isJqueryCallDone;
        });
        
    }
    
    
    //Instead of this method we can use below method. but up method is time complexity and below method is the space complexity
    
    
    /*
     * Function is a interface 
      
       interface wait {
         void untilAjaxcallIsDone();
         }
         
         public static class Function() {
         
                  wait function = new wait() {
          
            public void untilAjaxcallIsDone(){
          
                 Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
                 if (!isJqueryCallDone) 
                 System.out.println("jQuery call is in progress");
                 return isJqueryCallDone;
              }
          
         }
                     
         
     }
            
  */
  

    public static void untilPageReadyState(WebDriver driver, Long timeOutInSeconds) {
        until(driver, timeOutInSeconds, (function) -> {
            String isPageLoaded = String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"));
            if (isPageLoaded.equals("complete")) {
                return true;
            } else {
                System.out.println("Document is loading");
                return false;
            }
        });
    }
     
    
    

    public static void untilElementIsVisible(WebDriver driver, WebElement webElement, Long timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void untilListElementIsVisible(WebDriver driver, List<WebElement> webElements, Long timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfAllElements(webElements));
    }
	
}

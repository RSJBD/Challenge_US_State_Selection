package USState;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Select_State {

	//Alt+Shift+a == select and type for all 

//	static String stateName="alabama ";
//	static String stateName="alaska  ";
	static String stateName="arizona ";
//	static String stateName="arkansas";
//	static String stateName="california";
//	static String stateName="colorado";
//	static String stateName="connecticut";
//	static String stateName="delaware";
//	static String stateName="district-of-columbia";
//	static String stateName="florida ";
//	static String stateName="georgia ";
//	static String stateName="hawaii  ";
//	static String stateName="idaho   ";
//	static String stateName="illinois";
//	static String stateName="indiana ";
//	static String stateName="iowa    ";
//	static String stateName="kansas  ";
//	static String stateName="kentucky";
//	static String stateName="louisiana  ";
//	static String stateName="maine      ";
//	static String stateName="maryland   ";
//	static String stateName="massachusetts ";
//	static String stateName="michigan      ";
//	static String stateName="minnesota     ";
//	static String stateName="mississippi   ";
//	static String stateName="missouri      ";
//	static String stateName="montana       ";
//	static String stateName="nebraska      ";
//	static String stateName="nevada        ";
//	static String stateName="new-hampshire ";
//	static String stateName="new-jersey    ";
//	static String stateName="new-mexico    ";
//	static String stateName="new-york      ";
//	static String stateName="north-carolina";
//	static String stateName="north-dakota  ";
//	static String stateName="ohio          ";
//	static String stateName="oklahoma      ";
//	static String stateName="oregon        ";
//	static String stateName="pennsylvania  ";
//	static String stateName="rhode-island  ";
//	static String stateName="south-carolina";
//	static String stateName="south-dakota ";
//	static String stateName="tennessee    ";
//	static String stateName="texas        ";
//	static String stateName="utah         ";
//	static String stateName="vermont      ";
//	static String stateName="virginia     ";
//	static String stateName="washington   ";
//	static String stateName="west-virginia";
//	static String stateName="wisconsin    ";
//	static String stateName="wyomingN" ;                       


	public static void clickCountry(String stateName) throws InterruptedException {
		
		String list51="//*[name()='svg' and @id='map-svg']//*[@id='features']//*[name()='g']//*[name()='g' and  @class='region']//*[name()='path' and @id]";
		String iframe="//iframe[@src='https://api.capcvet.org/api/embed/forecast/n0vA38xpQ4J7Tcv4PA4v3NXtr4yo41AQVYaUQ7qr?iframe=1']";

		WebDriver  d=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(d, Duration.ofSeconds(10));
		d.get("https://petdiseasealerts.org/forecast-map#/");
		d.manage().window().maximize();
		try {
			Thread.sleep(10000);
			WebDriver frame = d.switchTo().frame(d.findElement(By.xpath(iframe)));
			Thread.sleep(5000);
			List<WebElement> findElements = frame.findElements(By.xpath(list51));
			System.out.println(findElements.size());
			
			int j=1;
				for (WebElement webElement : findElements) {
				String attribute = webElement.getAttribute("name");
				System.out.println(j+"."+attribute);
				j++;
			}
			task:	for (int i = 0; i < findElements.size(); i++) {
				String attribute = findElements.get(i).getAttribute("name").trim();
				i++;
				System.err.println(i+"."+attribute);
				i--;
				if (attribute.equalsIgnoreCase(stateName)) {
					Thread.sleep(3000);
					Actions a= new Actions(d);
					
//					a.click(findElements.get(i)).perform();
					
/*******************************or*****Clicking ************************************/
					
//					a.moveToElement(findElements.get(i)).build().perform();
//					Thread.sleep(3000);
//					a.click().build().perform();
					
/*******************************OR*****Clicking ***********************************/
					WebElement webElement = w.until(ExpectedConditions.elementToBeClickable(findElements.get(i)));
					a.moveToElement(webElement).build().perform();
					Thread.sleep(3000);
					findElements.get(i).click();	
					break task;
				}
			}
		} catch (InterruptedException e) {}
		
		Thread.sleep(10000);
		d.quit();
	}

	public static void main(String[] args) throws InterruptedException  {

		clickCountry(stateName.trim());
	}

}

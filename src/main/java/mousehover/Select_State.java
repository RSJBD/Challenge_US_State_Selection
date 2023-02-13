package mousehover;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
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
                    

static WebDriver d;
static String list51="//*[name()='svg' and @id='map-svg']//*[@id='features']//*[name()='g']//*[name()='g' and  @class='region']";
static String iframe="//iframe[@src='https://api.capcvet.org/api/embed/forecast/n0vA38xpQ4J7Tcv4PA4v3NXtr4yo41AQVYaUQ7qr?iframe=1']";
static Robot robot;
	public static void clickCountry(String stateName) throws InterruptedException {
		
		
		  d=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(d, Duration.ofSeconds(20));
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
				String attribute = webElement.getAttribute("id");
				System.out.println(j+"."+attribute);
				j++;
			}
			task:	for (int i = 0; i < findElements.size(); i++) {
				String attribute = findElements.get(i).getAttribute("id").trim();
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
//					JavascriptExecutor js = (JavascriptExecutor) d;
//					js.executeScript("arguments[0].scrollIntoView(true);", findElements.get(i));
					WebElement webElement = w.until(ExpectedConditions.elementToBeClickable(findElements.get(i)));
					a.moveToElement(webElement).build().perform();
					Thread.sleep(3000);
					findElements.get(i).click();	
					break task;
				}
			}
		} catch (InterruptedException e) {e.printStackTrace();}
		
		
	}
	
	public static void open() {
		  d=new ChromeDriver();
		WebDriverWait w=new WebDriverWait(d, Duration.ofSeconds(10));
		d.get("https://petdiseasealerts.org/forecast-map#/");
		d.manage().window().maximize();
	}
	
	public static void hover() throws InterruptedException {
		  // Create an instance of the Robot class
        
		try {
			robot = new Robot();
		} catch (AWTException e) {e.printStackTrace();}
        
        // Get the screen dimensions
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        int screenWidth = gc.getBounds().width;
        int screenHeight = gc.getBounds().height;
        
        // Move the mouse from left to right and from top to bottom over the entire screen
       task: for (int x = 0; x < screenWidth; x += 25) {
            for (int y = 0; y < screenHeight; y += 10) {
                robot.mouseMove(x, y);
                Thread.sleep(1);
                if (x==2000) {
                	
                	 break task;
				}
            }
       }
	}

	public static void main(String[] args) throws InterruptedException  {

		clickCountry("oregon");
	}

}

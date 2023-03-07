package playwriteUseToSelect;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Locator;

public class SelectionCounter {

	static String list51="//*[name()='svg' and @id='map-svg']//*[@id='features']//*[name()='g']//*[name()='g' and  @class='region']";
	static String iframe="//iframe[@src='https://api.capcvet.org/api/embed/forecast/n0vA38xpQ4J7Tcv4PA4v3NXtr4yo41AQVYaUQ7qr?iframe=1']";

	public static void name(String Country) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://petdiseasealerts.org/forecast-map#/");
		Thread.sleep(10000);
		FrameLocator frameLocator = page.frameLocator(iframe);
		Locator countrylocator = frameLocator.locator(list51);
		//		page.waitForLoadState();
		task:	for (int i = 0; i < countrylocator.count(); i++) {
			String countryName = countrylocator.nth(i).getAttribute("id").trim();
			System.out.println(i+". "+countryName);
			if ((Country.trim()).contains(countryName.trim())) {
				Locator nth = countrylocator.nth(i);
				nth.hover();Thread.sleep(1000);
				nth.click();
				break task;
			}
		}
		Thread.sleep(4000);
		page.close();
		browserContext.close();
		browser.close();
		playwright.chromium();
	}
	public static void main(String[] args) throws InterruptedException {
		name(stateName);

	}
	//	static String stateName="alabama";
	//	static String stateName="alaska";
	//	static String stateName="arizona";
	//	static String stateName="arkansas";
	//	static String stateName="california";
	//	static String stateName="colorado";
	//	static String stateName="connecticut";
	//	static String stateName="delaware";
//		static String stateName="district-of-columbia";
//	  static String stateName="florida";
	//	static String stateName="georgia ";
	//	static String stateName="hawaii  ";
	//	static String stateName="idaho   ";
	//	static String stateName="illinois";
	//	static String stateName="indiana ";
//		static String stateName="iowa    ";
	//	static String stateName="kansas  ";
	//	static String stateName="kentucky";
	//	static String stateName="louisiana  ";
	//	static String stateName="maine      ";
//		static String stateName="maryland   ";
	//	static String stateName="massachusetts ";
	//	static String stateName="michigan      ";
	//	static String stateName="minnesota     ";
	//	static String stateName="mississippi   ";
	//	static String stateName="missouri      ";
	//	static String stateName="montana       ";
	//	static String stateName="nebraska      ";
//		static String stateName="nevada        ";
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
		static String stateName="wyomingN" ;
}
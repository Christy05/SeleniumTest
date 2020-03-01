import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {

	private static final int SLEEP_INTERVAL = 5000;
	private static final String XPATH = "/html/body/div[9]/div[3]/div[8]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[4]/div/div[2]/div/div/div[1]/a";
	private static final String SEARCH_STRING = "lexisnexis";
	private static final String QUERY_PARAM = "q";
	private static final int IMPLICIT_WAIT = 20;
	private static final int LOAD_WAIT = 30;
	private static final String BASE_URL = "http://www.google.com";
	private static final String DRIVER_LOCATION = "C:\\\\Users\\\\b053jxr\\\\Desktop\\\\Christy\\\\chromedriver.exe";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

	public static void main(String[] args) {

		try {
			System.setProperty(WEBDRIVER_CHROME_DRIVER,
					DRIVER_LOCATION);

			WebDriver driver = new ChromeDriver();
			driver.get(BASE_URL);

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(LOAD_WAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

			driver.findElement(By.name(QUERY_PARAM)).clear();
			driver.findElement(By.name(QUERY_PARAM)).sendKeys(SEARCH_STRING);
			driver.findElement(By.name(QUERY_PARAM)).sendKeys(Keys.ENTER);
			
			Thread.sleep(SLEEP_INTERVAL);
			
			WebElement link = driver.findElement(By.xpath(XPATH));
			link.click();

			System.out.println("Title: " +driver.getTitle());

			driver.close();
		} catch (InterruptedException e) {
			System.err.println("Unable to process. Err -> " +e.getMessage());
		}
	}

}

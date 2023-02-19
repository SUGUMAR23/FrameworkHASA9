package pompages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewOpportunities {

	public static void main(String[] args) {
		
		//Launching Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse Workspace\\selenium\\Selenium Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Enter the URL
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Enter User Name and Password
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Home Page Verification
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Home"));
		System.out.println("Home Page is Verified");
		
		//Clicking on Opportunities Module
		driver.findElement(By.xpath("(//a[text()='Opportunities'])[1]")).click();
		wait.until(ExpectedConditions.titleContains("Opportunities"));
		System.out.println("Opportunities page is Displayed");
		
		//Clicking on new opportunities button
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		
		//Enter the necessary details 
		driver.findElement(By.name("potentialname")).sendKeys("Advertisment");
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
		
		//Get WindowHandles
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		
		//Move cursor to Child Window
		List<String> list = new ArrayList<String>(handles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//a[text()='ABC Company']")).click();
		
		//Move cursor to Parent Window
		driver.switchTo().window(list.get(0));
		driver.findElement(By.name("opportunity_type")).sendKeys("New Business");
		driver.findElement(By.name("leadsource")).sendKeys("Web Site");
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[4]")).click();
		
		//Print the window handles
		Set<String> handle1 = driver.getWindowHandles();
		System.out.println(handle1);
		
		//Point to the cursor Child window
		List<String> list1 = new ArrayList<String>(handle1);
		driver.switchTo().window(list1.get(1));
		driver.findElement(By.xpath("//a[text()='Digital Advertisement']")).click();
		
		//Cursor back to navigate Parent Window
		driver.switchTo().window(list.get(0));
		driver.findElement(By.name("amount")).sendKeys("100");
		driver.findElement(By.name("closingdate")).sendKeys("2023-03-30");
		driver.findElement(By.id("nextstep")).sendKeys("Come to Showroom");
		driver.findElement(By.name("sales_stage")).sendKeys("Qualification");
		driver.findElement(By.id("probability")).sendKeys("90");
		driver.findElement(By.name("description")).sendKeys("That is great Opportunities");
		
		//Clicking on save button
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		//Again clicking on Opportunities Module
		driver.findElement(By.xpath("(//a[text()='Opportunities'])[1]")).click();
		
		//Log Out the Application
		WebElement logOut = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(logOut).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//Quit the browser
		driver.quit();
		
	}

}

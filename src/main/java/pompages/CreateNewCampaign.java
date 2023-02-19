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

public class CreateNewCampaign {

	public static void main(String[] args) {
		
		//Launching Browser
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse Workspace\\selenium\\Selenium Software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Enter the URL
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Enter User Name and Password
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Home Page Verification
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Home"));
		System.out.println("Home Page is Verified");
		
		//Click on Campaign Module
		WebElement morebutton = driver.findElement(By.xpath("//a[text()='More']"));
		Actions act = new Actions(driver);
		act.moveToElement(morebutton).perform();
		driver.findElement(By.name("Campaigns")).click();
		
		//Click on create new Campaign button
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		//Enter the necessary details in the create new campaign page
		driver.findElement(By.name("campaignname")).sendKeys("Digital Advertisement");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		driver.findElement(By.name("campaigntype")).sendKeys("Advertisement");
		driver.findElement(By.id("targetaudience")).sendKeys("1000");
		driver.findElement(By.id("sponsor")).sendKeys("TATA");
		driver.findElement(By.id("numsent")).sendKeys("70");
		driver.findElement(By.name("campaignstatus")).sendKeys("Active");
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
		
		//To print the Multiple windowhandle
		Set<String> handle = driver.getWindowHandles();
		System.out.println(handle);
		
		//Cursor point to the Child window
		List<String> list = new ArrayList<String>(handle);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//a[text()='TATA Nano']")).click();
		
		//Cursor back navigate to parent Window
		driver.switchTo().window(list.get(0));
		driver.findElement(By.name("closingdate")).sendKeys("2023-03-25");
		driver.findElement(By.id("targetsize")).sendKeys("1000");
		
		//Expectations and Actual details
		driver.findElement(By.name("budgetcost")).sendKeys("100000");
		driver.findElement(By.name("expectedresponse")).sendKeys("Good");
		driver.findElement(By.id("expectedsalescount")).sendKeys("950");
		driver.findElement(By.id("expectedresponsecount")).sendKeys("550");
		driver.findElement(By.name("expectedroi")).sendKeys("100");
		driver.findElement(By.name("actualcost")).sendKeys("110");
		driver.findElement(By.name("expectedrevenue")).sendKeys("120");
		driver.findElement(By.id("actualsalescount")).sendKeys("850");
		driver.findElement(By.id("actualresponsecount")).sendKeys("700");
		driver.findElement(By.name("actualroi")).sendKeys("150");
		
		//Description Details
		driver.findElement(By.name("description")).sendKeys("This campaign will take place in LuLu Mall, Bangalore");
		
		//Clicking on Save Button
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		//Again clicking on Campaign Module
		driver.findElement(By.xpath("(//a[text()='Campaigns'])[1]")).click();
		
		//Logging Out the Application
		WebElement logOut = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		act.moveToElement(logOut).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//Quit the Application
		driver.quit();
	}

}

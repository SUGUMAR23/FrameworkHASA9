package pompages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewLead {

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
		
		//Click on lead Module
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		
		//Enter the necessary details of leads
		driver.findElement(By.name("salutationtype")).sendKeys("Mr.");
		driver.findElement(By.name("firstname")).sendKeys("John");
		driver.findElement(By.name("lastname")).sendKeys("clark");
		driver.findElement(By.name("company")).sendKeys("infoys privated limited");
		driver.findElement(By.id("designation")).sendKeys("Sales Manager");
		driver.findElement(By.name("leadsource")).sendKeys("Direct Mail");
		driver.findElement(By.name("industry")).sendKeys("Banking");
		driver.findElement(By.name("annualrevenue")).sendKeys("65000000");
		driver.findElement(By.id("noofemployees")).sendKeys("5000");
		driver.findElement(By.id("secondaryemail")).sendKeys("john.clark@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9899012200");
		driver.findElement(By.id("mobile")).sendKeys("8823780034");
		driver.findElement(By.id("fax")).sendKeys("9980290477");
		driver.findElement(By.id("email")).sendKeys("johnClark@apple.com");
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.apple.com");
		driver.findElement(By.name("leadstatus")).sendKeys("Qualified");
		driver.findElement(By.name("rating")).sendKeys("Active");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		
		//Address Information
		driver.findElement(By.xpath("//textarea[@name='lane']")).sendKeys("1st street, 11th cross, Basavagudi");
		driver.findElement(By.id("pobox")).sendKeys("121");
		driver.findElement(By.id("code")).sendKeys("590089");
		driver.findElement(By.id("city")).sendKeys("Bangalore");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("state")).sendKeys("Karnataka");
		
		//Description Details
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Thanks for the information");
		
		//Click on the Save Button
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		
		//Again clicking on lead Module
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		
		//Log Out the Application
		WebElement logOut = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(logOut).perform();
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
		//Quit the browser
		driver.quit();
		
	}

}

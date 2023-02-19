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

public class CreateNewVendor {

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
		
		//Clicking on vendor module
		WebElement vendorModule = driver.findElement(By.xpath("//a[text()='More']"));
		Actions act = new Actions(driver);
		act.moveToElement(vendorModule).perform();
		driver.findElement(By.xpath("//a[text()='Vendors']")).click();
		
		//Clicking on new vendor create button
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		
		//Enter the necessary details in create new vendor page
		driver.findElement(By.name("vendorname")).sendKeys("Balaji Automobilies");
		driver.findElement(By.id("email")).sendKeys("balaji_automobilies@gmail.com");
		driver.findElement(By.name("glacct")).sendKeys("301-Sales-Hardware");
		driver.findElement(By.id("category")).sendKeys("Automobile");
		driver.findElement(By.id("phone")).sendKeys("9867435471");
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.balajiautomobilies.com");
		
		//Enter Vendor Address Information
		driver.findElement(By.xpath("//textarea[@name='street']")).sendKeys("Nagavara Flyover, 2rd Cross, Nagavara");
		driver.findElement(By.id("city")).sendKeys("Bangalore");
		driver.findElement(By.id("postalcode")).sendKeys("784567");
		driver.findElement(By.id("pobox")).sendKeys("44");
		driver.findElement(By.id("state")).sendKeys("Karnataka");
		driver.findElement(By.id("country")).sendKeys("India");
		
		//Enter the Description Details
		driver.findElement(By.name("description")).sendKeys("You are the first customer. Happy to welcome you!!!!");
		
		//Saving the entered details
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		
		//Again Clicking on Vendor Module 
		driver.findElement(By.xpath("(//a[text()='Vendors'])[1]")).click();
		
		//Log Out the Application
		WebElement logOut = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		act.moveToElement(logOut).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//Quit the browser
		driver.quit();
		
		
		
		
		
		

	}

}

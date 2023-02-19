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

public class CreateNewOrganization {
		public static void main(String[] args) throws InterruptedException {
		
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
		
		//Organization Information
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys("ABC Company");
	    driver.findElement(By.name("website")).sendKeys("www.abc.com");
	    driver.findElement(By.id("employees")).sendKeys("1000");
	    driver.findElement(By.id("email2")).sendKeys("sales.abc@gmail.com");
	    driver.findElement(By.name("industry")).sendKeys("Engineering");
	    driver.findElement(By.name("emailoptout")).click();
	    driver.findElement(By.xpath("//input[@value='T']")).click();
	    driver.findElement(By.id("phone")).sendKeys("7896534612");
	    driver.findElement(By.id("fax")).sendKeys("88323213");
	    driver.findElement(By.id("otherphone")).sendKeys("7845690218");
	    driver.findElement(By.id("email1")).sendKeys("info.abc@gmail.com");
	    driver.findElement(By.id("ownership")).sendKeys("ABC Foundation");
	    driver.findElement(By.name("rating")).sendKeys("Active");
	    driver.findElement(By.id("siccode")).sendKeys("45678");
	    driver.findElement(By.name("annual_revenue")).sendKeys("55000000");
	    driver.findElement(By.xpath("//input[@name='notify_owner']")).click();
	    
	    //Address Information
	    driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys("2rd Street, 1st cross, Rajaji Nagar");
	    driver.findElement(By.id("bill_pobox")).sendKeys("2");
	    driver.findElement(By.id("bill_city")).sendKeys("Bangalore");
	    driver.findElement(By.id("bill_state")).sendKeys("Karnataka");
	    driver.findElement(By.id("bill_code")).sendKeys("570098");
	    driver.findElement(By.id("bill_country")).sendKeys("India");
	    driver.findElement(By.xpath("//input[@onclick='return copyAddressRight(EditView)']")).click();
	    
	    //Description
	    driver.findElement(By.name("description")).sendKeys("Welcome to the organization");
	    
	    //Click on Save Button
	    driver.findElement(By.xpath("//input[@accesskey='S']")).click();
	    
	    Thread.sleep(6000);
	    
	    //Click Organization list Page
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//Log Out the Application
		WebElement logOut = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(logOut).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//Quit the browser
		driver.quit();
		
		
		
	}
}

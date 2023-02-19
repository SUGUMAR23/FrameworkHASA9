package pompages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatingNewSalesOrder {

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
		
		//Click on Campaign Module
		WebElement morebutton = driver.findElement(By.xpath("//a[text()='More']"));
		Actions act = new Actions(driver);
		act.moveToElement(morebutton).perform();
		driver.findElement(By.name("Sales Order")).click();
		
		//Clicking on new create sales Order
		driver.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
		
		//Entering sales order information
		driver.findElement(By.name("subject")).sendKeys("Nano Car Sales Order");
		driver.findElement(By.id("customerno")).sendKeys("9964210976");
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[4]")).click();
		
		//Print the Window Handle
		Set<String> handle = driver.getWindowHandles();
		System.out.println(handle);
		
		//Point to the cursor Child Window
		List<String> list = new ArrayList<String>(handle);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//a[text()='Quotation']")).click();
		
		//Point to the cursor Parent Window
		driver.switchTo().window(list.get(0));
		
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[5]")).click();
		
		//Print out Window Handle 
		Set<String> handle1 = driver.getWindowHandles();
		System.out.println(handle1);
		
		//Point to the cursor Child Window
		List<String> list1 = new ArrayList<String>(handle1);
		driver.switchTo().window(list1.get(1));
		driver.findElement(By.xpath("//a[text()='Smith Allen']")).click();
		
		//Alert Handle
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Point to the Cursor Parent Window
		driver.switchTo().window(list1.get(0));
		
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
		
		//Print Out Window Handle
		Set<String> handle2 = driver.getWindowHandles();
		System.out.println(handle2);
		
		//Point to the cursor Child Window
		List<String> list2 = new ArrayList<String>(handle2);
		driver.switchTo().window(list2.get(1));
		driver.findElement(By.xpath("//a[text()='Advertisment']")).click();
		
		//Point to the cursor Parent Window
		driver.switchTo().window(list2.get(0));
		driver.findElement(By.id("vtiger_purchaseorder")).sendKeys("11");
		driver.findElement(By.name("duedate")).sendKeys("2023-06-15");
		driver.findElement(By.id("pending")).sendKeys("2");
		driver.findElement(By.id("salescommission")).sendKeys("6");
		
		//Enter Recurring Invoice Information details
		driver.findElement(By.xpath("//input[@name='start_period']")).sendKeys("2023-06-16");
		driver.findElement(By.name("payment_duration")).sendKeys("Net 45 days");
		driver.findElement(By.name("recurring_frequency")).sendKeys("Monthly");
		driver.findElement(By.xpath("//input[@name='end_period']")).sendKeys("2023-07-20");
		driver.findElement(By.name("invoicestatus")).sendKeys("Created");
		
		//Terms and Conditions Description
		WebElement termsAndConditions = driver.findElement(By.name("terms_conditions"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=' '", termsAndConditions);
		termsAndConditions.sendKeys("Sales order is ready");
		
		//Description Details
		driver.findElement(By.name("description")).sendKeys("Sales order is to procced next stage");
		
		//Clicking on save Button
		driver.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		
		//Again clicking on Sales Order Module
		driver.findElement(By.xpath("(//a[text()='Sales Order'])[1]")).click();
		
		//Logging Out the Application
		WebElement logOut = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		act.moveToElement(logOut).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//Quit the Application
		driver.quit();
		
		
		

	}

}

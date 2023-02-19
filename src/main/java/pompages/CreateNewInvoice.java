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

public class CreateNewInvoice {

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
		driver.findElement(By.xpath("//a[text()='Invoice']")).click();
		
		//Clinking on new create invoice Button
		driver.findElement(By.xpath("//img[@alt='Create Invoice...']")).click();
		
		//Enter the invoice information
		driver.findElement(By.name("subject")).sendKeys("Nano Car Invoice");
		driver.findElement(By.id("customerno")).sendKeys("5667");
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[4]")).click();
		
		//Print out the Window Handles
		Set<String> handle = driver.getWindowHandles();
		System.out.println(handle);
		
		//Point to the cursor child Window
		List<String> list = new ArrayList<String>(handle);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//a[text()='Smith Allen']")).click();
		
		//Handle PopUp
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Point to cursor Parent Window
		driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("//input[@name='duedate']")).sendKeys("2023-07-15");
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[5]")).click();
		
		//Print out the Window Handles
		Set<String> handle1 = driver.getWindowHandles();
		System.out.println(handle1);
		
		//Point to the cursor child Window
		List<String> list1 = new ArrayList<String>(handle1);
		driver.switchTo().window(list1.get(1));
		driver.findElement(By.xpath("//a[text()='ABC Company']")).click();
		
		//Handle PopUp
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		//Point to cursor Parent Window
		driver.switchTo().window(list1.get(0));
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
		
		//Print out the Window Handles
		Set<String> handle2 = driver.getWindowHandles();
		System.out.println(handle2);
		
		//Point to the cursor child Window
		List<String> list2 = new ArrayList<String>(handle2);
		driver.switchTo().window(list2.get(1));
		driver.findElement(By.xpath("//a[text()='Nano Car Sales Order']")).click();
		
		//Point to cursor Parent Window
		driver.switchTo().window(list2.get(0));
		driver.findElement(By.xpath("//input[@name='invoicedate']")).sendKeys("2023-07-01");
		driver.findElement(By.id("vtiger_purchaseorder")).sendKeys("99");
		driver.findElement(By.id("salescommission")).sendKeys("3");
		driver.findElement(By.xpath("//select[@name='invoicestatus']")).sendKeys("Created");
		
		//Enter the terms and conditions details
		WebElement termsandconditions = driver.findElement(By.name("terms_conditions"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=' '", termsandconditions);
		termsandconditions.sendKeys("Invoice is ready to dispatch");
		
		//Enter the Description details
		driver.findElement(By.name("description")).sendKeys("Invoice is compeletely ready");
		
		//Save the enter the details
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[2]")).click();
		
		//Again clicking on Invoice Module
		driver.findElement(By.xpath("(//a[text()='Invoice'])[1]")).click();
		
		//Logging Out the Application
		WebElement logOut = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		act.moveToElement(logOut).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//Quit the Application
		driver.quit();
		
		
		
		
		
		
		
		

	}

}

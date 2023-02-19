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

public class CreateNewProduct {

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
		
		//Click on Product Module
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		//Clicking on new create product button
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//Enter the necessary details
		driver.findElement(By.name("productname")).sendKeys("TATA Nano");
		driver.findElement(By.xpath("//input[@name='sales_start_date']")).sendKeys("2023-04-01");
		driver.findElement(By.name("productcategory")).sendKeys("Hardware");
		driver.findElement(By.xpath("//input[@name='sales_end_date']")).sendKeys("2023-06-01");
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
		
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		List<String> list = new ArrayList<String>(handles);
		
		//Navigate cursor to child Window
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//a[text()='Balaji Automobilies']")).click();
		
		//Navigate cursor to Parent Window
		driver.switchTo().window(list.get(0));
		driver.findElement(By.id("vendor_part_no")).sendKeys("23");
		driver.findElement(By.id("productsheet")).sendKeys("Mild Iron");
		driver.findElement(By.name("glacct")).sendKeys("301-Sales-Hardware");
		driver.findElement(By.id("productcode")).sendKeys("456hgdtzc89");
		driver.findElement(By.name("manufacturer")).sendKeys("MetBeat Corp");
		driver.findElement(By.name("start_date")).sendKeys("2023-04-01");
		driver.findElement(By.name("expiry_date")).sendKeys("2024-03-30");
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.BalajiAutomobilies.com");
		driver.findElement(By.id("mfr_part_no")).sendKeys("bhyb462332dsjhd");
		driver.findElement(By.id("serial_no")).sendKeys("Rghy65");
		
		//Enter Pricing Information
		driver.findElement(By.id("unit_price")).sendKeys("300");
		driver.findElement(By.id("tax1_check")).click();
		driver.findElement(By.id("tax2_check")).click();
		driver.findElement(By.id("tax3_check")).click();
		driver.findElement(By.id("commissionrate")).sendKeys("12");
		
		//Enter the Stock Information
		driver.findElement(By.xpath("//select[@name='usageunit']")).sendKeys("Box");
		driver.findElement(By.id("qtyinstock")).sendKeys("550");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		driver.findElement(By.id("qty_per_unit")).sendKeys("1");
		driver.findElement(By.id("reorderlevel")).sendKeys("2");
		driver.findElement(By.id("qtyindemand")).sendKeys("300");
		
		//Upload Product Image 
		//driver.findElement(By.id("my_file_element")).sendKeys("E:\\");
		
		//Enter the description details
		driver.findElement(By.name("description")).sendKeys("The nature colur is violet. it is petrol engine car. It have four stroke engine");
		
		//Click on Save Button
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		//Again clicking on Product Module
		driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
		
		//Log Out the Application
		WebElement logOut = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(logOut).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
		//Quit the browser
		driver.quit();
	}

}

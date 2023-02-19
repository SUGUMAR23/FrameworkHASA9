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

public class CreateNewQuotation {

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
		driver.findElement(By.name("Quotes")).click();
		wait.until(ExpectedConditions.titleContains("Quotes"));
		System.out.println("Quotes Page is Displayed");
		
		//Clicking on creating new Quotes button
		driver.findElement(By.xpath("//img[@alt='Create Quote...']")).click();
		driver.findElement(By.name("subject")).sendKeys("Quotation");
		driver.findElement(By.name("validtill")).sendKeys("2023-03-30");
		driver.findElement(By.name("carrier")).sendKeys("DHL");
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
		
		//Print window handle
		Set<String> handle = driver.getWindowHandles();
		System.out.println(handle);
		
		//Point to the cursor Child Window
		List<String> list = new ArrayList<String>(handle);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//a[text()='Advertisment']")).click();
		
		//Point to the cursor Parent Window
		driver.switchTo().window(list.get(0));
		driver.findElement(By.name("quotestage")).sendKeys("Created");
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[4]")).click();
		
		//Again Print out Window Handle
		Set<String> handle1 = driver.getWindowHandles();
		System.out.println(handle1);
		
		//Point to the cursor Child Browser
		List<String> list1 = new ArrayList<String>(handle1);
		driver.switchTo().window(list1.get(1));
		driver.findElement(By.xpath("//a[text()='Smith Allen']")).click();
		
		//Handling Allert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Point to the cursor Parrent Window
		driver.switchTo().window(list1.get(0));
		driver.findElement(By.id("shipping")).sendKeys("Not Delivered");
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[5]")).click();
		
		//Again get the Window Handle
		Set<String> handle2 = driver.getWindowHandles();
		System.out.println(handle2);
		
		//Point to the cursor Child Window
		List<String> list2 = new ArrayList<String>(handle2);
		driver.switchTo().window(list2.get(1));
		driver.findElement(By.xpath("//a[text()='ABC Company']")).click();
		
		//Alert Handle
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		//Point to the cursor Parent Window
		driver.switchTo().window(list2.get(0));
		
		//Enter the Terms And Conditions
		WebElement termsAndCondition = driver.findElement(By.name("terms_conditions"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=' '", termsAndCondition);
		termsAndCondition.sendKeys("This is New Quotes It include 18% GST");
		
		//Description Details
		driver.findElement(By.name("description")).sendKeys("Quotation is ready");
		
		//Enter the iteam details
		driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
		
		//get Window Handle
		Set<String> handle3 = driver.getWindowHandles();
		System.out.println(handle3);
		
		//Point to the Cursor child window
		List<String> list3 = new ArrayList<String>(handle3);
		driver.switchTo().window(list3.get(1));
		driver.findElement(By.xpath("//a[text()='TATA Nano']")).click();
		
		//Point to the cursor Parent window
		driver.switchTo().window(list3.get(0));
		driver.findElement(By.id("qty1")).sendKeys("10");
		
		//Click on Save Button
		driver.findElement(By.xpath("(//input[@accesskey='S'])[2]")).click();
		
		//Again clicking on Quotes Module
		driver.findElement(By.xpath("(//a[text()='Quotes'])[1]")).click();
		
		//Log Out the Application
		WebElement logOut = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(logOut).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//Quit the browser
		driver.quit();
	}

}

package pompages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateNewContact {

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
				
				//Click on Contact Module
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				//Click on New Contact Button
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				//Enter Contact Information
				driver.findElement(By.name("salutationtype")).sendKeys("Mr.");
				driver.findElement(By.name("firstname")).sendKeys("Smith");
				driver.findElement(By.name("lastname")).sendKeys("Allen");
				driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
			
				Set<String> handles = driver.getWindowHandles();
				System.out.println(handles);
				List<String> list = new ArrayList<String>(handles);
				
				//Navigate cursor to child Window
				driver.switchTo().window(list.get(1));
				driver.findElement(By.id("1")).click();
				
				//Navigate cursor to Parent Window
				driver.switchTo().window(list.get(0));
				driver.findElement(By.name("leadsource")).sendKeys("Web Site");
				driver.findElement(By.id("title")).sendKeys("Manager");
				driver.findElement(By.id("department")).sendKeys("Production");
				driver.findElement(By.id("email")).sendKeys("smith.allen@abc.com");
				driver.findElement(By.id("assistant")).sendKeys("Quality"); 
				driver.findElement(By.id("assistantphone")).sendKeys("9087453276");
				driver.findElement(By.name("emailoptout")).click();
				driver.findElement(By.name("reference")).click();
				driver.findElement(By.name("notify_owner")).click();
				driver.findElement(By.name("phone")).sendKeys("044-8756342568");
				driver.findElement(By.id("mobile")).sendKeys("7684532980");
				driver.findElement(By.id("homephone")).sendKeys("7744997653");
				driver.findElement(By.id("otherphone")).sendKeys("9967456387");
				driver.findElement(By.id("fax")).sendKeys("6543689877");
				driver.findElement(By.name("birthday")).sendKeys("1998-02-17");
				driver.findElement(By.id("secondaryemail")).sendKeys("smithallen@gmail.com");
				driver.findElement(By.name("donotcall")).click();
				driver.findElement(By.xpath("//input[@value='T']")).click();
				
				//Customer Portal Information
				driver.findElement(By.name("portal")).click();
				driver.findElement(By.name("support_start_date")).sendKeys("2023-06-01");
				driver.findElement(By.name("support_end_date")).sendKeys("2026-05-30");
				
				//Description
				driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[3]")).sendKeys("Welcome to your organization");
				
				//Click on Save Button
				driver.findElement(By.xpath("(//input[@accesskey='S'])[2]")).click();
				
				//Navigate to Contacts List Page
				driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
				
				//Log Out the Application
				WebElement logOut = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
				Actions act = new Actions(driver);
				act.moveToElement(logOut).perform();
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
				//Quit the browser
				driver.quit();
				
				
				
				
	}

}

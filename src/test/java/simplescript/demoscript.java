package simplescript;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class demoscript {

	public static void main(String[] args) {


             //GENERATE Random Number
				Random ran = new Random();
				int random = ran.nextInt(1000);
				
				//Step 1:Launch Browser
				WebDriverManager.firefoxdriver().setup();
				WebDriver driver = new FirefoxDriver();
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get("http://localhost:8888");
				
				//Step 2:Login to app
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				//Step 3: Navigate to organization link
				driver.findElement(By.linkText("Organizations")).click();
				
				//step 4:click on create look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//step 5: click on create organization look up image
				driver.findElement(By.name("accountname")).sendKeys("Dominos"+random);
				
				//step 6:Save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//step 7: Validate
				String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(OrgHeader.contains("Dominos"+random))
				{
					System.out.println("=== PASS ===");
				}
				
				else
				{
					System.out.println("=== FAIL ===");
				}
				
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(ele).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Signout successfull");
				
				driver.close(); 
			}
				
	

	}



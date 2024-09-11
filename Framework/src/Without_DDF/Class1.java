package Without_DDF;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Class1 
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		WebDriver j= new ChromeDriver();
		j.manage().window().maximize();
		j.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		j.get("https://www.saucedemo.com/");
		j.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
		j.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
		WebElement robot = j.findElement(By.xpath("//div[@class='bot_column']"));
		
		File scr = robot.getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(scr, new File("F:\\Excel\\sc.jpg"));
		FileUtils.copyFile(scr,  new File("F:\\Excel\\scr.jpg"));
		j.findElement(By.xpath("//input[@name='login-button']")).click();
		
		Thread.sleep(2000);
		
		WebElement logo = j.findElement(By.xpath("//div[@class='app_logo']"));
	
				
		
		boolean logo1 = logo.isDisplayed();
		
		if(logo1==true)
		{
			System.out.println("logo is present ");
		}
		else
		{
			System.out.println("logo is not present");
		}
		
		j.findElement(By.xpath("//button[text()='Open Menu']")).click();
		j.findElement(By.xpath("//a[text()='Logout']")).click();
		
		Thread.sleep(2000);
		j.close();
	
	}

}

package Without_DDF;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class16 
{
	public static void main(String[] args)
	{
		
		WebDriver j= new ChromeDriver();
		j.manage().window().maximize();
		j.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		j.get("https://www.saucedemo.com/");
		j.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
		j.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
		j.findElement(By.xpath("//input[@name='login-button']")).click();
		
		
		
		boolean logo = j.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		
		if(logo==true)
		{
			System.out.println("logo is present ");
		}
		else
		{
			System.out.println("logo is not present");
		}
		
		j.findElement(By.xpath("//button[text()='Open Menu']")).click();
		j.findElement(By.xpath("//a[text()='Logout']")).click();
	
	}

}

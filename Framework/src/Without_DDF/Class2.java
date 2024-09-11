package Without_DDF;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class2 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver n= new ChromeDriver();
		n.get("https://www.saucedemo.com/");
		n.manage().window().maximize();
		n.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		n.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("performance_glitch_user");
		n.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
		n.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		boolean logo = n.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		if(logo == true)
		{
			System.out.println("logo is present :pass");
		}
		else
		{
			System.out.println("logo is  not present");
		}
		
		n.findElement(By.xpath("//button[text()='Open Menu']")).click();
		n.findElement(By.xpath("//a[text()='Logout']")).clear();
		Thread.sleep(2000);
		n.quit();
	}

}

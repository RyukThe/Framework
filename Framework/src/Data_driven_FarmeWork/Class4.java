package Data_driven_FarmeWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class4 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
	{
		FileInputStream m= new FileInputStream("F:\\Excel\\Book1.xlsx");
		Sheet sh = WorkbookFactory.create(m).getSheet("Sheet5");
		String user1 = sh.getRow(0).getCell(0).getStringCellValue();
		String pass = sh.getRow(0).getCell(1).getStringCellValue();
		String user2 = sh.getRow(1).getCell(0).getStringCellValue();
		
		WebDriver m1 = new ChromeDriver();
		m1.get("https://www.saucedemo.com/");
		m1.manage().window().maximize();
		m1.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		m1.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(user1);
		
		m1.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		m1.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		boolean logo = m1.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		
		if(logo == true)
		{
			System.out.println("logo is present --- pass");
		}
		else
		{
			System.out.println(" logo is not present -- fail");
		}
		
		m1.findElement(By.xpath("//button[text()='Open Menu']")).click();
		m1.findElement(By.xpath("//a[text()='Logout']")).click();
		m1.close();
		Thread.sleep(2000);
		user2();
	}
	
	public static void user2() throws InterruptedException
	{
		WebDriver m1 = new ChromeDriver();
		m1.get("https://www.saucedemo.com/");
		m1.manage().window().maximize();
		m1.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		m1.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("problem_user");
		m1.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
		m1.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		boolean logo = m1.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		
		if(logo == true)
		{
			System.out.println("logo is present --- pass");
		}
		else
		{
			System.out.println(" logo is not present -- fail");
		}
		
		m1.findElement(By.xpath("//button[text()='Open Menu']")).click();
		m1.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(2000);
		m1.close();
		
	}

}

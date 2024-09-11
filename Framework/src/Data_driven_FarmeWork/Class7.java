package Data_driven_FarmeWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class7
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{
		FileInputStream xl= new FileInputStream("F:\\Excel\\Book1.xlsx");
		Sheet sh = WorkbookFactory.create(xl).getSheet("Sheet5");
		
		WebDriver m = new ChromeDriver();
		m.manage().window().maximize();
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		m.get("https://www.saucedemo.com/");
		m.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(sh.getRow(1).getCell(0).getStringCellValue());
		m.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sh.getRow(1).getCell(1).getStringCellValue());
		m.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		boolean log = m.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		if(log==true)
		{
			System.out.println("logo is present ");
			
			
		}
		else
		{
			System.out.println("logo is not present ");
		}
	
		m.findElement(By.xpath("//button[text()='Open Menu']")).click();
		m.findElement(By.xpath("//a[text()='Logout']")).click();
		m.quit();
	}
		
	

}

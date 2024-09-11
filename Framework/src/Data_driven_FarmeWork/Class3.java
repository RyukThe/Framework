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

public class Class3 
{
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
	{
		FileInputStream xl= new FileInputStream("F:\\Excel\\Book1.xlsx");
		Sheet sh = WorkbookFactory.create(xl).getSheet("Sheet5");
				String use = sh.getRow(0).getCell(0).getStringCellValue();
				String pass = sh.getRow(0).getCell(1).getStringCellValue();
	
		WebDriver n = new ChromeDriver();
		n.manage().window().maximize();
		n.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		n.get("https://www.saucedemo.com/");
		n.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(use);
		n.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		n.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		boolean logo = n.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		if(logo==true)
		{
			System.out.println("logo is present- pass ");
		}
		else
		{
			System.out.println("logo is present");
		}
		Thread.sleep(2000);
		
		n.findElement(By.xpath("//button[text()='Open Menu']")).click();
		n.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(2000);
		n.close();
		
		
		
		
	}

}

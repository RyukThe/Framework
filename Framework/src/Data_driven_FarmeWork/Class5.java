package Data_driven_FarmeWork;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class5 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
	{
		FileInputStream m= new FileInputStream("F:\\Excel\\Book1.xlsx");
		Sheet sd = WorkbookFactory.create(m).getSheet("Sheet5");
		String user = sd.getRow(1).getCell(0).getStringCellValue();
		String pass=sd.getRow(1).getCell(1).getStringCellValue();
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		
		boolean logo = driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		if(logo == true)
		{
			System.out.println("logo is present : pass");
		}
		else
		{
			System.out.println("log is not present :fail");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(2000);
		driver.close();
		
	}

}

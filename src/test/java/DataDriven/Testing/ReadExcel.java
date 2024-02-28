package DataDriven.Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadExcel {
	public static WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	@Test
	public void Login() throws FileNotFoundException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\maven\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();

		File src = new File("C:\\Users\\Sanket\\eclipse-workspace\\Testing\\TestData.xlsx");

		FileInputStream fis = new FileInputStream(src);

		workbook = new XSSFWorkbook(fis);

		sheet = workbook.getSheetAt(0);

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			cell = sheet.getRow(i).getCell(0);
			driver.findElement(By.xpath("//input[@name='email']")).clear();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(cell.getStringCellValue());
			
			System.out.println("Hello Github");

			cell = sheet.getRow(i).getCell(1);
			driver.findElement(By.xpath("//input[@id = 'pass']")).clear();
			driver.findElement(By.xpath("//input[@id = 'pass']")).sendKeys(cell.getStringCellValue());

			driver.close();
		}

	}

}

package mobile.org;

public class Flipkart {
	

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Assert;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class FlipkartTaskMobile {
		
		static WebDriver driver;
		@BeforeClass
		public static void openBrowser() {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kalees\\eclipse-workspace\\FlipkartTask.Junit\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			
		}
		
		@AfterClass
		public static void closeBrowser () {
			
		}
		static long startTime;
		@Before
		public void beforeTest() {
			startTime = System.currentTimeMillis();
			
		}
		@After
		public void afterTest() {
			long endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
		}
		@Test
		public void a() {
			
			WebElement clickBtn = driver.findElement(By.xpath("//button[text()='✕']"));
			clickBtn.click();
		}
		@Test
		public void b() {
			
			WebElement searchName = driver.findElement(By.xpath("//input[@type='text']"));	
			searchName.sendKeys("mi mobiles");
			WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));	
			searchBtn.click();
		}
		@Test
		public void c() throws Exception {
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement mName = driver.findElement(By.xpath("(//div[contains(@class,'rR')])[1]"));
			String Name = mName.getText();
			mName.click();
			File f = new File("C:\\Users\\Kalees\\Desktop\\Mobliread.xlsx");
			FileInputStream f1 = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(f1);
			Sheet s = w.getSheet("Sheet1");
			s.getRow(0).createCell(1).setCellValue(Name);
			FileOutputStream f2 = new FileOutputStream(f);
			w.write(f2);
			f2.close();
			w.close();
		}
		@Test
		public void d() throws Exception {
			
			Set<String> allWin = driver.getWindowHandles();
			List<String> win = new ArrayList<String>();
			win.addAll(allWin);
			String pWin = win.get(1);
			driver.switchTo().window(pWin);
			WebElement getName = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
			String mobName = getName.getText();
			File f = new File("C:\\Users\\Kalees\\Desktop\\Mobliread.xlsx");
			FileInputStream f1 = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(f1);
			Sheet s = w.getSheet("Sheet1");
			String d = s.getRow(0).getCell(1).getStringCellValue();
			w.close();
			Assert.assertEquals(d,mobName);
		}
		@Test
		public void e() throws Exception {
			
			TakesScreenshot t = (TakesScreenshot)driver;
			File source = t.getScreenshotAs(OutputType.FILE);
			File target = new File("C:\\Users\\Kalees\\eclipse-workspace\\FlipkartTask.Junit\\src\\test\\resources\\Screenshots\\Screen.png");
			FileUtils.copyFile(source, target);
			
			WebElement scroll = driver.findElement(By.xpath("//div[@class='_2MJMLX']"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", scroll);
			File source1 = t.getScreenshotAs(OutputType.FILE);
			File target1 = new File("C:\\Users\\Kalees\\eclipse-workspace\\FlipkartTask.Junit\\src\\test\\resources\\Screenshots\\Screendown.png");
			FileUtils.copyFile(source1, target1);
		}
	}
	}

}

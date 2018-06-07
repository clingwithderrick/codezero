package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	private static WebDriver driver;

	@BeforeSuite
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeTest
	public void setupTest() {
		driver = new ChromeDriver();
	}

	@AfterSuite
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public static void test() {
		driver.get("https://www.google.com/");
		By searchInput = By.id("lst-ib");
		driver.findElement(searchInput).sendKeys("Perficient");
		driver.findElement(searchInput).sendKeys(Keys.ENTER);
		String title = driver.getTitle();
		Assert.assertEquals("Perficient - Google Search", title);
	}

	@Test
	public static void test1() {
		driver.get("https://www.google.com/");
		By searchInput = By.id("lst-ib");
		driver.findElement(searchInput).sendKeys("India");
		driver.findElement(searchInput).sendKeys(Keys.ENTER);
		String title = driver.getTitle();
		Assert.assertEquals("India - Google Search", title);
	}

	@Test
	public static void test2() {
		driver.get("https://www.google.com/");
		By searchInput = By.id("lst-ib");
		driver.findElement(searchInput).sendKeys("Selenium");
		driver.findElement(searchInput).sendKeys(Keys.ENTER);
		String title = driver.getTitle();
		Assert.assertEquals("Selenium - Google Search", title);
	}
}

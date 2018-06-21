package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileOnNode {
    private static WebDriver driver;
    private static String baseUrl;
    private static String nodeURL;

    @BeforeSuite
    public static void setupClass() throws MalformedURLException {
	WebDriverManager.chromedriver().setup();

	baseUrl = "http://demo.guru99.com/test/upload/";
	nodeURL = "http://localhost:9090/wd/hub";

	DesiredCapabilities cap = DesiredCapabilities.chrome();
	cap.setBrowserName("chrome");
	cap.setPlatform(Platform.WINDOWS);
	new RemoteWebDriver(new URL(nodeURL), cap);
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
	driver.get("http://demo.guru99.com/test/upload/");
	driver.manage().window().maximize();
	uploadFile(By.id("uploadfile_0"), "sample.txt");
	driver.findElement(By.id("submitbutton")).click();
	System.out.println(driver.findElement(By.cssSelector("#emailwindow h3 > center")).getText());
    }

    public static void uploadFile(By by, String fileName) {
	try {
	    WebElement element = driver.findElement(by);
	    LocalFileDetector detector = new LocalFileDetector();

	    System.out.println("Absolute Path >>>> " + new File("").getAbsolutePath());

	    File file = detector.getLocalFile(new File("").getAbsolutePath() + "\\testData\\" + fileName);

	    ((RemoteWebElement) element).setFileDetector(detector);
	    System.out.println(file.getAbsolutePath());
	    element.sendKeys(file.getAbsolutePath());

	} catch (Exception e) {
	    e.printStackTrace();
	    Assert.fail("Upload Failed");
	}
    }
}

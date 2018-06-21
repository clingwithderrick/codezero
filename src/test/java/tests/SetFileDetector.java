package tests;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import junit.framework.Assert;

public class SetFileDetector {

    private RemoteWebDriver driver;

    public void tearDown() throws Exception {
	driver.quit();
    }

    public void testSauce() throws Exception {
	driver.get("http://demo.guru99.com/test/upload/");

	WebElement upload = driver.findElement(By.id("uploadfile_0"));

	uploadFile(upload, "sample.txt");
	driver.findElement(By.id("submit")).click();
	System.out.println("******************");
    }

    public void uploadFile(WebElement ele, String fileName) {

	try {

	    // WebElement element = driver
	    // .findElement(createDocumentMap.fileUploadInput());
	    LocalFileDetector detector = new LocalFileDetector();
	    File file = detector.getLocalFile(new File("").getAbsolutePath() + "/testData/" + fileName);
	    System.out.println(file.getAbsolutePath());
	    driver.setFileDetector(detector);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    ele.sendKeys(file.getAbsolutePath());
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("Upload Failed");
	}
    }
}

package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
import java.net.URL;
 
public class SampleSauceTest {
 
  public static final String USERNAME = "YOUR_USERNAME";
  public static final String ACCESS_KEY = "YOUR_ACCESS_KEY";
  // public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@<a class="vglnk" href="http://ondemand.saucelabs.com" rel="nofollow"><span>ondemand</span><span>.</span><span>saucelabs</span><span>.</span><span>com</span></a>:443/wd/hub";
 
  public static void main(String[] args) throws Exception {
 
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability("platform", "Windows 10");
    caps.setCapability("version", "latest");
 
    // WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
 
    /**
     * Goes to Sauce Lab's guinea-pig page and prints title
     */
 
    // driver.get("<a class="vglnk" href="https://saucelabs.com/test/guinea-pig" rel="nofollow"><span>https</span><span>://</span><span>saucelabs</span><span>.</span><span>com</span><span>/</span><span>test</span><span>/</span><span>guinea</span><span>-</span><span>pig</span></a>");
    // System.out.println("title of page is: " + driver.getTitle());
 
    // driver.quit();
  }
}
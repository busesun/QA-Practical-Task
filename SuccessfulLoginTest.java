import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class SuccessfulLoginTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void successfulLogin() {
    driver.get("https://www.shop-apotheke.com/login/");
    driver.manage().window().setSize(new Dimension(592, 746));
    driver.findElement(By.id("loginForm-eMail")).click();
    driver.findElement(By.id("loginForm-eMail")).click();
    driver.findElement(By.id("loginForm-eMail")).sendKeys("buse.sun21@gmail.com");
    driver.findElement(By.id("loginForm-password")).click();
    driver.findElement(By.id("loginForm-password")).sendKeys("ApothekeShop");
    {
      WebDriverWait wait = new WebDriverWait(driver, 0);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit-btn")));
    }
    driver.findElement(By.id("login-submit-btn")).click();
    driver.findElement(By.cssSelector(".u-padding--left:nth-child(2)")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".u-margin-xx-small--bottom"));
      assert(elements.size() > 0);
    }
  }
}

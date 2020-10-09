package diploTesting.actividad2;

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

public class Actividad2Test {
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
  public void actividad2() {
    driver.get("http://automationpractice.com/index.php?controller=contact");
    driver.manage().window().setSize(new Dimension(1552, 840));
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("fernandocotrena@gmail.com");
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).sendKeys("admin123456");
    driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
    driver.findElement(By.linkText("Contact us")).click();
    driver.findElement(By.id("id_contact")).click();
    {
      WebElement dropdown = driver.findElement(By.id("id_contact"));
      dropdown.findElement(By.xpath("//option[. = 'Customer service']")).click();
    }
    driver.findElement(By.id("id_contact")).click();
    driver.findElement(By.name("id_order")).click();
    driver.findElement(By.cssSelector(".form-group:nth-child(6)")).click();
    driver.findElement(By.id("message")).click();
    driver.findElement(By.id("message")).sendKeys("Test");
    driver.findElement(By.cssSelector("#submitMessage .icon-chevron-right")).click();
  }
}

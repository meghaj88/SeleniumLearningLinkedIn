import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class TestSample  {

    public static String CHROME_PATH = "/Users/meghajay/Documents/Appium/Ex_Files_Selenium_EssT/chromedriver";
    public static void main(String[] args) {
        // Set the property for webdriver.chrome.driver to be the location to your local              download of chromedriver
        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        WebDriver driver = new ChromeDriver();
        test_sample_dropdown(driver);
        driver.quit();
    }

    private static void test_sample_dropdown(WebDriver driver) {
        driver.get("https://formy-project.herokuapp.com/dropdown");
        explicit_sleep();

        driver.findElement(By.id("dropdownMenuButton")).click();
        explicit_sleep();

        driver.findElement(By.cssSelector("body > div > div > div > a:nth-child(7)")).click();

        explicit_sleep();
    }

    private static void test_sample_datepicker(WebDriver driver) {
        driver.get("https://formy-project.herokuapp.com/datepicker");
        explicit_sleep();

        WebElement element = driver.findElement(By.id("datepicker"));
        element.click();
        explicit_sleep();

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[2]/th[3]")).click();
        explicit_sleep();

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[2]/td[6]")).click();
        explicit_sleep();
/*
        element.sendKeys(Keys.RETURN);
        explicit_sleep();
*/



   }

    private static void test_sample_checkbox(WebDriver driver) {
        driver.get("https://formy-project.herokuapp.com/checkbox");
        explicit_sleep();

        driver.findElement(By.cssSelector("#checkbox-1")).click();
        explicit_sleep();

        driver.findElement(By.cssSelector("input[value='checkbox-2']")).click();
        explicit_sleep();

        driver.findElement(By.xpath("//*[@id='checkbox-3']")).click();
        explicit_sleep();

    }


    private static void test_sample_dragdrop() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/dragdrop");
        explicit_sleep();

        WebElement image = driver.findElement(By.id("image"));

        WebElement box = driver.findElement(By.id("box"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(image, box).build().perform();

        explicit_sleep();

        driver.quit();
    }

    private static void test_sample_jssampleTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/modal");
        explicit_sleep();

        driver.findElement(By.id("modal-button")).click();
        explicit_sleep();

        WebElement element_close = driver.findElement(By.id("close-button"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element_close);

        explicit_sleep();
        driver.quit();
    }

    private static void test_sample_alertTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/switch-window");
        explicit_sleep();

        driver.findElement(By.id("alert-button")).click();
        explicit_sleep();

        driver.switchTo().alert().accept();
        explicit_sleep();

        driver.quit();
    }


    private static void test_sample_autocomplete() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/autocomplete");
        explicit_sleep();

        driver.findElement(By.id("autocomplete")).sendKeys("5700 scruggs way");
        explicit_sleep();

        driver.findElement(By.className("pac-item")).click();
        explicit_sleep();

        driver.quit();
    }


    private static void test_sample_scroll() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/scroll");
        explicit_sleep();

        WebElement element = driver.findElement(By.id("name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        explicit_sleep();

        element.sendKeys("Megha Jay");

        driver.findElement(By.id("date")).sendKeys("01/01/2020");
        explicit_sleep();


        driver.quit();

    }


        private static void test_sample_switchwindow() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/switch-window");
        explicit_sleep();

        WebElement element = driver.findElement(By.id("new-tab-button"));
        element.click();

        explicit_sleep();

        final String current_windowHandle = driver.getWindowHandle();

        for (String handle: driver.getWindowHandles())
        {
            System.out.println(handle);
            driver.switchTo().window(handle);
            explicit_sleep();
        }

        driver.switchTo().window(current_windowHandle);
        explicit_sleep();

        driver.quit();
    }


    public static void test_sample_1(){
        // Create new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form
        element.submit();

        //Close the browser
        driver.quit();
    }

    private static void explicit_sleep()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}



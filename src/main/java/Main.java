import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.TodoPOM;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/ericchen/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:9000");
        TodoPOM pom = new TodoPOM(driver);

        pom.login();

        pom.completeReimb();

        pom.logout();
Thread.sleep(5000);
        driver.quit();
    }
}

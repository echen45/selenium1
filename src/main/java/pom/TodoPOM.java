package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TodoPOM {
    WebDriver driver;
    WebElement input;
    WebElement btn;
    By reimbSelector = By.id("r1");

    public TodoPOM(WebDriver driver){
        this.driver = driver;
    }

    public void login() {
        input = driver.findElement(By.id("username-input"));
        input.sendKeys("jcole24");
        btn = driver.findElement(By.id("login-button"));
        btn.click();
    }

    public void completeReimb() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(reimbSelector, 0));
        }catch (TimeoutException e){
            System.out.println("currently there is 0 reimbursements");
        }
        input = driver.findElement(By.id("link"));
        input.click();
        input = driver.findElement(By.id("i1"));
        input.sendKeys("20");
        input = driver.findElement(By.id("i2"));
        input.sendKeys("lunch");
        input = driver.findElement(By.id("i5"));
        input.sendKeys("0");
    }

    public void logout() {
        btn = driver.findElement(By.id("i6"));
        btn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(reimbSelector, 0));
        }catch (TimeoutException e){
            System.out.println("currently there is 0 reimbursements");
        }
        btn = driver.findElement(By.id("r8"));
        btn.click();
    }
}

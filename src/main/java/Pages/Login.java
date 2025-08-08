package Pages;

import Utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    WebDriver driver;

   
    public Login (WebDriver driver) {
        this.driver = driver;
    }

    public void login() throws InterruptedException {
        String URL = Utilities.getProperty("URL");
        try{
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        
        WebElement ShadowHost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frontegg-login-box-container-default")));
        		
        SearchContext ShadowRoot = ShadowHost.getShadowRoot();
        
        WebElement emailInput = ShadowRoot.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        emailInput.sendKeys("qa+test@spendflo.com");
        
        WebElement Continuebtn = ShadowRoot.findElement(By.cssSelector("button[id=':r0:']"));
        Continuebtn.click();
        
        WebElement PasswordInput = wait.until(driver1->{
        	
        WebElement pass = ShadowRoot.findElement(By.name("password"));
        return (pass.isDisplayed()) ? pass : null;
        });
        PasswordInput.sendKeys("Testingaccount@spendflo123");
        Continuebtn.click();
        
        }
        catch (Exception e){
            System.err.println("---Error--- " + e.getMessage());
            e.printStackTrace();
        }

    }
}

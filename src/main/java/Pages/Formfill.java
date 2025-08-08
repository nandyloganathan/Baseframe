package Pages;

import Utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Formfill {
    WebDriver driver;

    public Formfill(WebDriver driver) {

        this.driver = driver;
    }

    public void fillformandsubit() throws InterruptedException {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement createRequest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.//p[contains(text(), 'Create a Request')]]")));

            if (createRequest.isDisplayed()) {
                wait.until(ExpectedConditions.elementToBeClickable(createRequest)).click();
                System.out.println("Request clicked");
            } else {
                throw new ElementNotInteractableException("The 'Create a Request' button is not interactable.");
            }
         
            
            
//            //Thread.sleep(5000);
//            
//            WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='_dialog-body-container-primary_1387h_17 w-[960px] h-auto")));
//            form.isDisplayed();
            
            
         // Wait for the form container to be visible
            //Thread.sleep(15000);
            WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[class='_dialog-body-container-primary_1387h_17 w-[960px] h-auto']")
            ));

            // Wait for a key internal element that signifies the form has fully loaded
            WebElement formContent = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".mb-4.text-sf-slate-700") // Replace with an actual input, button, or title selector in the form
            ));

            // Optional: verify the form is displayed
            if (form.isDisplayed() && formContent.isDisplayed()) {
                System.out.println("Form is fully rendered and ready for interaction.");
            } else {
                throw new TimeoutException("Form did not render completely.");
            }
            
         By dropdownItemLocator = By.xpath("//span[text()='a file drop' and contains(@class, 'title-text')]");

         // Wait until the element is present in the DOM
         WebElement dropdownItem = wait.until(ExpectedConditions.presenceOfElementLocated(dropdownItemLocator));

         // Step 3: Scroll it into view using JavaScript
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", dropdownItem);

         // Optional: Wait for it to be visible/interactable
         wait.until(ExpectedConditions.visibilityOf(dropdownItem));
         wait.until(ExpectedConditions.elementToBeClickable(dropdownItem));

         // Step 4: Interact with the element
         dropdownItem.click();
         
         WebElement submit = driver.findElement(By.xpath("//button[.//p[contains(text(), 'Continue')]]"));
         submit.click();
         
          
         //WebElement vendername = driver.findElement(By.id("headlessui-input-:r81:")); 
         WebElement vendername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headlessui-input-:r81:")));

         if (vendername.isDisplayed()) {
             System.out.println("Form is fully rendered and ready for interaction.");
         } else {
             throw new TimeoutException("Form did not render completely.");
         }
         vendername.click();
         vendername.sendKeys("Salesforce");
         
        //headlessui-listbox-option-:rhq:
//         Thread.sleep(10000);
//         WebElement selctvendor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headlessui-listbox-option-:rhq:")));
//         selctvendor.click();
         
         List<WebElement> drop =wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("headlessui-listbox-option-:r92:"),0));
//         drop.get(2).click();
//         drop.get(2).click();
         
         WebElement firstsug = drop.get(0);
         Actions action = new Actions(driver);
         //action.doubleClick(firstsug).perform();
         action.click(firstsug).perform();
         
         String filepath = "/home/nandhini.l/eclipse-workspace/learningone/src/test/java/TestData/Screenshot from 2025-08-08 10-30-30.png";
         
         WebElement fileupload = driver.findElement(By.xpath("//input[@type='file']"));
         //fileupload.click();
         fileupload.sendKeys(filepath);
         
         WebElement LongTest = driver.findElement(By.xpath("//input[@id='headlessui-input-:r83:']"));
         LongTest.sendKeys("testcase");
         
         WebElement amount = driver.findElement(By.xpath("//input[@id='headlessui-input-:r84:']"));
         amount.sendKeys("6374");
         
         WebElement TotalFq = driver.findElement(By.xpath("//input[@id='headlessui-input-:r8b:']"));
         TotalFq.sendKeys("3787");
         
       //input[@id='headlessui-input-:r13u:']
         
         
         WebElement depart = driver.findElement(By.xpath("//label[contains(text(),'Product')]"));
         depart.click();
         
         WebElement submitl = driver.findElement(By.xpath("//p[contains(text(),'Submit')]"));
         
         if (submitl.isDisplayed()) {
             wait.until(ExpectedConditions.elementToBeClickable(submitl)).click();
             System.out.println("Submit clicked");
         } else {
             throw new ElementNotInteractableException("The 'Create a Request' button is not interactable.");
         }
         submitl.click();
         
        
        }
        catch (Exception e){
            System.err.println("---Error--- " + e.getMessage());
            e.printStackTrace();
        }

    }
}

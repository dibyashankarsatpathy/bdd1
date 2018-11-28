package login1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDfn {
    
    WebDriver driver;

    @Given("^User is on login1 page$")
    public void user_is_on_login1_page() throws Throwable {
       System.setProperty("webdriver.chrome.driver", "D:\\bdd\\BDD Jar Files\\BDD Jar Files\\chromedriver_win32\\chromedriver.exe");
       driver=new ChromeDriver();
       driver.get("file:///D:/bdd/login.html");
       System.out.println("page loaded in browser");
    }

    @When("^username password is blank$")
    public void username_password_is_blank() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        WebElement userNameTxt=driver.findElement(By.name("userName"));
        userNameTxt.sendKeys("");
        WebElement loginBtn= driver.findElement(By.className("btn"));
        loginBtn.click();
        
    }

    @Then("^Display Error Message: 'Please enter Username'$")
    public void display_Error_Message_Please_enter_Username() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        
        WebElement divEle =driver.findElement(By.id("userErrMsg"));
        String actualErrorMsg=divEle.getText();
        String expErrorMsg ="* Please enter userName.";
        Assert.assertEquals(expErrorMsg, actualErrorMsg);
        driver.close();
    }
    @When("^password is blank$")
    public void password_is_blank() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement userTxt=driver.findElement(By.name("userName"));
        WebElement pwdTxt=driver.findElement(By.name("userPwd"));
        WebElement loginBtn=driver.findElement(By.className("btn"));
        userTxt.sendKeys("Capgemini");
        pwdTxt.sendKeys("");
        loginBtn.click();
    }

    @Then("^Display Error Message: 'Please Enter Password'$")
    public void display_Error_Message_Please_Enter_Password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement divEle=driver.findElement(By.id("pwdErrMsg"));
        String actualErrorMsg=divEle.getText();
        String expErrorMsg ="* Please enter password.";
        Assert.assertEquals(expErrorMsg, actualErrorMsg);
        driver.close();
    }
    @When("^incorrect username or password entered$")
    public void incorrect_username_or_password_entered() throws Throwable {
    	 WebElement userTxt=driver.findElement(By.name("userName"));
         WebElement pwdTxt=driver.findElement(By.name("userPwd"));
         WebElement loginBtn=driver.findElement(By.className("btn"));
         userTxt.sendKeys("Capgemini");
         pwdTxt.sendKeys("capgemi4");
         loginBtn.click();
      
    }

    @Then("^Display Error Messsage: 'Please Enter Valid username or password'$")
    public void display_Error_Messsage_Please_Enter_Valid_username_or_password() throws Throwable {
        String expErrMsg="Invalid login! Please try again!";
        String actErrMsg=driver.switchTo().alert().getText();
        Assert.assertEquals(actErrMsg, expErrMsg);
        driver.close();
    }
    @When("^correct username or password entered$")
    public void correct_username_or_password_entered() throws Throwable {
    	 WebElement userTxt=driver.findElement(By.name("userName"));
         WebElement pwdTxt=driver.findElement(By.name("userPwd"));
         WebElement loginBtn=driver.findElement(By.className("btn"));
         userTxt.sendKeys("Capgemini");
         pwdTxt.sendKeys("capgemini123");
         loginBtn.click();
    }

    @Then("^Redirect the user to hotelBooking Page$")
    public void redirect_the_user_to_hotelBooking_Page() throws Throwable {
        driver.navigate().to("file:///D:/bdd/hotelbooking.html");
    
    }
}


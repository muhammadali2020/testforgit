package com.kano;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    public WebDriver driver;
    @Before
    public void invokeBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
//        driver.get("https://kano.me/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("^user in home page$")
    public void user_in_home_page()  {
        driver.get("https://kano.me/");

    }

    @When("^he click computer kit$")
    public void he_click_computer_kit()  {
        driver.findElement(By.cssSelector(".StickyHomeNav-linkLabel")).click();

    }

    @When("^he click buy now$")
    public void he_click_buy_now()  {
        driver.findElement(By.cssSelector("#ProductDisplay-actionPrimary--computer-kit")).click();

    }
    @When("^he click the basket link$")
    public void he_click_the_basket_link()  {

        driver.findElement(By.id("cart-icon")).click();

    }

    @Then("^the product should add to the basket$")
    public void the_product_should_add_to_the_basket()  {
        Assert.assertTrue(driver.findElement(By.cssSelector(".CartPage-title")).isDisplayed());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

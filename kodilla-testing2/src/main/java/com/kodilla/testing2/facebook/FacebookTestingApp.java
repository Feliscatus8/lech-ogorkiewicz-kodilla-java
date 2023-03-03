package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {
    public static final String XPATH_ESSENTIAL_COOKIES = "//div[contains(@role, \"dialog\")]/div/div/div/div/div[3]/button[1]";
    public static final String XPATH_NEW_ACCOUNT = "//form[contains(@data-testid, \"royal_login\")]/div[5]/a";
    public static final String XPATH_FIRSTNAME = "//div[@id=\"reg_form_box\"]/div/div/div/div/input";
    public static final String XPATH_LASTNAME = "//div[@id=\"reg_form_box\"]/div/div/div[2]/div/div/input";
    public static final String XPATH_EMAIL = "//div[@id=\"reg_form_box\"]/div[2]/div/div/input";
    public static final String XPATH_EMAIL_CONFIRM = "//div[@id=\"reg_form_box\"]/div[3]/div/div/div/input";
    public static final String XPATH_PASSWORD = "//div[@id=\"reg_form_box\"]/div[4]/div/div/input";
    public static final String XPATH_MONTH = "//div[@id=\"reg_form_box\"]/div[5]/div[2]/span/span/select[1]";
    public static final String XPATH_DAY = "//div[@id=\"reg_form_box\"]/div[5]/div[2]/span/span/select[2]";

    public static final String XPATH_YEAR = "//div[@id=\"reg_form_box\"]/div[5]/div[2]/span/span/select[3]";
    public static final String XPATH_GENDER_MALE = "//div[@id=\"reg_form_box\"]/div[7]/span/span[2]/input";
    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        WebElement cookiesButton = driver.findElement(By.xpath(XPATH_ESSENTIAL_COOKIES));
        cookiesButton.click();

        WebElement newAccountButton = driver.findElement(By.xpath(XPATH_NEW_ACCOUNT));
        newAccountButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 2L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_FIRSTNAME)));


        WebElement firstName = driver.findElement(By.xpath(XPATH_FIRSTNAME));
        firstName.sendKeys("Bonifacy");

        WebElement lastName = driver.findElement(By.xpath(XPATH_LASTNAME));
        lastName.sendKeys("Kot");

        WebElement email = driver.findElement(By.xpath(XPATH_EMAIL));
        email.sendKeys("Bonifacy_kot@meow.com");

        WebElement password = driver.findElement(By.xpath(XPATH_PASSWORD));
        password.sendKeys("IWantToSleep20Hours");

        WebElement confirmEmail = driver.findElement(By.xpath(XPATH_EMAIL_CONFIRM));
        confirmEmail.sendKeys("Bonifacy_kot@meow.com");

        WebElement month = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(month);
        selectMonth.selectByIndex(4);

        WebElement day = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(day);
        selectDay.selectByIndex(24);

        WebElement year = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1984");

        WebElement gender = driver.findElement(By.xpath(XPATH_GENDER_MALE));
        gender.click();
    }
}

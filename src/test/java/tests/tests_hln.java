package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class tests_hln {
    WebDriver driver;

    @BeforeEach
    void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Eigenaar\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.google.com");

        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div")).click();

    }

    @AfterEach
    void after() {
        driver.quit();
    }

    @Test
    public void GVA() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Gazet van antwerpen");

        searchBox.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement searchResultLink = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/a/h3"));
        searchResultLink.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement popup = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/button[2]"));
        popup.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement sport = driver.findElement(By.xpath("/html/body/div[4]/div[1]/header/div[1]/nav/ul[1]/li[3]/a/div"));
        sport .click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String first = driver.findElement(By.xpath("/html/body/div[5]/div/div/main/div/div[2]/div/div/div[1]/div/div/div/a/div/div/div/h1")).getText();
        System.out.println(first);

        assertEquals("KVM-coach Defour rekent zich nog niet rijk tegen Zulte Waregem: “Maar wel logisch dat we aan de bekerfinale denken”", first);

    }

    @Test
    public void HLN() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("HLN");

        searchBox.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement searchResultLink = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/a/h3"));
        searchResultLink.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement iframe = driver.findElement(By.xpath("/html/body/div[2]/iframe"));
        driver.switchTo().frame(iframe);
        WebElement button = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/button[1]"));
        button.click();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement sport = driver.findElement(By.xpath("/html/body/header/section[3]/div[1]/div/nav/div[1]/ul/li[2]/a/span"));
        sport.click();

        String first = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/div/section/div[1]/div/article/a/div[2]/header/h2")).getText();
        System.out.println(first);

        assertEquals("WUYTS & VLAEMINCK. “Misschien zit Wout van Aert nu wel in de moeilijkste positie bij Jumbo-Visma”", first);

    }
}

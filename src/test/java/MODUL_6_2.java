import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MODUL_6_2 {
    private WebDriver driver;

    @Before
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void TestModul_4_2()
    {
        driver.navigate().to("http://qa.skillbox.ru/module16/maincatalog/");
        var PageCreateCards = By.cssSelector("div.pageCreate__cards div");
        var BaseFooter = By.cssSelector("div.baseFooter > *");
        var PageCreate = By.cssSelector("div.pageCreate > div.pageCreate__cards img");
        var BaseCardPageCreate__card = By.cssSelector("div.baseCard.pageCreate__card:nth-of-type(1) p");
    }

}

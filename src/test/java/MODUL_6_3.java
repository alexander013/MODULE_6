import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MODUL_6_3 {
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
    public void TestModul_6_3()
    {
        driver.navigate().to("http://qa.skillbox.ru/module16/16_2/");
        var BaseCardTitleLocator = By.cssSelector("span:not([class='baseCard__title'])");
        var ButtonNotDisabled = By.cssSelector("button:not([disabled])");
        var DivaseCardPageCreate__card = By.cssSelector("div.baseCard.pageCreate__card:nth-of-type(4) .baseButton:not(.baseButton--noBorder)");


    }
}

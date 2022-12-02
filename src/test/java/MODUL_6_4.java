import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MODUL_6_4 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @After
    public void tearDown()

    {
        driver.quit();
    }

    @Test
    public void TestModul_6_4()
    {

        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/");
        var KnopkaVseZapisi = By.cssSelector("button.pageCreate__sidebarHeaderAdd");
        var LightBoxLocator = By.cssSelector("div.popup__content");
        var LightBoxTitleLocator = By.cssSelector("div.popup__content > div.baseInput.popup__baseInput input");
        var BasetextareaLocator = By.cssSelector("div.popup > div.popup__wrapper > div.popup__content > div > div.baseTextarea__inner textarea");
        var BaseButtonPopupLocator = By.cssSelector("div.popup > div.popup__wrapper > div.popup__content button.baseButton.popup__baseButton");
        var ArticlePreviewTitle = By.cssSelector("div.vb-content > div:nth-of-type(1) > div > p.articlePreview__title");
        var ArticlePreviewText = By.cssSelector("div.vb-content > div:nth-of-type(1) > div > p.articlePreview__text");
        driver.findElement(KnopkaVseZapisi).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(LightBoxLocator));

        Assert.assertTrue("Не отобразился лайтбокс для ввода данных", driver.findElement(LightBoxTitleLocator).isDisplayed());
        driver.findElement(LightBoxTitleLocator).sendKeys("Введите новый заголовок");
        driver.findElement(BasetextareaLocator).sendKeys("Введите основной текст");
        driver.findElement(BaseButtonPopupLocator).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(LightBoxTitleLocator));
        Assert.assertTrue("Лайтбокс не исчез", driver.findElements(LightBoxTitleLocator).size()==0);
        Assert.assertEquals("Неверный текст заголовка", "Введите новый заголовок", driver.findElement(ArticlePreviewTitle).getText());
        Assert.assertEquals("Неверный текст основного текста", "Введите основной текст", driver.findElement(ArticlePreviewText).getText());








    }

}

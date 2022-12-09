import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MODUL_6_5 {

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


//    ------------------------------------------------------------------------------------------------------------------
//    Задание № 1
    @Test
    public void TestZad_1()
    {
        var Teg_P_Locator = By.cssSelector("section.header p");
        var Teg_A_Locator = By.cssSelector("div[class*='text'] > a");
        var A_Teg_Locator = By.cssSelector("section > div.text:nth-of-type(2) > a");
    }

//    ------------------------------------------------------------------------------------------------------------------
//    Задание 2
    @Test
    public void TestModul_6_5_2()
    {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module04/practice1/");
        var TegInputElementLocator = By.cssSelector("input.form-input:not([id])");
        var TegPFormRowNotErrorLocator = By.cssSelector("p[class^='form']:not([class$='error'])");
        var DivFormInnerTegPLocator = By.cssSelector("div.form-inner p.form-row:nth-of-type(1)");
    }
//----------------------------------------------------------------------------------------------------------------------

//Задание 3
    @Test
    public void TestModul_6_5_3()
    {
//        переход на страницу
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
//        Элемент из списка заметок по центру экрана
        var ButtonarticlePreviewLinkLocator = By.cssSelector("div.pageStatistic__list > div > div.articlePreview.pageStatistic__article:nth-of-type(1) > button");
//        Элемент с текстом заголовка выбранного элемента заметок по центру экрана
        var TitleTextLocator = By.cssSelector("div.articlePreview__content > p[class*='title']");
//        Элемент с текстом элемента заметок по центру экрана
        var TextAreaLocator = By.cssSelector("div.articlePreview__content > p[class*='text']");
//        Появляющийся справа блок ВСЕ ЗАПИСИ после клика на Элемент из списка заметок по центру экрана
        var BlokVseZapisyLocator = By.cssSelector("div.pageArticle__sidebar.page__sidebar > div[class*='sidebarHeader']");
//        Текст заголовка элемента который появился справа  клика на Элемент из списка заметок по центру экрана
        var Teg_p_TitleLocator = By.cssSelector("div.page__sidebar > div[class*='vb'] > div.vb-content > div:nth-of-type(1) > div.articlePreview__content > p[class*='title']");
//        Текст элемента который появился справа  клика на Элемент из списка заметок по центру экрана
        var TegTextLocator = By.cssSelector("div.page__sidebar > div[class*='vb'] > div.vb-content > div:nth-of-type(1) > div.articlePreview__content > p[class*='text']");
//        Кнопка с иконой корзинки, расположенная в центральной части белой части страницы
        var PageArticleiconLocator = By.cssSelector("div.page.pageArticle.theLayout__body > div.page__content > div.pageArticle__contentHeader > div.pageArticle__buttons > button:nth-of-type(2)");
//        Элемент самой первой записи блока ВСЕ ЗАПИСИ
        var ButtonVseZapisy_1 = By.cssSelector("div.pageArticle__sidebar.page__sidebar > div[class*='vb'] > div.vb-content > div > button");
//        Клик на заметку из списка заметок по центру экрана
        driver.findElement(ButtonarticlePreviewLinkLocator).click();
//        Ожидание появления справа от заголовка выбранной записи в разделе ВСЕ ЗАПИСИ
        wait.until(ExpectedConditions.presenceOfElementLocated(BlokVseZapisyLocator));
//        Проверка на появление справа блока ВСЕ ЗАПИСИ
        Assert.assertTrue("Не отобразилось окно", driver.findElement(BlokVseZapisyLocator).isDisplayed());
//        Проверка на соответсвие текста заголовка выбранного элемента с заголовком первого элемента блока ВСЕ ЗАПИСИ
        Assert.assertEquals("Не верный текст", driver.findElement(Teg_p_TitleLocator).getText(), driver.findElement(TitleTextLocator).getText());
//         Проверка на соответсвие записанного текста выбранного элемента с текстом первого элемента блока ВСЕ ЗАПИСИ
        Assert.assertEquals("Не верный текст", driver.findElement(TextAreaLocator).getText(), driver.findElement(TegTextLocator).getText());
//        Клик кнопке с иконкой корзины, расположенной в центральной белой части страницы
        driver.findElement(PageArticleiconLocator).click();
//        В разделе «Все записи» выберите самую верхнюю запись (первую)
        driver.findElement(ButtonVseZapisy_1).click();
//        Клик кнопке с иконкой корзины, расположенной в центральной белой части страницы
        driver.findElement(PageArticleiconLocator).click();
//        Ожидание исчезновения первой записи в разделе ВСЕ ЗАПИСИ
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ButtonVseZapisy_1));
//        Прроверка что справа в блоке ВСЕ ЗАПИСИ не видно записей
        Assert.assertTrue("Лайтбокс не исчез", driver.findElements(ButtonVseZapisy_1).size()==0);


    }
}

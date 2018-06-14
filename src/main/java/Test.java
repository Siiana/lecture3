import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class Test {
    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", Test.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }

    public static void main(String[] args) {
        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("webinar.test@gmail.com");
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement buttonSubmit = driver.findElement(By.name("submitLogin"));
        buttonSubmit.submit();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.cssSelector("#subtab-AdminCategories > a")));
        WebElement category = driver.findElement(By.cssSelector("#page-header-desc-category-new_category > i"));
        category.click();
        WebElement name_category = driver.findElement(By.cssSelector("#name_1"));
        name_category.sendKeys("test");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.cssSelector("#category_form_submit_btn")));
        WebElement filter = driver.findElement(By.cssSelector("tr.nodrag.nodrop.filter.row_hover > th:nth-child(3) > input"));
        filter.sendKeys("test");
        WebElement search = driver.findElement(By.cssSelector("#submitFilterButtoncategory"));
        search.click();
        WebElement filter_check = driver.findElement(By.cssSelector("#tr_2_14_1 > td:nth-child(3)"));
        String check_text = filter_check.getText();
        Assert.assertEquals("test", check_text);
        driver.quit();
    }
}



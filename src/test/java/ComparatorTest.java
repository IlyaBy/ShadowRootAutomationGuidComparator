import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComparatorTest {

    @Test
    public void guidCompare() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestingplayground.com/shadowdom");
        WebElement shadowHost = driver.findElement(By.cssSelector("body > section > div > guid-generator"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement buttonGenerate = shadowRoot.findElement(By.cssSelector("#buttonGenerate"));
        buttonGenerate.click();
        WebElement fieldWithDataToCopy = shadowRoot.findElement(By.cssSelector("#editField"));
        WebElement buttonCopy = shadowRoot.findElement(By.cssSelector("#buttonCopy"));
        buttonCopy.click();
        buttonCopy.sendKeys(Keys.CONTROL+"v");
        Assert.assertEquals(fieldWithDataToCopy.getText(), buttonCopy.getText());
        driver.quit();
}
}

package base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasePage extends MyTestWatcher {
    /**
     * click is used for click on WebElement located by xPath locator, maximum after 10 seconds
     *
     * @param locator -xPath location of Webelwment
     */
    public void click(String locator) {
        waitForVisible(locator, 10);
        WebElement element = getDriver().findElement(By.xpath(locator));
        Actions action = new Actions(getDriver());
        action.moveToElement(element).click().perform();
    }

    /**
     * doubleClick  on WebElement located by xPath locator, maximum after 10 seconds
     *
     * @param locator -xPath location of Webelwment
     */
    public void doubleClick(String locator) {
        waitForVisible(locator, 10);
        WebElement element = getDriver().findElement(By.xpath(locator));
        Actions action = new Actions(getDriver());
        action.moveToElement(element).doubleClick().perform();
    }


    /**
     * waitForVisible  waits until Web element is visible for given period
     *
     * @param locator - xPath location of WebElement
     * @param seconds - time interval in which the element is expected
     */
    public void waitForVisible(String locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    /**
     waits until Web element is visible for given period
     *
     * @param locator - xPath location of WebElement
     * 10 seconds - time interval in which the element is expected
     * return  true or false, doesn't stops program
     */
    public boolean checkVisible(String locator){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            return true;
        }catch (Throwable t){
            return false;
        }
    }

    /**
     * waitForInVisible  waits until Web element is removed for given period
     * wait until overlay element is present, while page is loading
     *
     * @param locator - xPath location of WebElement
     * @param seconds - time interval in which the element is expected
     */
    public void waitForInvisible(String locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    /**
     * switches drifer focus to iframe
     * @param iFrame name of iFrame
     */
    public void switchToIframe(String iFrame){
        getDriver().switchTo().frame(iFrame);
    }

    /**
     * switches driver focus to new window
     */
    public void switchToNewWindow() {
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }
    }

    /**
     * return text from alertBox
     * @return
     */
    public String textFromAlertBox(){
        String alertMessage= getDriver().switchTo().alert().getText();
        return alertMessage;
    }

    /**
     * return true or false if alert is shown
     * @return
     */
    public boolean getAlert(){
        try {
            getDriver().switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    /**
     * get text value
     * @param locator
     * @return
     */
    public String textValue(String locator){
        waitForVisible(locator,10);
        WebElement element = getDriver().findElement(By.xpath(locator));
        if (!(element.getText().equals(""))) return element.getText();
        else return element.getAttribute("value");
    }

    /**
     * type text in form
     * @param locator
     * @param text
     */
    public void typeText(String locator,String text){
        waitForVisible(locator,10);
        WebElement textField = getDriver().findElement(By.xpath(locator));
        textField.sendKeys(text);
    }

    /**
     * take screenShot andas saves as file "sxhreenshot.png"
     * @throws IOException
     */
    public void takeScreenShot() throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) getDriver());
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("screenshot.png"));
    }

    /**
     * performs drag and drop actions of elements
     * @param elem1 locator of element which needs to drag
     * @param elem2  locator of element on which need to drop
     */
    public void dragAndDrop(String elem1, String elem2){
        waitForVisible(elem1, 10);
        waitForVisible(elem2, 10);
        WebElement from=getDriver().findElement(By.xpath(elem1));
        WebElement to=getDriver().findElement(By.xpath(elem2));
        Actions act=new Actions(getDriver());
        act.dragAndDrop(from, to).build().perform();
    }



}
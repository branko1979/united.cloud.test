package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTest extends MyTestWatcher {
    /**
     * test operating system
     *
     * @return name of os
     */
    public static String nameOS() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return "Windows";
        } else if (os.contains("nux")) {
            return "Linux";
        } else if (os.contains("mac")) {
            return "Mac";
        } else return "Other";
    }

    /**
     * starts proer webDriver based on operatingSystem
     *
     * @param
     */
    public static void setChromeDriver() {
        if (nameOS().equals("Windows")) {
            System.setProperty("webdriver.chrome.driver", "drivers//chromedriver-windows-32bit.exe");
        } else if (nameOS().equals("Linux")) {
            System.setProperty("webdriver.chrome.driver", "drivers//chromedriver-linux-64bit");
        } else if (nameOS().equals("Mac")) {
            System.setProperty("webdriver.chrome.driver", "drivers//chromedriver-mac-64bit");
        }
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        setWebDriver(driver);
    }

    /**
     * opens scpecific page in browser
     *
     * @param url - url adress of page
     */
    public static void openPage(String url) {
        getDriver().get(url);
    }
}

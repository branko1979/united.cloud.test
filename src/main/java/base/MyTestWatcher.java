package base;

import org.junit.Rule;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static base.WebDriverTest.setChromeDriver;

public abstract class MyTestWatcher {
    private final static Logger logger = Logger.getLogger(MyTestWatcher.class.getName());
    private static WebDriver driver;
    private FileHandler fh;

    /**
     * getter method
     *
     * @return driver
     */
    public static WebDriver getDriver() {
        return driver;
    }



    /**
     * setter method for driver
     *
     * @param webDriver
     */
    public static void setWebDriver(WebDriver webDriver) {
        driver = webDriver;
    }



    @Rule
    public org.junit.rules.TestWatcher watchman = new org.junit.rules.TestWatcher() {
        /**
         * add message in log if test crashed
         * @param e
         * @param description
         */
        @Override
        protected void failed(Throwable e, Description description) {
            logger.log(Level.WARNING, description + " text has been crashed!\n");
        }

        /**
         * add message in log if test is succesfull
         * @param description
         */
        @Override
        protected void succeeded(Description description) {
            logger.log(Level.INFO, description + "success!\n");
        }

        /**
         * add message to log if browser started
         * @param description
         */
        @Override
        protected void starting(Description description) {
            try {
                fh = new FileHandler("MyLogFile.log");
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.log(Level.INFO, description + " browser started, \n");
            setChromeDriver();

        }

        /**
         * if test has finished message is added and browser closed
         * @param description
         */
        @Override
        protected void finished(Description description) {
            logger.log(Level.INFO, " Finishing test: " + description.getDisplayName() + "\n");
            getDriver().quit();
        }
    };


}


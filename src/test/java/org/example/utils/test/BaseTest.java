package org.example.utils.test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.screens.BottomNavigationScreen;
import org.example.screens.SplashScreen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {

    private static String PROPERTIES_FILE = "src/test/resources/config.properties";
    private static Properties properties = new Properties();
    public static AndroidDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void environmentSetup(){
        UiAutomator2Options capabilities = new UiAutomator2Options();
        setUpCapabilities(capabilities);

        try {
            driver= new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        }
        catch(MalformedURLException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void loadProperties(){
        try{
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
            properties.load(fileInputStream);
        }catch(IOException e){
            throw new RuntimeException("Error handling properties file"+PROPERTIES_FILE);
        }
    }

    public static String getCapability(String variable){
        return properties.getProperty(variable);
    }

    public static void setUpCapabilities(UiAutomator2Options capabilities){
        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setPlatformName(getCapability("deviceName"));
        capabilities.setPlatformName(getCapability("appActivity"));
        capabilities.setPlatformName(getCapability("appPackage"));
    }

    public SplashScreen splashScreen(){
        return new SplashScreen(driver);
    }

    public BottomNavigationScreen bottomNavigationScreen(){
        return new BottomNavigationScreen(driver);
    }

    @AfterTest
    public static void downServer(){
        driver.quit();
    }


}


package org.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.utils.screens.BaseScreen;
import org.openqa.selenium.WebElement;

public class BottomNavigationScreen extends BaseScreen {
    public BottomNavigationScreen(AndroidDriver driver){
        super(driver);
    }
    @AndroidFindBy(accessibility = "Home")
    private WebElement homeTab;

    @AndroidFindBy(accessibility = "Webview")
    private WebElement webViewTab;


    @AndroidFindBy(accessibility = "Login")
    private WebElement loginTab;

    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipeTab;

    @AndroidFindBy(accessibility = "Drag")
    private WebElement dragTab;

    public void navigateToHome() {
        homeTab.click();
    }

    public void navigateToWebView() {
        webViewTab.click();
    }

    public void navigateToLogin() {
        loginTab.click();
    }

    public void navigateToSwipe() {
        swipeTab.click();
    }

    public void navigateToDrag(){
        dragTab.click();
    }

    // Validation methods
    public boolean isHomeScreenDisplayed() {
        return isElementDisplayed(homeTab);
    }

    public boolean isWebViewScreenDisplayed() {
        return isElementDisplayed(webViewTab);
    }

    public boolean isLoginScreenDisplayed() {
        return isElementDisplayed(loginTab);
    }

    public boolean isSwipeScreenDisplayed() {
        return isElementDisplayed(swipeTab);
    }

    public boolean isDragScreenDisplayed(){
        return isElementDisplayed(dragTab);
    }
}


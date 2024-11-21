package org.example.test;

import org.example.screens.BottomNavigationScreen;
import org.example.screens.SplashScreen;
import org.example.utils.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTest extends BaseTest {

    @Test
    public void firstTestAppium(){
        SplashScreen splashScreen = splashScreen();

    }

    @Test
    public void BottomNavigationTest(){
        BottomNavigationScreen bottomNavigationScreen = bottomNavigationScreen();
        bottomNavigationScreen.navigateToHome();
        Assert.assertTrue(bottomNavigationScreen.isHomeScreenDisplayed());

        bottomNavigationScreen.navigateToWebView();
        Assert.assertTrue(bottomNavigationScreen.isWebViewScreenDisplayed());

        bottomNavigationScreen.navigateToLogin();
        Assert.assertTrue(bottomNavigationScreen.isLoginScreenDisplayed());

        bottomNavigationScreen.navigateToSwipe();
        Assert.assertTrue(bottomNavigationScreen.isSwipeScreenDisplayed());

        bottomNavigationScreen.navigateToDrag();
        Assert.assertTrue(bottomNavigationScreen.isDragScreenDisplayed());

    }
}

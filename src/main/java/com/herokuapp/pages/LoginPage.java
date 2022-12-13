package com.herokuapp.pages;

import com.aventstack.extentreports.Status;
import com.herokuapp.customlisteners.CustomListeners;
import com.herokuapp.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility
{
    @CacheLookup
    @FindBy(id = "username")
    WebElement enterUsername;

    @CacheLookup
    @FindBy(name = "password")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(xpath = "//button[@class='radius']")
    WebElement clickLogin;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'flash error']")
    WebElement passwordErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'flash']")
    WebElement usernameInvalidMessage;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Secure Area']")
    WebElement secureAreaText;

        public void usernameField(String email) {
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + email);
        sendTextToElement(enterUsername,email);
    }

    public void passwordField(String passcode) {
        CustomListeners.test.log(Status.PASS,"Enter Passcode " + passcode);
        sendTextToElement(enterPassword, passcode);
    }

    public void clickLoginButton() {
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
        clickOnElement(clickLogin);
    }

    public String passwordError() {
        CustomListeners.test.log(Status.PASS,"Password Error");
        return getTextFromElement(passwordErrorMessage);
    }

    public String usernameError() {
        CustomListeners.test.log(Status.PASS,"Username Error");
        return getTextFromElement(usernameInvalidMessage);
    }
    public String getSecureAreaMessage(){
        CustomListeners.test.log(Status.PASS,"Get Secure Area Message");
        return getTextFromElement(secureAreaText);
        }
}


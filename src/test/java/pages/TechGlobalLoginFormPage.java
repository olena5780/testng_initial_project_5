package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import scripts.TechGlobalLoginFormTest;
import utilities.Driver;

import java.util.List;

public class TechGlobalLoginFormPage extends TechGlobalBasePage {
        /*
    Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
Then user should see heading1 as “Login Form”
And user should see “Please enter your username” label and username input box
And user should see “Please enter your password” label and password input box
And user should see “LOGIN” button
And user should see “Forgot Password?” link
     */


    public TechGlobalLoginFormPage(){
        super();

    }
    @FindBy(id = "main_heading")
    public WebElement loginForm;

    @FindBy(xpath = "//input[@id='username']/../label")
    public WebElement usernameLabel;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']/../label")
    public WebElement passwordLabel;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    @FindBy(id = "forgot-password")
    public WebElement forgotPassword;

    @FindBy(id = "success_lgn")
    public WebElement successfulLoginMessage;

    @FindBy(id ="error_message")
    public WebElement errorMessage;

    @FindBy(id ="logout")
    public WebElement logoutButton;

    @FindBy(id ="sub_heading")
    public WebElement resetPasswordLabel;

    @FindBy(xpath ="//input[@id='email']/../label")
    public WebElement resetPasswordMessage;

    @FindBy(id ="email")
    public WebElement resetPasswordInput;

    @FindBy(id ="submit")
    public WebElement submitButton;

    @FindBy(id = "confirmation_message")
    public WebElement confirmationMessage;




}

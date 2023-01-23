package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utilities.TestData;

public class TechGlobalLoginFormTest extends TechGlobalBase{
        /*
    Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
Then user should heading1 as “Login Form”
And user should see “Please enter your username” label and username input box
And user should see “Please enter your password” label and password input box
And user should see “LOGIN” button
And user should see “Forgot Password?” link
     */
        @BeforeMethod
        public void setPage(){
            techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
            techGlobalLoginFormPage = new TechGlobalLoginFormPage();

            techGlobalFrontendTestingHomePage.getFrontedTestingPage();
            techGlobalFrontendTestingHomePage.clickOnCard("Login Form");
        }

        @Test(priority = 1, description = "Validate Login Form heading1")
        public void validateLoginForm(){
            Assert.assertTrue(techGlobalLoginFormPage.loginForm.isDisplayed());
                }

        @Test(priority = 2, description = "Validate Username")
         public void validateUsername(){
            Assert.assertTrue(techGlobalLoginFormPage.usernameLabel.isDisplayed());
            Assert.assertTrue(techGlobalLoginFormPage.usernameInput.isDisplayed());
                }

        @Test(priority = 3, description = "Validate Password")
        public void validatePassword(){
        Assert.assertTrue(techGlobalLoginFormPage.passwordLabel.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.passwordInput.isDisplayed());
            }

        @Test(priority = 4, description = "Validate Login Button")
        public void validateLoginButton(){
        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isEnabled());
        }

        @Test(priority = 5, description = "Validate Forgot Password Link")
        public void validateForgotPassword(){
            Assert.assertTrue(techGlobalLoginFormPage.forgotPassword.isDisplayed());
            Assert.assertTrue(techGlobalLoginFormPage.forgotPassword.isEnabled());
        }
        /*
        Test Case 2: Validate TechGlobal Login Form card valid login
Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
And user enters username as “TechGlobal” and password as “Test1234”
And user clicks on “LOGIN” button
Then user should see “You are logged in” message
And user should see “LOGOUT” button
         */

    @Test(priority = 6, description = "Validate TechGlobal Login Form card valid login")
    public void validateLoginWithCorrectCredentials(){
        techGlobalLoginFormPage.usernameInput.sendKeys(TestData.validUsername);
        techGlobalLoginFormPage.passwordInput.sendKeys(TestData.validPassword);

        techGlobalLoginFormPage.loginButton.click();

        Assert.assertTrue(techGlobalLoginFormPage.successfulLoginMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.successfulLoginMessage.getText(), TestData.successfulMessage);
        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isEnabled());


    }
        /*
       Test Case 3: Validate TechGlobal Login Form card valid login and then logout
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “Test1234”
    And user clicks on “LOGIN” button
    And user clicks on “LOGOUT” button
    Then user should be navigated back to Login Form
     */

    @Test (priority = 7, description = "Validate TechGlobal Login Form card valid login and then logout")

    public void validateLoginAndLogoutWithValidCredentials(){
        techGlobalLoginFormPage.usernameInput.sendKeys(TestData.validUsername);
        techGlobalLoginFormPage.passwordInput.sendKeys(TestData.validPassword);

        techGlobalLoginFormPage.loginButton.click();
        techGlobalLoginFormPage.logoutButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), TestData.loginFormURL);

    }
    /*
    Test Case 4: Validate TechGlobal Login Form card Forgot Password? Link and Reset Password page
Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
And user clicks on “Forgot Password?” link
Then user should see “Reset Password” heading1
And user should see “Enter your email address and we'll send you a link to reset your password.” message
And user should see email input box
And user should see “SUBMIT” button
     */

    @Test(priority = 8, description = "Validate TechGlobal Login Form card Forgot Password? Link and Reset Password page")
    public void validateForgotPasswordLink(){
        techGlobalLoginFormPage.forgotPassword.click();
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordLabel.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.resetPasswordMessage.getText(), TestData.resetPasswordLabelMessage);
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordInput.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.submitButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.submitButton.isEnabled());

    }
    /*
    Test Case 5: Validate TechGlobal Login Form card Reset Password link
Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
And user clicks on “Forgot Password?” link
When user enters a valid email to email input box
And user clicks on “SUBMIT” button
Then user should see “A link to reset your password has been sent to your email address.” message
     */
    @Test(priority = 9, description = "Validate TechGlobal Login Form card Reset Password link")
    public void validateLinkToResetPasswordHasBeenSentToEmail(){
        techGlobalLoginFormPage.forgotPassword.click();
        techGlobalLoginFormPage.resetPasswordInput.sendKeys(TestData.validEmail);
        techGlobalLoginFormPage.submitButton.click();
        Assert.assertEquals(techGlobalLoginFormPage.confirmationMessage.getText(), TestData.confirmationMessage);
    }

    /*
    Test Case 6: Validate TechGlobal Login Form card invalid login with wrong username
Given user is on https://techglobal-training.netlify.app/
When user clicks on "Practices" dropdown in the header
And user select the "Frontend Testing" option
And user clicks on the "Login Form" card
And user enters username as “john” and password as “Test1234”
And user clicks on “LOGIN” button
Then user should see “Invalid Username entered!” message
     */
    @Test(priority = 10, description = "Validate TechGlobal Login Form card invalid login with wrong username")
    public void validateLoginWithInvalidUsername(){
        techGlobalLoginFormPage.usernameInput.sendKeys(TestData.invalidUsername);
        techGlobalLoginFormPage.passwordInput.sendKeys(TestData.validPassword);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.errorMessage.getText(), TestData.errorMessageInvalidUsername);
    }
    /*
        Test Case 7: Validate TechGlobal Login Form card invalid login with wrong password
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Password entered!” message
     */
    @Test(priority = 11, description = "Validate TechGlobal Login Form card invalid login with wrong password")
    public void validateLoginWithInvalidPassword(){
        techGlobalLoginFormPage.usernameInput.sendKeys(TestData.validUsername);
        techGlobalLoginFormPage.passwordInput.sendKeys(TestData.invalidPassword);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.errorMessage.getText(), TestData.errorMessageInvalidPassword);
    }
    /*
         Test Case 8: Validate TechGlobal Login Form card invalid login with both wrong credentials
     Given user is on https://techglobal-training.netlify.app/
     When user clicks on "Practices" dropdown in the header
     And user select the "Frontend Testing" option
     And user clicks on the "Login Form" card
     And user enters username as “john” and password as “1234”
     And user clicks on “LOGIN” button
     Then user should see “Invalid Username entered!” message
          */

    @Test(priority = 12, description = "Validate TechGlobal Login Form card invalid login with wrong password")
    public void validateLoginWithBothInvalidCredentials(){
        techGlobalLoginFormPage.usernameInput.sendKeys(TestData.invalidUsername);
        techGlobalLoginFormPage.passwordInput.sendKeys(TestData.invalidPassword);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.errorMessage.getText(), TestData.errorMessageInvalidUsername);
    }











}

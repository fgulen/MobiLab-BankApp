package com.mobilab.step_definitions;

import com.mobilab.pages.CreateAccount;
import com.mobilab.utilities.BrowserUtils;
import com.mobilab.utilities.ConfigurationReader;
import com.mobilab.utilities.Driver;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CreateAccountStepDefs {

    CreateAccount createAccount = new CreateAccount();
    String url= ConfigurationReader.get("url");

    @Given("Open the application with given URL")
    public void open_the_application_with_given_URL() {
        Driver.get().get(url);
        createAccount.createAccountBTN.click();

    }


    @Given("Verify the windows title {string}")
    public void Verify_the_windows_title(String string) {
        Assert.assertEquals(Driver.get().getTitle(),string);
    }


    @When("Enter {string}, {string} and select {string}")
    public void enter_and_select(String string, String string2, String string3) {
        createAccount.Owner.sendKeys(string);
        createAccount.balance.sendKeys(string2);

        Select currencyList = new Select(createAccount.dropDown);
        currencyList.selectByVisibleText(string3);

    }


    @Then("Click submit button")
    public void clickSubmitButton() {
        createAccount.submit.click();
        BrowserUtils.waitFor(2);
    }



    @When("Verify to get expected {string}")
    public void verifyToGetExpected(String string) {
        Assert.assertEquals(string,createAccount.message.getText());
    }



    @When("Enter {string}, {string} and select no currency")
    public void enter_and_select_no_currency(String string, String string2) {
        createAccount.Owner.sendKeys(string);
        createAccount.balance.sendKeys(string2);
    }


}

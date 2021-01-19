package com.mobilab.step_definitions;

import com.mobilab.pages.AccountList;
import com.mobilab.pages.CreateTransaction;
import com.mobilab.utilities.BrowserUtils;
import com.mobilab.utilities.ConfigurationReader;
import com.mobilab.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateTransactionStepDef {

    String url= ConfigurationReader.get("url");
    CreateTransaction createTransaction =new CreateTransaction();

    @Given("Open the Application with given URL and click Transaction Button")
    public void openTheApplicationWithGivenURLAndClickTransactionButton() {
        Driver.get().get(url);
        createTransaction.creattransactionBTN.click();
    }


    @And("Verify the windows Title {string}")
    public void verifyTheWindowsTitle(String expectedTitle) {
        Assert.assertEquals(Driver.get().getTitle(),expectedTitle);

    }


    @Given("Enter {string},  select {string} and select {string}")
    public void enterSelectAndSelect(String amount, String sender, String reciever) {

        createTransaction.amount.sendKeys(amount);

        Select ownerSender = new Select(createTransaction.sender);
        List<WebElement> ownerList =ownerSender.getOptions();
        System.out.println(ownerList.size());

        for (WebElement lists :ownerList){
            System.out.println(lists.getText());
        }

        ownerSender.selectByVisibleText(sender);

        Select ownerReceiver = new Select(createTransaction.reciever);
        ownerReceiver.selectByVisibleText(reciever);

    }


    @Then("Click Submit Button")
    public void clickSubmitButton() {
        createTransaction.sendButton.click();
        BrowserUtils.waitFor(3);
    }

    @When("Verify to get Expected {string}")
    public void verifyToGetExpected(String expectedAlert) {
        Assert.assertEquals(expectedAlert,createTransaction.message.getText());
    }



}

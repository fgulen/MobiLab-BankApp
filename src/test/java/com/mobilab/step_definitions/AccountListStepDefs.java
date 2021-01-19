package com.mobilab.step_definitions;

import com.mobilab.pages.AccountList;
import com.mobilab.pages.CreateAccount;
import com.mobilab.pages.CreateTransaction;
import com.mobilab.utilities.BrowserUtils;
import com.mobilab.utilities.ConfigurationReader;
import com.mobilab.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountListStepDefs {

    String url= ConfigurationReader.get("url");
    AccountList accountList = new AccountList();

    @Given("Open Application with given URL and click Transaction Button")
    public void openApplicationWithGivenURLAndClickTransactionButton() {
        Driver.get().get(url);
        accountList.accountListBTN.click();

    }

    @And("Verify the Windows Title {string}")
    public void verifyTheWindowsTitle(String expectedTitle) {
        Assert.assertEquals(Driver.get().getTitle(),expectedTitle);

    }

    double transactionAmount = 0;
    double balanceFirst = 0;
    double balanceLast = 0;

    @Given("{string} sends {string} to {string}")
    public void sendsTo(String sender, String balance, String receiver) {
        accountList.searchBox.sendKeys(sender);

        String firstBalanceInAccount =Driver.get().findElement(By.xpath("//td[normalize-space()='"+sender+"']/../td[3]")).getText();

        System.out.println("firstBalanceInAccount = " + firstBalanceInAccount);

        accountList.creattransactionBTN.click();
        CreateTransaction createTransaction = new CreateTransaction();
        createTransaction.amount.sendKeys(balance);

        Select ownerSender = new Select(createTransaction.sender);
        ownerSender.selectByVisibleText(sender);

        Select ownerReceiver = new Select(createTransaction.reciever);
        ownerReceiver.selectByVisibleText(receiver);

        createTransaction.sendButton.click();
        createTransaction.accountListBTN.click();

        accountList.searchBox.sendKeys(sender);
        String lastBalanceInAccount =Driver.get().findElement(By.xpath("//td[normalize-space()='"+sender+"']/../td[3]")).getText();

        System.out.println("lastBalanceInAccount = " + lastBalanceInAccount);

        balanceFirst=Double.parseDouble(firstBalanceInAccount);
        balanceLast=Double.parseDouble(lastBalanceInAccount);

        transactionAmount = balanceFirst-balanceLast;

        System.out.println("firstBalanceInAccount = " + firstBalanceInAccount);
        System.out.println("lastBalanceInAccount = " + lastBalanceInAccount);
        System.out.println("balanceFirst = " + balanceFirst);
        System.out.println("balanceLast = " + balanceLast);

    }

    @Then("Verify first balance and current balance difference gives the {string}transaction amount")
    public void verifyFirstBalanceAndCurrentBalanceDifferenceGivesTheTransactionAmount(String difference) {

        double differenceInt = Integer.parseInt(difference);
        String differenceString = Double.toString(differenceInt);
        String transactionAmountString = Double.toString(transactionAmount);
        System.out.println("transactionAmount = " + transactionAmountString);
        System.out.println("differenceInt = " + differenceString);

        Assert.assertEquals(differenceString,transactionAmountString);


    }

    @Given("Go To CreateAccountPage for new Account")
    public void goToCreateAccountPageForNewAccount() {
        accountList.createAccountBTN.click();

    }

    @When("Enter {string}, {string} And Select {string}")
    public void enterAndSelect(String owner, String balance, String currency) {

        CreateAccount createAccount = new CreateAccount();
        createAccount.Owner.sendKeys(owner);
        createAccount.balance.sendKeys(balance);

        Select currencyList = new Select(createAccount.dropDown);
        currencyList.selectByVisibleText(currency);
        createAccount.submit.click();

    }

    @Then("Go To AccountListPage To Verify New Account with {string}, {string}, {string} Data")
    public void goToAccountListPageToVerifyNewAccountWithData(String accountHolder, String balance, String currency) {
        accountList.accountListBTN.click();

        Select pageSize = new Select(accountList.pageSize);
        pageSize.selectByVisibleText("10");

        int i=0;

        while (i < 20){
            accountList.nextPage.click();
            i++;
        }

        BrowserUtils.waitFor(3);

        List<WebElement> allRow = Driver.get().findElements(By.xpath("//table/tbody/tr")); // for  getting row size
        System.out.println("allRow.size() = " + allRow.size());

        String idFromAccountListPage = Driver.get().findElement(By.xpath("//table/tbody/tr["+allRow.size()+"]//td["+1+"]")).getText();
        String aHolderFromAccountListPage = Driver.get().findElement(By.xpath("//table/tbody/tr["+allRow.size()+"]//td["+2+"]")).getText();
        String balanceFromAccountListPage = Driver.get().findElement(By.xpath("//table/tbody/tr["+allRow.size()+"]//td["+3+"]")).getText();
        System.out.println("aHolderFromAccountListPage = " + aHolderFromAccountListPage);
        System.out.println("balanceFromAccountListPage = " + balanceFromAccountListPage);
        System.out.println("accountHolder = " + accountHolder);
        System.out.println("balance = " + balance);

        Assert.assertEquals(accountHolder,aHolderFromAccountListPage);
        Assert.assertEquals(balance,balanceFromAccountListPage);

    }
}

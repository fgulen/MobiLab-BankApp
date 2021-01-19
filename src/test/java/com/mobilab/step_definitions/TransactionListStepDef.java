package com.mobilab.step_definitions;

import com.mobilab.pages.AccountList;
import com.mobilab.pages.CreateAccount;
import com.mobilab.pages.CreateTransaction;
import com.mobilab.pages.TransactionListPage;
import com.mobilab.utilities.BrowserUtils;
import com.mobilab.utilities.ConfigurationReader;
import com.mobilab.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TransactionListStepDef {


    String url= ConfigurationReader.get("url");
    TransactionListPage transactionListPage = new TransactionListPage();

    @Given("Open Application with given URL and click TransactionList Button")
    public void openApplicationWithGivenURLAndClickTransactionListButton() {
        Driver.get().get(url);
        transactionListPage.transactionListBTN.click();

    }

    @And("Verify The Windows Title {string}")
    public void verifyTheWindowsTitle(String expectedTitle) {
        Assert.assertEquals(Driver.get().getTitle(),expectedTitle);

    }



    @Given("Go To CreateTransaction Page For New Transaction")
    public void goToCreateTransactionPageForNewTransaction() {

        Driver.get().get(url);
        transactionListPage.creattransactionBTN.click();
    }

    @When("Enter {string}, Select {string}, Select {string}, Submit To Send Money")
    public void enterSelectSelectSubmitToSendMoney(String money, String sender, String receiver) {

        CreateTransaction createTransaction = new CreateTransaction();
        createTransaction.amount.sendKeys(money);

        Select ownerSender = new Select(createTransaction.sender);
        List <WebElement> ownerList=ownerSender.getOptions();
        System.out.println("ownerList.size() = " + ownerList.size());

        for (WebElement lists : ownerList){
            System.out.println("lists.getText() = " + lists.getText());
        }

        ownerSender.selectByVisibleText(sender);

        Select ownerReceiver = new Select(createTransaction.reciever);
        ownerReceiver.selectByVisibleText(receiver);

        createTransaction.sendButton.click();


    }



    @Then("Verify transaction exist in TransactionList page with {string}, {string},{string}")
    public void verifyTransactionExistInTransactionListPageWith(String sender, String reciever, String amount) {

        Driver.get().get(url);
        transactionListPage.transactionListBTN.click();

        transactionListPage.dateOrder.sendKeys(Keys.ENTER);

        String idFromAccountListPage = Driver.get().findElement(By.xpath("//table/tbody/tr[1]//td[1]")).getText();
        String aHolderFromAccountListPage = Driver.get().findElement(By.xpath("//table/tbody/tr[1]//td[2]")).getText();
        String balanceFromAccountListPage = Driver.get().findElement(By.xpath("//table/tbody/tr[1]//td[9]")).getText();

        System.out.println("balanceFromAccountListPage = " + balanceFromAccountListPage);
        System.out.println("aHolderFromAccountListPage = " + aHolderFromAccountListPage);
        System.out.println("idFromAccountListPage = " + idFromAccountListPage);


//       accountList.searchBox.sendKeys("asd");
//
//        //String senderFromTable = Driver.get().findElement(By.xpath("//td[normalize-space()='"+sender+"']/../td[3]")).getText();
//
//        List <WebElement> allRow = Driver.get().findElements(By.xpath("//table/tbody/tr"));
//        List <WebElement> allColumn =Driver.get().findElements(By.xpath("//table//th"));
//
//
//        for (int i = 1; i <= allRow.size() ; i++) {
//
//            String rowXpath ="//table/tbody/tr["+i+"]";
//            WebElement singleRow = Driver.get().findElement(By.xpath(rowXpath));
//            System.out.println("singlerow.getText() = " + singleRow.getText());
//
//            for (int j = 1; j < allColumn.size() ; j++) {
//
//                String columnXpath = "//table/tbody/tr["+i+"]//td["+j+"]";
//                WebElement row = Driver.get().findElement(By.xpath(columnXpath));
//                System.out.println("row.getText() = " + row.getText());
//
//                if(row.getText().equals("asd")){
//
//                    String balance = Driver.get().findElement(By.xpath("//table/tbody/tr["+i+"]//td["+j+1+"]")).getText();
//                    System.out.println("balance = " + balance);
//
//                    if(balance.equals("500"));
//
//                    System.out.println("balance = " + balance);
//
//                }else;
//            }
//
//        }
//
//
//
//        String senderId = Driver.get().findElement(By.xpath("//td[normalize-space()='"+sender+"']/../td[1]")).getText();
//





    }



}

package com.mobilab.pages;

import com.mobilab.utilities.ConfigurationReader;
import com.mobilab.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){ PageFactory.initElements(Driver.get(),this);}

    @FindBy(id="createaccbtn")
    public WebElement createAccountBTN;

    @FindBy(id = "createtransbtn")
    public WebElement creattransactionBTN;

    @FindBy(id = "acclistbtn")
    public WebElement accountListBTN;

    @FindBy(id = "translistbtn")
    public WebElement transactionListBTN;


}

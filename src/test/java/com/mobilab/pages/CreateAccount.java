package com.mobilab.pages;

import com.mobilab.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount extends BasePage{
    public CreateAccount(){ PageFactory.initElements(Driver.get(),this);}

    @FindBy(id = "owner")
    public WebElement Owner;

    @FindBy(id = "balance")
    public WebElement balance;

    @FindBy(id = "currency")
    public WebElement dropDown;

    @FindBy(id="accountsubmit")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement message;

}

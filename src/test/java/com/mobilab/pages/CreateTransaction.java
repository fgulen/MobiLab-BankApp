package com.mobilab.pages;

import com.mobilab.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CreateTransaction extends BasePage {
    public CreateTransaction(){ PageFactory.initElements(Driver.get(),this);}

    @FindBy(id = "amount")
    public WebElement amount;

    @FindBy(id = "source")
    public WebElement sender;

    @FindBy(id = "destination")
    public WebElement reciever;

    @FindBy(id = "transsubmit")
    public WebElement sendButton;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement message;


}

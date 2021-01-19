package com.mobilab.pages;

import com.mobilab.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountList extends BasePage {
    public AccountList(){ PageFactory.initElements(Driver.get(),this);}

    @FindBy(id = "text-filter-column-owner")
    public WebElement searchBox;

    @FindBy (id = "Size")
    public WebElement pageSize;

    @FindBy (id = "pagNext")
    public WebElement nextPage;

    @FindBy (id="pagPrev")
    public  WebElement prevPage;


}

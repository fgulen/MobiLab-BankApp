package com.mobilab.pages;

import com.mobilab.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionListPage extends BasePage{
    public TransactionListPage(){ PageFactory.initElements(Driver.get(),this);}

    @FindBy(id="datefrom")
    public WebElement dateFrom;

    @FindBy (id = "dateto")
    public WebElement dateTo;

    @FindBy(id="text-filter-column-source.owner")
    public WebElement sourceName;

    @FindBy (id = "text-filter-column-destination.owner")
    public WebElement destinationName;

    @FindBy (xpath = "//th[@aria-label='Transaction Date sortable']")
    public WebElement dateOrder;


}

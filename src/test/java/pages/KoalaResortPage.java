package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class KoalaResortPage {
    public KoalaResortPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;
    @FindBy(id = "UserName")
    public WebElement kullaniciAdiTextBox;
    @FindBy(id = "Password")
    public WebElement passwordTexBox;
    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;
    @FindBy (linkText = "Hotel Management")
    public WebElement HotelManagementButonu;
    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement HotelListButton;

    @FindBy (xpath = "//button[@id='btnSubmit']")
    public WebElement saveButton;

    @FindBy(css = ".hidden-480")
    public WebElement addHotelButton;

    @FindBy (xpath = "//input[@id='Code']")
    public WebElement codeBox;

    @FindBy(xpath = "//select[@id='IDGroup']")
    public WebElement idGroupDropDown;

    @FindBy (xpath= "//div[text()='Hotel was inserted successfully']")
    public  WebElement sonucYazisiElementi;





    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> birinciSatirDatalar;

    @FindBy (xpath = "//thead//tr[1]//th")
    public List<WebElement> sutunBasliklari;

    @FindBy (xpath = "//tbody")
    public WebElement tbodyWebElement;

    @FindBy(xpath = "//tbody//td")
    public List<WebElement> bodydekiTumDataListesi;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;



    public  void koalaResortLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        ilkLoginLinki.click();
        kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        passwordTexBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        loginButonu.click();

    }

    public void istenenSatiriYazdir(int satirNo){
//  //tbody//tr[3]
        String satirXPath="//tbody//tr[" + (satirNo-1) + "]";

        System.out.println(Driver.getDriver().findElement(By.xpath(satirXPath)).getText());

    }
}


package smokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class E2E_CreateHotel {
    /*2. Bir metod olusturun: createHotel
3. http://qa-environment.koalaresorthotels.com adresine git.
            4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri
    girin.
            a. Username : manager
    b. Password : Manager2!
            5. Login butonuna tıklayın.
6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
            8. Save butonuna tıklayın.
9. "Hotel was inserted successfully" textinin göründüğünü test edin.
            10. OK butonuna tıklayın.*/

    @Test
    public void createHotel() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.ilkLoginLinki.click();
        koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        koalaResortPage.loginButonu.click();

        koalaResortPage.HotelManagementButonu.click();
        koalaResortPage.HotelListButton.click();
        koalaResortPage.addHotelButton.click();
        koalaResortPage.codeBox.sendKeys("20"+ Keys.ENTER+Keys.ENTER);



        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys("kr_customer_name"+Keys.ENTER).perform();
        actions.sendKeys(ConfigReader.getProperty("kr_customer_adress")+Keys.ENTER).perform();
        actions.sendKeys(ConfigReader.getProperty("kr_customer_phone")+Keys.ENTER).perform();
        actions.sendKeys(ConfigReader.getProperty("kr_customer_email")+Keys.ENTER).perform();
        Thread.sleep(5000);

        Select select=new Select(koalaResortPage.idGroupDropDown);
        select.selectByVisibleText(ConfigReader.getProperty("kr_idgroup_Value"));

        koalaResortPage.saveButton.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        Assert.assertEquals(koalaResortPage.sonucYazisiElementi.getText(), ConfigReader.getProperty("kr_sonuc_yazisi"));






    }
}

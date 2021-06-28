package smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KoalaResortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeTest {
     /*
    1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
    3 Farkli test Methodunda 3 senaryoyu test et
- yanlisSifre
- yanlisKulllanici
- yanlisSifreKullanici
test data dogru username: manager , dogru password : Manager2!
2) http://qa-environment.koalaresorthotels.com adresine git
3) Login butonuna bas
4) Verilen senaryolar ile giris yapilamadigini test et
     */

    @Test
    public  void yanlisSifre(){

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.ilkLoginLinki.click();
        koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_wrong_username"));
        koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty(("kr_valid_password")));
        koalaResortPage.loginButonu.click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty(ConfigReader.getProperty("kr_url")));

    }
    @Test
    public void yanlisKulllanici(){

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.ilkLoginLinki.click();
        koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_wrong_password"));
        koalaResortPage.loginButonu.click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("kr_url"));

    }
    @Test

    public void yanlisSifreKullanici(){

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        KoalaResortPage koalaResortPage=new KoalaResortPage();
        koalaResortPage.ilkLoginLinki.click();
        koalaResortPage.kullaniciAdiTextBox.sendKeys(ConfigReader.getProperty("kr_wrong_username"));
        koalaResortPage.passwordTexBox.sendKeys(ConfigReader.getProperty("kr_wrong_password"));
        koalaResortPage.loginButonu.click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("url"));
    }
}


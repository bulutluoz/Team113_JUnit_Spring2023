package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_BasicAuthentication extends TestBase {
    //1- Bir class olusturun : BasicAuthentication
    //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //
    //Html komutu : https://username:password@URL
    //	Username     : admin
    // 	password      : admin
    //
    //4- Basarili sekilde sayfaya girildigini dogrulayin

    @Test
    public void test01() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : admin
        // 	password      : admin
        //

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement congratyaziElementi = driver.findElement(By.tagName("p"));
        Assert.assertTrue(congratyaziElementi.isDisplayed());

        Thread.sleep(5000);

    }

}

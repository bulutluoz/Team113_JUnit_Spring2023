package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_NewWindow extends TestBase {

    /*
        Eger driver.switchTo().newWindow() kullanilirsa
        driver otomatik olarak acilan yeni sayfaya gecer

        eger gorevimizde yeni window'a gittik'ten sonra
        window'lar arasi gecis islemi varsa
        uzerinde calistigimiz window'larin
        windowHandleDegerlerini alip kaydetmekte fayda var

     */

    @Test
    public void test01() throws InterruptedException {
        // gerekli ayarlamalari yapip
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaWHD= driver.getWindowHandle();
        // title'in Amazon kelimesi icerdigini test edin
        String expectedIcerik = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        // yeni bir tab acarak wisequarter anasayfaya gidin

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(1000);
        driver.get("https://www.wisequarter.com");
        String ikinciSayfaWHD= driver.getWindowHandle();
        // url'in wisequarter icerdigini test edin
        expectedIcerik = "wisequarter";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        // tekrar amazon'un acik oldugu sayfaya gecin
        // ve url'in amazon icerdigini test edin

        driver.switchTo().window(ilkSayfaWHD);
        expectedIcerik = "amazon";
        actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Thread.sleep(3000);

    }


}

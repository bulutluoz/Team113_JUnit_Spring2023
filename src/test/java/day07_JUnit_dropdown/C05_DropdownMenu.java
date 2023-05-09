package day07_JUnit_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropdownMenu {
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //	4.Tüm dropdown değerleri(value) yazdırın
    //	5. Dropdown’un boyutunun 4 olduğunu test edin
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void dropdownTest() throws InterruptedException {
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdownMenuElementi= driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select= new Select(dropdownMenuElementi);
        select.selectByIndex(1);

        System.out.println(select.getFirstSelectedOption().getText());
        //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //	4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> optionsList = select.getOptions();

        System.out.println("=================");
        for (WebElement eachElement: optionsList
             ) {
            System.out.println(eachElement.getText());
        }



        //	5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedSize=4;
        int actualSize= optionsList.size();

        Assert.assertEquals(expectedSize,actualSize);

        Thread.sleep(3000);
    }

}

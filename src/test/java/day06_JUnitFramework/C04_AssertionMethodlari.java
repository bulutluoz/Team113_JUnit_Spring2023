package day06_JUnitFramework;


import org.junit.Assert;
import org.junit.Test;

public class C04_AssertionMethodlari {

    @Test
    public void test01(){
        /*
            Eger testin sonucunu turkce olarak olumlu bir cumle ile sorduysa assertTrue
            olumsuz cumle kullanilmissa assertfalse tercih edilir
         */

        int sayi1 = 20;
        int sayi2 = 10;
        int sayi3 = 30;

        // sayi1'in sayi2'den buyuk oldugunu test edin

        Assert.assertTrue(sayi1>sayi2);     //    sayi1>sayi2   PASSED


        // sayi1'in sayi3'den buyuk olmadigini test edin

        Assert.assertFalse(sayi1 > sayi3);

        // sayi1'in sayi3'den kucuk oldugunu test edin

        Assert.assertTrue(sayi1<sayi3);

    }
}

package org.example;

import org.junit.Assert;
import org.junit.Test;

public class KalkulatorTest {
    @Test
    public void metodaDodajPowinnaZwracacSumeArgumentow(){
        // 1 Given
        Kalkulator kalkulator = new Kalkulator();

        // 2 When
        int wynik = kalkulator.dodaj(3, 7);

        // 3 Then
        Assert.assertEquals(10, wynik);
    }
}

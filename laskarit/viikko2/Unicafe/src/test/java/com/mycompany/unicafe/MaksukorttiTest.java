package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
    
    @Test
    public void saldoKasvaaLisättäessä() {
        kortti.lataaRahaa(500);
        assertEquals("Kortilla on rahaa 15.0 euroa", this.kortti.toString());
    }
    
    @Test
    public void saldoEiKasvaLisättäessaNegatiivista() {
        kortti.lataaRahaa(-5);
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
    
    @Test
    public void metodinSaldoTest() {
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void saldoVaheneeOstettaessaOikein() {
        kortti.otaRahaa(400);
        assertEquals("Kortilla on rahaa 6.0 euroa", this.kortti.toString());
    }
    
    @Test
    public void saldoEiVaheneNegatiiviseksi() {
        kortti.otaRahaa(1500);
        assertEquals("Kortilla on rahaa 10.0 euroa", this.kortti.toString());
    }
    
    @Test
    public void josRahatRiittavatMetodiPalauttaaTrue() {
        assertTrue(kortti.otaRahaa(5));
    }
    
    @Test
    public void josRahatEivatRiitaMetodiPalauttaaFalse() {
        assertFalse(kortti.otaRahaa(2000));
    }
}

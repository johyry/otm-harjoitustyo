/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author johyry
 */
public class KassapaateTest {

    Kassapaate kassapaate;
    Maksukortti kortti;

    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void uudenKassapäätteenRahatJaLounaatOikein() {
        assertEquals("Rahaa kassassa 1000.0 euroa. Maukkaita lounaita myyty 0 kpl ja edullisia 0 kpl.", kassapaate.toString());
    }

    @Test
    public void käteisOstoEdullinen() {
        assertEquals(4760, kassapaate.syoEdullisesti(5000));
        assertEquals(100240, kassapaate.kassassaRahaa());
    }

    @Test
    public void käteisOstoEdullinenEiTarpeeksiRahaa() {
        assertEquals(200, kassapaate.syoEdullisesti(200));
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void käteisOstoMaukas() {
        assertEquals(4600, kassapaate.syoMaukkaasti(5000));
        assertEquals(100400, kassapaate.kassassaRahaa());
    }

    @Test
    public void käteisOstoMaukasEiTarpeeksiRahaa() {
        assertEquals(200, kassapaate.syoMaukkaasti(200));
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void lounaidenMääräKasvaaOstettaessa() {
        kassapaate.syoEdullisesti(500);
        kassapaate.syoMaukkaasti(500);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    
    @Test
    public void korttiostoEdullisetTarpeeksiRahaa() {
        assertTrue(kassapaate.syoEdullisesti(kortti));
        assertEquals("Kortilla on rahaa 7.60 euroa", kortti.toString());
    }
    
    @Test
    public void korttiostoMaukkaastiTarpeeksiRahaa() {
        assertTrue(kassapaate.syoMaukkaasti(kortti));
        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }
    
    @Test
    public void korttiostoEdullisetLounaidenMääräKasvaa() {
        assertTrue(kassapaate.syoEdullisesti(kortti));
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiostoMaukkaidenLounaidenMääräKasvaa() {
        assertTrue(kassapaate.syoMaukkaasti(kortti));
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiostoEdullinenEiTarpeeksiRahaa() {
        Maksukortti kortti1 = new Maksukortti(100);
        assertFalse(kassapaate.syoEdullisesti(kortti1));
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void korttiostoMaukasEiTarpeeksiRahaa() {
        Maksukortti kortti1 = new Maksukortti(100);
        assertFalse(kassapaate.syoMaukkaasti(kortti1));
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassanRahaMääräEiNouseKortillaOstettaessaEdullinen() {
        kassapaate.syoEdullisesti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kassanRahaMääräEiNouseKortillaOstettaessaMaukas() {
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleOikea() {
        kassapaate.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000, kassapaate.kassassaRahaa());
        assertEquals(2000, kortti.saldo());
    }
    
    @Test
    public void lataaRahaaKortilleNegatiivinenSumma() {
        kassapaate.lataaRahaaKortille(kortti, -500);
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(1000, kortti.saldo());
    }

}

package com.mycompany.unicafe;

public class Maksukortti {

    private int saldo;

    public Maksukortti(int saldo) {
        this.saldo = saldo;
    }

    public int saldo() {
        return saldo;
    }

    public void lataaRahaa(int lisays) {
        if (lisays >= 0) {
            this.saldo += lisays;
        }
    }

    public boolean otaRahaa(int maara) {
        if (this.saldo < maara) {
            return false;
        }

        this.saldo = this.saldo - maara;
        return true;
    }

    @Override
    public String toString() {
        int euroja = saldo/100;
        int sentteja = saldo%100;
        String palautus = "Kortilla on rahaa " + euroja + "." + sentteja + " euroa";
        return palautus;
    }

}

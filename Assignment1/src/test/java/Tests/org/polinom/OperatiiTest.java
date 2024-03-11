package org.polinom;

import GUI.MainFrame;


import static org.junit.Assert.*;

public class OperatiiTest {


    private Polinom polinom1=new Polinom("3x^2+3x");
    private Polinom polinom2=new Polinom("3x");
    @org.junit.Test
    public void adunare() {

       Polinom expected = new Polinom("6x+3x^2");
       Polinom rezultat = Operatii.Adunare(polinom1,polinom2);
       assertArrayEquals(expected.getCoefficients(), rezultat.getCoefficients());
    }

    @org.junit.Test
    public void scadere() {
        Polinom expected = new Polinom("3x^2");
        Polinom rezultat = Operatii.Scadere(polinom1,polinom2);
        assertArrayEquals(expected.getCoefficients(), rezultat.getCoefficients());
    }

    @org.junit.Test
    public void inmultire() {

        Polinom expected = new Polinom("9x^2+9x^3");
        Polinom rezultat = Operatii.Inmultire(polinom1, polinom2);

     assertArrayEquals(expected.getCoefficients(), rezultat.getCoefficients());
    }

    @org.junit.Test
    public void impartire() {

        Polinom poli1=new Polinom("4x^2");
        Polinom poli2=new Polinom("2x");
        Polinom expected = new Polinom("2x");
        Polinom rezultat = Operatii.Impartire(poli1, poli2);

        assertArrayEquals(expected.getCoefficients(), rezultat.getCoefficients());
    }


    @org.junit.Test
    public void derivare() {

        Polinom expected = new Polinom("6x+3");
        Polinom rezultat = Operatii.Derivare(polinom1);

        assertArrayEquals(expected.getCoefficients(), rezultat.getCoefficients());
    }

    @org.junit.Test
    public void integrare() {

        Polinom expected = new Polinom("1x^3+1x^2");
        Polinom rezultat = Operatii.Integrare(polinom1);

        assertArrayEquals(expected.getCoefficients(), rezultat.getCoefficients());
    }
}
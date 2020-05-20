package org.example;


import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    Kalkulator kalkulator = new Kalkulator();
    int wynik = kalkulator.dodaj(2,5);
        System.out.println(wynik);
    String komunikat = kalkulator.przywitaj();
        System.out.println(komunikat);
    }
}

package com.company;


import org.w3c.dom.Element;

public class Kniha {

    String isbn;
    int vydano;
    String nazev;
    String jmeno;
    String prijmeni;

    public Kniha(Element elementKniha) {
        this.isbn = elementKniha.getAttribute("ISBN");
        this.vydano = Integer.parseInt(elementKniha.getAttribute("Vydano"));
        Element nazevElement = (Element) elementKniha.getElementsByTagName("Nazev").item(0);
        this.nazev = nazevElement.getTextContent();
        Element autorElement = (Element) elementKniha.getElementsByTagName("Autor").item(0);
        this.jmeno = autorElement.getAttribute("Jmeno");
        this.prijmeni = autorElement.getAttribute("Prijmeni");
    }

    public String serializeToCSVString() {
        return isbn + ";" + jmeno + " " + prijmeni + ";" + nazev + ";" + vydano + "\n";
    }


    public static String serializeHeader() {
        return "ISBN" + ";" + "Autor" + ";" + "Nazev" + ";" + "Vydano" + "\n";
    }
}
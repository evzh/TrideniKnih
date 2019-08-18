package com.company;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class Main {

    public static void main(String[] args) {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document xmlDom = docBuilder.parse(new File("knihy.xml"));

            Element seznamElement = (Element) xmlDom.getElementsByTagName("Seznam").item(0);
            NodeList knihy = seznamElement.getElementsByTagName("Kniha");

            List <Kniha> listKnihy = new ArrayList<>();

            for(int i=0; i<knihy.getLength(); i++){
                Node node = knihy.item(i);
                Element elementKniha = (Element) node;
                Kniha kniha = new Kniha(elementKniha);
                listKnihy.add(kniha);
            }

            SeznamKnih seznamKnih = new SeznamKnih(listKnihy);
            seznamKnih.sort();

        }catch (Exception ex){
            System.out.println(ex.toString());
        }



    }
}


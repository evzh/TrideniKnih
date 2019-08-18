package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class SeznamKnih {

    List<Kniha> knihy;

    public SeznamKnih(List<Kniha> knihy) {
        this.knihy = knihy;
    }


    public void sort() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("zadejte rok zlomu: ");
        int x = Integer.parseInt(scanner.nextLine());
        StringBuilder sb1 = new StringBuilder();
        sb1.append(Kniha.serializeHeader());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Kniha.serializeHeader());
        for (Kniha kniha : knihy) {
            if (kniha.vydano < x) {
                sb1.append(kniha.serializeToCSVString());
            } else {
                sb2.append(kniha.serializeToCSVString());
            }
        }

        writeToTextFile("knihy_stare.csv", sb1.toString());
        writeToTextFile("knihy_nove.csv", sb2.toString());

    }

    private void writeToTextFile(String filename, String content){
        try {
            PrintWriter out;
            out = new PrintWriter(filename);
            out.println(content);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}

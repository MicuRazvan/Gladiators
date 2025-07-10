package dictionare;

import gladiatori.CantReadException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DictionarNume {
    List<String> cuvinte = new ArrayList<>();

    public DictionarNume() {
        File file = new File(
                "nume.txt");

        try {
            BufferedReader br
                    = new BufferedReader(new FileReader(file));

            String st;

            while ((st = br.readLine()) != null)
                cuvinte.add(st);
        }catch (Exception exception) {
            throw new CantReadException();
        }
    }

    public List<String> getCuvinte() {
        return cuvinte;
    }
}
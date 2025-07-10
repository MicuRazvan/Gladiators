package dictionare;

import gladiatori.Animal;

import java.io. * ;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private List<Animal> animals = new ArrayList<>();

    public CSVReader(String path) {
        boolean primaLinie = true;
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)
            {
                if(primaLinie)
                    primaLinie = false;
                else {
                    String[] animals = line.split(splitBy);
                    this.animals.add(new Animal(animals[0], Integer.parseInt(animals[1])));
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> getAnimale() {
        return animals;
    }

    public void afiseazaAnimals(){
        for(Animal animal : animals)
            System.out.println(animal.getNume() + " " + animal.getDangerLevel());
    }
}
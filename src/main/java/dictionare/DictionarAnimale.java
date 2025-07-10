package dictionare;

import gladiatori.Animal;

import java.util.ArrayList;
import java.util.List;

public class DictionarAnimale {
    private List<Animal> animals = new ArrayList<>();

    public DictionarAnimale(){
        CSVReader csvReader = new CSVReader
                ("animaleCSV.csv");

        this.animals = csvReader.getAnimale();
    }

    public void afiseazaAnimals(){
        for(Animal animal : animals)
            System.out.println(animal.getNume() + " " + animal.getDangerLevel());
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
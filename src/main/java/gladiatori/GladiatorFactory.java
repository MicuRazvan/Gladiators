package gladiatori;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GladiatorFactory {
    private List<Gladiator> gladiatori = new ArrayList<>();

    public void generateRandomGladiator(String nume) {
        int number;
        Random rand = new Random();
        number = rand.nextInt(4) + 1;
        if (number == 1)
            gladiatori.add(new Archer(nume));
        if (number == 2)
            gladiatori.add(new Assasin(nume));
        if (number == 3)
            gladiatori.add(new Brutal(nume));
        if (number > 3)
            gladiatori.add(new Fighter(nume));
    }

    public void afisareGladiatori() {
        for (Gladiator i : gladiatori)
            i.afisareGladiator();
        System.out.println();
    }

    Gladiator getGladiator(int numar) {
        if (numar >= gladiatori.size()) return null;
        return gladiatori.get(numar);
    }

    List<Gladiator> getAllGladiators() {
        return gladiatori;
    }
}

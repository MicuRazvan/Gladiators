package gladiatori;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Tournament {
    private List<Gladiator> concurenti = new ArrayList<>();
    private Gladiator castigator;
    private Colosseum colosseum;

    public Tournament(Colosseum colosseum, Gladiator gladiator){
        this.colosseum = colosseum;
        concurenti.add(gladiator);
        for(int i = 1; i <= 7; i++){
            concurenti.add(this.colosseum.generateRandomGladiatorFaraClasa(
                    this.colosseum.getDictionar().getCuvinte().
                            get(this.getConcurenti().get(0).randomNumber(1, this.colosseum.getDictionar().getCuvinte().size() - 1))));
        }
        afisareConcurenti();
    }

    public void afisareConcurenti() {
        System.out.println("Concurentii:");
        for(int i = 0; i < concurenti.size(); i++)
            concurenti.get(i).afisareGladiator();
    }

    public void startTurneu() throws InterruptedException {
        while (concurenti.size() > 1) {
            List<Gladiator> aux = new ArrayList<>();
            for (int i = 0; i < concurenti.size() - 1; i += 2) {
                 //Scanner sc= new Scanner(System.in);
               // String request = sc.nextLine();

                Combat fight = new Combat(concurenti.get(i), concurenti.get(i + 1));
                fight.simulate();
                fight.afisareCombatLog();
                System.out.println("");
                aux.add(fight.getCastigator());
            }
            this.concurenti = aux;
        }
        this.castigator = concurenti.get(0);
        this.castigator.setTurneeCastigate(castigator.getTurneeCastigate() + 1);

        System.out.println("Castigator: ");
        this.getCastigator().afisareGladiator();
    }

    public Gladiator getCastigator(){
        return castigator;
    }

    public List<Gladiator> getConcurenti() {
        return concurenti;
    }
}
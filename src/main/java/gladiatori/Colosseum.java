package gladiatori;

import dictionare.DictionarNume;
import items.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Colosseum {
    List<Gladiator> gladiatoriJucator;



    public Gladiator getGenerat() {
        return generat;
    }

    Gladiator player;

    public Gladiator getPlayer() {
        return player;
    }

    Boolean win = false;

    public Boolean getWin() {
        return win;
    }

    Gladiator generat;
    DictionarNume dictionar = new DictionarNume();
    Tournament tournament;

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Tournament getTournament() {
        return tournament;
    }

    Campaign campaign;

    public Colosseum(){
        this.gladiatoriJucator = new ArrayList<>();
    }

    public void startCampaign(int index){
        if(index >= this.gladiatoriJucator.size())
            System.out.println("Index invalid");
        else {
            if(this.getGladiatorByIndex(index).getExpeditiiLaRand() == 3)
                System.out.println("Gladiatorul nu mai poate participa la expeditii");
            else {
                this.getGladiatorByIndex(index).setCurrentHp();
                this.gladiatoriJucator.remove(index);
                campaign.startCampaign();
                campaign.afisaretLog();

                if (!campaign.getGladiator().isDead()) {
                    Gladiator gladiatorFromCampaign = campaign.getGladiator();
                    String itemFromCampaign = campaign.getItem();

                    if(itemFromCampaign.equals("Weapon") && !campaign.getWeapon().getType().equals(gladiatorFromCampaign.getWeapon().getType())){
                        System.out.println("Sadly you can't use the weapon you found because it isn't for your class!");
                    }
                    else {
                        System.out.println("Do you want to keep the item?");

                        Scanner sc = new Scanner(System.in);
                        String request = sc.nextLine();

                        if (request.equals("yes")) {
                            System.out.println("Item saved!");
                            if (itemFromCampaign.equals("Weapon"))
                                gladiatorFromCampaign.setWeapon(campaign.getWeapon());
                            if (itemFromCampaign.equals("Chest"))
                                gladiatorFromCampaign.setChest(campaign.getChest());
                            if (itemFromCampaign.equals("Boots"))
                                gladiatorFromCampaign.setBoots(campaign.getBoots());
                            if (itemFromCampaign.equals("Helmet"))
                                gladiatorFromCampaign.setHelmet(campaign.getHelmet());
                        }
                        else
                            System.out.println("Item not saved!");
                    }
                    gladiatorFromCampaign.expeditii++;
                    gladiatorFromCampaign.expeditiiLaRand++;
                    this.gladiatoriJucator.add(gladiatorFromCampaign);
                }
            }
        }
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void generateRandomStandardGladiators(List<String> concurenti){
        for (String nume : concurenti)
            this.gladiatoriJucator.add(generateRandomGladiatorFaraClasa(nume));
    }

    public void generateRandomStandardGladiator(String concurent){
        gladiatoriJucator.add(this.generateRandomGladiatorFaraClasa(concurent));
    }

    public void startTurneu(int index) throws InterruptedException {
        if(index >= this.gladiatoriJucator.size())
            System.out.println("Index invalid");
        else {
            String numeGladatiatorAles = this.getGladiatorByIndex(index).getNume();
            this.gladiatoriJucator.remove(index);
            this.tournament.startTurneu();

            if(tournament.getCastigator().getNume().equals(numeGladatiatorAles)) {
                this.gladiatoriJucator.add(tournament.getCastigator());
                this.gladiatoriJucator.get(gladiatoriJucator.size() - 1).setExpeditiiLaRand(0);
                this.gladiatoriJucator.get(gladiatoriJucator.size() - 1).setLupteCasualCastigateLaRand(0);
            }
        }
    }

    public void startCasualFight(int index){
        if(index >= this.gladiatoriJucator.size())
            System.out.println("Index invalid");
        else {
            if(this.getGladiatorByIndex(index).getLupteCasualCastigateLaRand() == 5)
                System.out.println("Gladiatorul nu mai poate participa la lupte casual");
            else {
                player = this.getGladiatorByIndex(index);
                generat = this.generateRandomGladiatorFaraClasa(
                        this.getDictionar().getCuvinte().get(this.getGladiatorByIndex(0).randomNumber(1, 149)));
                Combat fight = new Combat(this.getGladiatorByIndex(index),generat);

                fight.simulate();
                fight.afisareCombatLog();
                fight.getCastigator().afisareGladiator();


                if (fight.getCastigator().equals(this.getGladiatorByIndex(index))) {
                    win = true;
                    this.getGladiatorByIndex(index).cresteLupteCasualCastigate();
                    this.getGladiatorByIndex(index).cresteLupteCasualCastigateLaRand();
                    player = this.getGladiatorByIndex(index);
                }else win = false;
            }
        }
    }

    public void afisareTotiGladiatorii(){
        System.out.println("Concurentii din colosseum");
        for(int i = 0; i < this.gladiatoriJucator.size(); i++)
            this.gladiatoriJucator.get(i).afisareGladiator();
    }

    public void generateGladiatorCuClasa(String nume, String clasa){
        Gladiator gladiator = null;
        if(clasa == "Archer")
            gladiator = new Archer(nume);

        if(clasa == "Assasin")
            gladiator = new Assasin(nume);

        if(clasa == "Brutal")
            gladiator = new Brutal(nume);

        if(clasa == "Fighter")
            gladiator = new Fighter(nume);

        if(gladiator != null)
            this.gladiatoriJucator.add(gladiator);
        else
            System.out.println("Clasa invalida");
    }

    public Gladiator generateRandomGladiatorFaraClasa(String nume) {
        int number;
        Random rand = new Random();
        number = rand.nextInt(4) + 1;
        Gladiator gladiator = null;

        if (number == 1)
            gladiator = new Archer(nume);
        if (number == 2)
            gladiator = new Assasin(nume);
        if (number == 3)
            gladiator = new Brutal(nume);
        if (number == 4)
            gladiator = new Fighter(nume);

        return gladiator;
    }

    public void generateGladiatorCuClasa(String nume, String clasa, int lvl){
        Gladiator gladiator = null;
        if(clasa == "Archer")
            gladiator = new Archer(nume, lvl);

        if(clasa == "Assasin")
            gladiator = new Assasin(nume, lvl);

        if(clasa == "Brutal")
            gladiator = new Brutal(nume, lvl);

        if(clasa == "Fighter")
            gladiator = new Fighter(nume, lvl);

        if(gladiator != null)
            this.gladiatoriJucator.add(gladiator);
        else
            System.out.println("Clasa invalida");
    }

    public Gladiator generateRandomGladiatorFaraClasa(String nume, int lvl) {
        int number;
        Random rand = new Random();
        number = rand.nextInt(4) + 1;
        Gladiator gladiator = null;

        if (number == 1)
            gladiator = new Archer(nume, lvl);
        if (number == 2)
            gladiator = new Assasin(nume, lvl);
        if (number == 3)
            gladiator = new Brutal(nume, lvl);
        if (number == 4)
            gladiator = new Fighter(nume, lvl);

        return gladiator;
    }

    Gladiator getGladiatorByIndex(int index){
        if(index < gladiatoriJucator.size() && index >= 0)
            return this.gladiatoriJucator.get(index);
        System.out.println("Index invalid");
        return null;
    }

    public List<Gladiator> getGladiatoriJucator() {
        return gladiatoriJucator;
    }

    public void setGladiatoriJucator(List<Gladiator> gladiatoriJucator) {
        this.gladiatoriJucator = gladiatoriJucator;
    }

    public DictionarNume getDictionar() {
        return dictionar;
    }
}
package gladiatori;

import dictionare.DictionarAnimale;
import items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Campaign {
    private Gladiator gladiator;
    private String item;
    private Weapon weapon;
    private Boots boots;
    private Helmet helmet;
    private Chest chest;
    private int chanceToLeave = 0;
    DictionarAnimale dictionarAnimale = new DictionarAnimale();
    List<String> log = new ArrayList<>();

    private Boolean win = false;

    public Campaign(Gladiator gladiator){
        this.gladiator = gladiator;
    }

    public void startCampaign(){
        List<Animal> animals = this.dictionarAnimale.getAnimals();
        log.add("Campaign started:");
        Random r = new Random();
        int animalNumber;

        while(this.gladiator.randomNumber(1,100) > this.chanceToLeave && !this.gladiator.isDead()){
            animalNumber = r.nextInt(animals.size() - 1);
            log.add(this.gladiator.getFullName() + " found a " + animals.get(animalNumber).getNume() + " and ");

            if(r.nextInt(99) + 1 > 100 - animals.get(animalNumber).getDangerLevel() * 10) {
                log.set(log.size() - 1, log.get(log.size() - 1) + " died!");
                this.gladiator.setCurrentHp(0);
            }
            else{
                log.set(log.size() - 1, log.get(log.size() - 1) + " killed him!");
            }
            this.chanceToLeave += 30;
        }

        this.createRandomItem();
        if(!this.gladiator.isDead()) {
            win = true;
            if(item.equals("Weapon"))
                log.add(this.gladiator.getFullName() + " escaped and found " + this.weapon.toString());
            if(item.equals("Boots"))
                log.add(this.gladiator.getFullName() + " escaped and found " + this.boots.toString());
            if(item.equals("Helmet"))
                log.add(this.gladiator.getFullName() + " escaped and found " + this.helmet.toString());
            if(item.equals("Chest"))
                log.add(this.gladiator.getFullName() + " escaped and found " + this.chest.toString());
        }else win = false;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public void createRandomItem(){
        Random r = new Random();
        int number = r.nextInt(3) + 1;

        switch (number) {
            case 1 -> {
                weapon = new Weapon(this.gladiator.getLevel());
                item = "Weapon";
            }
            case 2 -> {
                boots = new Boots(this.gladiator.getLevel());
                item = "Boots";
            }
            case 3 -> {
                helmet = new Helmet(this.gladiator.getLevel());
                item = "Helmet";
            }
            case 4 -> {
                chest = new Chest(this.gladiator.getLevel());
                item = "Chest";
            }
        }


    }

    public void afisaretLog(){
        for (int i = 0; i < this.log.size(); i++)
            System.out.println(log.get(i));
    }

    public Gladiator getGladiator() {
        return gladiator;
    }

    public void setGladiator(Gladiator gladiator) {
        this.gladiator = gladiator;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getChanceToLeave() {
        return chanceToLeave;
    }

    public void setChanceToLeave(int chanceToLeave) {
        this.chanceToLeave = chanceToLeave;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Boots getBoots() {
        return boots;
    }

    public void setBoots(Boots boots) {
        this.boots = boots;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public List<String> getLog() {
        return log;
    }

    public void setLog(List<String> log) {
        this.log = log;
    }
}
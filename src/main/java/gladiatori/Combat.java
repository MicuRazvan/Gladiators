package gladiatori;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Combat {
    private Gladiator gladiator1;
    private Gladiator gladiator2;
    private Gladiator castigator;
    private List<String> combatLog = new ArrayList<>();

    public Combat(Gladiator a, Gladiator b){
        gladiator1 = a;
        gladiator2 = b;
    }

    void simulate(){
        double HPglad1, HPglad2;
        if (gladiator1 == null && gladiator2 == null) castigator = null;
        if (gladiator1 == null) {
            gladiator2.levelUp();
            castigator = gladiator2;
        }
        if (gladiator2 == null) {
            gladiator1.levelUp();
            castigator = gladiator1;
        }

        if(gladiator1 != null && gladiator2 != null) {
            combatLog.add("Fight: " + gladiator1.getFullName() + " versus " + gladiator2.getFullName());
            combatLog.add("Begin!");
            gladiator1.setCurrentHp();
            gladiator2.setCurrentHp();
            gladiator1.setAffected("");
            gladiator2.setAffected("");

            Random rand = new Random();
            int number = rand.nextInt(2) + 1;
            int nr = 1;
            while (!gladiator1.isDead() && !gladiator2.isDead() && nr <= 100) {
                nr++;
                if (number == 1) {
                    if(!gladiator1.getAffected().equals("Freeze"))
                        gladiator1.attack(gladiator2, this.combatLog);
                    else {
                        this.combatLog.add(gladiator1.getFullName() + " is frozen and can't attack");
                        gladiator1.setAffected("");
                    }

                    if (!gladiator2.isDead()) {
                        if(!gladiator2.getAffected().equals("Freeze"))
                            gladiator2.attack(gladiator1, combatLog);
                        else {
                            this.combatLog.add(gladiator2.getFullName() + " is frozen and can't attack");
                            gladiator2.setAffected("");
                        }
                    }
                } else {
                    if(!gladiator2.getAffected().equals("Freeze"))
                        gladiator2.attack(gladiator1, this.combatLog);
                    else{
                        this.combatLog.add(gladiator2.getFullName() + " is frozen and can't attack");
                        gladiator2.setAffected("");
                    }

                    if (!gladiator1.isDead()) {
                        if(!gladiator1.getAffected().equals("Freeze"))
                            gladiator1.attack(gladiator2, combatLog);
                        else {
                            this.combatLog.add(gladiator1.getFullName() + " is frozen and can't attack");
                            gladiator1.setAffected("");
                        }
                    }
                }

                if(gladiator1.getPower().equals("Healing") && !gladiator1.isDead() && gladiator1.randomNumber(1,100) <= 30) {
                    gladiator1.healUp((gladiator1.getMaxHp() - gladiator1.getCurrentHp()) / 2);
                    this.combatLog.add(gladiator1.getFullName() + " healed himself for " + (gladiator1.getMaxHp() - gladiator1.getCurrentHp()) / 2 + " HP!");
                }

                if(gladiator2.getPower().equals("Healing") && !gladiator2.isDead() && gladiator2.randomNumber(1,100) <= 30) {
                    gladiator2.healUp((gladiator2.getMaxHp() - gladiator2.getCurrentHp()) / 2);
                    this.combatLog.add(gladiator2.getFullName() + " healed himself for " + (gladiator2.getMaxHp() - gladiator2.getCurrentHp()) / 2 + " HP!");
                }

                if(gladiator1.getPoisonedRounds() > 0){
                    gladiator1.decreasePoisonedRounds();
                    this.combatLog.add(gladiator1.getFullName() + " was poisoned for " + gladiator1.getMaxHp() / 90 + " damage!");
                    gladiator1.decreasaHpBy(gladiator1.getCurrentHp() / 10);
                }

                if(gladiator2.getPoisonedRounds() > 0){
                    gladiator2.decreasePoisonedRounds();
                    this.combatLog.add(gladiator2.getFullName() + " was poisoned for " + gladiator2.getMaxHp() / 90 + " damage!");
                    gladiator2.decreasaHpBy(gladiator2.getCurrentHp() / 10);
                }

                this.combatLog.add(" ");
            }
            if (!gladiator1.isDead()) {
                combatLog.add(gladiator2.getFullName() + " has died, " + gladiator1.getFullName() + " wins!");
                gladiator1.levelUp();
                gladiator1.setAffected(null);
                castigator = gladiator1;
            } else {
                combatLog.add(gladiator1.getFullName() + " has died, " + gladiator2.getFullName() + " wins!");
                gladiator2.levelUp();
                gladiator2.setAffected(null);
                castigator = gladiator2;
            }
        }
    }

    List<String> getCombatLog() {
        return combatLog;
    }

    Gladiator getCastigator() {
        return castigator;
    }

    Gladiator getParticipant(int nr) {
        if (nr == 1) return gladiator1;
        return gladiator2;
    }

    public void afisareCombatLog(){
        for (int i = 0; i < this.combatLog.size(); i++)
            System.out.println(combatLog.get(i));
    }
}
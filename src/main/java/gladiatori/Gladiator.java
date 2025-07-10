package gladiatori;

import items.*;

import java.util.List;
import java.util.Random;

public abstract class Gladiator {
    public int currentHp;
    protected String clasa;
    protected String nume;
    protected int level;
    protected int hp, sp, dex;
    protected String hpMult, spMult, dexMult;
    protected int turneeCastigate = 0;
    protected int lupteCasualCastigate = 0;
    protected int lupteCasualCastigateLaRand = 0;
    protected int expeditii = 0;
    protected int expeditiiLaRand = 0;
    protected String power;
    protected String affected = "";
    protected int poisonedRounds = 0;
    protected Helmet helmet = new Helmet(1);
    protected Chest chest = new Chest(1);
    protected Weapon weapon;
    protected Boots boots = new Boots(1, "None");

    public void levelUp(){
        this.level++;
    }

    public void decreasaHpBy(int dmg){
        this.currentHp = this.currentHp - dmg;
    }

    public boolean isDead(){
        if(this.currentHp <= 0)
            return true;

        return  false;
    }

    public void healUp(int heal){
        this.currentHp += heal;
    }

    public void afisareGladiator(){
        System.out.println(getClasa() + " " + getNume() + " " +  " HP: " + getHp() + " SP: " + getSp() + " DEX: " + getDex() +
                " level: " + getLevel() + " power: " + getPower() + " " + weapon.toString() + " " +
                helmet.toString() + " " + chest.toString() + " " + boots.toString());
    }

    public void attack(Gladiator defender, List<String> combatLog) {
        int dex = this.getDex() - defender.getDex() + defender.getChest().getLevel()/4;

        if (dex < 10) dex = 10;
        if (dex > 100) dex = 100;

        if (this.getPower().equals("Rage") && randomNumber(1, 100) <= 30) {
            combatLog.add(this.getFullName() + " used Rage");
            int dmg = this.getSp() * (randomNumber(1, 5)) / 10 + this.getWeapon().getLevel()/4;
            defender.decreasaHpBy(dmg);
            combatLog.add(this.getFullName() + " deals " + dmg + " damage");
        }
        else {
            if(this.getPower().equals("Rage"))
                combatLog.add(this.getFullName() + " failed in using Rage");

            if (randomNumber(1, 100) <= dex) {
                if(this.getPower().equals("None") || this.getPower().equals("Healing"))
                    combatLog.add(this.getFullName() + " missed");
                else
                    combatLog.add(this.getFullName() + " missed the hit and to apply "  + this.getPower());
            } else {
                int dmg = this.getSp() * (randomNumber(1, 5)) / 10 + this.getWeapon().getLevel()/4;
                defender.decreasaHpBy(dmg);


                combatLog.add(this.getFullName() + " deals " + dmg + " damage");
                if(this.getPower().equals("Freeze") || this.getPower().equals("Poison") ){
                    if(this.randomNumber(1, 100) <= 30) {
                        combatLog.set(combatLog.size() - 1, combatLog.get(combatLog.size() - 1) + " and applied " + this.getPower());

                        if(defender.getBoots().getImmuneTo().equals(this.getPower()))
                            combatLog.set(combatLog.size() - 1, combatLog.get(combatLog.size() - 1) + " but " + defender.getFullName() + " is immune to it!");
                        else {
                            if (this.getPower().equals("Poison"))
                                defender.setPoisonedRounds(3);
                            else
                                defender.setAffected("Freeze");
                        }
                    }
                    else
                        combatLog.set(combatLog.size() - 1, combatLog.get(combatLog.size() - 1) + " but failed to apply " + this.getPower());
                }
            }
        }
    }

    public void kill(){
        this.currentHp = 0;
    }

    public int randomNumber(int low, int high){
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }

    public int getMaxDex(){
        String mult = this.getDexMult();
        if(mult == "low")
            return (int) (this.getDex() * 0.75 * level);

        if(mult == "medium")
            return this.getDex() * 1 * level;

        return (int) (this.getDex() * 1.25 * level);
    }

    public int getMaxSp(){
        String mult = this.getSpMult();
        if(mult == "low")
            return (int) (this.getSp() * 0.75 * level);

        if(mult == "medium")
            return this.getSp() * 1 * level;

        return (int) (this.getSp() * 1.25 * level);
    }

    public int getMaxHp(){
        String mult = this.getHpMult();
        if(mult == "low")
            return (int) (this.getHp() * 0.75 * level);

        if(mult == "medium")
            return this.getHp() * 1 * level;

        return (int) (this.getHp() * 1.25 * level);
    }

    public String choosePower(){
        int number = this.randomNumber(1,100);

        if(number >= 60) {
            if (number <= 70)
                return new String("Freeze");

            if(number <= 80)
                return new String("Poison");

            if(number <= 90)
                return new String("Rage");

            return new String("Healing");
        }

        return new String("None");
    }

    public void decreasePoisonedRounds(){
        this.poisonedRounds--;
    }

    public void cresteLupteCasualCastigate(){
        this.lupteCasualCastigate++;
    }

    public void cresteLupteCasualCastigateLaRand(){
        this.lupteCasualCastigateLaRand++;
    }

    public void cresteExpeditii(){
        this.expeditii++;
    }

    public void cresteExpeditiiLaRand(){
        this.expeditiiLaRand++;
    }

    public String getFullName(){
        return this.getClasa() + " " + this.getNume();
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp() {
        this.currentHp = getMaxHp() + this.getHelmet().getLevel()/4;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getLevel() {
        return level;
    }

    public String getClasa() {
        return clasa;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

    public String getHpMult() {
        return hpMult;
    }

    public void setHpMult(String hpMult) {
        this.hpMult = hpMult;
    }

    public String getSpMult() {
        return spMult;
    }

    public void setSpMult(String spMult) {
        this.spMult = spMult;
    }

    public String getDexMult() {
        return dexMult;
    }

    public void setDexMult(String dexMult) {
        this.dexMult = dexMult;
    }

    public int getTurneeCastigate() {
        return turneeCastigate;
    }

    public void setTurneeCastigate(int turneeCastigate) {
        this.turneeCastigate = turneeCastigate;
    }

    public int getLupteCasualCastigate() {
        return lupteCasualCastigate;
    }

    public void setLupteCasualCastigate(int lupteCasualCastigate) {
        this.lupteCasualCastigate = lupteCasualCastigate;
    }

    public int getLupteCasualCastigateLaRand() {
        return lupteCasualCastigateLaRand;
    }

    public void setLupteCasualCastigateLaRand(int lupteCasualCastigateLaRand) {
        this.lupteCasualCastigateLaRand = lupteCasualCastigateLaRand;
    }

    public int getExpeditii() {
        return expeditii;
    }

    public void setExpeditii(int expeditii) {
        this.expeditii = expeditii;
    }

    public int getExpeditiiLaRand() {
        return expeditiiLaRand;
    }

    public void setExpeditiiLaRand(int expeditiiLaRand) {
        this.expeditiiLaRand = expeditiiLaRand;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public String getAffected() {
        return affected;
    }

    public void setAffected(String affected) {
        this.affected = affected;
    }

    public int getPoisonedRounds() {
        return poisonedRounds;
    }

    public void setPoisonedRounds(int poisonedRounds) {
        this.poisonedRounds = poisonedRounds;
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
}
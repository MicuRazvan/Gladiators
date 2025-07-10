package gladiatori;

import items.Boots;
import items.Chest;
import items.Helmet;
import items.Weapon;

public class Assasin extends Gladiator{
    public Assasin(String nume){
        this.nume = nume;
        this.level = randomNumber(20, 25);
        this.clasa = "Assasin";
        this.hpMult = "low";
        this.spMult = "high";
        this.dexMult = "high";
        this.hp = randomNumber(1, 25);
        this.dex = randomNumber(1, 25);
        this.sp = randomNumber(1, 25);
        this.power = this.choosePower();
        this.weapon = new Weapon(1, "Daggers");
    }

    public Assasin(String nume, int lvl){
        this.nume = nume;
        this.level = randomNumber(lvl - 2, lvl + 2);
        this.clasa = "Assasin";
        this.hpMult = "low";
        this.spMult = "high";
        this.dexMult = "high";
        this.hp = randomNumber(1, 25);
        this.dex = randomNumber(1, 25);
        this.sp = randomNumber(1, 25);
        this.power = this.choosePower();

        if (randomNumber(1, 100) < 25)
            this.weapon = new Weapon(randomNumber(lvl - 2, lvl + 2), "Daggers");
        else
            this.weapon = new Weapon(1, "Daggers");

        if (randomNumber(1, 100) < 25)
            this.chest = new Chest(randomNumber(lvl - 2, lvl + 2));

        if (randomNumber(1, 100) < 25)
            this.helmet = new Helmet(randomNumber(lvl - 2, lvl + 2));

        if (randomNumber(1, 100) < 15) {
            if(randomNumber(1,100) <= 50)
                this.boots = new Boots(randomNumber(lvl - 2, lvl + 2), "Freeze");
            else
                this.boots = new Boots(randomNumber(lvl - 2, lvl + 2), "Poison");
        }
    }

    public Assasin(String nume, int hp, int sp, int dex, String power, int turneeCastigate, int lupteCasualCastigate,
                   int lupteCasualCastigateLaRand, int expeditii, int expeditiiLaRand, int level, int helmetLevel,
                   int chestLevel, int weaponLevel, int bootsLevel, String immuneTo){

        this.clasa = "Assasin";
        this.nume = nume;
        this.hp = hp;
        this.sp = sp;
        this.dex = dex;
        this.power = power;
        this.turneeCastigate = turneeCastigate;
        this.lupteCasualCastigate = lupteCasualCastigate;
        this.lupteCasualCastigateLaRand = lupteCasualCastigateLaRand;
        this.expeditii = expeditii;
        this.expeditiiLaRand = expeditiiLaRand;
        this.level = level;
        this.helmet = new Helmet(helmetLevel);
        this.chest = new Chest(chestLevel);
        this.weapon = new Weapon(level, "Daggers");
        this.boots = new Boots(bootsLevel, immuneTo);
    }
}
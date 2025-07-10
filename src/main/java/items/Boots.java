package items;

import java.util.Random;

public class Boots extends Item{
    private String ImmuneTo;

    public Boots(int level){
        this.level = level;

        Random r = new Random();
        if(r.nextInt(99) + 1 <= 25) {
            int number = r.nextInt(2) + 1;

            switch (number) {
                case 1 -> this.ImmuneTo = "Freeze";
                case 2 -> this.ImmuneTo = "Poison";
            }
        }
        else
            this.ImmuneTo = "None";
    }

    public Boots(int level, String immuneTo) {
        this.level = level;
        this.ImmuneTo = immuneTo;
    }

    public String afiseazaBoots(){
        return "Boots " + "Level: " + this.level + " Immune to " + this.ImmuneTo;
    }

    public String getImmuneTo() {
        return ImmuneTo;
    }

    public void setImmuneTo(String immuneTo) {
        ImmuneTo = immuneTo;
    }

    @Override
    public String toString() {
        return "Boots Level: " + this.level + " Immune to: " + this.ImmuneTo;
    }
}
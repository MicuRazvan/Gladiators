package items;

import java.util.Random;

public class Weapon extends Item{
    private String type;

    public Weapon(int level){
        this.level = level;

        Random r = new Random();
        int number = r.nextInt(3) + 1;

        switch (number) {
            case 1 -> this.type = "Bow";
            case 2 -> this.type = "Sword";
            case 3 -> this.type = "Mace";
            case 4 -> this.type = "Daggers";
        }
    }

    public Weapon(int level, String type){
        this.level = level;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type + " Level: " + this.level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
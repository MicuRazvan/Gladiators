package items;

public class Chest extends Item{
    public Chest(int level){
        this.level = level;
    }

    @Override
    public String toString() {
        return "Chest Level: " + this.level;
    }
}
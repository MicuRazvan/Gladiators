package items;

public class Helmet extends Item {
    public Helmet(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Helmet Level: " + this.level;
    }
}
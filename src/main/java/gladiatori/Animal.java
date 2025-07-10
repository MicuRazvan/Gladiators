package gladiatori;

public class Animal {
    private String nume;
    private int dangerLevel;

    public Animal(String nume, int dangerLevel) {
        this.nume = nume;
        this.dangerLevel = dangerLevel;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(int dangerLevel) {
        this.dangerLevel = dangerLevel;
    }
}
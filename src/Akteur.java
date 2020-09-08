public abstract class Akteur {

    double damage, hp;
    boolean race;

    Akteur() {
        this.damage = 1;
        this.hp = 5;
        this.race = true;
    }

    Akteur(double damage, double hp, boolean race) {
        this.damage = damage;
        this.hp = hp;
        this.race = race;
    }

    public double getDamage() {
        return damage;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void increaseDamage() {
        damage ++;
    }

    public void decreaseHp() {
        hp --;
    }
  
    public boolean getRace(){
        return race;
    }

    public abstract double getTrueDamage();

}

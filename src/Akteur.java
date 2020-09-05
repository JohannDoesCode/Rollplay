public abstract class Akteur {

    double damage, hp;

    Akteur() {
        this.damage = 1;
        this.hp = 5;
    }

    Akteur(double damage, double hp) {
        this.damage = damage;
        this.hp = hp;
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

    public abstract double getTrueDamage();

}

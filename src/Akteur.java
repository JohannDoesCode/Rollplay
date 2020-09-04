public abstract class Akteur {

    int damage, hp;

    Akteur() {
        this.damage = 1;
        this.hp = 5;
    }

    Akteur(int damage, int hp) {
        this.damage = damage;
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getHp() {
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

    public abstract int getTrueDamage();

}

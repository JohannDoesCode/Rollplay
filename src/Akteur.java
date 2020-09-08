import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public abstract class Akteur {

    int damage, hp;
    int xKoord, yKoord, size;
    boolean race;
    static RoundRectangle2D rect;

    Akteur(int size, int xKoord, int yKoord) {
        this.damage = 1;
        this.hp = 100;
        this.race = true;
        this.size = size;
        this.xKoord = xKoord;
        this.yKoord = yKoord;

        rect = new RoundRectangle2D.Float(xKoord, yKoord, size, size,10,10);
    }

    Akteur(int damage, int hp, boolean race, int size, int xKoord, int yKoord) {
        this.damage = damage;
        this.hp = hp;
        this.race = race;
        this.size = size;
        this.xKoord = xKoord;
        this.yKoord = yKoord;

        rect = new RoundRectangle2D.Float(xKoord, yKoord, size, size,10,10);
    }

    public int getHp() {
        return hp;
    }

    public void setSettings(int size, int xKoord, int yKoord) {
        this.size = size;
        this.xKoord = xKoord;
        this.yKoord = yKoord;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void increaseDamage() {
        damage += 2;
    }

    public abstract String getRaceClass();
  
    public boolean getRace(){
        return race;
    }

    public abstract int getTrueDamage();

}

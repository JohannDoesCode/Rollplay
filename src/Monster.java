public class Monster extends Akteur {

    private int poisonDamage;

    public Monster() {
        super(2, 2);
    }

    public int getTrueDamage() {
        poisonDamage = (int) (Math.random()*2) + 1;
        int trueDamage = damage + poisonDamage;
        return trueDamage;
    }

}

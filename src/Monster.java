public class Monster extends Akteur {

    private double poisonDamage;

    public Monster() {
        super(2, 2);
    }

    public double getTrueDamage() {
        poisonDamage = (int) (Math.random()*2) + 1;
        double trueDamage = damage + poisonDamage;
        return trueDamage;
    }

}

public class Monster extends Akteur {

    private double poisonDamage;
    private String raceClass, raceElement;
    String[] raceClassList, raceElements;

    public Monster() {
        super(2, 2, false);
        raceClassList = new String[4];
        raceElements = new String[7];
        createRaceClass((int) Math.random()*3);
        createRaceElement((int) Math.random()*5);
    }

    public void createRaceClass(int whichClass){
        raceClassList[0] = "golem";
        raceClassList[1] = "werwolf";
        raceClassList[2] = "skeleton";
        raceClassList[3] = "oni";
        raceClass = raceClassList[whichClass];
    }

    public void createRaceElement(int whichElement){
        raceElements[0] = "";
        raceElements[1] = "ice";
        raceElements[2] = "lightning";
        raceElements[3] = "healing";
        raceElements[4] = "damage";
        raceElements[5] = "destruction";
        raceElements[6] = "fire";
        raceElement = raceElements[whichElement];
    }

    public double getTrueDamage() {
        poisonDamage = (int) (Math.random()*2) + 1;
        double trueDamage = damage + poisonDamage;
        return trueDamage;
    }

}

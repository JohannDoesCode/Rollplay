public class Monster extends Akteur {

    private int poisonDamage;
    private String raceClass, raceElement;
    String[] raceClassList, raceElements;

    public Monster() {
        super(2, 100, false, 0, 0, 0);
        raceClassList = new String[4];
        raceElements = new String[7];
        createRaceClass((int) (Math.random()*4));
        createRaceElement((int) (Math.random()*6));
    }

    public void createRaceClass(int whichClass){
        raceClassList[0] = "golem";
        raceClassList[1] = "werwolf";
        raceClassList[2] = "skeleton";
        raceClassList[3] = "oni";
        raceClass = raceClassList[whichClass];
    }

    public String getRaceClass(){
        return raceClass;
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

    public int getTrueDamage() {
        poisonDamage = (int) (Math.random()*3) + 1;
        int trueDamage = damage + poisonDamage;
        return trueDamage;
    }

}

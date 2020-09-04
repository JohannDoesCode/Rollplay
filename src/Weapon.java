public class Weapon {

    String matter;
    int strengthBuff;

    public Weapon(){
        matter = "wood";
        strengthBuff = 1;
    }

    public Weapon(String matter,int strengthBuff){
        this.matter = matter;
        this.strengthBuff = strengthBuff;
    }

    public String getMatter(){
        return matter;
    }

    public int getStrengthBuff(){
        return strengthBuff;
    }

}

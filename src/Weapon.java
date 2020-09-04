public class Weapon {

    String[] matters;
    String matter;
    int strengthBuff;

    public Weapon(){
        matter = "iron";
        strengthBuff = 1;
    }

    public Weapon(String matter,int strengthBuff){
        this.matter = matter;
        this.strengthBuff = strengthBuff;
        createMatter();
    }

    public void createMatter(){
        matters = new String[20];
            matters[0] = "copper";
            matters[1] = "iron";
            matters[2] = "steel";
            matters[3] = "moonstone";
            matters[4] = "gold";
            matters[5] = "pyerite";
            matters[6] = "silver";
            matters[7] = "orcish";
            matters[8] = "dwarven";
            matters[9] = "elven";
            matters[10] = "mythril";
            matters[11] = "ebony";
            matters[12] = "eridium";
            matters[13] = "diamond";
            matters[14] = "corbomite";
            matters[15] = "obsidian";
            matters[16] = "viridium";
            matters[17] = "dragonbone";
            matters[18] = "soulsteel";
            matters[19] = "tarydium";
            matters[20] = "stygium";






    }

    public String getMatter(){
        return matter;
    }

    public int getStrengthBuff(){
        return strengthBuff;
    }

}

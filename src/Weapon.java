public class Weapon {

    String[] matters, enchantements;
    String matter, enchantement;
    int strengthBuff;


    public Weapon(){
        matter = "iron";
        strengthBuff = 1;
    }

    public Weapon(String matter,int strengthBuff, String enchantement){
        this.matter = matter;
        this.strengthBuff = strengthBuff;
        this.enchantement = enchantement;
        createMatter();
        createEnchantements();
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
            matters[19] = "stygium";

    }

    public void createEnchantements(){
        enchantements = new String[20];
        enchantements[0] = "copper";
        enchantements[1] = "iron";
        enchantements[2] = "steel";
        enchantements[3] = "moonstone";
        enchantements[4] = "gold";
        enchantements[5] = "pyerite";
        enchantements[6] = "silver";
        enchantements[7] = "orcish";
        enchantements[8] = "dwarven";
        enchantements[9] = "elven";

    }

    public String getMatter(){
        return matter;
    }

    public int getStrengthBuff(){
        return strengthBuff;
    }

}

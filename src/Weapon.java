public class Weapon {

    String[] matters, enchantments;
    String matter, enchantment;
    int strengthBuff;
    boolean whichIHave;


    public Weapon(){
        matter = "iron";
        strengthBuff = 1;
        whichIHave = false;
    }

    public Weapon(String matter, String enchantment){
        this.matter = matter;
        this.enchantment = enchantment;
        createGame();
        whichIHave = false;
    }

    public void createGame(){
        createMatter();
        createEnchantments();
        createStrengthBuff();
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
            matters[14] = "corbonite";
            matters[15] = "obsidian";
            matters[16] = "viridium";
            matters[17] = "dragonbone";
            matters[18] = "soulsteel";
            matters[19] = "stygium";

    }

    public void createStrengthBuff(){
        switch (matter) {

            case "copper":
                strengthBuff = 1;
                break;

            case "iron":
                strengthBuff = 2;
                break;

            case "steel":
                strengthBuff = 3;
                break;
            case "moonstone":
                strengthBuff = 4;
                break;
            case "gold":
                strengthBuff = 5;
                break;
            case "pyerite":
                strengthBuff = 6;
                break;
            case "silver":
                strengthBuff = 7;
                break;
            case "orcish":
                strengthBuff = 8;
                break;
            case "dwarven":
                strengthBuff = 9;
                break;
            case "elven":
                strengthBuff = 10;
                break;
            case "mythril":
                strengthBuff = 11;
                break;
            case "ebony":
                strengthBuff = 12;
                break;
            case "eridium":
                strengthBuff = 13;
                break;
            case "diamond":
                strengthBuff = 14;
                break;
            case "corbonite":
                strengthBuff = 15;
                break;
            case "obsidian":
                strengthBuff = 16;
                break;
            case "viridium":
                strengthBuff = 17;
                break;
            case "dragonbone":
                strengthBuff = 18;
                break;
            case "soulsteel":
                strengthBuff = 19;
                break;
            case "stygium":
                strengthBuff = 20;
                break;
        }
    }

    public void createEnchantments(){
        enchantments = new String[7];
        enchantments[0] = "";
        enchantments[1] = "ice";
        enchantments[2] = "lightning";
        enchantments[3] = "healing";
        enchantments[4] = "damage";
        enchantments[5] = "destruction";
        enchantments[6] = "fire";

    }

    public void equip(boolean whichIHave){
        this.whichIHave = whichIHave;

    }

    public boolean equiped(){
        return whichIHave;
    }

    public String getMatter(){
        return matter;
    }

    public String getEnchantment(){
        return enchantment;
    }

    public int getStrengthBuff(){
        return strengthBuff;
    }

}

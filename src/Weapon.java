public class Weapon {

    String[] matters, enchantments;
    String matter, enchantment;
    double strengthBuff;


    public Weapon(){
        matter = "iron";
        strengthBuff = 1;
    }

    public Weapon(String matter, String enchantment){
        this.matter = matter;
        this.enchantment = enchantment;
        createGame();
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
                strengthBuff = 0.5;
                break;

            case "iron":
                strengthBuff = 1;
                break;

            case "steel":
                strengthBuff = 1.5;
                break;
            case "moonstone":
                strengthBuff = 2;
                break;
            case "gold":
                strengthBuff = 2.5;
                break;
            case "pyerite":
                strengthBuff = 3;
                break;
            case "silver":
                strengthBuff = 3.5;
                break;
            case "orcish":
                strengthBuff = 4;
                break;
            case "dwarven":
                strengthBuff = 4.5;
                break;
            case "elven":
                strengthBuff = 5;
                break;
            case "mythril":
                strengthBuff = 5.5;
                break;
            case "ebony":
                strengthBuff = 6;
                break;
            case "eridium":
                strengthBuff = 6.5;
                break;
            case "diamond":
                strengthBuff = 7;
                break;
            case "corbonite":
                strengthBuff = 7.5;
                break;
            case "obsidian":
                strengthBuff = 8;
                break;
            case "viridium":
                strengthBuff = 8.5;
                break;
            case "dragonbone":
                strengthBuff = 9;
                break;
            case "soulsteel":
                strengthBuff = 9.5;
                break;
            case "stygium":
                strengthBuff = 10;
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

    public String getMatter(){
        return matter;
    }

    public String getEnchantment(){
        return enchantment;
    }

    public double getStrengthBuff(){
        return strengthBuff;
    }

}

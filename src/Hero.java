public class Hero extends Akteur {


    Weapon weaponExample;
    Weapon[] weapons;
    int weaponWeight;

    public Hero(){
        super();
        weaponExample = new Weapon("",1,"");
        weapons = new Weapon[3];
        weaponWeight = (int) (Math.random()*2)+1;
        for(int i = 0; i < weaponWeight; i++){
            int matterType = (int) (Math.random()*6);
            weapons[i] = new Weapon(weaponExample.matters[matterType],matterType ,"");
        }
    }

    public int getWeaponWeight(){
        return weaponWeight;
    }

    public void lootWeapon(Weapon weapon){
        if(weaponWeight < 3 && weaponWeight != 0){
            weapons[weaponWeight -1] = new Weapon();
            weaponWeight ++;
        }
        if(weaponWeight == 0){
            weapons[weaponWeight] = new Weapon();
            weaponWeight ++;
        }
    }

    public int getTrueDamage(){
        int trueDamage = damage;

        for(int i = 0; i < weaponWeight; i++){
            trueDamage += weapons[i].getStrengthBuff();
        }

        return trueDamage;
    }


}

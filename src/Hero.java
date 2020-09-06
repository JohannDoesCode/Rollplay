public class Hero extends Akteur {


    Weapon weaponExample;
    Weapon[] weapons;
    int weaponWeight;

    public Hero(){
        super();
        weaponExample = new Weapon("","");
        weapons = new Weapon[3];
        weaponWeight = (int) (Math.random()*2)+1;
        for(int i = 0; i < weaponWeight; i++){
            weapons[i] = new Weapon(weaponExample.matters[(int) (Math.random()*6)],"");
        }
    }

    public int getWeaponWeight(){
        return weaponWeight;
    }

    public void lootWeapon(Weapon weapon){
        if(weaponWeight < 3 && weaponWeight != 0){
            weapons[weaponWeight -1] = new Weapon(weaponExample.matters[(int) (Math.random()*3)+16],"");
            weaponWeight ++;
        }
        if(weaponWeight == 0){
            weapons[weaponWeight] = new Weapon(weaponExample.matters[(int) (Math.random()*19)],"");
            weaponWeight ++;
        }
    }

    public double getTrueDamage(){
        double trueDamage = damage;

        for(int i = 0; i < weaponWeight; i++){
            trueDamage += weapons[i].getStrengthBuff();
        }

        return trueDamage;
    }


}

public class Hero extends Akteur {


    Weapon weaponExample;
    Weapon[] weapons;
    int weaponWeight;
    boolean bot;

    public Hero(){
        super(0,0,0);
        bot = true;
        weaponExample = new Weapon("","");
        weapons = new Weapon[10];
        weaponWeight = (int) (Math.random()*3)+1;
        for(int i = 0; i < weaponWeight; i++){
            weapons[i] = new Weapon(weaponExample.matters[(int) (Math.random()*6)],"");
        }
    }

    public int getWeaponWeight(){
        return weaponWeight;
    }

    public void lootWeapon(){
        if(weaponWeight < 10 ){
            weaponWeight ++;
            weapons[weaponWeight - 1] = new Weapon(weaponExample.matters[(int) (Math.random()*16)+4],"");
        }
    }

    public Weapon getWeaponId(int id){
        return weapons[id];
    }


    public int getTrueDamage(){
        int trueDamage = damage;

        if(bot) {
            if(weaponWeight <= 1) {
                for (int i = 0; i < weaponWeight; i++) {
                    trueDamage += (int) (Math.random() * (weapons[i].getStrengthBuff() + 1));
                }
            }
            else{
                for (int i = 0; i < weaponWeight-1; i++) {
                    trueDamage += (int) (Math.random() * (weapons[i].getStrengthBuff() + 1));
                }
            }
        }

        if(!bot){
            for (int i = 0; i < weaponWeight; i++) {
                if(weapons[i].equiped()) {
                    trueDamage += weapons[i].getStrengthBuff();
                }
            }
        }

        return trueDamage;
    }

    public String getRaceClass(){
        return "hey";
    }

}

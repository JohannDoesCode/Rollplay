public class InitGame{

    Healer healer;

    public InitGame(){
     Hero hero = new Hero();
     Monster monster = new Monster();
     healer = new Healer();
     fight(hero, monster);
    }

    public void fight(Hero hero, Monster monster){

        if(hero.getHp() > 0 && monster.getHp() > 0) {

            if (hero.getTrueDamage() < monster.getTrueDamage()) {
               printFaint(1,hero,monster);
            }

            if (hero.getTrueDamage() > monster.getTrueDamage()) {
               printFaint(2,hero,monster);

            } else if (hero.getTrueDamage() == monster.getTrueDamage()) {
               printFaint(3,hero,monster);
            }
        }
    }

    public void printFaint(int faintNumber, Hero hero, Monster monster){
        switch (faintNumber) {

            case  1:
                System.out.println("The monster ate the hero. The hero was to weak and could not stand a chance.");
                System.out.println("");
                monster.increaseDamage();

                if (hero.getHp() > 1) {
                    System.out.println("The hero (" + hero.getHp() + "hp) fainted and lost 1 hp");
                    hero.decreaseHp();

                } else {
                    System.out.println("The hero (" + hero.getHp() + "hp) died as his last hp were drained out of his body.");
                    hero.decreaseHp();
                }
                break;

            case  2:
                System.out.println("The hero cut the monster in half. The monster was to weak and could not stand a chance.");
                System.out.println("");
                hero.increaseDamage();

                if (hero.getHp() > 1) {
                    System.out.println("The monster (" + monster.getHp() + "hp) fainted and lost 1 hp");
                    monster.decreaseHp();
                } else {
                    System.out.println("The monster (" + monster.getHp() + "hp) died as his last hp were drained out of his body.");
                    monster.decreaseHp();
                }
                break;

            case  3:
                System.out.println("The hero (" + hero.getHp() + "hp) fought the monster (" + monster.getHp() + "hp) for hours. After a while they both gave up and returned home.");
                System.out.println("");
                hero.increaseDamage();
                monster.increaseDamage();
                hero.decreaseHp();
                monster.decreaseHp();
                break;



        }
    }


    public static void main(String[] args){
        new InitGame();
    }

}

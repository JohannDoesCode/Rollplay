public class InitGame{
  
  Akteur[] akteure;
  Healer healer;
  
  public InitGame(){
    akteure = new Akteur[10];
    
    for (int i = 0;i < 10 ;i++ ) {
      int rand = (int) (Math.random()*1) + 1;
      if (rand == 1){
        akteure[i] = new Monster();
      }
      else {
        akteure[i] = new Hero();
      }
      if (i == 2 || i == 4 || i == 6 || i == 8 || i == 10){
        fight(akteure[i], akteure[i - 1]);
      }
      healer = new Healer();
    }
  }
  public void fight(Akteur akteur1, Akteur akteur2){
    
    if(akteur1.getHp() > 0 && akteur2.getHp() > 0) {
      
      if (akteur1.getTrueDamage() < akteur2.getTrueDamage()) {
        if(!akteur1.getRace()){
          if(!akteur2.getRace()){
            printFaint("monsterMonster2",akteur1,akteur2);
          }
          else if(akteur2.getRace()){
              printFaint("monsterHero2",akteur1,akteur2);
          }
          }
        if(akteur1.getRace()){
          if(!akteur2.getRace()){
            printFaint("heroMonster2",akteur1,akteur2);
          }
          else if(akteur2.getRace()){
              printFaint("heroHero2",akteur1,akteur2);
          }
          }
      }
      
      if (akteur1.getTrueDamage() > akteur2.getTrueDamage()) {
        if(!akteur1.getRace()){
          if(!akteur2.getRace()){
            printFaint("monsterMonster1",akteur1,akteur2);
          }
          else if(akteur2.getRace()){
              printFaint("monsterHero1",akteur1,akteur2);
          }
          }
        if(akteur1.getRace()){
          if(!akteur2.getRace()){
            printFaint("heroMonster1",akteur1,akteur2);
          }
          else if(akteur2.getRace()){
              printFaint("heroHero1",akteur1,akteur2);
          }
          }
      }
       
        else if (akteur1.getTrueDamage() == akteur2.getTrueDamage()) {
          if(!akteur1.getRace()){
          if(!akteur2.getRace()){
            printFaint("monsterMonsterDraw",akteur1,akteur2);
          }
          else if(akteur2.getRace()){
              printFaint("monsterHeroDraw",akteur1,akteur2);
          }
          }
        if(akteur1.getRace()){
          if(!akteur2.getRace()){
            printFaint("monsterHeroDraw",akteur1,akteur2);
          }
          else if(akteur2.getRace()){
              printFaint("heroHeroDraw",akteur1,akteur2);
          }
          }
        }
    }
    
  }
  
  public void printFaint(String faintCase, Akteur akteur1, Akteur akteur2){
    switch (faintCase) {
      
      case  "monsterMonster2":
        System.out.println("The monster ate the second monster. It was to weak and could not stand a chance.");
        System.out.println("");
        akteur2.increaseDamage();
        
        if (akteur1.getHp() > 1) {
          System.out.println("The monster (" + akteur1.getHp() + "hp) fainted and lost 1 hp");
          System.out.println("");
          akteur1.decreaseHp();
          
        } else {
          System.out.println("The monster (" + akteur1.getHp() + "hp) died as his last hp were drained out of his body.");
          System.out.println("");
          akteur1.decreaseHp();
          healer.addHero(akteur1);
        }
        break;
        
      case  "monsterHero2":
        System.out.println("The hero cut the monster in half. The monster was to weak and could not stand a chance.");
        System.out.println("");
        akteur2.increaseDamage();
        
        if (akteur1.getHp() > 1) {
          System.out.println("The monster (" + akteur1.getHp() + "hp) fainted and lost 1 hp");
          System.out.println("");
          akteur1.decreaseHp();
        } else {
          System.out.println("The monster (" + akteur1.getHp() + "hp) died as his last hp were drained out of his body.");
          System.out.println("");
          akteur1.decreaseHp();
          healer.addHero(akteur1);
        }
        break;
        
      case  "heroMonster2":
        System.out.println("The monster ate the hero. The hero was to weak and could not stand a chance.");
        System.out.println("");
        akteur2.increaseDamage();
        
        if (akteur1.getHp() > 1) {
          System.out.println("The hero (" + akteur1.getHp() + "hp) fainted and lost 1 hp");
          System.out.println("");
          akteur1.decreaseHp();
        } else {
          System.out.println("The hero (" + akteur1.getHp() + "hp) died as his last hp were drained out of his body.");
          System.out.println("");
          akteur1.decreaseHp();
          healer.addHero(akteur1);
        }
        break;
      case  "heroHero2":
        System.out.println("The hero finished the second hero with his full willpower. The hopeless hero was to weak and could not stand a chance.");
        System.out.println("");
        akteur2.increaseDamage();
        
        if (akteur1.getHp() > 1) {
          System.out.println("The hero (" + akteur1.getHp() + "hp) fainted and lost 1 hp");
          System.out.println("");
          akteur1.decreaseHp();
        } else {
          System.out.println("The hero (" + akteur1.getHp() + "hp) died as his last hp were drained out of his body.");
          System.out.println("");
          akteur1.decreaseHp();
          healer.addHero(akteur1);
        }
        break;
              case  "monsterMonster1":
                System.out.println("The monster ate the second monster. It was to weak and could not stand a chance.");
                System.out.println("");
                akteur1.increaseDamage();
                
                if (akteur2.getHp() > 1) {
                  System.out.println("The monster (" + akteur2.getHp() + "hp) fainted and lost 1 hp");
                  System.out.println("");
                  akteur2.decreaseHp();
                  
                } else {
                  System.out.println("The monster (" + akteur2.getHp() + "hp) died as his last hp were drained out of his body.");
                  System.out.println("");
                  akteur2.decreaseHp();
                  healer.addHero(akteur2);
                }
                break;
              case  "monsterHero1":
                System.out.println("The monster ate the hero. The hero was to weak and could not stand a chance.");
                System.out.println("");
                akteur1.increaseDamage();
                
                if (akteur2.getHp() > 1) {
                  System.out.println("The hero (" + akteur2.getHp() + "hp) fainted and lost 1 hp");
                  System.out.println("");
                  akteur2.decreaseHp();
                } else {
                  System.out.println("The hero (" + akteur2.getHp() + "hp) died as his last hp were drained out of his body.");
                  System.out.println("");
                  akteur2.decreaseHp();
                  healer.addHero(akteur2);
                }
                break;
              case  "heroMonster1":
                System.out.println("The hero cut the monster in half. The monster was to weak and could not stand a chance.");
                System.out.println("");
                akteur1.increaseDamage();
                
                if (akteur2.getHp() > 1) {
                  System.out.println("The monster (" + akteur2.getHp() + "hp) fainted and lost 1 hp");
                  System.out.println("");
                  akteur2.decreaseHp();
                } else {
                  System.out.println("The monster (" + akteur2.getHp() + "hp) died as his last hp were drained out of his body.");
                  System.out.println("");
                  akteur2.decreaseHp();
                  healer.addHero(akteur2);
                }
                break;
              case  "heroHero1":
                System.out.println("The dstination of the heros where alredy setted, when they began to fight. After a few seconds the weaker hero felt on his kneew and bagged for his life, in hope that the powerfull hero would show some mercy.");
                System.out.println("");
                akteur1.increaseDamage();
                
                if (akteur2.getHp() > 1) {
                  System.out.println("The hero (" + akteur2.getHp() + "hp) fainted and lost 1 hp");
                  System.out.println("");
                  akteur2.decreaseHp();
                } else {
                  System.out.println("The hero (" + akteur2.getHp() + "hp) died as his last hp were drained out of his body.");
                  System.out.println("");
                  akteur2.decreaseHp();
                  healer.addHero(akteur2);
                }
                break;
                      case  "monsterMonsterDraw":
                        System.out.println("The monster (" + akteur1.getHp() + "hp) fought the other monster (" + akteur2.getHp() + "hp) for hours. After a while they both gave up and returned home.");
                        System.out.println("");
                        akteur1.increaseDamage();
                        akteur2.increaseDamage();
                        akteur1.decreaseHp();
                        akteur2.decreaseHp();
                        if(akteur1.getHp() == 0){
                          healer.addHero(akteur1);
                        }
                        if(akteur2.getHp() == 0){
                          healer.addHero(akteur2);
                        }
                        break;
                      case  monsterHeroDraw:
                        System.out.println("The hero (" + akteur1.getHp() + "hp) fought the monster (" + akteur2.getHp() + "hp) for hours. After a while they both gave up and returned home.");
                        System.out.println("");
                        akteur1.increaseDamage();
                        akteur2.increaseDamage();
                        akteur1.decreaseHp();
                        akteur2.decreaseHp();
                        if(akteur1.getHp() == 0){
                          healer.addHero(akteur1);
                        }
                        if(akteur2.getHp() == 0){
                          healer.addHero(akteur2);
                        }
                        break;
                      
                      case  "heroHeroDraw":
                        System.out.println("The hero (" + akteur1.getHp() + "hp) fought the other hero (" + akteur2.getHp() + "hp) for hours. After a while they both gave up and returned home.");
                        System.out.println("");
                        akteur1.increaseDamage();
                        akteur2.increaseDamage();
                        akteur1.decreaseHp();
                        akteur2.decreaseHp();
                        if(akteur1.getHp() == 0){
                          healer.addHero(akteur1);
                        }
                        if(akteur2.getHp() == 0){
                          healer.addHero(akteur2);
                        }
                        break;    
    } 
                
  }


  public static void main(String[] args){
    new InitGame();
  }

}

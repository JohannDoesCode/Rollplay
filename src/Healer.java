public class Healer {
  
  Hero[] waitHero;
  int guildMembers;
  

    public Healer(){
           waitHero = new Hero[4];
           guildMembers = 0;
    }
  
    public void addHero(Hero hero){
    switch (guildMembers) {
      case  0: 
        System.out.println("The hero is getting heald soon!");
        waitHero[0] = hero;
        guildMembers ++;
        break;
      case  1: 
        System.out.println("The hero is getting heald soon!");
        waitHero[1] = hero;
        guildMembers ++;
        break;
      case  2: 
        System.out.println("The hero is getting heald soon!");
        waitHero[2] = hero;
        guildMembers ++;
        break;
      case  3: 
        System.out.println("The hero is getting heald soon!");
        waitHero[3] = hero;
        guildMembers ++;
        break;
      case  4: 
        System.out.println("The healer can not heal so many heros, he needs to regain his magica.");
        break;
    } 
      }

    public void heal(){
    
      if ( guildMembers > 0 ) {
        waitHero[0].setHp(5);
          for (int x = 0; 3 > x; x++ ) {
            waitHero[x] = waitHero[x+1];
          } 
          System.out.println("Hero healed!");
      } 

    }

}

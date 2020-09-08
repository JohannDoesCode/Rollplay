public class Healer {
  
  Akteur[] waitHero;
  int guildMembers;
  

    public Healer(){
           waitHero = new Akteur[4];
           guildMembers = 0;
    }
  
    public void addHero(Akteur akteur){
    if(!akteur.getRace()){                  
      
        switch (guildMembers) {
          case  0: 
            System.out.println("The hero is getting heald soon!");
            System.out.println("");
            waitHero[0] = akteur;
            guildMembers ++;
            break;
          case  1: 
            System.out.println("The hero is getting heald soon!");
            System.out.println("");
            waitHero[1] = akteur;
            guildMembers ++;
            break;
          case  2: 
            System.out.println("The hero is getting heald soon!");
            System.out.println("");
            waitHero[2] = akteur;
            guildMembers ++;
            break;
          case  3: 
            System.out.println("The hero is getting heald soon!");
            System.out.println("");
            waitHero[3] = akteur;
            guildMembers ++;
            break;
          case  4: 
            System.out.println("The healer can not heal so many heros, he needs to regain his magica.");
            System.out.println("");
            break;
        } 
      }
      else{
           System.out.println("Begone you filthy monster!");
           System.out.println("");
        }
    }

    public void heal(){
    
      if ( guildMembers > 0 ) {
        waitHero[0].setHp(5);
          for (int x = 0; 3 > x; x++ ) {
            waitHero[x] = waitHero[x+1];
          } 
          System.out.println("Hero healed!");
          System.out.println("");
      } 

    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InitGame extends JPanel implements Runnable, KeyListener {


  JFrame myFrame;
  Akteur[] akteure;
  Weapon[] weapons;
  Healer healer;
  Hero mainHero;
  int width, height, itemFieldAktive, itemFieldAktiveAction;
  boolean printActionDead;
  String printAction;
  
  public InitGame(){
    width = 1000;
    height = 800;
    weapons = new Weapon[10];
    itemFieldAktive = 1;
    itemFieldAktiveAction = 1;
    printAction = "";
    printActionDead = true;
    this.setPreferredSize(new Dimension(width, height));
    this.setBackground(Color.WHITE);
    myFrame = new JFrame("ADVENTURE");
    myFrame.setLocation(100, 100);
    myFrame.setResizable(false);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.add(this);
    myFrame.addKeyListener(this);
    myFrame.pack();
    myFrame.setVisible(true);

    Thread th = new Thread(this);
    th.start();

    akteure = new Akteur[10];
    healer = new Healer();
    respawnMob();

  }

  public void run() {
    mainHero = new Hero();
    mainHero.setHp(80);
    mainHero.bot = false;
    while(myFrame.isVisible()){
      repaint();
    }
  }

  public void fight(){

    if (mainHero.getTrueDamage() < akteure[1].getTrueDamage() || mainHero.getTrueDamage() > akteure[1].getTrueDamage())
    {
      mainHero.setHp(mainHero.getHp()-akteure[1].getTrueDamage());
      akteure[1].setHp(akteure[1].getHp()-mainHero.getTrueDamage());
      if (mainHero.getHp() > 1) {
        printAction  = "hpLost";
      }
      else{
        printAction  = "dead";
        dead();
      }
      if (akteure[1].getHp() > 1) {
        printAction  = "hpLost";
      } else{
        printAction  = "kill";
        respawnMob();
        mainHero.lootWeapon();
      }
    }
    else
    {
      mainHero.setHp(mainHero.getHp()-(akteure[1].getTrueDamage()/2));
      akteure[1].setHp(akteure[1].getHp()-(mainHero.getTrueDamage()/2));
      if (mainHero.getHp() > 1) {
        printAction  = "hpLost";
      } else{
        printAction  = "dead";
        dead();
      }
      if (akteure[1].getHp() > 1) {
        printAction  = "hpLost";
      } else{
        printAction  = "kill";
        respawnMob();
        mainHero.lootWeapon();
      }
    }
  }

  public void dead(){
    printActionDead  = false;
  }

  public void respawnMob(){

    for (int i = 0;i < 10 ;i++ ) {
      int rand = (int) (Math.random() * 2) + 1;

      if (rand == 1) {
        akteure[1] = new Monster();
      } else {
        akteure[1] = new Hero();
      }
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    switch (printAction) { // change koordinaten
      case "hpLost":
        g.setColor(Color.RED);
        g.drawString( (mainHero.getHp()) +" Hp ", width - 50, 20);
        break;
      case "blocked":
        g.setColor(Color.BLUE);
        g.drawString( (mainHero.getHp()) +" Hp ", width - 50, 20);
        break;
      case "dead":
        akteure[1].setHp(100);
        g.setColor(Color.BLACK);
        g.drawString( (mainHero.getHp()) +" Hp ", width - 50, 20);
        printActionDead = false;
        break;
      case "kill":
        mainHero.setHp(80);
        g.setColor(Color.BLACK);
        g.drawString( (mainHero.getHp()) +" Hp ", width - 50, 20);
        break;
    }
      if(!printActionDead){
        g.setColor(Color.RED);
        g.drawString( "You Died", width/2 - 18, height/2+4);
      }
      if (printActionDead){
        g.setColor(Color.WHITE);
        g.drawString( "You Died", width/2 - 18, height/2+4);
      for (int i = 0; i < 100; i++) {
        g.setColor(Color.WHITE);
        g.fillRect(i * 5, 20, 5, 10);
      }
      for (int i = mainHero.getHp(); i > 0; i--) {
        g.setColor(Color.RED);
        g.fillRect(width + i * -5, 20, 5, 10);
      }

      for (int i = 0; i < mainHero.getWeaponWeight(); i++) {
        weapons[i] = mainHero.getWeaponId(i);
        if (itemFieldAktive == i) {
          weapons[i].equip(true);
        }
        else{
          weapons[i].equip(false);
        }
      }
      g.setColor(Color.DARK_GRAY);
      g.fillRect(width - 220, height - 200, 100, 40);
      g.fillRect(width - 120, height - 200, 100, 40);
      g.fillRect(width - 220, height - 160, 100, 40);
      g.fillRect(width - 120, height - 160, 100, 40);

      g.setColor(Color.BLACK);
      g.drawRect(width - 220, height - 200, 100, 40);
      g.drawString("Attack", width - 220 + 36, height - 200 + 24);
      g.drawRect(width - 120, height - 200, 100, 40);
      g.drawString("Wait", width - 120 + 40, height - 200 + 24);
      g.drawRect(width - 220, height - 160, 100, 40);
      g.drawString("Heal", width - 220 + 40, height - 160 + 24);
      g.drawRect(width - 120, height - 160, 100, 40);
      g.drawString("Spare", width - 120 + 38, height - 160 + 24);

      switch (itemFieldAktiveAction) {
        case 1:
          g.setColor(Color.LIGHT_GRAY);
          g.fillRect(width - 220, height - 200, 100, 40);
          g.setColor(Color.BLACK);
          g.drawRect(width - 220, height - 200, 100, 40);
          g.drawString("Attack", width - 220 + 36, height - 200 + 24);

          break;
        case 2:
          g.setColor(Color.LIGHT_GRAY);
          g.fillRect(width - 120, height - 200, 100, 40);
          g.setColor(Color.BLACK);
          g.drawRect(width - 120, height - 200, 100, 40);
          g.drawString("Wait", width - 120 + 40, height - 200 + 24);
          break;
        case 3:
          g.setColor(Color.LIGHT_GRAY);
          g.fillRect(width - 220, height - 160, 100, 40);
          g.setColor(Color.BLACK);
          g.drawRect(width - 220, height - 160, 100, 40);
          g.drawString("Heal", width - 220 + 40, height - 160 + 24);
          break;
        case 4:
          g.setColor(Color.LIGHT_GRAY);
          g.fillRect(width - 120, height - 160, 100, 40);
          g.setColor(Color.BLACK);
          g.drawRect(width - 120, height - 160, 100, 40);
          g.drawString("Spare", width - 120 + 38, height - 160 + 24);
          break;

      }

      for (int i = 0; i < 10; i++) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(i * 100, height - 60, width / 10, 60);
        g.setColor(Color.BLACK);
        g.drawRect(i * 100, height - 60, width / 10, 60);
        for(int i2 = 0; i2 < mainHero.getWeaponWeight();i2++){
          g.setColor(Color.BLACK);
          g.fillRect(i2 * 100 +40, height - 40, 20, 20);
        }
        g.setColor(Color.PINK);
        switch (itemFieldAktive) {
          case 1:
            g.fillRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            g.setColor(Color.BLACK);
            g.drawRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            if(mainHero.getWeaponWeight() >= itemFieldAktive) {
              g.fillRect((itemFieldAktive - 1) * 100 + 40, height - 40, 20, 20);
            }

            break;
          case 2:
            g.fillRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            g.setColor(Color.BLACK);
            g.drawRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            if(mainHero.getWeaponWeight() >= itemFieldAktive) {
              g.fillRect((itemFieldAktive - 1) * 100 + 40, height - 40, 20, 20);
            }
            break;
          case 3:
            g.fillRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            g.setColor(Color.BLACK);
            g.drawRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            if(mainHero.getWeaponWeight() >= itemFieldAktive) {
              g.fillRect((itemFieldAktive - 1) * 100 + 40, height - 40, 20, 20);
            }
            break;
          case 4:
            g.fillRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            g.setColor(Color.BLACK);
            g.drawRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            if(mainHero.getWeaponWeight() >= itemFieldAktive) {
              g.fillRect((itemFieldAktive - 1) * 100 + 40, height - 40, 20, 20);
            }
            break;
          case 5:
            g.fillRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            g.setColor(Color.BLACK);
            g.drawRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            if(mainHero.getWeaponWeight() >= itemFieldAktive) {
              g.fillRect((itemFieldAktive - 1) * 100 + 40, height - 40, 20, 20);
            }
            break;
          case 6:
            g.fillRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            g.setColor(Color.BLACK);
            g.drawRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            if(mainHero.getWeaponWeight() >= itemFieldAktive) {
              g.fillRect((itemFieldAktive - 1) * 100 + 40, height - 40, 20, 20);
            }
            break;
          case 7:
            g.fillRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            g.setColor(Color.BLACK);
            g.drawRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            if(mainHero.getWeaponWeight() >= itemFieldAktive) {
              g.fillRect((itemFieldAktive - 1) * 100 + 40, height - 40, 20, 20);
            }
            break;
          case 8:
            g.fillRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            g.setColor(Color.BLACK);
            g.drawRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            if(mainHero.getWeaponWeight() >= itemFieldAktive) {
              g.fillRect((itemFieldAktive - 1) * 100 + 40, height - 40, 20, 20);
            }
            break;
          case 9:
            g.fillRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            g.setColor(Color.BLACK);
            g.drawRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            if(mainHero.getWeaponWeight() >= itemFieldAktive) {
              g.fillRect((itemFieldAktive - 1) * 100 + 40, height - 40, 20, 20);
            }
            break;
          case 10:
            g.fillRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            g.setColor(Color.BLACK);
            g.drawRect((itemFieldAktive - 1) * 100, height - 60, width / 10, 60);
            if(mainHero.getWeaponWeight() >= itemFieldAktive) {
              g.fillRect((itemFieldAktive - 1) * 100 + 40, height - 40, 20, 20);
            }
            break;
        }
      }

      akteure[1].setSettings(40, width / 2 - 30, height / 2 - height / 8);

      if (akteure[1] instanceof Monster) {
        switch (akteure[1].getRaceClass()) {

          case "golem":
            g.setColor(Color.BLACK);
            g.drawString(" golem ", width / 2 - 34, height / 2 - height / 8 - 8);
            g.setColor(Color.DARK_GRAY);
            g.fillRoundRect(akteure[1].xKoord, akteure[1].yKoord, akteure[1].size, akteure[1].size, 10, 10);

            for (int i = 0; i < 100; i++) {
              g.setColor(Color.WHITE);
              g.fillRect(i + akteure[1].xKoord - akteure[1].getHp() / 2 + akteure[1].size / 2, akteure[1].yKoord + akteure[1].size + 5, 1, 4);
            }
            for (int i = 0; i < akteure[1].getHp(); i++) {
              g.setColor(Color.RED);
              g.fillRect(i + akteure[1].xKoord - akteure[1].getHp() / 2 + akteure[1].size / 2, akteure[1].yKoord + akteure[1].size + 5, 1, 4);
            }
            break;
          case "werwolf":
            Color color1 = new Color(59, 32, 15);
            g.setColor(Color.BLACK);
            g.drawString(" werwolf ", width / 2 - 34, height / 2 - height / 8 - 8);
            g.setColor(color1);
            g.fillRoundRect(akteure[1].xKoord, akteure[1].yKoord, akteure[1].size, akteure[1].size, 10, 10);

            for (int i = 0; i < 100; i++) {
              g.setColor(Color.WHITE);
              g.fillRect(i + akteure[1].xKoord - akteure[1].getHp() / 2 + akteure[1].size / 2, akteure[1].yKoord + akteure[1].size + 5, 1, 4);
            }
            for (int i = 0; i < akteure[1].getHp(); i++) {
              g.setColor(Color.RED);
              g.fillRect(i + akteure[1].xKoord - akteure[1].getHp() / 2 + akteure[1].size / 2, akteure[1].yKoord + akteure[1].size + 5, 1, 4);
            }
            break;
          case "skeleton":
            g.setColor(Color.BLACK);
            g.drawString(" skeleton ", width / 2 - 34, height / 2 - height / 8 - 8);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRoundRect(akteure[1].xKoord, akteure[1].yKoord, akteure[1].size, akteure[1].size, 10, 10);

            for (int i = 0; i < 100; i++) {
              g.setColor(Color.WHITE);
              g.fillRect(i + akteure[1].xKoord - akteure[1].getHp() / 2 + akteure[1].size / 2, akteure[1].yKoord + akteure[1].size + 5, 1, 4);
            }
            for (int i = 0; i < akteure[1].getHp(); i++) {
              g.setColor(Color.RED);
              g.fillRect(i + akteure[1].xKoord - akteure[1].getHp() / 2 + akteure[1].size / 2, akteure[1].yKoord + akteure[1].size + 5, 1, 4);
            }
            break;
          case "oni":
            Color color2 = new Color(159, 32, 15);
            g.setColor(Color.BLACK);
            g.drawString(" oni ", width / 2 - 20, height / 2 - height / 8 - 8);
            g.setColor(color2);
            g.fillRoundRect(akteure[1].xKoord, akteure[1].yKoord, akteure[1].size, akteure[1].size, 10, 10);
            g.setColor(Color.BLACK);
            g.fillRect(akteure[1].xKoord + akteure[1].size / 2 - 15, akteure[1].yKoord - 10, 5, 15);
            g.fillRect(akteure[1].xKoord + akteure[1].size / 2 + 10, akteure[1].yKoord - 10, 5, 15);

            for (int i = 0; i < 100; i++) {
              g.setColor(Color.WHITE);
              g.fillRect(i + akteure[1].xKoord - akteure[1].getHp() / 2 + akteure[1].size / 2, akteure[1].yKoord + akteure[1].size + 5, 1, 4);
            }
            for (int i = 0; i < akteure[1].getHp(); i++) {
              g.setColor(Color.RED);
              g.fillRect(i + akteure[1].xKoord - akteure[1].getHp() / 2 + akteure[1].size / 2, akteure[1].yKoord + akteure[1].size + 5, 1, 4);
            }
            break;
        }
      } else {
        g.setColor(Color.BLACK);
        g.drawString(" Hero ", width / 2 - 34, height / 2 - height / 8 - 8);
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(akteure[1].xKoord, akteure[1].yKoord, akteure[1].size, akteure[1].size, 10, 10);

        for (int i = 0; i < 100; i++) {
          g.setColor(Color.WHITE);
          g.fillRect(i + akteure[1].xKoord - akteure[1].getHp() / 2 + akteure[1].size / 2, akteure[1].yKoord + akteure[1].size + 5, 1, 4);
        }
        for (int i = 0; i < akteure[1].getHp(); i++) {
          g.setColor(Color.RED);
          g.fillRect(i + akteure[1].xKoord - akteure[1].getHp() / 2 + akteure[1].size / 2, akteure[1].yKoord + akteure[1].size + 5, 1, 4);
        }
      }
    }
  }

  public void keyPressed(KeyEvent e) {

    if ((e.getKeyCode() == KeyEvent.VK_UP)) {

    }

    if ((e.getKeyCode() == KeyEvent.VK_DOWN)) {

    }

    if ((e.getKeyChar() == '1')) {
      itemFieldAktive = 1;
    }

    if ((e.getKeyChar() == '2')) {
      itemFieldAktive = 2;
    }

    if ((e.getKeyChar() == '3')) {
      itemFieldAktive = 3;
    }

    if ((e.getKeyChar() == '4')) {
      itemFieldAktive = 4;
    }

    if ((e.getKeyChar() == '5')) {
      itemFieldAktive = 5;
    }

    if ((e.getKeyChar() == '6')) {
      itemFieldAktive = 6;
    }

    if ((e.getKeyChar() == '7')) {
      itemFieldAktive = 7;
    }

    if ((e.getKeyChar() == '8')) {
      itemFieldAktive = 8;
    }

    if ((e.getKeyChar() == '9')) {
      itemFieldAktive = 9;
    }

    if ((e.getKeyChar() == '0')) {
      itemFieldAktive = 10;
    }

    if ((e.getKeyCode() == KeyEvent.VK_LEFT)) {
      if(itemFieldAktiveAction == 1){
        itemFieldAktiveAction = 4;
      }
      else{
        itemFieldAktiveAction -= 1;
      }
    }

    if ((e.getKeyCode() == KeyEvent.VK_RIGHT)) {
      if(itemFieldAktiveAction == 4){
        itemFieldAktiveAction = 1;
      }
      else{
        itemFieldAktiveAction += 1;
      }
    }

    if ((e.getKeyCode() == KeyEvent.VK_DELETE)) { // not working
      for(int i= 0;i < weapons.length-1;i++){
        if(weapons[i].equiped()){
          weapons[i] = new Weapon();
          for(int i2= i;i2 < weapons.length-2;i2++){
            weapons[i2] = weapons[i2+1];
          }
          weapons[8] = weapons[9];
          weapons[9] = new Weapon();
        }
      }
    }

    if ((e.getKeyCode() == KeyEvent.VK_ENTER)) {
      if (!printActionDead) {
        mainHero.setHp(100);
        akteure[1].setHp(100);
        printActionDead = true;
      }
      if (printActionDead) {
        switch (itemFieldAktiveAction) {
          case 1:
            fight();
            break;
          case 2:
            //tacticalWait();
            break;
          case 3:
            //healing();
            break;
          case 4:
            // spare();
            break;
        }
      }
    }

  }

  public void keyReleased(KeyEvent e) {

    if ((e.getKeyCode() == KeyEvent.VK_UP)) {

    }
    if ((e.getKeyCode() == KeyEvent.VK_DOWN)) {

    }

    if ((e.getKeyChar() == 'w')) {

    }

    if ((e.getKeyChar() == 's')) {

    }

    if ((e.getKeyCode() == KeyEvent.VK_LEFT)) {

    }

    if ((e.getKeyCode() == KeyEvent.VK_RIGHT)) {

    }
  }

  public void keyTyped(KeyEvent e) {

    if (e.getKeyChar() == 27) {
      System.exit(0);
    }

  }

  public static void main(String[] args){
    new InitGame();
  }

}

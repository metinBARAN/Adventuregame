import java.util.Scanner;

public class Player {
   private int damage;
   private  int health;
   private int originalHealty;
   private int money;
   private  String name;
   private  String charName;
    private Scanner input= new Scanner(System.in);
    private Inventory inventory;

   public Player(String name){
       this.name=name;
       this.inventory=new Inventory();
   }

   public void selectChar(){
       Samurai samurai=new Samurai();
       Archer archer=new Archer();
       Knight knight=new Knight();

       GameCharacter[] charList= {new Samurai(),new Archer(),new Knight()};
       System.out.println("-------------------------------------------------------");
       System.out.println("Karakterler: ");
       System.out.println("-------------------------------------------------------");
       for (GameCharacter gameCharacter:charList){
           System.out.println("id: "+gameCharacter.getId()+
                   "\tKarakter: "+ gameCharacter.getName()+
                   "\t Hasar: "+gameCharacter.getDamage()+
                   "\t Saglik: " +gameCharacter.getHealth()+
                   "\t Para: "+gameCharacter.getMoney());

       }
       System.out.println("--------------------------------------------------------");
       System.out.println("Please select a character: ");
       int selectChar=input.nextInt();
      switch (selectChar){
          case 1:
          initPlayer(new Samurai());
          break;
          case 2:
              initPlayer(new Archer());
              break;
          case 3:
              initPlayer(new Knight());
          default:
              System.out.println("Karakter secimini yapmadiginiz için otomatik secilmistir");
              initPlayer(new Samurai());
      }
       System.out.println("Character: "+this.getCharName()+
               "\tDamage: "+this.getDamage()+
               "\tHealty: "+this.getHealth()+
               "\tMoney: "+this.getMoney());
   }

   public void initPlayer(GameCharacter gameCharacter){
       this.setDamage(gameCharacter.getDamage());
       this.setHealth(gameCharacter.getHealth());
       this.setOriginalHealty(gameCharacter.getHealth());
       this.setMoney(gameCharacter.getMoney());
       this.setCharName(gameCharacter.getName());
   }

    // player'in durumu ekrana yazdırıyoruz
   public void printInfo(){
       System.out.println("Your weapon: "+this.getInventory().getWeaponry().getName()+
                          "\tYour armor: "+this.getInventory().getArmor().getName()+
                          "\tBlock: "+this.getInventory().getArmor().getBlock()+
                          "\tDamage: "+this.getTotalDamage()+
                          "\tHealty: "+this.getHealth()+
                          "\tMoney: "+this.getMoney());


   }
   public int getTotalDamage(){
       return damage+this.getInventory().getWeaponry().getDamage();
   }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealty() {
        return originalHealty;
    }

    public void setOriginalHealty(int originalHealty) {
        this.originalHealty = originalHealty;
    }

    //Savaş kısmında player kısmında player daha kolay çağırmak için metodu yazdık
    public Weaponry getWeaponryn(){
       return this.getInventory().getWeaponry();
    }
}

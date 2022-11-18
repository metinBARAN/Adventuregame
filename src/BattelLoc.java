import java.util.Random;

public class BattelLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxOsbtacle;

    public BattelLoc(Player player, String name,Obstacle obstacle, String award,int maxOsbtacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxOsbtacle=maxOsbtacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("You are here now "+this.getName());
        System.out.println("Be careful, "+this.randomObstacleNumber()+" "+this.getObstacle().getName()+" live here");
        System.out.println("<W>arfare or <E>scape: ");
        String selectBatCase=input.nextLine();
        selectBatCase=selectBatCase.toUpperCase();
        if (selectBatCase.equals("W")&&combat(obsNumber)){
            System.out.println(this.getName()+" You defeated all the enemies!");
            return true;


        }
        if (this.getPlayer().getHealth()<=0){
            System.out.println("You Died!");
            return false;
        }

        return true;
    }
    //Warfare

    public  boolean combat(int obsNumber){
        for (int i=1;i<=obsNumber;i++){ // for kaç canavarla çatışacaksam onu bize döndürecektir
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealty()); // canavar öldüğünde orjinal canını yenileme
         playerStart();
         obsStarts(i);
         // birbirine kim kaç gere vuracağını belirle
            while (this.getPlayer().getHealth()>0&&this.getObstacle().getHealth()>0){
                System.out.println("<S>trike or <E>scape: ");
                String selectCombat=input.nextLine().toUpperCase();
                if (selectCombat.equals("S")){
                    System.out.println("You Striked");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth()>0){
                        System.out.println("The Obstacle Striked You! ");
                        int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage<0){
                            obstacleDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                             afterHit();
                    }
                }else {
                    return false;
                }


            }
            if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("You defeated the enemy!");
                System.out.println(this.getObstacle().getAward()+" You made money");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println(this.getPlayer().getMoney()+" Your current money");
            }else {
                return false;
            }
        }
        return true;
    }
    // Vurma işleminden sonraki durumu gösterme
    public void afterHit(){
        System.out.println("Your Healty: "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" Healty "+this.getObstacle().getHealth());
        System.out.println();

    }
    public void playerStart(){
        System.out.println("--------------------------------------------");
        System.out.println("--Player Values--");
        System.out.println("--------------------------------------------");
        System.out.println("Healty: "+this.getPlayer().getHealth());
        System.out.println("Weapon: "+this.getPlayer().getInventory().getWeaponry().getName());
        System.out.println("Damage: "+this.getPlayer().getTotalDamage());
        System.out.println("Armor: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Many: "+this.getPlayer().getMoney());


    }
    public void obsStarts(int i){
        System.out.println("--------------------------------------------");
        System.out.println(i+". "+this.getObstacle().getName()+" Values");
        System.out.println("Healty: "+this.getObstacle().getHealth());
        System.out.println("Damage: "+this.getObstacle().getDamage());
        System.out.println("Award: "+this.getObstacle().getAward());


    }
    public int randomObstacleNumber(){
        Random r=new Random();
        //0-2 -> 0+1-1+1
        return r.nextInt(2)+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxOsbtacle() {
        return maxOsbtacle;
    }

    public void setMaxOsbtacle(int maxOsbtacle) {
        this.maxOsbtacle = maxOsbtacle;
    }
}

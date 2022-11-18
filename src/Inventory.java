public class Inventory {
   private  Weaponry weaponry;
   private Armor armor;

    public Inventory() {
        this.weaponry=new Weaponry("Punch",-1,0,0);
        this.armor=new Armor(-1,"None",0,0);

    }

    public Weaponry getWeaponry() {
        return weaponry;
    }

    public void setWeaponry(Weaponry weaponry) {
        this.weaponry = weaponry;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}

public class Weaponry {
    private String name;
    private int id;
    private int damage;
    private int price;

    public Weaponry(String name,int id, int damage, int price) {
        this.name=name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }
    public static Weaponry[] weaponries(){
        Weaponry[] weaponList=new Weaponry[3];
        weaponList[0]=new Weaponry("Revolver",1,2,15);
        weaponList[1]=new Weaponry("Sword   ",2,3,35);
        weaponList[2]=new Weaponry("Rifle   ",3,7,45);

        return weaponList;
    }
    // Seçileni bulup  Id'ye göre Weapon döndürme
    public static Weaponry getWeaponryObjByID(int id){

        for (Weaponry w:Weaponry.weaponries()){
            if (w.getId()==id){
                return w;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

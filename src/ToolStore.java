public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu=true;
       while (showMenu){
           System.out.println("Welcome to the tool store");
           System.out.println("1-Weaponry");
           System.out.println("2-Armons");
           System.out.println("3-Exit");
           System.out.print("Make your choice: ");
           int selectCase = input.nextInt();
           while (selectCase < 1 || selectCase > 3) {
               System.out.println("Invalid value, re-enter");
               selectCase = input.nextInt();
           }
           switch (selectCase) {
               case 1:
                   printWeapon();
                   buyWeapon();
                   break;

               case 2:
                   printArmon();
                   buyArmor();
                   break;
               case 3:
                   System.out.println("We hope you come again");
                    showMenu= false;
                   break;

           }


       }
        return true;
    }

    //Weapon listelenme
    public void printWeapon() {
        System.out.println("------------------------------------------------------");
        System.out.println("---Weaponry---");
        for (Weaponry w : Weaponry.weaponries()) {
            System.out.println(w.getId() + "\t" + w.getName() +
                    " -> Maney:\t" + w.getPrice() + " Damage:\t" + w.getDamage());
        }
        System.out.println("0 Log out");

    }

    public void buyWeapon() {
        System.out.println("Choose a weapon");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weaponry.weaponries().length) {
            System.out.print("Invalid value, re-enter");
            selectWeaponID = input.nextInt();
        }
        //Bir üst menüye dönmemizi sağlamak 0 çıkış işlemi yapıldı
       if (selectWeaponID!=0){
           Weaponry selectedWeapon = Weaponry.getWeaponryObjByID(selectWeaponID);
           if (selectedWeapon != null) {
               if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                   System.out.println("You don't have enough money");
               } else {
                   System.out.println(selectedWeapon.getName() + ": You bought your weapon");
                   int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                   this.getPlayer().setMoney(balance);
                   System.out.println("your remaining money: " + this.getPlayer().getMoney());

                   //System.out.println("Your previous weapon: "+this.getPlayer().getInventory().getWeaponry().getName());
                   this.getPlayer().getInventory().setWeaponry(selectedWeapon);
                   // System.out.println("your new weapon: "+this.getPlayer().getInventory().getWeaponry().getName());
               }
           }
       }
    }

    public void printArmon() {
        System.out.println("------------------------------------------------------");
        System.out.println("---Armor---");
        for (Armor a : Armor.armor()) {
            System.out.println(a.getId() + "\t" + a.getName() + " -> Money: " + a.getPrice() + " Block: " + a.getBlock());
        }

    }

    public void buyArmor() {
        System.out.println("Choose a armor");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armor().length) {
            System.out.print("Invalid value, re-enter");
            selectArmorID = input.nextInt();
        }
        //Bir üst menüye dönmemizi sağlamak 0 çıkış işlemi yapıldı
       if (selectArmorID!=0){
           Armor selectArmor = Armor.getArmorObjByID(selectArmorID);

           //Yanlış bir değer girilmediyse
           if (selectArmor.getPrice() > this.getPlayer().getMoney()) {
               System.out.println("You don't have enough money");

           } else {
               System.out.println(selectArmor.getName() + ": You bought your armor");
               int balance = this.getPlayer().getMoney() - selectArmor.getPrice();
               this.getPlayer().setMoney(balance);
               System.out.println("Your remainin money: " + this.getPlayer().getMoney());

               // setArmor ile selectedArmor değiştirme işlemi
               this.getPlayer().getInventory().setArmor(selectArmor);
           }

       }
       }
}

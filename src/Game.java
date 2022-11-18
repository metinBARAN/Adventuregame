import java.util.Scanner;

public class Game {

    private Scanner input= new Scanner(System.in);


    public void start(){
        System.out.println("Welcome to Adventure Game");
        System.out.println("Please Enter Your Name: ");
       // String playName=input.nextLine();
        Player player=new Player("metin");
        System.out.println(" Welcome to "+ player.getName());
        System.out.println("Please select a character");
         player.selectChar();
         while (true){
             player.printInfo();
             System.out.println("-------------------------------------------------");
             Location location=null;
             System.out.println("Regions");
             System.out.println("1-Safe House");
             System.out.println("2-Tool Store");
             System.out.println("3-Cave");
             System.out.println("4-Forest");
             System.out.println("5-River");
             System.out.println("0-Exit Game ended");
             System.out.println("Please select the region you want to the go");
             System.out.println("--------------------------------------------------");
             int selectLoc=input.nextInt();
             switch (selectLoc){
                 case 0:
                     location=null;
                     break;
                 case 1:
                     location=new SafeHouse(player);
                     break;
                 case 2:
                     location=new ToolStore(player);
                     break;
                 case 3:
                     location=new Cave(player);
                     break;
                 case 4:
                     location=new Forest(player);
                     break;
                 case 5:
                     location=new River(player);
                     break;
                 default:
                     location=new SafeHouse(player);
             }
             if (location==null){
                 System.out.println("Game Over We Wait Again");
                 break;
             }
             if (!location.onLocation()) {
                 System.out.println("Game Over!");
                 break;
             }

         }

    }
}

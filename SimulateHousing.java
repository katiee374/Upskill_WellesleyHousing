import java.util.*;

public class SimulateHousing {

    public SimulateHousing() {

    }

    private void HungerGames(){
        Scanner bob = new Scanner(System.in);
        String n1 = "Which dorm would you like to live in?" + 
        "\nPick one: Caz, Beebe, Munger, Pom, Shafer, Stone D, " +
        "McAfee, Bates, Sev, Claf, Tower Court, Lake House, or Freeman.";
        String n2 = "What type of dorm room would you like to live?" + 
        "\nPick one: single, double, triple.";
        String n3 = "Here's your options!";
        String n4 = "Uh oh spaghetti oh, that's an invalid input";
        System.out.println(n1);
        String response = bob.nextLine();
        if(response.equalsIgnoreCase("Caz")){
            
        }else if(response.equalsIgnoreCase("Beebe")){

        }else if(response.equalsIgnoreCase("Munger")){

        }else if(response.equalsIgnoreCase("Pom")){

        }else if(response.equalsIgnoreCase("Shafer")){
        
        }else if(response.equalsIgnoreCase("Stone D")){

        }else if(response.equalsIgnoreCase("McAfee")){

        }else if(response.equalsIgnoreCase("Bates")){

        }else if(response.equalsIgnoreCase("Sev")){

        }else if(response.equalsIgnoreCase("Claf")){

        }else if(response.equalsIgnoreCase("Tower Court")){

        }else if(response.equalsIgnoreCase("Lake House")){

        }else if(response.equalsIgnoreCase("Freeman")){

        }else{
            System.out.println(n4);
            //this needs to figure out how to redo....?
        }


    }

    private String chooseRoomType(String building) {
        Scanner scan = new Scanner(System.in);

        String n2 = "What type of dorm room would you like to live?" + 
        "\n" + buildingCollections.get(i).toString();
        scan.nextLine();
    }

    //I know that at the end what we should do is
    //System.out.println(RoomCollection (whichever one it it).toString()); 
    //This will print out that person's options. 
    public static void main(String[] args) {

    }
}

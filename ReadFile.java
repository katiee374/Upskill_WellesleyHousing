import java.util.Scanner;
import java.io.*;
public class ReadFile{
    private Wellesley wellesley;

    public ReadFile(String fn) throws IOException{
        wellesley = new Wellesley();
        Scanner bob = new Scanner(new File(fn));
        Room tempRoom;
        Building tempBuilding = new Building("Bates");
        while(bob.hasNext()){
            String ln = bob.nextLine();
            //Line should be Munger,MUN 034,Single
            String[] tokens = ln.split(",");
            //IF tokens[2].contains("single") then just import single
            //IF tokens[2].contains("double") then just import double
            //IF tokens[2].contains("triple") then just import triple
            tempRoom = new Room(tokens[0], tokens[2], tokens[1]);
            if(tempRoom.getLocation().equals(tempBuilding.getName())){
                tempBuilding.addRoom(tempRoom);
            } else {
                wellesley.add(tempBuilding);
                tempBuilding = new Building(tempRoom.getLocation());
                tempBuilding.addRoom(tempRoom);
            }
        }
    }

    public static void main(String[] args){
        
    }

    // private Building createBuidling(String line) {
    //     String[] tokens = line.split(",");
    // }

    // private Room createRoom(String line){`
    //     //decide which location it belongs to
    //     Room finir = new Room(building, type, roomNum);
    //     return finir;
    // }
}

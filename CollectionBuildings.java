import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

import javax.management.relation.Role;

public class CollectionBuildings{
    private Dictionary<String, ArrayList<RoomCollection>> buildingCollection; 
    public CollectionBuildings(){
        buildingCollection = new Hashtable<>();
        readFile("SmallDataSet.txt");
    }

public void readFile(String fn) throws IOException{
    try{
        Scanner scan = new Scanner(new File(fn));
        Room tempRoom;
        while(scan.hasNext()){
            String ln = scan.nextLine();
            //Line should be Munger,MUN 034,Single
            String[] tokens = ln.split(",");
            tempRoom = new Room(tokens[0], tokens[2], tokens[1]);
            //
            if(buildingCollection.get((tokens[0]) == null){
                buildingCollection.put(tokens[0], new ArrayList<RoomCollection>);
            } else {
                g
                
            }
        }
        } catch(IOException ex) {
            System.out.println(ex);
        }
    }  
    }


public String returnRooms(String name){
    buildingCollection.get(name)
}
    public static void main(String[] args){
        System.out.println();
    }

}
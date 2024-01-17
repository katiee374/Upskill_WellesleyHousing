import java.util.Scanner;
import java.io.*;

public class ReadFile{
    String fileName;
    Room temp;

    public ReadFile(String fn) throws IOException{
        fileName = fn;
        Scanner bob = new Scanner(new File(fileName));
        while(bob.hasNext()){
            String ln = bob.nextLine();
            temp = createRoom(ln);
        } 
        //what should we do with the temporary Room???
    }

    public Room createRoom(String line){
        //Line should be Munger,MUN 034,Single
        String[] tokens = line.split(",");
        String building = tokens[0];
        String roomNum = tokens[1];
        String type = tokens[2];
        //decide which location it belongs to
        Room finir = new Room(building, type, roomNum);
        return finir;
    }
}

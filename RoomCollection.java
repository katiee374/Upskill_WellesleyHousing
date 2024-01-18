import java.util.*;

public class RoomCollection {
    private String roomType;
    private ArrayList<Room> rooms;

    public RoomCollection(String r) {
        rooms = new ArrayList<Room>();
        roomType = r;
    }

    public String getType() {
        return roomType;
    }

    public void addRoom(Room r) {
        rooms.add(r);
    }

    public Room getRoom(int i) {
        return rooms.get(i);
    }
    public ArrayList<Room> getList(){
        return rooms;
    }

    public boolean samesies(String n) {
        return (roomType.equals(n));
    }

    public String toString(){
        String printer = "Here are your options! \n";
        for(int i = 0; i < rooms.size(); i++){
            printer += rooms.get(i) + "\n";
        }
        return printer;
    }
}

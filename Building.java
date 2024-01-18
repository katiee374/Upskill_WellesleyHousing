import java.util.*;
public class Building {
    private ArrayList<Room> rooms;
    private String name;

    public Building(String name) {
        this.name = name;
        rooms = new ArrayList<Room>();
    }
    
    public void addRoom(Room r) {
        rooms.add(r);
    }

    public String getName(){
        return name;
    }
}
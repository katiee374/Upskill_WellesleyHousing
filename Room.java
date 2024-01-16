
public class Room{
    String location;
    String type;
    String roomNumber;
    // int floor;

    public Room(String l, String t, String r){
        location = l;
        type = t;
        roomNumber = r;
    }

    public String getRoomNumber(){
        return roomNumber;
    }

    public String getType(){
        return type;
    }

    public String getLocation(){
        return location;
    }

    public void setRoomNumber(String rm){
        roomNumber = rm;
    }

    public void setType(String t){
        type = t;
    }

    public void setLocation(String l){
        location = l;
    }

}
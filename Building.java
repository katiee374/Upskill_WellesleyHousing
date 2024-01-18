public class Building {
    private ArrayList<Room> rooms;
    private String title;
    private int roomCount;

    public Building(Room[] roomLayout, String name) {
        title = name;
        rooms = roomLayout;
        roomCount = rooms.length;
    }
    
    public void addRoom(Room r) {
        if (roomCount>=rooms.length) {
            Room[] temp = new Room[rooms.length*2];
            for (int i=0; i<rooms.length; i++) {
                temp[i] = rooms[i];
            }
            rooms = temp;
        }
        rooms[roomCount] = r;
        roomCount++;
    }
}

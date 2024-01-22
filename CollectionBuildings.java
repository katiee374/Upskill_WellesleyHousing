import java.io.File;
import java.io.IOException;
import java.util.*;

public class CollectionBuildings {
    Hashtable<String, ArrayList<RoomCollection>> buildingCollection;

    public CollectionBuildings() throws IOException {
        buildingCollection = new Hashtable<String, ArrayList<RoomCollection>>();
        buildingCollection.put("Bates", new ArrayList<RoomCollection>());
        buildingCollection.put("Stone Davis", new ArrayList<RoomCollection>());
        buildingCollection.put("Freeman", new ArrayList<RoomCollection>());
        buildingCollection.put("McAfee", new ArrayList<RoomCollection>());
        buildingCollection.put("Beebe", new ArrayList<RoomCollection>());
        buildingCollection.put("Cazenove", new ArrayList<RoomCollection>());
        buildingCollection.put("Munger", new ArrayList<RoomCollection>());
        buildingCollection.put("Pomeroy", new ArrayList<RoomCollection>());
        buildingCollection.put("Shafer", new ArrayList<RoomCollection>());
        buildingCollection.put("Claflin", new ArrayList<RoomCollection>());
        buildingCollection.put("Lake House", new ArrayList<RoomCollection>());
        buildingCollection.put("Severance Hall", new ArrayList<RoomCollection>());
        buildingCollection.put("Tower Court", new ArrayList<RoomCollection>());
        readFile("BigDataSet.txt");
    }

    public void readFile(String fn) throws IOException {
        Scanner scan = new Scanner(new File(fn));
        Room tempRoom;
        while (scan.hasNext()) {
            String ln = scan.nextLine();
           if (ln.contains("Dower") || ln.contains("Orchid") || ln.contains("Hemlock")) {
            } else {
                String[] tokens = ln.split(",");
                // Making the actual room
                tempRoom = new Room(tokens[0], tokens[2], tokens[1]);
                // Getting the collection of roomTypes ie: single, f-y double.accordin
                // gets the roomType of that Location (building) from the collection of
                // buildings
                ArrayList<RoomCollection> tempTypes = buildingCollection.get(tokens[0]);// temperary roomtypes building
                                                                                        // currently has
                int length = tempTypes.size();
                boolean found = false;
                for (int i = 0; i < length; i++) { // loops and checks if roomtype exists
                    if (tempTypes.get(i).samesies(tokens[2])) {
                        tempTypes.get(i).addRoom(tempRoom);
                        found = true;
                    }
                }
                // if this is a NEW type of room, create a new RoomCollection w/ tokens[2] name,
                // and add the temp room to it
                if (!found) {
                    RoomCollection tempRoomCollection = new RoomCollection(tokens[2]);
                    tempRoomCollection.addRoom(tempRoom);
                    tempTypes.add(tempRoomCollection);
                }
            }
        }
    }

    public String returnBuilding(String building, String roomType) {
        String temp = "";
        ArrayList<RoomCollection> tempTypes = buildingCollection.get(building);// temperary roomtypes building currently
                                                                               // ha
        int num = tempTypes.indexOf(roomType);
        temp += tempTypes.get(num).getType();
        temp += "\n";
        ArrayList<Room> tempRooms = tempTypes.get(num).getList();
        for (int j = 0; j < tempRooms.size(); j++) {
            temp += tempRooms.get(j).toString();
            temp += "\n";
        }
        temp += "\n";
        return temp;
    }

    public String returnRoomTypes(String building) {
        String temp = "";
        ArrayList<RoomCollection> tempTypes = buildingCollection.get(building);// temperary roomtypes building currently
                                                                               // has
        int num = tempTypes.size();
        System.out.println("Types of rooms avalible- " + num);
        for (int i = 0; i < num; i++) {
            temp += tempTypes.get(i).getType();
            temp += "\n";
        }
        return temp;
    }

    public String returnRooms(String building, String roomType) {
        String retourner = "Here are your room options." + "\n";
        ArrayList<RoomCollection> temp = buildingCollection.get(building);
        for (int i = 0; i < temp.size(); i++) {
            if (((ArrayList<Room>) (temp.get(i).getList())).get(0).getLocation().equals(building)
                    && ((ArrayList<Room>) (temp.get(i).getList())).get(0).getType().equals(roomType)) {
                // We've found our collection of rooms
                ArrayList<Room> isabelle = temp.get(i).getList();
                for (int j = 0; j < isabelle.size(); j++) {
                    retourner += isabelle.get(j) + "\n";
                }
            }
        }
        return retourner;
    }

    public String returnTypes() {
        // returns the list of the roomTypes for that building.
        String retourner = "These are your options: ";
        Collection<ArrayList<RoomCollection>> values = buildingCollection.values();
        Iterator<ArrayList<RoomCollection>> iter = values.iterator();
        while (iter.hasNext()) {
            ArrayList<RoomCollection> i = iter.next();
            for (int j = 0; j < i.size(); j++) {
                retourner += i.get(j).getType() + ", ";
            }
        }
        return retourner;
    }

    public static void main(String[] args) throws IOException {
        CollectionBuildings test = new CollectionBuildings();
        // System.out.println(test.returnBuilding("Tower Court"));
        // System.out.println(test.toString());
        // System.out.println(test.returnRoomTypes("Bates"));
        System.out.println(test.returnRooms("Stone Davis", "First-Year Double "));
    }

}
import java.io.IOException;
import java.util.*;

public class SimulateHousing {

    private String buildingName;
    private String roomType;
    private final String[] dorms = { "Bates", "Stone Davis", "Freeman", "McAfee", "Beebe", "Cazenove", "Munger",
            "Bates",
            "Pomeroy", "Shafer", "Claflin", "Tower Court", "Lake House", "Severance Hall" };

    private CollectionBuildings wellesley;

    public SimulateHousing() throws IOException {
        wellesley = new CollectionBuildings();
        Scanner scan = new Scanner(System.in);
        String response = ""; // response user input
        String roomTypesList = ""; // list of avalible types of rooms in string form
        String result = ""; // final list of rooms
        ArrayList<String> roomTypes = new ArrayList<String>(); // list of avalible types of rooms in arrayList form
        do {
            System.out.println("Which dorm would you like to live in?" +
                    "\nPick one: Bates, Stone Davis, Freeman, McAfee, Beebe, Cazenove, Munger,\n Bates, Pomeroy, Shafer, Claflin, Tower Court, Lake House, Severance Hall\n");
            response = scan.nextLine();
            response = returnRoomTypes(response);
            System.out.println(response);
        } while (response.equals("Building not found! Try again"));
        
        roomTypesList = response;

        //adds rooms to an arrayList
        Scanner scanRoomsTypes = new Scanner(roomTypesList);
        scanRoomsTypes.nextLine();
        while (scanRoomsTypes.hasNextLine()) {
            roomTypes.add(scanRoomsTypes.nextLine());
        }
            scanRoomsTypes.close();
        /*for(int i = 0; i < roomTypes.size(); i++){
            System.out.println(roomTypes.get(i) + "*");
        }
     */

    
 // checks room types exists
        do {
            System.out.println("What type of room would you like to live in?");
            response = scan.nextLine() + " ";
            response = -returnAvalibleRooms(response, roomTypes);
            //System.out.println(response);
        } while (response.equals("Room Type not Found. Try Again!!"));

        result = wellesley.returnRooms(buildingName, roomType);
        System.out.println(result);

        scan.close();

    }

    public String returnRoomTypes(String input) {
        for (int i = 0; i < dorms.length; i++) {
            if (input.equalsIgnoreCase(dorms[i])) {
                buildingName = dorms[i];
                return wellesley.returnRoomTypes(dorms[i]);
            }
        }
        return "Building not found! Try again";
    }

    public String returnAvalibleRooms(String response, ArrayList<String> roomTypes){
        for (int i = 0; i < roomTypes.size(); i++) {
                if (response.equalsIgnoreCase(roomTypes.get(i))) {
                    roomType = roomTypes.get(i);
                    return roomTypes.get(i); 
                }
            }
            return("Room Type not Found. Try Again!!");
    }
    
    

    /*
     * private String chooseRoomType(String building) {
     * Scanner scan = new Scanner(System.in);
     * String n2 = "What type of dorm room would you like to live?" +
     * "\n" + buildingCollections.get(i).toString();
     * scan.nextLine();
     * }
     */
    // I know that at the end what we should do is
    // System.out.println(RoomCollection (whichever one it it).toString());
    // This will print out that person's options.
    public static void main(String[] args) throws IOException {
        SimulateHousing test = new SimulateHousing();
    }
}

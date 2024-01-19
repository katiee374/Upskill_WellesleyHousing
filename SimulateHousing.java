import java.io.IOException;
import java.util.*;

public class SimulateHousing {

    private String buildingName;
    private final String[] dorms = { "Bates", "Stone Davis", "Freeman", "McAfee", "Beebe", "Cazenove", "Munger",
            "Bates",
            "Pomeroy", "Shafer", "Claflin", "Tower Court", "Lake House", "Severance Hall" };
    private CollectionBuildings wellesley;

    public SimulateHousing() throws IOException {
        wellesley = new CollectionBuildings();
        Scanner scan = new Scanner(System.in);
        String response = "";
        String roomTypesList = "";
        String result = "";
        ArrayList<String> roomTypes = new ArrayList<String>();
        String roomType = "";
        do {
            System.out.println("Which dorm would you like to live in?" +
                    "\nPick one: Bates, Stone Davis, Freeman, McAfee, Beebe, Cazenove, Munger, Bates, Pomeroy, Shafer, Claflin, Tower Court, Lake House, Severance Hall\n");
            // formerly was buildingType = scan.nextLine();
            // buildingType was never declared so we changed it
            buildingName = scan.nextLine();
            response = returnRoomTypes(response);
        } while (response.equals("Building not found! Try again"));
        roomTypesList = response;
        Scanner scanRoomsTypes = new Scanner(roomTypesList);
        scanRoomsTypes.nextLine();
        while (scanRoomsTypes.hasNextLine()) {
            roomTypes.add(scanRoomsTypes.nextLine());
        }
        scanRoomsTypes.close();
        // checks room types exists
        // boolean found = false;
        // do {
        System.out.println("What type of room would you like to live in?");
        System.out.println(roomTypesList);
        roomType = scan.nextLine() + " ";

        /*
         * for (int i = 0; i < roomTypes.size(); i++) {
         * if (response.equalsIgnoreCase(roomTypes.get(i))) {
         * found = true;
         * roomType = roomTypes.get(i);
         * } else {
         * System.out.println("Building Type not Found. Try Again!!");
         * }
         * }
         * } while (!found);
         * 
         */
        result = wellesley.returnRooms(buildingName, roomType);
        System.out.println(result);

        scan.close();

    }

    public String returnRoomTypes(String input) {

        for (int i = 0; i < dorms.length; i++) {
            if (input.equalsIgnoreCase(input)) {
                buildingName = dorms[i];
                return wellesley.returnRoomTypes(dorms[i]);
            }
        }
        return "Building not found! Try again";
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

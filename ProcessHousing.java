/** ProcessHousing takes the housing.txt and reads from file, formating the text and creating a new text file that is formated correctly for 
 * 
 * @LilymoonW
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProcessHousing {
    private String allText;
    private final String HOUSEFILE = "housing.txt";
    private final String[] housingCodes = { "BAT", "DAV", "FRE", "MCA", "STO", "BEB", "CAZ", "MUN",
            "POM", "SHA", "CLA", "LAK", "SEV", "TCE", "TCW", "DOW", "HEM", "ORC" };
    private final String[] approvedEndings = {"Single", "Double", "room", "Triple", "Staff", "Apartment"};
    public ProcessHousing() {
        allText = "";
        // writes all the text from housing txt to one string
        try {
            Scanner myReader = new Scanner(new File(HOUSEFILE));
            while (myReader.hasNext()) {
                boolean changed = false;
                String temp = myReader.next();
                for(int i = 0; i < housingCodes.length; i++){
                    if(temp.contains(housingCodes[i])&& temp.indexOf(housingCodes[i])!=0){
                        int num = temp.indexOf(housingCodes[i]);
                        allText += temp.substring(0, num) + " " + temp.substring(num, temp.length()) + " ";
                        changed = true;
                    }
                }            
                if(!changed){
                    allText += (temp + " ");
                }
                changed = false;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        allText = removeLines("Pre-Halled Student Leader Room");
        allText = removeLines("Pre-Halled Language Learning Community");
        allText = removeLines("House President Room");
        allText = removeLines("Pre-Halled Language House");
        allText = removeLines("Pre-Halled Student Leader");
        processString("BigDataSet.txt");


    }

    public String returnAllText() {
        return allText;
    }
    public String removeLines(String line){
        String newText = allText;
        while(newText.indexOf(line)>0){
            int num = newText.indexOf(line);
            int length = line.length();
            newText = newText.substring(0, num) + newText.substring(num+length, newText.length());
        }
        return newText;
    }
    public String processRoom(String code) {
      return ""; 
    }

    /**
     * Saves the current information into a text file
     * 
     * @param String fileName the name of the tgf file
     */
    public void processString(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(new File(fileName));
            Scanner scan = new Scanner(allText);
            Queue<String> codes = new LinkedList<>();
            boolean sequence = false;
            boolean wasCode = false;
            while(scan.hasNext()){
                String token = scan.next();
                for(int i = 0; i < housingCodes.length; i++){
                    if (token.equals(housingCodes[i])){
                        token = associatedDorm(token);
                        token += scan.next();
                        codes.add(token);
                        wasCode = true;
                        sequence = false;
                    }
                }
                if(!wasCode){
                    if (!codes.isEmpty() && sequence == false) {
                        writer.print(codes.remove() + ",");
                    }
                     writer.print(token + " ");
                     sequence = true;
                        for(int i = 0; i < approvedEndings.length; i++){
                            if(token.contains(approvedEndings[i])){
                                writer.println();
                                sequence = false;
                            } 
                        }                    
                }
                wasCode = false;
            }
              
         writer.close();
         scan.close();
        } catch (IOException ex) {
            System.out.println("***ERROR***" + fileName + " could not be written");
        }
    }
    /** 
     * Takes a string token that contains a code, finds the associated dorm name 
     * @return string with dorm name and code formated like dorm,CODE
     * "BAT", "DAV", "DOW", "FRE", "HEM", "MCA", "ORC", "STO", "BEB", "CAZ", "MUN",
            "POM", "SHA", "CLA", "LAK", "SEV", "TCE", "TCW"
            // doesn't regonize hem
     */
    public String associatedDorm(String code){
        if(code.equals("BAT")){
            return "Bates,BAT ";
        }else if(code.equals("DAV")){
            return "Stone Davis,DAV ";
        }else if(code.equals("DOW")){
            return "Dower,DOW ";
        }else if(code.equals("FRE")){
            return "Freeman,FRE ";
        }else if(code.equals("MCA")){
            return "McAfee,MCA ";
        }else if(code.equals("STO")){
            return "Stone Davis,STO ";
        }else if(code.equals("CAZ")){
            return "Cazenove,CAZ ";
        }else if(code.equals("BEB")){
            return "Beebe,BEB ";
        }else if(code.equals("MUN")){
            return "Munger,MUN ";
        }else if(code.equals("POM")){
            return "Pomeroy,POM ";
        }else if(code.equals("SHA")){
            return "Shafer,SHA ";
        }else if(code.equals("CLA")){
            return "Claflin,CLA ";
        }else if(code.equals("LAK")){
            return "Lake House,LAK ";
        }else if(code.equals("SEV")){
            return "Severance Hall,SEV ";
        }else if(code.equals("TCE")){
            return "Tower Court,TCE ";
        }else if(code.equals("TCW")){
            return "Tower Court,TCW ";
        }else if(code.equals("DOW")){
            return "Dower,Dow ";
        }else if(code.equals("ORC")){
            return "Orchid,ORC ";
        }else if(code.equals("HEM")){
            return "Hemlock,HEM ";
        }else{
        
            return "Undefined, ";
        }
    }

    public String returnCode(int i){
        return housingCodes[i];
    }

    public static void main(String[] args) {
        ProcessHousing tester = new ProcessHousing();
        //System.out.println(tester.returnAllText());

    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProcessHousing {
    private String allText;
    private final String HOUSEFILE = "housing.txt";
    private String[] housingCodes;
    public ProcessHousing() {
        allText = "";
        // writes all the text from housing txt to one string
        try {
            Scanner myReader = new Scanner(new File(HOUSEFILE));
            while (myReader.hasNext()) {
                String temp = myReader.nextLine();
                    allText += temp;
                    allText += "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
    public String returnAllText(){
        return allText;
    }
    public String[] processRoom( String code) {
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
            writer.close();
        } catch (IOException ex) {
            System.out.println("***ERROR***" + fileName + " could not be written");
        }
    }
    public static void main(String[] args) {
        ProcessHousing tester = new ProcessHousing();
        System.out.println(tester.returnAllText());
    }
}

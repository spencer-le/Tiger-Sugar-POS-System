import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; //like a vector, used for storing csv tokens
/*
brainstorming:
Two methods of reading (via loop) in csv
1. Line by line
    Pros
    - 1 line = 1 order
    Cons
    - Requires new line in makeCSV at the end of every person's order (easy, already there)
2. every [num] elements
    Pros
    - Format given in lecture slides
    Cons
    - database changes could lead to mismatch of hardcoded [num] elements
 */

public class CSVReader {
    public static void readCSV(String filePath) {
        ArrayList<String> tokens = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {

                }
                tokens.add(line.at)
                //Use arraylist to split into tokens
                // Process the line (e.g., split into fields, transform data)
                // Insert data into the database
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readCSV2(String filePath){
        /*
        function based upon lecture slides
         */
        Scanner sc = new Scanner(new File("F:\\CSVDemo.csv"));
        sc.useDelimiter(","); //sets the delimiter pattern
        while(sc.hasNext()){ //returns a boolean value
            System.out.print(sc.next()); //find and returns the next complete token from this scanner
        }
        sc.close(); //closes the scanner
    }

}


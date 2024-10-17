package classes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class ReadWriteHandler {
    static int lineCounter = 0;
    
    //write array to file using buffered writer. For each element in array, write it to file
    public static void writeArraytoFile(int array[], String filename){
        try (BufferedWriter output = new BufferedWriter(new FileWriter(new File(filename)))){
            for(int i = 0; i < array.length; i++){
                output.write(array[i] + "\n");
            }
            output.close();
        } catch(Exception e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    
    //read array from file using buffered reader. Must use getArraySize method first to get the size of array
    public static int[] readArrayfromFile(String filename){
        try (BufferedReader file = new BufferedReader(new FileReader(filename))){
            String line = file.readLine();
            int[] array = new int[lineCounter];

            //loop to put in the content from file to array
            for(int i = 0; i < lineCounter; i++){
                array[i] = Integer.parseInt(line);
                line = file.readLine();
            }

            file.close();
            return array;

        } catch(Exception e){
            System.err.println("An error occurred while reading from the file: " + e.getMessage());
            return new int[0]; // Return an empty array in case of an error
        }
    }

    //get the size of the array in the file
    public static int getArraySize(String filename){
        try (BufferedReader file = new BufferedReader(new FileReader(filename))){
            String line = file.readLine();
            //loop to count the lines so we can initilize the max size of array
            while(line != null){
                lineCounter++;
                line = file.readLine();
            }
        return lineCounter;
        } catch(Exception e){
            System.err.println("An error occurred while reading from the file: " + e.getMessage());
            return lineCounter = 0;
        }
        
    }
}



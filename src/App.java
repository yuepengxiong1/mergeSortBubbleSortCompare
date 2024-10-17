import classes.ArrayHandler;
import classes.ReadWriteHandler;
import classes.SortingAlgorithms;


public class App {
    public static void main(String[] args) throws Exception {

        //if user passes nothing
        if (args.length == 0) {
            System.out.println("There was nothing passed into the program as an argument. Please provide a textfile or a numerical value");

        } else if (args.length == 1) { 
           String store = args[0];
           int array[] = new int[0];
           int array2[] = new int[0];

           //Check if the passed argument is a passed file or a numerical value
           if (store.contains(".txt") == true){
            array = new int[ReadWriteHandler.getArraySize(store)]; //initialize the array with the size of the file
            array = ReadWriteHandler.readArrayfromFile(store);// read array from file and put into variable
            System.out.println("Is the intial array sorted? " + ArrayHandler.isSorted(array));
            array2 = array; //this is because i dont know if when u use bubblesort, mergesort will be sorting the already sorted numbers.

            long bubbleStartTime = System.currentTimeMillis();
            SortingAlgorithms.bubbleSort(array); //sort the array
            long bubbleEndTime = System.currentTimeMillis();
            System.out.println("Bubble Sort took " + (bubbleEndTime - bubbleStartTime) + "ms to sort the array");
            System.out.println("Is the final array sorted? " + ArrayHandler.isSorted(array));
            ReadWriteHandler.writeArraytoFile(array, "BubblesortedGivenArray.txt");//write the array to new file

            long mergeStartTime = System.currentTimeMillis();
            SortingAlgorithms.mergeSort(array2); //sort the array
            long mergeEndTime = System.currentTimeMillis();
            System.out.println("Merge Sort took " + (mergeEndTime - mergeStartTime) + "ms to sort the array");
            System.out.println("Is the final array sorted? " + ArrayHandler.isSorted(array));
            ReadWriteHandler.writeArraytoFile(array2, "MergesortedGivenArray.txt");//write the array to new file

            if((mergeEndTime - mergeStartTime) < (bubbleEndTime - bubbleStartTime)){
                System.out.println("Merge sort is faster by: " + ((bubbleEndTime - bubbleStartTime) - (mergeEndTime - mergeStartTime) ) + "ms");
            } else if ((mergeEndTime - mergeStartTime) > (bubbleEndTime - bubbleStartTime)){
                System.out.println("Bubble sort is faster by: " + ((mergeEndTime - mergeStartTime) - (bubbleEndTime - bubbleStartTime)) + "ms");
            } else if ((mergeEndTime - mergeStartTime) == (bubbleEndTime - bubbleStartTime)){
                System.out.println("Both sorting methods took the same time.");
            } else {
                System.out.println("Seems like an error has occured comparing times.");
            }
            
            

            //if the passed argument is a numerical value and does not include .txt
            } else if (ArrayHandler.isNumeric(store) == true){
                array = new int[Integer.parseInt(store)]; //initialize the array with the size of the file
                array = ArrayHandler.generateRandomArray(Integer.parseInt(store));
                System.out.println("Generated random array of size " + store);
                ReadWriteHandler.writeArraytoFile(array, "randomlyGeneratedArrayof[" + store + "]Numbers.txt");//write the array to new file
                System.out.println("Is the intial array sorted? " + ArrayHandler.isSorted(array));
                array2 = array; //this is because i dont know if when u use bubblesort, mergesort will be sorting the already sorted numbers. because passing arrays passes in the memory location, not a copy of the array.

                long bubbleStartTime = System.currentTimeMillis();
                SortingAlgorithms.bubbleSort(array); //sort the array
                long bubbleEndTime = System.currentTimeMillis();
                System.out.println("Bubble Sort took " + (bubbleEndTime - bubbleStartTime) + "ms to sort the array");
                System.out.println("Is the final array sorted? " + ArrayHandler.isSorted(array));
                ReadWriteHandler.writeArraytoFile(array, "BubblesortedGeneratedArray.txt");//write the array to new file

                long mergeStartTime = System.currentTimeMillis();
                SortingAlgorithms.mergeSort(array2); //sort the array
                long mergeEndTime = System.currentTimeMillis();
                 System.out.println("Merge Sort took " + (mergeEndTime - mergeStartTime) + "ms to sort the array");
                System.out.println("Is the final array sorted? " + ArrayHandler.isSorted(array));
                ReadWriteHandler.writeArraytoFile(array2, "MergesortedGeneratedArray.txt");//write the array to new file

                if((mergeEndTime - mergeStartTime) < (bubbleEndTime - bubbleStartTime)){
                    System.out.println("Merge sort is faster by: " + ((bubbleEndTime - bubbleStartTime) - (mergeEndTime - mergeStartTime) ) + "ms");
                } else if ((mergeEndTime - mergeStartTime) > (bubbleEndTime - bubbleStartTime)){
                    System.out.println("Bubble sort is faster by: " + ((mergeEndTime - mergeStartTime) - (bubbleEndTime - bubbleStartTime)) + "ms");
                } else if ((mergeEndTime - mergeStartTime) == (bubbleEndTime - bubbleStartTime)){
                    System.out.println("Both sorting methods took the same time.");
                } else {
                    System.out.println("Seems like an error has occured comparing times.");
                }

            } else {
                System.out.println("Please provide a valid textfile or a numerical value");
            }
        } else {
            System.out.println("Please provide only one argument. Either a textfile or a numerical value");
        } 
    }
}

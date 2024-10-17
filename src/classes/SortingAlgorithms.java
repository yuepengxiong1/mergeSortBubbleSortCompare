package classes;

public class SortingAlgorithms {
    public static void bubbleSort(int[] array){
        int comparisons = 0;
        int passes = 0;
        //first loop is number of passes
        for(int i=0; i< array.length - 1; i++){
            boolean swapped = false; // for each pass, check if there is a swap that occured from previous pass, if not, array is sorted
            //second loop to compare each element
            for(int j=0; j < array.length - i - 1; j++){
                //compare array at now and next index
                //if array at j is bigger, swap
                if(array[j] > array[j+1]){
                    int temp = array[j];// saves the value of array[j] to temp
                    array[j] = array[j+1];// repleaces the value of array[j] with array[j+1]
                    array[j+1] = temp; // replaces the value of array[j+1] with temp
                    swapped = true; // if there is a swap, set swapped to true
                    comparisons++;
                }
            }
            //if there is no swap, break the loop
            if (!swapped){
                break;
            }
        }
    }

    public static void mergeSort(int[] array){
        mergeSort(array, 0, array.length);
    }
    public static void mergeSort(int[] array, int startIndex, int endIndex){
        if(endIndex - startIndex <= 1){
            return;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        mergeSort(array, startIndex, middleIndex); //first split of start to middle
        mergeSort(array, middleIndex, endIndex);// second split of middle to end
        merge(array,startIndex,middleIndex,endIndex);
    }
    public static void merge(int[] array, int startIndex, int middleIndex, int endIndex){
        int i = startIndex, j = middleIndex, k = 0; //i for left array. starting point of first, j for right array. starting point of second, k for temp array
        int[] tempArray = new int[endIndex-startIndex];
        while(i < middleIndex && j < endIndex){
            if(array[i] <= array[j]){
                tempArray[k] = array[i];
                i++;
            } else {
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }
        //for when one side is completed, for first array
        while(i < middleIndex){
            tempArray[k] = array[i];
            i++;
            k++;
        }
        //same thing but for second array
        while(j < endIndex){
            tempArray[k] = array[j];
            j++;
            k++;
        }
        for (i = startIndex; i < endIndex; i++){
            array[i] = tempArray[i - startIndex];
        }
    }

}

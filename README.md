This is a modifed version of BubbleSort but with MergeSort implemeneted. 
It compare the 2 sorting algorithms and see which one is faster.

How to use:
```
java -jar --enable-preview [jar file] [enter a integer or a text file]
```

Example of output:

```
$ java -jar --enable-preview mergeSortBubbleSortCompare.jar 100000
Generated random array of size 100000
Is the intial array sorted? false
Bubble Sort took 7497ms to sort the array
Is the final array sorted? true
Merge Sort took 10ms to sort the array
Is the final array sorted? true
Merge sort is faster by: 7487ms
```

This save the unsorted array and sorted array using both methods as a textfile. Generated arrays will have the number of generated numbers in the name of the text file. Passed in text files will not generate an unsorted array as you already have one. It will only generate the sorted one.


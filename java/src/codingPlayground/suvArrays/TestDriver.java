package codingPlayground.suvArrays;

import java.util.Random;

public class TestDriver {
    
    public static void main(String[] args) {
        int arraySize = 1000000;
        Random rand = new Random();

        int[] data = new int[arraySize];

        // initialize array
        for(int i=0; i<arraySize; i++) {
            data[i] = rand.nextInt();
        }

        SuvArrays array = new SuvArrays(data);
        // array.displayData();
        array.quickSort(true);
        // array.displayData();

        array.setData(data);
        // array.displayData();
        array.mergeSort(true);
        // array.displayData();
    }
}

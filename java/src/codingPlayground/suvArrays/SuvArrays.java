package codingPlayground.suvArrays;

public class SuvArrays {
    
    private int[] data;

    public SuvArrays(int[] data) {
        this.data = data.clone();
    }

    public void setData(int[] data) {
        this.data = data.clone();
    }

    public void displayData() {
        System.out.println("\n-----Data-----");
        for(int i: data) {
            System.out.print(i + ",");
        }
    }

    // Sort the internal array using quicksort
    public void quickSort(boolean verbose) {
        long startTime = System.nanoTime();
        quickSortHelper(0, data.length - 1);
        long endTime = System.nanoTime();
        
        if (verbose) {
            System.out.println("\n<Debug> Quicksort execution time: " + (endTime - startTime) + " ns");
        }
    }

    // Sort the internal array using mergesort
    public void mergeSort(boolean verbose) {
        long startTime = System.nanoTime();
        mergeSortHelper(0, data.length-1);
        long endTime = System.nanoTime();

        if (verbose) {
            System.out.println("\n<Debug> Mergesort execution time: " + (endTime - startTime) + " ns");
        }
    }

    private void quickSortHelper(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            quickSortHelper(p, q-1);
            quickSortHelper(q+1, r);
        }
    }

    private int partition(int p, int r) {
        int x = data[r];
        int i = p - 1;
        for(int j=p; j<=r-1; j++) {
            if(data[j] <= x) {
                i++;
                int temp = data[j];
                data[j] = data[i];
                data[i] = temp;
            }
        }
        i++;
        int temp = data[r];
        data[r] = data[i];
        data[i] = temp;

        return i;
    }

    private void mergeSortHelper(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSortHelper(p, q);
            mergeSortHelper(q+1, r);
            merge(p, q, r);
        }
    }
    
    private void merge(int p, int q, int r) {
        int[] scratchPad = new int[r - p + 1];
        int leftIndex = p;
        int rightIndex = q+1;
        int index = 0;

        while(leftIndex <= q && rightIndex <= r) {
            if (data[leftIndex] <= data[rightIndex]) {
                scratchPad[index++] = data[leftIndex++];
            }
            else {
                scratchPad[index++] = data[rightIndex++];
            }
        }

        while (leftIndex <= q) {
            scratchPad[index++] = data[leftIndex++];
        }

        while (rightIndex <= r) {
            scratchPad[index++] = data[rightIndex++];
        }

        for(int i=0; i<scratchPad.length; i++) {
            data[p+i] = scratchPad[i];
        }
    }
}

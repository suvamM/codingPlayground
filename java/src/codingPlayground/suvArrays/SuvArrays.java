package codingPlayground.suvArrays;

public class SuvArrays {
    
    private int[] data;

    public SuvArrays(int[] data) {
        this.data = data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    // Sort the internal array using quicksort
    public void quickSort() {
        quickSortHelper(0, data.length - 1);
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

    public void displayData() {
        System.out.println("\n-----Data-----\n");
        for(int i: data) {
            System.out.print(i + ",");
        }
    }
}

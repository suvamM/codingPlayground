package codingPlayground.suvArrays;

public class TestDriver {
    
    public static void main(String[] args) {
        int[] data = {2,8,7,1,3,5,6,4};
        SuvArrays array = new SuvArrays(data);
        array.displayData();
        array.quickSort();
        array.displayData();
    }
}

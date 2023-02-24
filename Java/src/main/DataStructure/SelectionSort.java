import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int []arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        int index = 0;
        for (int i=index;i<arr.length;i++) {
            for (int j=i+1;j<arr.length;j++) {
                if (arr[index] > arr[j])
                    index = j;
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}

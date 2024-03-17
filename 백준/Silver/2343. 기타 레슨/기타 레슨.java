import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] list = new int[N];
        int start=0;
        int end=0;
        for(int i=0;i<N;i++) {
            list[i] = sc.nextInt();
            if (start < list[i]) start = list[i];
            end+=list[i];
        }
        
        while (start <= end) {
            int mid = (start+end) / 2;
            int sum=0;
            int count=0;
            for(int i=0;i<N;i++) {
                if (sum + list[i] > mid) {
                    count++;
                    sum =0;
                }
                sum += list[i];
            }
            if (sum != 0)
                count++;
            if (count > M)
                start = mid +1;
            else
                end = mid - 1;
        }
        System.out.println(start);
    }
}

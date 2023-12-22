import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N_size = sc.nextInt();
        int[] N = new int[N_size];
        for (int i=0;i<N_size;i++)
            N[i] = sc.nextInt();
        int M_size = sc.nextInt();
        int[] M = new int[M_size];
        for (int i=0;i<M_size;i++)
            M[i] = sc.nextInt();

        Arrays.sort(N);

        for(int i=0;i<M_size;i++) {
            int K = M[i];
            boolean flag = false;
            int start = 0;
            int end = N_size - 1;
            while (start <= end) {
                int mid = (start+end) / 2;
                int midi = N[mid];
                if (K < midi) {
                    end = mid-1;
                } else if (K > midi) {
                    start = mid+1;
                } else {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                System.out.println(1);
            }
            else
                System.out.println(0);
        }
    }
}

import java.io.*;
import java.util.Scanner;

public class SWEA1859 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("SWEA/static/1859.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int t = 1; t <= testcase; t++) {
            int N = sc.nextInt();
            int[] list = new int[N];
            for(int i=0;i<N;i++) {
                list[i] = sc.nextInt();
            }
            bw.write("#"+t+" ");
            long result = solve(N, list);
            bw.write(result + "\n");
        }
        bw.flush();
    }

    private static long solve(int N, int[] list) {
        long total = 0;
        long max = Long.MIN_VALUE;
        for(int i=list.length-1;i>=0;i--) {
            if (list[i] <= max) {
                total += (max - list[i]);
            } else {
                max = list[i];
            }
        }
        return total;

    }
}

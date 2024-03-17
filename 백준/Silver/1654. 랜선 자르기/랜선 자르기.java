import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] lines;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());
        long largest =0;
        N = Integer.parseInt(st.nextToken());
        lines = new int[K];
        for (int i=0;i<K;i++) {
            lines[i] = Integer.parseInt(bf.readLine());
            if (lines[i] > largest)
                largest = lines[i];
        }

        long result = binary_search(1, largest+1, 0);
        System.out.println(result);
    }

    private static long binary_search(long start, long end, long result) {
        if (start >= end)
            return result;

        if (start < end) {
            int count = 0;
            long mid = (start + end) / 2;
            for (int i : lines) {
                count += (i / mid);
            }

            if (count < N)
                return binary_search(start, mid, result);
            else {
                if (result < mid)
                    result = mid;
                return binary_search(mid +1, end, result);
            }
        }
        return -1;
    }
}

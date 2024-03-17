import java.io.*;
import java.util.*;

public class BaekJoon11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        Integer[] list = new Integer[N];
        for(int i=0;i<N;i++)
            list[i] = Integer.parseInt(bf.readLine());

        Arrays.sort(list, Collections.reverseOrder());

        for(Integer i : list) {
            bw.write(i + "\n");
        }

        bw.flush();
    }
}

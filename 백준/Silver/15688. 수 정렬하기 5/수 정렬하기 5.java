import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        int[] list = new int[N];
        for(int i=0;i<N;i++)
            list[i] = Integer.parseInt(bf.readLine());

        Arrays.sort(list);
        
        for(int i:list)
            sb.append(i).append("\n");

        System.out.print(sb);
    }

}

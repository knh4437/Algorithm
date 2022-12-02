import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        String[] arr = new String[Integer.parseInt(st.nextToken())];
        int X = Integer.parseInt(st.nextToken());
        int[] num = new int[arr.length];
        s = bf.readLine();
        arr = s.split(" ");
        for(int i=0;i<arr.length;i++){
            num[i] = Integer.parseInt(arr[i]);
            if (num[i] < X)
                System.out.print(num[i]+" ");
        }
    }
}

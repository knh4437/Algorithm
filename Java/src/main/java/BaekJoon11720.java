import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split("");
        int sum=0;
        for(int i=0;i<s.length;i++) {
            sum += Integer.parseInt(s[i]);
        }
        System.out.println(sum);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int count = 1;
        int result = 666;
        while (N != count) {
            result++;

            if (String.valueOf(result).contains("666")) {
                count++;
            }
        }
        System.out.println(result);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] alpha = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
        for(String index : alpha) {
            if (input.contains(index)) {
                input = input.replace(index, "!");
            }
        }
        System.out.println(input.length());
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int count = 0;
        for(int i=0;i<N;i++) {
            String input = bf.readLine();
            if (check(input))
                count++;
        }
        System.out.println(count);
    }

    public static boolean check(String input) {
        List<String> list = new ArrayList<>();
        String[] tokens = input.split("");
        String prev = tokens[0];
        for(int i=1;i<tokens.length;i++) {
            String now = tokens[i];
            if (list.contains(now)) {
                return false;
            }
            if (!prev.equals(now)) {
                list.add(prev);
                prev = now;
            }
        }
        return true;
    }
}

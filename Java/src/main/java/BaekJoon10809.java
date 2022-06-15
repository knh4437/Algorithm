import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BaekJoon10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        for(int i=0;i<str.length;i++) {
            if (!map.containsKey(str[i]))
                    map.put(str[i], i);
        }
        for (int i=97;i<=122;i++) {
            if (map.containsKey((char)i))
                System.out.print(map.get((char)i));
            else
                System.out.print("-1");
            System.out.print(" ");
        }
    }
}

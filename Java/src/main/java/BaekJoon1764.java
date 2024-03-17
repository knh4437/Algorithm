import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count =0;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<N;i++)
            map.put(bf.readLine(), 0);
        for(int i=0;i<M;i++) {
            String s = bf.readLine();
            if (map.containsKey(s))
                map.put(s, 1);
        }
        List<String> keySort = new ArrayList<>(map.keySet());
        keySort.sort((s1, s2)->s1.compareTo(s2));
        for(String key : keySort)
            if (map.get(key) == 1) {
                count++;
                sb.append(key + "\n");
            }

        System.out.print(count + "\n" + sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BaekJoon3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map =new HashMap<>(); // 나머지값, 갯수
        int[] num = new int[10];
        for(int i=0;i<10;i++){
            num[i] = Integer.parseInt(bf.readLine());
            num[i] = num[i]%42;
            if (!map.containsKey(num[i])) {
                map.put(num[i], 1);
            }
            else {
                map.put(num[i], map.get(num[i]) + 1);
            }
        }
        System.out.println(map.size());
    }
}

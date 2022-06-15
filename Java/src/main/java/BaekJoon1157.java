import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BaekJoon1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> map = new HashMap<>();
        String str = bf.readLine();
        Boolean flag = false;
        int most = 0;
        char answer = ' ';
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 65) && (str.charAt(i) <= 90)) {
                // 대문자일 경우
                if (!map.containsKey(str.charAt(i)))
                    // 대문자를 키로 설정. 값이 비어있을 경우
                    map.put(str.charAt(i), 1);
                else
                    map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else if ((str.charAt(i) >= 97) && ((str.charAt(i)) <= 122)) {
                // 소문자일 경우,
                char a = (char) (str.charAt(i) - 32);  // 대문자로 바꿈
                if (!map.containsKey(a))
                    // 값이 비어있을 경우
                    map.put(a, 1);
                else {
                    map.put(a, map.get(a) + 1);
                }
            }
        }
        for (char s : map.keySet()) {
            if (most <= map.get(s)) {
                    flag = true;
                if (most == map.get(s)) {
                    flag = false;
                }
                    most = map.get(s);
                    answer = s;
            }
        }
        if (flag == false)
            System.out.println("?");
        else
            System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        s = s.trim();
        int num;
        String[] str = s.split(" ");
        num = str.length;
        if (str[0].isEmpty())
            num -= 1;
        System.out.println(num);
    }

}

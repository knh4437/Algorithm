import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2908 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int first = Integer.parseInt(st.nextToken());   // 734
        int second = Integer.parseInt(st.nextToken());  // 893
        int num = 0;
        int firstChanged = 0;
        int secondChanged = 0;
        int bak = 100;

        for(int i=0;i<3;i++) {
            firstChanged = changeNum(first, firstChanged, bak);
            first /= 10;
            secondChanged = changeNum(second, secondChanged, bak);
            second /=10;
            bak /= 10;
        }

        System.out.println((firstChanged<secondChanged)?secondChanged:firstChanged);
    }
    public static int changeNum(int num, int changed, int bak) {
        int a = 0;
        a = num % 10;
        changed += a * bak;
        return changed;
    }
}


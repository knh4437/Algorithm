import java.util.*;

public class BaekJoon2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] list = new String[num];    // 0 1 2 3 4
        Arrays.fill(list, " ");
        for(int i=num-1;i>=0;i--) {     // 4 3 2 1 0
            list[i] = "*";
            for (int j=0;j<num;j++) {
                System.out.print(list[j]);
            }
            System.out.println();
        }
    }
}

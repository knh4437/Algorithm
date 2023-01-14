import java.util.Scanner;

// 바이러스 - https://softeer.ai/practice/info.do?idx=1&eid=407
public class Level02_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        long K = Long.parseLong(s[0]);
        long P = Long.parseLong(s[1]);
        int N = Integer.parseInt(s[2]);
        long mod = 1000000007;

        while (N > 0) {
            K = (K*P) % mod;
            N--;
        }
        System.out.println(K);
    }
}

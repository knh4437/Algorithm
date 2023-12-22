import java.util.Scanner;

// 백준 2023번 - 신기한 소수 찾기 : https://www.acmicpc.net/problem/2023
public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] primeList = { 2,3,5,7 };
        for(int i=0;i<primeList.length;i++)
            DFS(primeList[i], 1);

    }

    static void DFS(int num, int digit) {
        if (digit == N) {
            if (isPrime(num))
                System.out.println(num);
            return;
        }

        for(int i=1;i<10;i++) {
            if (i%2==0)
                continue;
            if (isPrime(10 * num + i)) {
                DFS(10 * num + i, digit + 1);
            }
        }

    }

    static boolean isPrime(int num) {
        for (int i=2;i<=(int)Math.sqrt(num);i++)
            if (num%i==0)
                return false;
        return true;
    }
}

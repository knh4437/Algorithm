import java.util.Scanner;

public class BaekJoon9663 {
    private static int N;
    private static int[] arr;
    private static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        count = 0;
        dfs(0);
        System.out.println(count);
    }

    /*
        (depth, arr[depth]) : 행과 열
        Ex) arr = { 0, 1, 2, 3 }
            1 0 0 0
            0 1 0 0
            0 0 1 0
            0 0 0 1
            과 같이 놓여있음을 의미한다.(해당 예시는 예시일 뿐, 다음과 같이 퀸을 배치시킬 순 없다.)
     */
    private static void dfs(int depth) {
        if (depth==N) {
            count++;
            return;
        }

        for(int i=0;i<N;i++) {
            arr[depth] = i;
            if (check(depth))
                dfs(depth+1);
        }

    }

    private static boolean check(int col) {
        for(int i=0;i<col;i++) {
            if (arr[i] == arr[col]) {
                return false;
            }
            if (Math.abs(i-col) == Math.abs(arr[i] - arr[col]))
                return false;
        }
        return true;
    }


}

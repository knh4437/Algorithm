import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon1018 {

    private static int start() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] blocks = requestInput(N, M);
        int result = calBlocks(blocks, N, M);

        return result;
    }

    private static char[][] requestInput(int N, int M) {
        char[][] blocks = new char[N][M];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<N;i++) {
            String s = sc.nextLine();
            blocks[i] = s.toCharArray();
        }
        return blocks;
    }

    private static int calBlocks(char[][] blocks, int N, int M) {
        int result=-1;
        int num;
        for(int i=0;i+7<blocks.length;i++) {
            for(int j=0;j+7<blocks[i].length;j++) {
                num = color(copy(blocks, N, M), i, j);
                if (num < result || result == -1) {
                    result = num;
                }
            }
        }
        return result;
    }

    private static char[][] copy(char[][] blocks, int N, int M) {
        if (blocks == null)
            return null;
        char[][] copyArray = new char[N][M];
        for (int i=0; i<blocks.length;i++) {
            copyArray[i] = blocks[i].clone();
        }
        return copyArray;
    }

    private static int color(char[][] blocks, int X, int Y) {
        int count = 0;
        char[][] clone = blocks.clone();
        System.out.println(clone);
        for (int i=X;i<X+8;i++) {
            if (i+1 != X+8) {
                if (i != X + 8 && clone[i][0] == clone[i + 1][0]) {
                    count++;
                    if (clone[i][Y] == 'B') {
                        clone[i + 1][Y] = 'W';
                    }
                    else
                        clone[i + 1][Y] = 'B';
                }
            }

            for (int j=Y;j<Y+7;j++) {
                if (clone[i][j] == clone[i][j+1]) {
                    if (clone[i][j] == 'B') {
                        clone[i][j + 1] = 'W';
                    } else {
                        clone[i][j + 1] = 'B';
                    }
                    count++;
                }
            }
        }
        System.out.println("count : " + count);
        return count;
    }

    public static void main(String[] args) {
        int result = start();
        System.out.println(result);
    }
}

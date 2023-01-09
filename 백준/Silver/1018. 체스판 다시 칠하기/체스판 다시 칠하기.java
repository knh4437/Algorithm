import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        start(bf);
    }

    private static void start(BufferedReader bf) {
        int[] length = getLength(bf);
        char[][] board = getBoard(length[0], length[1], bf);
        int result = calculate(board, length[0], length[1]);
        System.out.printf(String.valueOf(result));
    }

    private static int[] getLength(BufferedReader bf) {
        int[] length = new int[2];
        try {
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            length[0] = width;
            length[1] = height;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }

    private static char[][] getBoard(int width, int height,BufferedReader bf) {
        char[][] board = new char[width][height];
        for(int i=0;i<width;i++){
            try {
                String s = bf.readLine();
                board[i] = s.toCharArray();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return board;
    }

    private static int calculate(char[][] board, int width, int height) {
        int result = 64;
        for(int i=0;i<width-7;i++) {
            for (int j=0;j<height-7;j++) {
                int r = chess(board, i, j);
                result = Math.min(result, r);
            }
        }
        return result;
    }

    // board[n][m] means a starting point of a chess
    private static int chess(char[][] board, int n, int m) {
        char[][] cloneBoard = board.clone();
        int result=0;
        char start = cloneBoard[n][m];
        for (int i=n;i<n+8;i++) {
            for (int j=m;j<m+8;j++) {
                if (cloneBoard[i][j] != start)
                    result++;
                start = (start=='B')?'W':'B';
            }
            start = (start=='B')?'W':'B';
        }
        result = Math.min(result, 64-result);
        return result;
    }
}

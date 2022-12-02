import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HyundaiTech {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        String[][] array = getArray(n);
        br.close();
        System.out.println(equalNumbers(array, 0, 0, Integer.parseInt(input)));
        System.out.println("Hello Goorm! Your input is " + input);
    }

    private static String[][] getArray(int input) throws IOException {
        String[][] array = new String[input][input];
        for(int i=0;i<input;i++) {
            String s= getLine();
            System.out.println("s:" + s);
            String[] list = s.split("");
            for(int j=0;j<list.length;j++) {
                array[i][j] = list[j];
            }
        }
        return array;
    }

    private static String getLine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine())!=null) {
            return s;
        }
        br.close();
        return s;
    }

    private static String equalNumbers(String[][] array, int x, int y, int n) {
        if (n <= 1)
            return array[x][y];
        for (int i=x;i<n-1;i++) {
            for (int j=y;j<n-1;j++) {
                if (!array[i][j].equals(array[i][j+1])) {
                    equalNumbers(array, i, j+1, n / 2);
                }
                else if (!array[i][j].equals(array[i+1][j])) {
                    equalNumbers(array, i+1, j, n / 2);
                }
            }
        }
        return array[n-1][n-1];
    }
}

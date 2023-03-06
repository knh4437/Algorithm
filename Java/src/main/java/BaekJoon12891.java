import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 12891번 : DNA 비밀번호 - https://www.acmicpc.net/problem/12891
public class BaekJoon12891 {

    static char[] arr;
    static int[] checkArr;
    static int[] statusArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        arr = new char[S];
        checkArr = new int[4];
        arr = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        checkSecret=0;
        int result=0;
        for(int i=0;i<4;i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0)
                checkSecret++;
        }
        statusArr = new int[4];
        for (int i=0;i<P;i++) {
            Add(arr[i]);
        }
        if (checkSecret==4)
            result++;
        for(int i=P;i<S;i++) {
            int j=i-P;
            Add(arr[i]);
            Remove(arr[j]);
            if (checkSecret==4)
                result++;
        }
        System.out.println(result);
        bf.close();
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                statusArr[0]++;
                if (statusArr[0] == checkArr[0])
                    checkSecret++;
                break;
            case 'C':
                statusArr[1]++;
                if (statusArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                statusArr[2]++;
                if (statusArr[2] == checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                statusArr[3]++;
                if (statusArr[3] == checkArr[3])
                    checkSecret++;
                break;
        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (statusArr[0] == checkArr[0])
                    checkSecret--;
                statusArr[0]--;
                break;
            case 'C':
                if (statusArr[1] == checkArr[1])
                    checkSecret--;
                statusArr[1]--;
                break;
            case 'G':
                if (statusArr[2] == checkArr[2])
                    checkSecret--;
                statusArr[2]--;
                break;
            case 'T':
                if (statusArr[3] == checkArr[3])
                    checkSecret--;
                statusArr[3]--;
                break;
        }
    }
}
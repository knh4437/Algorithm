import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 12891번 : DNA 비밀번호 - https://www.acmicpc.net/problem/12891
public class BaekJoon12891 {

    static char[] arr;
    static int[] countArr;
    static int[] statusArr;
    static int check;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int length = Integer.parseInt(st.nextToken());
        int partLength = Integer.parseInt(st.nextToken());
        arr = new char[length];
        countArr = new int[4];
        int result=0;
        arr = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        check =0;
        statusArr = new int[4];
        for (int i=0;i<4;i++) {
            countArr[i] = Integer.parseInt(st.nextToken());
            if (countArr[i] == 0)
                check++;
        }
        for (int i=0;i<partLength;i++) {
            Add(arr[i]);
        }
        if (check==4)
            result++;
        for (int i=partLength;i<length;i++) {
            int j=i-partLength;
            Add(arr[i]);
            Remove(arr[j]);
            if (check==4)
                result++;
        }
        System.out.println(result);
        bf.close();

    }

    private static void Add(char c) {

        switch (c) {
            case 'A':
                statusArr[0]++;
                if (countArr[0]==statusArr[0])
                    check++;
                break;
            case 'C':
                statusArr[1]++;
                if (countArr[1]==statusArr[1])
                    check++;
                break;
            case 'G':
                statusArr[2]++;
                if (countArr[2]==statusArr[2])
                    check++;
                break;
            case 'T':
                statusArr[3]++;
                if (countArr[3]==statusArr[3])
                    check++;
                break;
        }
    }

    private static void Remove(char c) {

        switch (c) {
            case 'A':
                if (countArr[0]==statusArr[0])
                    check--;
                statusArr[0]--;
                break;
            case 'C':
                if (countArr[1]==statusArr[1])
                    check--;
                statusArr[1]--;
                break;
            case 'G':
                if (countArr[2]==statusArr[2])
                    check--;
                statusArr[2]--;
                break;
            case 'T':
                if (countArr[3]==statusArr[3])
                    check--;
                statusArr[3]--;
                break;
        }
    }
}
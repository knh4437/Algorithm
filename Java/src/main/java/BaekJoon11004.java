import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11004 - K번째 수 : https://www.acmicpc.net/problem/11004
public class BaekJoon11004 {

    static int[] list;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i=0;i<N;i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(0, N-1);
        System.out.println(list[K-1]);
    }

    static void quickSort(int S, int E) {
        if (S < E) {
            int p = partition(S, E);

            if (p == K-1) return;
            else if (p > K-1) quickSort(S, p-1);
            else quickSort(p+1, E);
        }
    }

    static int partition(int S, int E) {
        if (S+1 == E) {
            // 확인이 필요한(혹은 정렬이) 숫자가 2개만 남았을 경우
            if (list[S] > list[E]) swap(S,E);
            // 앞뒤 크기 비교후, swap
            return E;
        }
        int M = (S+E) / 2;
        swap(S, M);
        int pivot = list[S];
        int l = S+1;
        int r = E;
        while (l<=r) {
            while (pivot < list[r] && r>0) r--;
            while (l < list.length-1 && pivot > list[l]) l++;
            if (l<=r) {
                swap(l++, r--);
            }
        }
        list[S] = list[r];
        list[r] = pivot;
        return r;
    }

    static void swap(int a1, int a2) {
        int temp = list[a1];
        list[a1] = list[a2];
        list[a2] = temp;
    }
}

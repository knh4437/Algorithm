import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        int[] mode_arr = new int[8001];
        double sum = 0;
        double avg = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int mode;
        int range;
        /*
            avg = 평균
            median = 중앙값
            mode = 최빈값
            range = 범위
        */
        for (int i=0;i<N;i++) {
            int input = Integer.parseInt(bf.readLine());
            sum += input;
            arr[i] = input;
            if (max < input)
                max = input;
            if (min > input)
                min = input;
            mode_arr[4000+input]++;
        }

        avg = sum / N;
        sb.append(Math.round(avg) + "\n");

        Arrays.sort(arr);
        sb.append(arr[N/2] + "\n");

        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<8001;i++) {
            if (count < mode_arr[i]) {
                list.clear();
                count = mode_arr[i];
                list.add(i);
            }
            else if (count == mode_arr[i]) {
                list.add(i);
            }
        }
        mode = list.get(0);
        if (list.size() > 1)
            mode = list.get(1);
        mode -= 4000;
        sb.append(mode + "\n");

        range = max - min;
        sb.append(range);

        System.out.println(sb);
    }
}

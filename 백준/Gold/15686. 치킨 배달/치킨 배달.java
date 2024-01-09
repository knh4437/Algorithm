import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Location {
    int x;
    int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

}

public class Main {
    private static int N;
    private static int M;
    private static boolean[] opened;
    private static ArrayList<Location> chickens;
    private static ArrayList<Location> houses;
    private static ArrayList<Integer> choice;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        for (int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for (int j=0;j<N;j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    houses.add(new Location(i, j));
                }
                else if (num == 2) {
                    chickens.add(new Location(i, j));
                }
            }
        }
        opened = new boolean[chickens.size()];
        choice = new ArrayList<>();
        ans = Integer.MAX_VALUE;
        solve(0, 0);
        System.out.println(ans);
    }

    private static void solve(int depth, int index) {
        if (depth == M) {
            int res =0;

            for(Location l : houses) {
                int min = Integer.MAX_VALUE;
                for(int c : choice) {
                    Location ch = chickens.get(c);
                    int d = Math.abs(l.x - ch.x) + Math.abs(l.y - ch.y);
                    min = Math.min(min, d);
                    // 해당 집이 어느 치킨 집과 가장 가까운지 계산
                }
                res += min;
                // 계산된 거리 합
            }
            ans = Math.min(res, ans);
            // 폐업시키지 않을 치킨집의 경우 수 중 거리의 합이 최소 값을 결과값으로 설정
        }

        for (int i=index;i<chickens.size();i++) {
            if (opened[i])
                continue;
            opened[i] = true;
            choice.add(i);
            solve(depth+1, i+1);
            opened[i] = false;
            choice.remove(choice.size()-1);
        }
        // 순열
    }

}

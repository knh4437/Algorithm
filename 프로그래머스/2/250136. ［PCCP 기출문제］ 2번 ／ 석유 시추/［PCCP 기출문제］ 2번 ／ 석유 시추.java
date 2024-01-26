import java.util.*;

class Solution {
    static int[] mx = {0,0,1,-1};
    static int[] my = {1,-1,0,0};
    static int N, M;
    static Map<Integer, Integer> map;
    
    public int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        N = land.length;    // 5
        M = land[0].length; // 8
        map = new HashMap<>();

        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if (land[i][j]==1) {
                    Set<Integer> set = new HashSet<>();
                    bfs(land, set, i, j);
                }
            }
        }

        for (int key : map.keySet()) {
            answer = Math.max(map.get(key), answer);
        }

        return answer;
    }
    
    private static void bfs(int[][] land, Set<Integer> set, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        set.add(y);
        int size = 1;
        land[x][y] =2;

        while (!queue.isEmpty()) {
            int[] v = queue.poll();

            for(int i=0;i<4;i++) {
                int nextX = v[0] + mx[i];
                int nextY = v[1] + my[i];
                if (nextX < 0 || nextY < 0 || nextX > N-1 || nextY > M-1)
                    continue;
                if (land[nextX][nextY] == 1) {
                    land[nextX][nextY] = 2;
                    queue.add(new int[]{nextX, nextY});
                    size++;
                    set.add(nextY);
                }
            }
        }
        for(int tmp : set) {
            map.put(tmp, map.getOrDefault(tmp,0) + size);
        }

    }
}
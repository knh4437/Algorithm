import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int room_size = book_time.length;
        int[][] list = new int[room_size][2];
        int gotRoom = 0;
        boolean[] visited = new boolean[room_size];
        int[] rooms = new int[room_size];
        Arrays.fill(rooms, -1);
        
        for(int i=0;i<room_size;i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":",""));
            int end = Integer.parseInt(book_time[i][1].replace(":",""));
            
            end += 10;
            if (end%100 >= 60) {
                end += 40;
            }
            list[i][0] = start;
            list[i][1] = end;
        }
        
        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        
        for(int i=0;i<room_size;i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            rooms[i] = list[i][1];
            for(int j=0;j<room_size;j++) {
                if (visited[j])
                    continue;
                if (rooms[i] <= list[j][0]) {
                    visited[j] = true;
                    rooms[i] = list[j][1];
                }  
            }
        }
        
        for(int i : rooms){
            if (i != -1) {
                answer++;
            }
        }
        return answer;
    }
}
/*
    도착점(x,y)에 대하여 각 쿼리를 반대로 돌려 동작시켜보자
    - 0 : 오른쪽으로 1칸 이동 (y 증가)
    - 1 : 왼쪽으로 1칸 이동 (y 감소)
    - 2 : 아래로 1칸 이동 (x 증가)
    - 3 : 위로 1칸 이동 (x 감소)
*/
class Solution {
    public long solution(int n, int m, long x, long y, int[][] queries) {
        long answer = 0;
        long xMax = x;
        long xMin = x;
        long yMax = y;
        long yMin = y;
        for(int i = queries.length-1; i >= 0; i--) {
            long weight = queries[i][1];
            switch (queries[i][0]) {
                // 왼쪽 이동 => 오른쪽 이동으로 변경
                case 0:
                    yMax += weight;
                    if (yMax >= m) yMax = m-1;
                    if (yMin != 0) yMin += weight;
                    break;
                // 오른쪽 이동 => 왼쪽 이동으로 변경
                case 1:
                    yMin -= weight;
                    if (yMin < 0) yMin = 0;
                    if (yMax != m-1) yMax -= weight;
                    break;
                // 위 이동 => 아래 이동으로 변경
                case 2:
                    xMax += weight;
                    if (xMax >= n) xMax = n-1;
                    if (xMin != 0) xMin += weight;
                    break;
                // 아래 이동 => 위 이동으로 변경
                case 3:
                    xMin -= weight;
                    if (xMin < 0) xMin = 0;
                    if (xMax != n-1) xMax -= weight;
                    break;
            }
            if (yMin >= m || yMax < 0 || xMin >=n || xMax < 0) return 0; 
        }
        answer = (xMax - xMin +1) * (yMax - yMin + 1);
        return answer;
    }
}
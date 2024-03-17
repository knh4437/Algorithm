class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int same = 0;
        int zero = 0;
        int high, low;
        for (int i : lottos) {
            for (int j : win_nums) {
                if (i==j)
                    same++;
            }
            if (i == 0)
                zero++;
        }
        
        return new int[]{cal(same+zero), cal(same)};
    }
    
    public static int cal(int count) {
        switch (count) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
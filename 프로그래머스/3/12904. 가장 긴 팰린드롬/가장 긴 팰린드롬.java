class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        String[] arr = s.split("");


        for (int i=s.length();i>0;i--) {
            // i : 탐색 길이 설정(팰린드롬 길이)
            for (int start=0;start+i<=arr.length;start++) {
                // start : 문자열의 검사를 시작할 위치
                boolean flag = true;

                for (int j=0;j<i/2;j++) {
                    // j : 검사 횟수로 사용
                    int left = start + j;
                    int right = start - j + i - 1;
                    if (!arr[left].equals(arr[right])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }
}
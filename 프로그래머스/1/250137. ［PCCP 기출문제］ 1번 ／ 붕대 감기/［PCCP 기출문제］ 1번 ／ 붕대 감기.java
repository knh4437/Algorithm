class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int now_time = 0;
        int index = 0;
        int max_health = health;
        int heal_time = 0;
        
        while (index < attacks.length) {
            now_time += 1;
            
            if (now_time == attacks[index][0]) {
                health -= attacks[index][1];
                index++;
                heal_time = 0;
                continue;
            }
            
            if (health <= 0) {
                answer = -1;
                break;
            }
            
            health += bandage[1];
            heal_time += 1;
            if (health > max_health)
                health = max_health;
            if (heal_time == bandage[0]) {
                health = (health+bandage[2]>max_health)?max_health:(health+bandage[2]);
                heal_time = 0;
            }
        }
        answer = (health<=0)?-1:health;
        
        return answer;
    }
}
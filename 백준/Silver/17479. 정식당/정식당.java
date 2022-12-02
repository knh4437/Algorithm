import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args){

        HashMap<String, Integer> food = new HashMap<>();  // 음식명, 가격
        HashMap<String, String> kind = new HashMap<>();   // 음식명, 메뉴판
        HashMap<String ,Integer> order = new HashMap<>();   // 주문한 메뉴판 종류, 해당 등급의 주문 메뉴 갯수
        Scanner sc = new Scanner(System.in);
        int[] amount = new int[3];
        String name, order_name;
        String answer = "Okay";
        int price, order_amount, l=0;
        long general_total = 0;
        long special_total = 0;

        for(int i=0;i<3;i++){
            amount[i] = sc.nextInt();
            l += amount[i];
        }

        for (int i=0;i<l;i++) {
            if (amount[0]>0) {
                name = sc.next();
                price = sc.nextInt();
                food.put(name,price);
                kind.put(name, "normal");
                amount[0]--;
            }
            else if (amount[1]>0) {
                name = sc.next();
                price = sc.nextInt();
                food.put(name,price);
                kind.put(name, "special");
                amount[1]--;
            }
            else {
                name = sc.next();
                kind.put(name, "service");
                amount[2]--;
            }
        }

        order_amount = sc.nextInt();

        if (order_amount>0) {
            for (int i = 0; i < order_amount; i++) {
                order_name = sc.next();     // 주문한 음식 이름
                if (!kind.containsKey(order_name))   // 주문한 음식이 메뉴판에 없을 경우
                    answer = "No";
                else {          // 메뉴판에 있을 경우
                    String rank = kind.get(order_name); // 해당 메뉴의 등급
                    if (!order.containsKey(rank)) {      // 주문 내역에서 주문한 등급의 음식 수가 없는 경우
                        order.put(rank, 1);     // 주문 추가
                    } else      // 1개이상 있는 경우
                        order.put(rank, order.get(rank) + 1);   // 등급, 해당 등급 주문 수 증가
                    if (rank.equals("normal"))      // 등급이 일반일 경우
                        general_total += food.get(order_name);  // 일반 주문 총 가격
                    else if (rank.equals("special"))    // 등급이 특별일 경우
                        special_total += food.get(order_name);  // 특별 주문 총 가격
                }
            }
            if (order.containsKey("special")) { // 특별 주문을 한 경우
                if (general_total < 20000)  // 일반 가격합이 20000미만일 경우
                    answer = "No";
            }
            if (order.containsKey("service")) { // 서비스 주문을 할 경우
                if ((general_total + special_total < 50000))    // 총 5만원 미만일 경우
                    answer = "No";
                else if (order.get("service") > 1)  // 서비스 주문 수가 2이상일 경우
                    answer = "No";
            }
        }

        System.out.println(answer);

    }
}


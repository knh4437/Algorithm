/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#"+test_case+" ");
			String str = sc.nextLine();
			sb.append(func(str) + "\n");
		}
		System.out.print(sb);
	}
	
	private static String func(String str) {
		String result = "";
		String year = str.substring(0,4);
		String month = str.substring(4, 6);
		String day = str.substring(6, 8);
		int tmp_month = Integer.parseInt(month);
		int tmp_day = Integer.parseInt(day);
		if (tmp_month > 12 || tmp_month < 1 || tmp_day < 1 || tmp_day > 31) 
			return "-1";
		
		switch (tmp_month) {
			case 2:
				if (tmp_day > 28)
					return "-1";
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if (tmp_day > 30)
					return "-1";
		}
		result = year + "/" + month +"/" + day;
		return result;
	}
}
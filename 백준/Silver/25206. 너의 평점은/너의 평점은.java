import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int credit_total=0; // 이수 총합
        double grade_total=0;  // 성적 총합

        HashMap<String, Double> map = new HashMap<>() {{
            put("A+", 4.5);
            put("A0", 4.0);
            put("B+", 3.5);
            put("B0", 3.0);
            put("C+", 2.5);
            put("C0", 2.0);
            put("D+", 1.5);
            put("D0", 1.0);
            put("F", 0.0);
        }};

        for(int i=0;i<20;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P"))
                continue;
            credit_total+=credit;
            double grade_score = map.get(grade);
            grade_total += (credit * grade_score);
        }
        System.out.printf("%.6f", grade_total/credit_total);
    }
}

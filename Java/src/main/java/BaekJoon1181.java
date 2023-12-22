import java.util.*;

public class BaekJoon1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[count];

        for(int i=0;i<count;i++) {
            arr[i] = sc.nextLine();
        }

        // 중복 제거
        HashSet<String> dupSet = new HashSet<>(Arrays.asList(arr));
        arr = dupSet.toArray(new String[0]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else if (o1.length() < o2.length())
                    return -1;

                    // 같은 길이일 경우, 사전순
                else if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return 0;
            }
        });

        for(String i : arr) {
            System.out.println(i);
        }
    }
}

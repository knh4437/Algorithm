import java.util.ArrayList;
import java.util.List;

public class grammers01 {

    public static void main(String[] args) {
        int low;
        int high;
        String[] img = {".##.", ".##."};
        String[][] list = separate(img);

        for (int i=0;i<list.length;i++) {
            for (int j=0;j<list[i].length;j++) {
                if (fourBlack(list, i, j))

            }
        }
    }

    public double calPercent(int k, int n) {
        double under = Math.pow(n-2, 2);
        double percent = k * (1/under) * 100;
        return percent;
    }

    public static boolean fourBlack(String[][] list, int width, int index) {
        if (IsBlack(list[width]))
    }

    public static boolean IsBlack(String input) {
        if (input.equals('#'))
            return true;
        return false;
    }

    public static String[][] separate(String[] img) {
        String[][] list = new String[50][50];
        for (int i=0;i<img.length;i++) {
            for (int j=0;j<img[i].length();j++) {
                list[i][j] = img[i].split("")[j];
            }
        }
        return list;
    }
}

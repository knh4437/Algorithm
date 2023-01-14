import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] moveR = { 1, 0, -1, 0 };
    static int[] moveC = { 0, 1, 0, -1 };
    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] endpoint = getEndpoint(bf);
        int result = start(bf, endpoint);
        System.out.println(result);

    }

    private static int[] getEndpoint(BufferedReader bf) throws IOException {
        int[] endpoint = new int[2];
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        endpoint[0] = Integer.parseInt(st.nextToken());
        endpoint[1] = Integer.parseInt(st.nextToken());
        return endpoint;
    }

    private static int start(BufferedReader bf, int[] endpoint) throws IOException {
        int r = endpoint[0];
        int c = endpoint[1];

        boolean[][] visited = new boolean[r][c];
        char[][] cities = new char[r][c];
        ArrayList<Character> visitedCities = new ArrayList<>();
        int result = 1;

        for(int i=0;i<r;i++) {
            String s = bf.readLine();
            cities[i] = s.toCharArray();
        }
        result = find(cities, visited,visitedCities, 0, 0, endpoint, 0, result);
        return result;
    }

    private static int find(char[][] cities, boolean[][] visited, ArrayList<Character> visitedCities, int x, int y, int[] endpoint,int count,int result) {
        count++;
        if (count > result)
            result = count;
        visited[x][y] = true;
        visitedCities.add(cities[x][y]);

        for (int i=0;i<moveR.length;i++) {
            int nextR = x + moveR[i];
            int nextC = y + moveC[i];
            if (nextC < 0 || nextR < 0 || nextR >= endpoint[0] || nextC >= endpoint[1] || visited[nextR][nextC] || visitedCities.contains(cities[nextR][nextC]))
                continue;
            int r = find(cities, visited,visitedCities, nextR,nextC, endpoint, count, result);
            if (r > result)
                result = r;
            visited[nextR][nextC] = false;
            if (visitedCities.size() > 1) {
                visitedCities.remove(visitedCities.size() - 1);
            }
        }
        return result;
    }

}

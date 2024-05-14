import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class 백준_2667_단지번호붙이기 {
    static int[][] arr;
    static int N;
    static boolean[][] visited;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> houseCounts = new ArrayList<>();

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        // 배열 생성
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                int temp = line.charAt(j) - '0';
                arr[i][j] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0 && visited[i][j] == false) {
                    int houseCount = dfs(i,j);
                    houseCounts.add(houseCount);
                }
            }
        }
        Collections.sort(houseCounts);

        System.out.println(houseCounts.size());

        for (int h : houseCounts) {
            System.out.println(h);
        }
    }

    private static int dfs(int a, int b) {
        visited[a][b] = true;
        int sum = 1;

        for (int i = 0; i < 4; i++) {
            int newA = a + dx[i];
            int newB = b + dy[i];

            if (newA >= 0 && newA < N && newB >=0 && newB < N && arr[newA][newB] != 0 && visited[newA][newB] == false) {
                sum += dfs(newA, newB);
            }
        }
        return sum;
    }
}
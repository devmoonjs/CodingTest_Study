import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1012_유기농배추 {
    static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] visited;
    static Queue<Point> q;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static int count;
    static int[][] arr;

    private static void BFS(int a, int b) {
        count++;
        visited[a][b] = true;
        q.add(new Point(a,b));

        while(!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int newA = p.x + dx[i];
                int newB = p.y + dy[i];

                if (newA >= 0 && newA < N && newB >= 0 && newB < M) {
                    if (arr[newA][newB] == 1 && !visited[newA][newB]) {
                        q.add(new Point(newA, newB));
                        visited[newA][newB] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[b][a] = 1;
            }
            q = new LinkedList<Point>();
            for (int i = 0 ; i < N; i++) {
                for (int j = 0 ;j < M; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        BFS(i,j);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}

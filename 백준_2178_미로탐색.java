import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2178_미로탐색 {
    static Queue<Point> q;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int count = 1;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        q = new LinkedList<Point>();

        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        // 미로 생성
        for (int i = 1; i < N+1; i++) {
            String str = br.readLine();
            for (int j = 1; j < M+1; j++) {
                int temp = str.charAt(j-1) - '0';
                arr[i][j] = temp;
            }
        }
        BFS(1,1);
        System.out.println(arr[N][M]);
    }

    private static void BFS(int a, int b) {
        q.add(new Point(a,b));
        visited[a][b] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int newA = p.a + dx[i];
                int newB = p.b + dy[i];

                if (newA > 0 && newA <= N && newB > 0 && newB <= M) {
                    if (arr[newA][newB] == 1  && !visited[newA][newB]) {
                        q.add(new Point(newA, newB));
                        visited[newA][newB] = true;
                        arr[newA][newB] = arr[p.a][p.b]+ 1;
                    }
                }
            }
        }
    }
}

class Point{
    int a;
    int b;

    Point(int a, int b){
        this.a = a;
        this.b = b;
    }
}
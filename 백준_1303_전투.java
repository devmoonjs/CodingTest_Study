import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1303_전투 {
    static char[][] arr; // 문제에서 주어지는 전쟁터 배열을 저장
    static boolean[][] visited; // 방문 처리 배열
    static int[] dx = {1, 0, -1, 0}; // 상하좌우 움직임을 위한 요소
    static int[] dy = {0, 1, 0, -1};
    static int M; // 전쟁터의 가로 크기
    static int N; // 전쟁터의 세로 크기
    static int count = 0;
    static int wCount = 0; // W 수를 담을 변수
    static int bCount = 0; // B 수를 담을 변수

    private static void DFS(int a, int b, char color) { // color 을 매개변수로 받는다!
        visited[a][b] = true;
        count +=1;

        for (int i =0; i < 4; i++) {
            int newA = a + dx[i];
            int newB = b + dy[i];

            // 이동한 곳이 매개변수로 들어온 color 와 같은지 함께 확인
            if (newA >= 0 && newA < M && newB >=0 && newB < N && arr[newA][newB] == color) {
                if (!visited[newA][newB]) {
                    DFS(newA, newB, arr[newA][newB]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    char color = arr[i][j];
                    count = 0; // 새로운 DFS를 돌 때마다 color가 달라질 수 있으므로 count를 여기서 초기화 해줌.
                    DFS(i, j, color);

                    if (color == 'W') { // DFS 가 완료된 후 어떤 컬러에서 탐색되어 나온 건지에 따라 나눠서 진행
                        wCount += count * count;
                    }
                    else {
                        bCount += count * count;
                    }
                }
            }
        }
        System.out.println(wCount + " " + bCount);
    }
}
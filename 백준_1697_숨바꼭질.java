import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1697_숨바꼭질 {

    static Queue<Integer> q = new LinkedList<Integer>();
    static boolean[] visited = new boolean[100001];
    static int N;
    static int K;
    static int count = 0;

    private static void BFS(int a) {
        q.add(a);
        visited[a] = true;

        if (a-1 == K || a+1 == K || a*2 == K) {
            System.out.println(0);
            return;
        }

        while(!q.isEmpty()) {
            int x = q.poll();
            count++;

            if (x-1 == K || x+1 == K || x*2 == K) {
                System.out.println(count);
                return;
            }

            if (x-1 > 0 && !visited[x-1]) {
                q.add(x-1);
                visited[x-1] = true;
            }

            if (x+1 < 100001 && !visited[x+1]) {
                q.add(x+1);
                visited[x+1] = true;
            }

            if (x*2 < 100001 && !visited[x*2]) {
                q.add(x*2);
                visited[x*2] = true;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS(N);


    }
}
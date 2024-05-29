import java.io.*;
import java.util.*;

public class 백준_1890_점프 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][N];
        int[][] memo = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        memo[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0 || memo[i][j] == 0) continue;

                int jump = dp[i][j];

                if (i + jump < N) {
                    memo[i + jump][j] += memo[i][j];
                }

                if (j + jump < N) {
                    memo[i][j + jump] += memo[i][j];
                }
            }
        }
        System.out.println(memo[N-1][N-1]);
    }
}

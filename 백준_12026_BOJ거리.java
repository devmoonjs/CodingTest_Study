import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준_12026_BOJ거리 {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String blocks = br.readLine();

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (canJump(blocks.charAt(i), blocks.charAt(j)) && dp[i] != Integer.MAX_VALUE) {
                    int energe = (j-i) * (j-i);
                    dp[j] = Math.min(dp[j], dp[i] + energe);
                }
            }
        }

        if (dp[N-1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N-1]);
        }
    }

    private static boolean canJump(char from, char to) {
        if (from == 'B' && to == 'O') return true;
        if (from == 'O' && to == 'J') return true;
        if (from == 'J' && to == 'B') return true;

        return false;
    }
}
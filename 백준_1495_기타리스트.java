import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1495_기타리스트 {
    public static int n, s, m, vol[], dp[][];

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        vol = new int[n];
        dp = new int[n][m+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            vol[i] = Integer.parseInt(st.nextToken());
        }

        // 첫번째 곡은 먼저 계산 , 더하고 뺀 값이 허용 범위라면 dp배열에 1을 저장
        if (s + vol[0] <= m) {
            dp[0][s+vol[0]] = 1; //첫번째 곡의 start 볼륨 + vol[0] 의 볼륨을 더
        }

        if (s - vol[0] >= 0) {
            dp[0][s-vol[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            calc(i);
        }

        int result = getMaxVol();
        System.out.println(result);
    }

    private static void calc(int cur) {
        int i, changeVol = vol[cur], prev = cur-1;
        for (i = 0; i <= m; i++) {
            if (dp[prev][i] == 1) {
                if (i + changeVol <= m) {
                    dp[cur][i+changeVol] = 1;
                }
                if (i - changeVol >= 0) {
                    dp[cur][i-changeVol] = 1;
                }
            }
        }
    }

    private static int getMaxVol() {
        for (int i =m; i >=0; i--) {
            if (dp[n-1][i] == 1) return i;
        }
        return -1;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준_10815_숫자카드 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                q.add(new int[]{i, arr[i]});
            }
            Arrays.sort(arr);
            int max = arr[N - 1];
            int cnt = 0;
            while (!q.isEmpty()) {
                int[] tempArr = q.poll();
                if (tempArr[1] < max) {
                    q.add(tempArr);

                } else if (tempArr[1] == max) {
                    cnt++;
                    if (tempArr[0] == M) {
                        sb.append(cnt).append("\n");
                        break;
                    } else {
                        max = arr[N - 1 - cnt];
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준_2217_로프 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int cnt = 1;
        int max = 0;
        int[] result = new int[N+1];

        for (int i = N-1; i >= 0; i--) {

            int temp = cnt * arr[i];
            result[cnt] = temp;

            if (temp <= max) {
                System.out.println(result[cnt]);
                return;

            } else {
                max = temp;
                cnt++;
            }
        }
        System.out.println(result[cnt-1]);
    }
}

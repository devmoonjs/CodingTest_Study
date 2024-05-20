import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_11047_동전 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        while(K > 0) {
            for (int i = N-1; i >= 0; i--) {
                if (arr[i] <= K) {
                    count += K / arr[i];
                    K %= arr[i];
                }
            }
        }
        System.out.println(count);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B.length; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            if (N < M) {
                for (int i = 0; i < M - N + 1; i++) {
                    int temp = 0;
                    for (int j = 0; j < N; j++) {
                        temp += A[j] * B[i + j];
                    }
                    answer = Math.max(answer, temp);
                }
            } else if (N > M) {
                for (int i = 0; i < N - M; i++) {
                    int temp = 0;
                    for (int j = 0; j < M; j++) {
                        temp += A[i + j] * B[j];
                    }
                    answer = Math.max(answer, temp);
                }
            }
            else {
                int temp = 0;
                for (int i = 0; i < N; i++) {
                    temp += A[i] * B[i];
                }
                answer = Math.max(answer, temp);
            }
            System.out.print("#" + test_case + " " + answer);
        }
    }
}



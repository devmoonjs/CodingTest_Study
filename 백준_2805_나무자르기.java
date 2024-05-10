import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int min = 0;
        for (int i = 0; i < N; i++) { // 나무의 길이들 배열에 저장
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        while (min <= max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (int tree : arr) {
                // 자른 나무 길이 합 구하기
                if (tree - mid > 0) {
                    sum += tree - mid;
                }
            }
            // 자른 나무 길이의 합이 원하는 길이보다 적다면, 이진탐색에서 왼쪽 배열과 동일. 따라서 end 포인트를 mid - 1
            if (sum < M) {
                max = mid - 1;

                // 자른 나무 길이의 합이 원하는 길이보다 크다면, 이진탐색에서 오른쪽. 따라서 start 포인트를 mid + 1
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
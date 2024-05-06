import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1158_요세푸스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> result = new LinkedList<>(); // 출력될 결과를 저장할 큐
        Queue<Integer> queue = new LinkedList<>(); // 입력에 사용될 큐

        // 큐 자료구조에 값 입력
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // K 번째 카운팅을 위해 cnt 변수 선언
        int cnt = 1;
        while (!queue.isEmpty()) {
            if (cnt < K) {
                int temp = queue.poll();
                queue.add(temp);
                cnt++;

            } else if (cnt == K) { // K 번째가 되었을 경우 result 큐에 저장
                cnt = 1;
                result.add(queue.poll());
            } else if (queue.size() < K) { // 큐가 K보다 적을 경우 전부 result 저장
                result.add(queue.poll());
            }
        }

        // 출력
        System.out.print("<");
        for (int i = 0; i < N; i++) {
            System.out.print(result.poll());
            if (!result.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }
}
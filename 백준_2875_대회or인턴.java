import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2875_대회or인턴 {

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 여학생 수
        int M = Integer.parseInt(st.nextToken()); // 남학생 수
        int K = Integer.parseInt(st.nextToken()); // 인턴쉽에 참여해야 하는 학생 수

        // 팀을 구성할 수 있는 최대 수를 계산
        int cnt = 0;

        // 가능한 최대 팀 수를 구하는 반복문
        while (N >= 2 && M >= 1 && N + M >= K + 3) {
            N -= 2;
            M -= 1;
            cnt++;
        }

        System.out.println(cnt);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_4796_캠핑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNumber = 1;

        while (true) {
            // 한 줄씩 입력 받기
            String line = br.readLine();
            String[] parts = line.split(" ");

            int L = Integer.parseInt(parts[0]);
            int P = Integer.parseInt(parts[1]);
            int V = Integer.parseInt(parts[2]);

            // 종료 조건
            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            // 캠핑장을 최대 며칠동안 사용할 수 있는지 계산
            int fullCycles = V / P; // V일을 P일씩 나눈 전체 사이클 수
            int remainingDays = V % P; // 남은 날 수
            int maxCampingDays = fullCycles * L + Math.min(remainingDays, L); // 최대 캠핑 가능 일수

            // 결과 출력
            System.out.println("Case " + caseNumber + ": " + maxCampingDays);
            caseNumber++;
        }

        br.close();
    }
}
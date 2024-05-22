import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_1931_회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetArr = new Meeting[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long start = Integer.parseInt(st.nextToken());
            long end = Integer.parseInt(st.nextToken());

            meetArr[i] = new Meeting(start, end);
        }

        Arrays.sort(meetArr);

        int count = 0;
        long preEnd = 0;

        for (int i = 0 ; i < N; i++) {
            if (preEnd <= meetArr[i].start) {
                count++;
                preEnd = meetArr[i].end;
            }
        }

        System.out.println(count);

    }

}

class Meeting implements Comparable<Meeting> {
    long start;
    long end;

    public Meeting(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        // -1 이 되면 오름차순 / 1이 되면 내림차순
        if (this.end == o.end) {
            return Long.compare(this.start, o.start);
        }
        return Long.compare(this.end, o.end);
    }
}

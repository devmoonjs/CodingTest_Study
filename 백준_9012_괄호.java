import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            boolean result = true;
            Stack<Character> stack = new Stack<>();
            String temp = br.readLine();

            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                if (c == '(') {
                    stack.add(c);
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        result = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!result || !stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }
    }
}
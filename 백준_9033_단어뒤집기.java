import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_9033_단어뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String sentence = br.readLine();
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i <sentence.length() ; i++) {
                if (sentence.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                } else {
                    stack.add(sentence.charAt(i));
                }
            }
            while (!stack.isEmpty()) { // 마지막 단어는 뒤에 공백이 없으므로
                sb.append(stack.pop());
            }
            System.out.println(sb);
        }
    }
}
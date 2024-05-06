import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] tokens = input.split(" ");
            String command = tokens[0];

            // push 명령
            if (command.equals("push")) {
                int temp = Integer.parseInt(tokens[1]);
                stack.push(temp);
            }

            // pop 명령
            if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    int value = stack.pop();
                    System.out.println(value);
                }
            }

            // size 명령
            if (command.equals("size")) {
                int size = stack.size();
                System.out.println(size);
            }

            // empty 명령
            if (command.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }

            // top 명령
            if (command.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    int top = stack.peek();
                    System.out.println(top);
                }
            }
        }
        br.close();
    }
}
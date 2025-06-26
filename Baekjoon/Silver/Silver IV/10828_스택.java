import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 스택
 *  - 번호 : 10828
 *  - 링크 : https://www.acmicpc.net/problem/10828
 * 2. 풀이핵심
 *  - 스택 자료구조와 메서드
 * 3. 풀이후기
 *  - Java의 스택 자료구조에 대해서 알고 있다면 어려울게 없다.
 *  - switch case문을 사용해서 구현
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<Integer> stack = new Stack<Integer>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int result = 0;

            while(st.hasMoreTokens()) {
                String command = st.nextToken();

                switch(command) {
                    case "push":
                        stack.push(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop":
                        sb.append(stack.isEmpty() ? -1 : stack.pop());
                        break;
                    case "size":
                        sb.append(stack.size());
                        break;
                    case "empty":
                        sb.append(stack.isEmpty() ? 1 : 0);
                        break;
                    case "top":
                        sb.append(stack.isEmpty() ? -1 : stack.peek());
                        break;
                }
                if(!command.equals("push")) {
                    sb.append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}
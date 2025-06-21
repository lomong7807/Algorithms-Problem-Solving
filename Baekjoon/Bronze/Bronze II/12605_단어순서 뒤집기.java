import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 수 정렬하기
 *  - 번호 : 12605
 *  - 링크 : https://www.acmicpc.net/problem/12605
 * 2. 풀이핵심
 *  - 문자열 자르기
 *  - stack
 * 3. 풀이후기
 *  - 반복문으로 charAt()을 사용해 뒤집을 수 있지만, FILO(First In Last Out) 자료구조인 Stack을 사용해 처리해봄
 *  - Java에서 Stack 자료구조를 딱히 사용해본 적이 없는데, 뒤집을 때 사용하니 매우 좋다.
 *  - push/pop으로 자료를 넣고 빼줌
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append("Case #").append(i + 1).append(": ");

            Stack<String> stack = new Stack<>();
            
            while(st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }
            while(!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
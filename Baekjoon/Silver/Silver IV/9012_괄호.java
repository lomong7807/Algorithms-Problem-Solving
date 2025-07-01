import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 괄호
 *  - 번호 : 9012
 *  - 링크 : https://www.acmicpc.net/problem/9012
 * 2. 풀이핵심
 *  - Stack 자료구조
 *  - 하지만 Deque
 * 3. 풀이후기
 *  - 괄호 여닫기는 애초에 stack을 공부할때 예시로 나온거라 바로 생각이 났음
 *  - 그런데 조건문을 정확히 어떻게 짜야되는지에서 한참 걸렸다. 머리가 나쁜거같음
 *  - 결국 조건은 아래처럼 짜야한다.
 *    1. '('일때는 stack에 넣어줌
 *    2. ')'인데 stack이 비어있으면 ')'이 더 많은거라 조건 false로 끝
 *    3. ')'인데 stack에 괄호가 있으면 그걸 매칭시켜서 없애줌
 *    4. '('만 계속 들어올 수도 있으므로 마지막 조건에 stack이 비어있어야 "YES"를 출력하게끔 추가
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            sb.append(isMatch(str)).append("\n");
        }

        System.out.print(sb);
    }
    
    public static String isMatch(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == '(') {
                stack.push(c);
            }else if(stack.isEmpty()) {
                return "NO";
            }else {
                stack.pop();
            }
        }
        
        if(stack.isEmpty()) {
            return "YES";
        }else {
            return "NO";
        }
    }
}
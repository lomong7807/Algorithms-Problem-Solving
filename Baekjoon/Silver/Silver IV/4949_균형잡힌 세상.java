import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 균형잡힌 세상
 *  - 번호 : 4949
 *  - 링크 : https://www.acmicpc.net/problem/4949
 * 2. 풀이핵심
 *  - Stack 자료구조
 *  - 하지만 Deque
 * 3. 풀이후기
 *  - 9012_괄호 문제와 비슷하지만 괄호가 하나 더 추가됐다.
 *  - 처음에 아무 생각 없이 StringTokenizer를 사용했는데, 굳이 필요 없었음.
 *  - 그냥 문자열 전체를 보면 되는건데 굳이 StringToknizer로 문장을 잘라서 하느라 더 복잡했다.
 *  - 문제를 잘 읽자
 */

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        while(!s.equals(".")) {
            sb.append(solve(s)).append("\n");
            
            s = br.readLine();
        }
        
        System.out.print(sb);
    }
    
    public static String solve(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            // 여는 괄호일 경우 stack에 넣기
            if(isOpen(c)) {
                stack.push(c);
            // 닫는 괄호일 경우
            }else if(isClose(c)) {
                // 닫는 괄호가 들어왔는데 stack에 여는 괄호가 없을 경우 이미 잘못됐기 때문에 no
                if(stack.isEmpty()) {
                    return "no";
                }else {
                    // 닫는 괄호와 그 전에 들어온 괄호가 매칭이 될 경우 stack에서 괄호를 없애줌
                    if(match(stack, c)) {
                        stack.pollFirst();
                    // 닫는 괄호와 그 전에 들어온 괄호가 매칭이 안 될 경우 이미 잘못됐기 때문에 no
                    }else {
                        return "no";
                    }
                }
            }
        }
        
        if(stack.isEmpty()) {
            return "yes";
        // 문장이 끝났는데도 stack에 괄호가 남아있을 경우 no
        }else {
            return "no";
        }
    }
    
    public static boolean match(Deque<Character> stack, char c) {
        if(c == ']') {
            return stack.peekFirst() == '[';
        }else {
            return stack.peekFirst() == '(';
        }
    }
    
    public static boolean isOpen(char c) {
        return (c == '[' || c == '(');
    }
    
    public static boolean isClose(char c) {
        return (c == ']' || c == ')');
    }
}
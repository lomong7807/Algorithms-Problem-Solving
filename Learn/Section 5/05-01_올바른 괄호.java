import java.io.*;
import java.util.*;
/*
 * 문제: 괄호가 입력됐을때 올바른 괄호이면 "YES", 올바르지 않으면 "NO"를 출력
 * 입력: 첫 줄에 괄호 문자열이 입력. 문자열의 최대 길이는 30
 * 출력: YES or NO
 * 풀이후기:
 *  - Deque 자료구조를 Stack으로 사용한다.
 *  - Stack 자료구조를 사용하는 가장 기본적인 괄호 문제
 *  - 마지막에 비어있는지 체크까지 꼭 해주자. 이 부분에서 항상 틀린다.
 * */

public class Main {

    public static String solution(String s) {
        String answer = "YES";
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
                continue;
            }

            if(stack.isEmpty()) {
                return "NO";
            }else {
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            return "NO";
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.print(solution(s));
    }
}
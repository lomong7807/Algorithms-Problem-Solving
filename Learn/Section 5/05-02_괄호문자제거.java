import java.io.*;
import java.util.*;
/*
 * 문제: 입력된 문자열에서 소괄호 () 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램
 * 입력: 첫 줄에 길이가 100을 넘지 않는 문자열
 * 출력: 남은 문자
 * 풀이후기:
 *  - Deque 자료구조를 Stack으로 사용한다.
 *  - Stack 자료구조를 사용하는 가장 기본적인 괄호 문제
 *  - 문제가 좀 애매해서 아주 보수적으로 풀었는데, 간단한 문제였음
 *  - 처음에 ) 괄호로 시작한다거나 문자열 끝에 괄호가 남는 경우까지 생각했는데 아니었음..
 *  - 추가로 문자열을 순서대로 출력해야 되는데 stack은 마지막에 들어온 문자부터 출력하므로
 *    stack 기준에서 제일 마지막의 원소부터 출력해줘야 한다.
 * */

public class Main {

    public static String solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(c == ')') {
                while(stack.pop() != '(') {
                    if(stack.pop() == '(') break;
                }
            }else {
                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.print(solution(s));
    }
}
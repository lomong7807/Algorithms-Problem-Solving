import java.io.*;
import java.util.*;
/*
 * 문제: 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램
        만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12이다.
 * 입력: 첫 줄에 후위연산식이 주어진다. 연산식의 길이는 50을 넘지 않는다.
        식은 1~9의 숫자와 +,-,*,/ 연산자로만 이루어진다.
 * 출력: 연산한 결과 출력
 * 풀이후기:
 *  - Deque 자료구조를 Stack으로 사용한다.
 *  - 어려울거 없었음
 *  - 근데 Character.isDigit()과 같은 함수를 자꾸 까먹는다. 기억해두자.
 * */

public class Main {

    public static int solution(String s) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                stack.push(c - '0');
            }else {
                int m = stack.pop();
                int n = stack.pop();
                stack.push(calculate(n, m, c));
            }
        }

        if(!stack.isEmpty()) {
            answer = stack.pop();
        }

        return answer;
    }

    public static int calculate(int n, int m, char c) {
        if(c == '*') {
            return n * m;
        }else if(c == '+') {
            return n + m;
        }else if(c == '-') {
            return n - m;
        }else {
            return n / m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.print(solution(s));
    }
}
import java.io.*;
import java.util.*;
/*
 * 문제: 여러 개의 쇠막대기를 레이저로 절단하는데, 효율적인 작업을 위해 쇠막대기를 아래에서 위로 겹쳐 놓고,
        레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.
        - 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
        - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.
        - 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
        - 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
 * 입력: 한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 개수는 최대 100,000이다.
 * 출력: 잘려진 조각의 총 개수
 * 풀이후기:
 *  - Deque 자료구조를 Stack으로 사용한다.
 *  - 제일 위에 있는 쇠막대기가 끝났을때의 조건을 생각하지 못했다.
 *  - 제일 위의 쇠막대기가 끝났을 때는 해당 쇠막대기의 우측 끝부분이 남게 되므로 쇠막대기가 끝나는 조건을 확인하여 1을 더해줘야 함.
 *  - 이런 괄호 문제가 나오면 거의 대부분 여는 괄호 '('는 일단 stack에 넣어주면 되는거 같음
 * */

public class Main {

    public static int solution(String s) {
        int answer = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            }else {
                stack.pop();
                if(s.charAt(i - 1) == '(') {
                    answer += stack.size();
                }else {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.print(solution(s));
    }
}
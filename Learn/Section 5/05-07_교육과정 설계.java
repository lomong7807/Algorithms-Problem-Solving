import java.io.*;
import java.util.*;
/*
 * 문제: 현수는 1년 과정의 수업계획을 짜야 한다. 수업중에는 필수과목이 있는데, 이 필수과목은 반드시 이수해야 하며, 들어야되는 순서도 정해져 있다.
        만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 C, B, A로 주어지면 필수과목은 C, B, A이며 이 순서대로 수업계획을 짜야 한다.
        여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것이다.
        현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만,
        C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이다.
        수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작한다는 것으로 해석한다.
        수업계획서상의 각 과목은 무조건 이수된다고 가정한다.
        필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 "YES", 잘못된 것이면 "NO"
 * 입력: 첫 줄에 필수과목의 순서가 주어진다. 모든 과목은 영문 대문자
        두 번째 줄부터 현수가 짠 수업설계가 주어진다. (수업설계의 길이는 30 이하)
 * 출력: 첫 줄에 수업설계가 잘된 것이면 "YES", 잘못된 것이면 "NO"
 * 풀이후기:
 *  - Deque 자료구조를 Queue으로 사용한다.
 *  - 어려운 내용이 없는데 생각하는데 너무 오래 걸렸음.
 *  - 필수과목을 queue에 순서대로 담고, 수업계획을 순회하면서 가장 위에 있는 값을 확인하여 계속 빼주면 됨.
 *  - 필수과목과 수업계획의 순서가 일치하면 수업계획을 순회했을때 Queue는 빈 자료구조가 될 것이다.
 * */

public class Main {

    public static String solution(String s, String clazz) {
        String answer = "NO";
        Deque<Character> queue = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            queue.add(c);
        }

        for(char c : clazz.toCharArray()) {
            if(!queue.isEmpty() && queue.peek() == c) {
                queue.poll();
            }else if(queue.isEmpty()) {
                return "YES";
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String clazz = br.readLine();

        System.out.print(solution(s, clazz));
    }
}
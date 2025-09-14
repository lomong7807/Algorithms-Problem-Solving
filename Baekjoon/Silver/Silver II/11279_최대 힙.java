import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 최대 힙
 *  - 번호 : 11279
 *  - 링크 : https://www.acmicpc.net/problem/11279
 * 2. 풀이핵심
 *  - 우선순위 큐
 * 3. 풀이후기
 *  - 우선순위 큐라는 자료구조가 있는지 몰랐어서 푸는데 꽤 많이 돌아갔다.
 *  - PriorityQueue라는 자료구조가 있어 해당 자료구조에 오름차순으로 설정을 해주면 큰 수가 가장 앞에 오게 된다.
 *  - 매우 쉬운 문제였다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> Q = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                if(Q.isEmpty()) {
                    sb.append(0).append("\n");
                }else {
                    sb.append(Q.poll()).append("\n");
                }
            }else {
                Q.offer(input);
            }
        }

        System.out.print(sb);
    }
}
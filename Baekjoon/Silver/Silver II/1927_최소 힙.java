import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 최소 힙
 *  - 번호 : 1927
 *  - 링크 : https://www.acmicpc.net/problem/1927
 * 2. 풀이핵심
 *  - 우선순위 큐
 * 3. 풀이후기
 *  - Java의 자료구조인 우선순위 큐를 알고 있다면 매우 쉬운 문제다.
 *  - PriorityQueue라는 자료구조가 있어 해당 자료구조는 기본적으로 내림차순 정렬이 돼있다.
 *  - 이전에 풀었던 11279_최대 힙 문제와 똑같다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> Q = new PriorityQueue<Integer>();

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
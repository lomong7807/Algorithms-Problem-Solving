import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 최소 힙
 *  - 번호 : 11286
 *  - 링크 : https://www.acmicpc.net/problem/11286
 * 2. 풀이핵심
 *  - 우선순위 큐
 * 3. 풀이후기
 *  - Java의 자료구조인 우선순위 큐를 알고 있다면 매우 쉬운 문제다.
 *  - PriorityQueue라는 자료구조가 있어 해당 자료구조는 기본적으로 내림차순 정렬이 돼있다.
 *  - 여기서 익명 클래스를 정의해서 순서를 원하는대로 만들 수 있다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

/*
        // 익명 클래스로 일회성 구현
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                }else if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }else {
                    return -1;
                }
            }
        });
*/
        // 명확한 람다 표현식 사용
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>((o1, o2) -> {
                if(Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
                }else if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }else {
                    return -1;
                }
        });
/*

        // 람다 표현식 사용
        PriorityQueue<Integer> Q = new PriorityQueue<>(
                Comparator.comparingInt((Integer x) -> Math.abs(x))
                        .thenComparingInt(Integer::intValue)
        );
*/
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
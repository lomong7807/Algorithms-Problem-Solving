import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 요세푸스 문제 0
 *  - 번호 : 11866
 *  - 링크 : https://www.acmicpc.net/problem/11866
 * 2. 풀이핵심
 *  - Queue
 * 3. 풀이후기
 *  - Queue 자료구조를 사용한 문제
 *  - 이전에 풀어본적 있는 유형의 문제라 어렵지 않았음. 확실히 문제를 많이 풀면서 다양한 유형을 마주해보는게 도움이 된다.
 */

public class Main {

    public static String solution(int n, int k) {
        StringBuilder sb = new StringBuilder();

        Deque<Integer> Q = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            Q.add(i);
        }

        int count = 0;
        sb.append("<");
        while(1 < Q.size()) {
            int tmp = Q.poll();
            count++;
            if(count == k) {
                sb.append(tmp).append(", ");
                count = 0;
                continue;
            }
            Q.add(tmp);
        }
        sb.append(Q.poll()).append(">");

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.print(solution(n, k));
    }
}
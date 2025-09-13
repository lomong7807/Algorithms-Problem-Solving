import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 최대 힙
 *  - 번호 : 11279
 *  - 링크 : https://www.acmicpc.net/problem/11279
 * 2. 풀이핵심
 *  - 
 * 3. 풀이후기
 *  - 
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int max = 0;

        Queue<Integer> Q = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            
            if(input == 0) {
                if(Q.isEmpty()) {
                    sb.append(0).append("\n");
                }else {
                    while(true) {
                        int cur = Q.poll();

                        if(cur == max) {
                            sb.append(cur).append("\n");
                            break;
                        }

                        Q.offer(cur);
                    }
                }
            }else {
                max = Math.max(max, input);
                Q.offer(input);
            }
        }

        System.out.print(sb);
    }
}
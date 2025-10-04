import java.util.*;
import java.io.*;
/**
 * 1. 문제정보
 *  - 제목 : 파도반 수열
 *  - 번호 : 9461
 *  - 링크 : https://www.acmicpc.net/problem/9461
 * 2. 풀이핵심
 *  - DP
 * 3. 풀이후기
 *  - dfs로 다시 풀어봐야겠다.
 */

public class Main {

    static Long[] memo = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        memo[1] = 1L;
        memo[2] = 1L;
        memo[3] = 1L;

        for(int i = 4; i <= 100; i++) {
            memo[i] = memo[i-2] + memo[i-3];
        }

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(memo[n]).append("\n");
        }


        System.out.println(sb);
    }
}
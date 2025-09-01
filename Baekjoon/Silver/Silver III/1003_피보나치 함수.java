import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 비밀번호 찾기
 *  - 번호 : 17219
 *  - 링크 : https://www.acmicpc.net/problem/17219
 * 2. 풀이핵심
 *  - 맵
 * 3. 풀이후기
 *  - 어렵지 않은 문제였음
 */

public class Main {

    static Integer[][] memo = new Integer[41][2];
    
    public static int dfs(int n) {
        if(memo[n][0] == null || memo[n][1] == null) {
            memo[n][0] = dfs(n - 1) + dfs(n - 2);
            memo[n][1] = dfs(n - 1) + dfs(n - 2);
        }

        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dfs(n);
            sb.append(memo[n][0]).append(" ").append(memo[n][1]).append("\n");
        }

        System.out.print(sb);
    }
}
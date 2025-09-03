import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 계단 오르기
 *  - 번호 : 2579
 *  - 링크 : https://www.acmicpc.net/problem/2579
 * 2. 풀이핵심
 *  - 맵
 * 3. 풀이후기
 *  - 어렵지 않은 문제였음
 */

public class Main {

    static Integer[] dp;
    static int[] arr;

    public static int dfs(int n) {
        if(dp[n] == null) {
            dp[n] = Math.max(dfs(n - 2), dfs(n - 3) + arr[n - 1]) + arr[n];
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new Integer[n + 1];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if(2 <= n) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.print(dfs(n));
    }
}
import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 계단 오르기
 *  - 번호 : 2579
 *  - 링크 : https://www.acmicpc.net/problem/2579
 * 2. 풀이핵심
 *  - 
 * 3. 풀이후기
 *  - 
 */

public class Main {

    static int n;
    static Integer[] dp;
    static int[] arr;

    public static int dfs(int n) {
        if(dp[n] == null) {
            dp[n] = 
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new Integer[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 계단이 1개 또는 2개밖에 없을때 예외 처리
        if(n == 1) {
            System.out.println(stairs[1]);
            return;
        }
        if(n == 2) {
            System.out.println(stairs[1] + stairs[2]);
            return;
        }

        int result = Math.max(dfs(n, 0), dfs(n, 1));
        System.out.print(result);
    }
}
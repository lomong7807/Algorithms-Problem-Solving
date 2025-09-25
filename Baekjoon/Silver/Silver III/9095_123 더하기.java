import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 1, 2, 3 더하기
 *  - 번호 : 9095
 *  - 링크 : https://www.acmicpc.net/problem/9095
 * 2. 풀이핵심
 *  - 맵
 * 3. 풀이후기
 *  - 어렵지 않은 문제였음
 */

public class Main {

    static int count;
    static Integer[] dp = new Integer[12];

    public static void dfs(int sum, int max) {
        if(dp[sum] != null) return;
        if(sum > max) return;
        if(sum == max) {
            count++;
        } else {
            for(int i = 1; i <= 3; i++) {
                dfs(sum + i, max);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int[] arr = new int[t];
        for(int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int n : arr) {
            count = 0;

            dfs(0, n);
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
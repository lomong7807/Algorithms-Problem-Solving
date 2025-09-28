import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 1, 2, 3 더하기
 *  - 번호 : 9095
 *  - 링크 : https://www.acmicpc.net/problem/9095
 * 2. 풀이핵심
 *  - dfs or dp
 * 3. 풀이후기
 *  - dfs로는 바로 생각이 났는데 dp로는 바로 어떻게 풀어야될지 몰라서 dp는 풀이를 찾아봤다..
 *  - 점화식으로 풀어야되는데 이게 이해가 잘 안갔음
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[11];

        // DP 테이블 미리 계산 (최대 11까지)
        dp[1] = 1; // 1을 만드는 방법: (1)
        dp[2] = 2; // 2를 만드는 방법: (1 + 1), (2)
        dp[3] = 4; // 3을 만드는 방법: (1+1+1), (1+2), (2+1), (3)

        for(int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}

/* dfs
public class Main {

    static int count;

    public static void dfs(int sum, int max) {
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
*/
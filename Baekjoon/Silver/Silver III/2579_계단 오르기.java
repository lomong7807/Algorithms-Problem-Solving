import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 계단 오르기
 *  - 번호 : 2579
 *  - 링크 : https://www.acmicpc.net/problem/2579
 * 2. 풀이핵심
 *  - dfs
 *  - 메모이제이션
 * 3. 풀이후기
 *  - dfs 연습이 매우 많이 필요할듯 하다.
 */

public class Main {

    static int n;
    static Integer[][] dp;
    static int[] stairs;

    /*
    * @param step: 현재 계단 번호
    * @param jumpType: 현재 계단에 도달한 방식(0: 2칸 점프, 1: 1칸 점프)
    * @return 해당 계단에 해당 방식으로 도달했을 때의 최대 점수
    * */
    public static int dfs(int step, int jumpType) {
        // 기저 조건
        if(step == 1) {
            return jumpType == 1 ? stairs[1] : 0; // 1번 계단은 1칸 점프로만 도달 가능
        }
        if(step == 2) {
            if(jumpType == 0) return stairs[2]; // 2칸 점프로 도달
            else return stairs[1] + stairs[2];  // 1칸 점프로 도달
        }

        // 이미 계산된 값이 있으면 반환
        if(dp[step][jumpType] != null) {
            return dp[step][jumpType];
        }

        int result = 0;

        // 현재 계단에 2칸 점프로 도달하는 경우
        if(jumpType == 0) {
            // 2칸 전 계단에서 어떤 방식으로 왔든 상관 없음
            result = Math.max(dfs(step - 2, 0), dfs(step - 2, 1)) + stairs[step];

        // 현재 계단에 1칸 점프로 도달하는 경우    
        }else {
            // 바로 전 계단은 반드시 2칸 점프로 도달해야 함 (연속 3계단 방지)
            result = dfs(step - 1, 0) + stairs[step];
        }

        // 계산 결과 저장 및 반환
        return dp[step][jumpType] = result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stairs = new int[n + 1];
        dp = new Integer[n + 1][2];

        for(int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
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
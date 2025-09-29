import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 구간 합 구하기
 *  - 번호 : 11659
 *  - 링크 : https://www.acmicpc.net/problem/11659
 * 2. 풀이핵심
 *  - dp
 * 3. 풀이후기
 *  - 구간 합이라 처음에는 dfs 먼저 떠올렸고, dfs로 풀어봤지만, 범위가 너무 넓어서 시간 초과 에러
 *  - 분명 dp가 사용될거 같은데.. dfs와 dp를 같이 해도 시간 초과 에러였다.
 *  - 간단하게 생각해서 그냥 바로 dp만 사용해서 풀었더니 해결
 *  - 그리고 처음에는 기본 입력값을 받는 반복분과 누적 합을 구하는 반복분을 나눠뒀는데,
 *    이를 입력값을 배열에 넣을때 바로 누적 합도 계산하여 최적화 함
 *  - 최적화로 평균 650ms -> 평균 520ms
 */

public class Main {

    static int[] arr;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        memo = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        arr[1] = Integer.parseInt(st.nextToken());
        memo[1] = arr[1];
        for(int i = 2; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            memo[i] = memo[i - 1] + arr[i];
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(memo[end] - memo[start - 1]).append("\n");
        }

        System.out.print(sb);
    }
}
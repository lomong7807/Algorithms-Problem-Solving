import java.io.*;
import java.util.*;
/*
 * 문제: 입력받은 n x n의 격자판에서 각 행의 합, 열의 합, 대각선의 합 중 가장 큰 값 출력
 * 입력: 2 <= n <= 50, n x n의 자연수
 * 출력: 가장 큰 합
 * 풀이후기:
 *  - 어려운게 없는 문제
 *  - 풀긴 풀었는데 좀 더 리팩토링하니 처음의 코드보다 코드의 양도 확실히 줄고 보기 더 쉬워졌음
 * */

public class Main {

    public static int solution(int n, int[][] board) {
        int answer = 0;
        int sum1, sum2;

        for(int i = 0; i < n; i++) {
            sum1 = sum2 = 0;

            for(int j = 0; j < n; j++) {
                sum1 += board[i][j];
                sum2 += board[j][i];
            }
            answer = Math.max(answer, Math.max(sum1, sum2));
        }

        sum1 = sum2 = 0;
        for(int i = 0; i < n; i++) {
            sum1 += board[i][i];
            sum2 += board[i][n - i - 1];
        }

        answer = Math.max(answer, Math.max(sum1, sum2));

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(solution(n, board));
    }
}
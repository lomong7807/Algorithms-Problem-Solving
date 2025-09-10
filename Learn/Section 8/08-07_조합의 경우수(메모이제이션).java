import java.io.*;
import java.util.*;
/*
 * 문제: combi(n, r) = combi(n-1, r-1) + combi(n-1, r)이다.
        재귀를 이용해 조합수를 구해주는 프로그램을 작성하라
 * 입력: 첫 번째 줄에 자연수 N(3<=N<=33)과 R(0<=R<=N)이 입력된다.
 * 출력: 첫 번째 줄에 조합수를 출력
 * 풀이후기:
 *  - combi 자체를 이해못했는데 재귀 풀이는 굉장히 간단하다.
 *  - 메모이제이션을 사용한 동적 프로그래밍도 적용해서 수가 커지더라도 해결되게끔 한다.
 * */

public class Main {

    static int[][] board;

    public static int dfs(int n, int r) {
        if(board[n][r] != 0) return board[n][r];
        if(n == r || r == 0) {
            return 1;
        }else {
            return board[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        board = new int[35][35];

        System.out.print(dfs(n, r));
    }
}
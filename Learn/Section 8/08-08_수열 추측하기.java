import java.io.*;
import java.util.*;
/*
 * 문제: 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼
        위의 두개를 더한 값이 저장되게 한다. 예를 들어 N이 4이고 가장 윗 줄에 3 1 2 4가 있다고 했을 때,
        다음과 같은 삼각형이 그려진다.
        3 1 2 4
         4 3 6
          7 9
           16
        N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성.
        단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력해야 한다.
 * 입력: 첫 번째 줄에 두개의 정수 N(1<=N<=10)과 F가 주어진다.
        N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하다.
 * 출력: 첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
        답이 존재하지 않는 경우는 입력으로 주어지지 않는다.
 * 풀이후기:
 *  - 이전 문제에서 풀었던 combi문제의 활용 문제
 *  - 근데 그거랑 다르게 너무 어렵다
 * */

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, f;
    static int[][] board = new int[35][35];
    static int[] b, p, ch;
    boolean flag = false;

    public static int combi(int n, int r) {
        if(0 < board[n][r]) return board[n][r];
        if(n == r || r == 0) {
            return 1;
        }else {
            return board[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

    public static int dfs(int L, int sum) {
        if(flag) return;
        if(L == n) {
            if(sum == f) {
                for(int x : p) {
                    sb.append(x).append(" ");
                }
                sb.append("\n");
                flag = true;
            }
        }else {
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    dfs(L + 1, sum + (p[L]*b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        b = new int[n];
        p = new int[n];
        ch = new int[n];

        for(int i = 0; i < n; i++) {
            b[i] = combi(n - 1, i);
        }

        System.out.print(dfs(0, 0));
    }
}
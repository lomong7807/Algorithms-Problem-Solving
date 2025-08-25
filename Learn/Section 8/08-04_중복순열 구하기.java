import java.io.*;
import java.util.*;
/*
 * 문제: 1부터 N까지 번호가 적힌 구슬이 있다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력
 * 입력: 첫 줄에 자연수 N(3<=N<=10)와 M(2<=M<=N)이 주어진다.
 * 출력: 첫 번째 줄에 결과를 출력한다. 출력순서는 사전순으로 오름차순 출력
 * 풀이후기:
 *  - 이것도 dfs인데 이번에는 true or false가 아니라 여러 갈래로 뻗어나가는 문제였다.
 * */

public class Main {

    static int n, m;
    static boolean[] pm;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int L) {
        if(L == m) {
            for(int x : pm) {
                sb.append(x).append(" ").append("\n");
            }
        }else {
            for(int i = 1; i <= n; i++) {
                pm[L] = i;
                dfs(L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];

        dfs(0);

        System.out.print(sb);
    }
}
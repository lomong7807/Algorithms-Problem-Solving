import java.io.*;
import java.util.*;
/*
 * 문제: 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.
 * 입력: 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
 * 출력: 첫 번째 줄에 결과를 출력합니다.
        출력순서는 사전순으로 오름차순으로 출력합니다.
 * 풀이후기:
 *  - 순열, 조합 구하기에도 일정한 패턴이 있다. 패턴을 잘 익히자.
 * */

public class Main {

    static int n, m;
    static int[] combi;

    public static void dfs(int L, int s) {
        if(L == m) {
            for(int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
        }else {
            for(int i = s; i <= n; i++) {
                combi[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        combi = new int[m];

        dfs(0, 1);
    }
}
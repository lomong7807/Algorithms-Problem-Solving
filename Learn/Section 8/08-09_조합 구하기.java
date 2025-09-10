import java.io.*;
import java.util.*;
/*
 * 문제: 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.
 * 입력: 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
 * 출력: 첫 번째 줄에 결과를 출력합니다.
        출력순서는 사전순으로 오름차순으로 출력합니다.
 * 풀이후기:
 *  - 순열, 조합 구하기에도 일정한 패턴이 있다. 패턴을 잘 익히자.
 *  - 이번에는 중복된 조합은 나와서 안된다.
 *  - 그래서 반복문에서 시작 숫자를 방금 앞에서 나온 숫자보다 더 큰 숫자부터 시작하게끔 설정해야 한다.
 * */

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] pm;

    public static void dfs(int L, int s) {
        if(L == m) {
            for(int x : pm) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }else {
            for(int i = s; i <= n; i++) {
                pm[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];

        dfs(0, 1);

        System.out.print(sb);
    }
}
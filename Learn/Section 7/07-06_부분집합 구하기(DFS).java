import java.io.*;
import java.util.*;
/*
 * 문제: 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램
 * 입력: 첫 번째 줄에 자연수 N(1<=N<=10)
 * 출력: 첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
 *      단 공집합은 출력하지 않는다.
 * 지우고 다시 풀어본 횟수: 3
 * 풀이후기:
 *  - 어렵다. 여전히 어렵다.
 *  - 계속 흐름을 생각하자.
 * */

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] ch;
    static int n;

    public static void dfs(int L) {
        if(L == n + 1) {
            for(int i = 1; i <= n; i++) {
                if(ch[i]) sb.append(i).append(" ");
            }
            sb.append("\n");
        }else {
            ch[L] = true;
            dfs(L + 1);
            ch[L] = false;
            dfs(L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new boolean[n + 1];

        dfs(1);
        System.out.print(sb);
    }
}
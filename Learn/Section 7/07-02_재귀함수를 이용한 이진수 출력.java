import java.io.*;
import java.util.*;
/*
 * 문제: 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성한다.
        단, 재귀함수를 이용해서 출력해야 한다.
 * 입력: 첫 줄에 10진수 N(1<=N<=1,000)
 * 출력: 첫째 줄에 이진수 출력
 * 풀이후기:
 *  - 재귀함수를 이렇게 활용하니까 너무 어렵다.
 *  - 2로 계속 나눠서 dfs()를 호출하고, 그러다 더이상 나눠지지 않으면 0 or 1을 출력
 *  - ex) 11
 *    dfs(11 / 2) -> dfs(5 / 2) -> dfs(2 / 2) -> dfs(1 / 2)
 *    -> sb.append(1 % 2) -> sb.append(2 % 2) -> sb.append(5 % 2) -> sb.append(11 % 2)
 * */

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void dfs(int n) {

        if(n < 1) return;

        dfs(n / 2);
        sb.append(n % 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dfs(n);

        System.out.print(sb);
    }
}
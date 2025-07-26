import java.io.*;
import java.util.*;
/*
 * 문제: 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하라.
        예를 들어 5! = 5*4*3*2*1 = 120
 * 입력: 첫 줄에 N(1<=N<=10)
 * 출력: 첫째 줄에 N팩토리얼 값을 출력
 * 풀이후기:
 *  - 오히려 앞선 07-01,02보다 해당 문제가 더 쉬웠음
 * */

public class Main {

    public static int dfs(int n) {
        if(n == 1) return 1;

        return dfs(n - 1) * n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(dfs(n));
    }
}
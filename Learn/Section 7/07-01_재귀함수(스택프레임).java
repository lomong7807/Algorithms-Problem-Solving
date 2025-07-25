import java.io.*;
import java.util.*;
/*
 * 문제: 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램
 * 입력: 첫 줄에 정수 N(3<=N<=10) 입력
 * 출력: 첫째 줄에 출력
 * 풀이후기:
 *  - 재귀함수 활용.
 *  - 그런데 재귀함수 내의 모든 값을 출력해야 되는건 처음 봐서 어려웠음.
 * */

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void dfs(int n) {
        if(n < 1) {
            return 1;
        }

        solution(n - 1);
        sb.append(n).append(" ");
    }

    public static void solution(int n) {
        dfs(n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
        System.out.print(sb);
    }
}
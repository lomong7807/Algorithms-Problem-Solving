import java.io.*;
import java.util.*;
/*
 * 문제: 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
        입력은 피보나치 수열의 총 항의 수이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 * 입력: 첫 줄에 총 항수 N(3<=N<=45)
 * 출력: 첫째 줄에 피보나치 수열을 출력
 * 풀이후기:
 *  - 재귀함수 너무 어렵다.. 단순 피보나치 수열을 구현하는건 바로 할 수 있겠는데, 특정 조건이 추가될수록 구현을 못함.
 *  - 피보나치 수열에서는 첫 번째와 두 번째는 1으로 고정이다. 반드시 까먹지 말자.
 * */

public class Main {

    static int[] memo;

    public static int fibo(int n) {
        if(0 < memo[n]) return memo[n];
        if(n <= 2) return memo[n] = 1;

        return memo[n] = fibo(n - 2) + fibo(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        memo = new int[n];

        fibo(n);

        for(int i = 1; i <= n; i++) {
            sb.append(memo[i]).append(" ");
        }

        System.out.print(sb);
    }
}
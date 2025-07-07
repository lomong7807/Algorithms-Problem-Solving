import java.io.*;
import java.util.*;
/*
 * 문제: 입력받은 숫자까지의 피보나치 수열 출력
 * 입력: 3 <= n <= 45
 * 출력: 1부터 n까지의 피보나치 수열
 * 풀이후기:
 *  - 재귀함수를 100% 공략하고 싶다.
 *  - 메모이제이션을 활용한 메모리 최적화
 *  - calculated[]라는 배열으로 체크하여 피보나치 수열 구현
 * */

public class Main {

    static int[] memo = new int[45];
    static boolean[] calculated = new boolean[45];

    public static int fibo(int n) {

        if(calculated[n]) {
            return memo[n];
        }

        if(n <= 1) {
            memo[n] = n;
        }else {
            memo[n] = fibo(n - 1) + fibo(n - 2);
        }

        calculated[n] = true;
        return memo[n];
    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            sb.append(memo[i]).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo(n);
        System.out.print(solution(n));
    }
}
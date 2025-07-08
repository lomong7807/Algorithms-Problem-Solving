import java.io.*;
import java.util.*;
/*
 * 문제: n개의 자연수를 입력받고, 숫자의 자리를 뒤집어서 소수인 수를 구하기
 * 입력: 3 <= n <= 100
 *      자연수 < 100,000
 * 출력: 뒤집힌 수 중에 소수인 수
 * 풀이후기:
 *  - 뒤집힌 수의 제곱근까지 나눠보면서 소수인지 확인하면 됨
 * */

public class Main {

    public static String solution(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for(int n : arr) {
            if(n < 2) {
                continue;
            }

            boolean flag = true;

            for(int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) {
                    flag = false;
                }
            }

            if(flag) {
                sb.append(n).append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(String.valueOf(new StringBuilder(st.nextToken()).reverse()));
        }
        System.out.print(solution(arr));
    }
}
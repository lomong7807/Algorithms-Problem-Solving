import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 소수 구하기
 *  - 번호 : 1929
 *  - 링크 : https://www.acmicpc.net/problem/1929
 * 2. 풀이핵심
 *  - 에라토스테네스의 체
 * 3. 풀이후기
 *  - 에라토스테네스의 체를 사용하여 소수를 구하는 문제
 *  - 소수 구할때 꼭 사용되는 알고리즘이니 이해하고 외우자 그냥..
 *  - 시간복잡도 O(N*log(logN))으로 선형 시간에 가까움
 */

public class Main {

    static boolean[] prime;

    public static String solution(int m, int n) {
        StringBuilder sb = new StringBuilder();

        makePrime(n);

        for(int i = m; i <= n; i++) {
            if(!prime[i]) sb.append(i).append("\n");
        }

        return sb.toString();
    }

    public static void makePrime(int n) {
        prime = new boolean[n + 1];

        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(n); i++) {

            if(prime[i]) continue;

            for(int j = i * i; j < prime.length; j=j+i) {
                prime[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        System.out.print(solution(m, n));
    }
}
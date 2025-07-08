import java.io.*;
import java.util.*;
/*
 * 문제: 자연수 n이 입력되면 1부터 n 까지의 소수의 개수를 출력
 * 입력: 2 <= n <= 200,000
 * 출력: 1부터 n 까지의 소수의 개수 정수
 * 풀이후기:
 *  - 에라토스테네스 체 알고리즘으로 풀면 되는데, 그게 뭔지 몰라서 찾아봄
 *  - 에라토스테네스 체
 *    소수를 구하는 대표적인 방법 중 하나다.
 *    k=2부터 √N 이하까지 반복하여 자연수들 중 k를 제외한 k의 배수들을 제외시킨다.
 *    √N 이하까지만 반복하는 이유는 합성수는 반드시 √N 이하의 소인수를 가지기 때문임.
 * */

public class Main {

    static boolean[] prime;

    public static int solution(int n) {
        int count = 0;
        makePrime(n);

        for(boolean v : prime) {
            if(!v) {
                count++;
            }
        }

        return count;
    }

    public static void makePrime(int n) {
        prime = new boolean[n + 1];

        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            
            if(prime[i]) {
                continue;
            }

            for(int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(solution(n));
    }
}
import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 소수
 *  - 번호 : 2581
 *  - 링크 : https://www.acmicpc.net/problem/2581
 * 2. 풀이핵심
 *  - 소수 찾기
 * 3. 풀이후기
 *  - 소수 찾는 문제를 좀 더 연습하기 위해 풀었다.
 *  - 에라토스테네스의 체
 */

public class Main {
    
    static boolean[] prime;
    
    public static String solution(int m, int n) {
        StringBuilder sb = new StringBuilder();
        makePrime(m, n);
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = m; i <= n; i++) {
            if(!prime[i]) {
                sum += i;
                if(min == Integer.MAX_VALUE) {
                    min = i;
                }
            }
        }
        
        if(sum == 0) {
            sb.append(-1);
        }else {
            sb.append(sum).append("\n").append(min);
        }
        
        return sb.toString();
    }
    
    public static void makePrime(int m, int n) {
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
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        System.out.print(solution(m, n));
    }
}
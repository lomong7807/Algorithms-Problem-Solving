import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 이항계수
 *  - 번호 : 11050
 *  - 링크 : https://www.acmicpc.net/problem/11050
 * 2. 풀이핵심
 *  - factorial
 *  - 재귀 함수
 * 3. 풀이후기
 *  - 수의 범위가 작아서 일반적인 재귀 함수로 구현이 가능하다.
 *  - 재귀 함수의 기저조건을 잘 확인하자. n == 1이 아니라 n <= 1이다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int result = fac(N) / (fac(K) * fac(N - K));
        
        System.out.print(result);
    }
    
    public static int fac(int n) {
        if(n <= 1) {
            return 1;
        }
        
        return fac(n - 1) * n;
    }
}
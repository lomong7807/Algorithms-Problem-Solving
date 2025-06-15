import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 소수 찾기
 *  - 번호 : 1978
 *  - 링크 : https://www.acmicpc.net/problem/1978
 * 2. 풀이핵심
 *  - 조건에 따른 출력
 * 3. 풀이후기
 *  - 조건문을 따로 함수로 만들어 해당 조건이 참이면 count를 추가하는 형식으로 구현
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int count = 0;
        
        while(st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            
            if(isPrime(temp)) {
                count++;
            }
        }
        
        System.out.print(count);
    }
    
    public static boolean isPrime(int n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        
        for(int i = 5; i < n; i+=2) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
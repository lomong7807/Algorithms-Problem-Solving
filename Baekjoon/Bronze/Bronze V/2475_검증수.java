import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 검증수
 *  - 번호 : 2475
 *  - 링크 : https://www.acmicpc.net/problem/2475
 * 2. 풀이핵심
 *  - 반복문
 *  - 공백 제거
 * 3. 풀이후기
 *  - split보단 StringTokenizer를 사용하자
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int sum = 0;
        
        while(st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            sum += temp * temp;
        }
        
        System.out.println(sum % 10);
    }
}
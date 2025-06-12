import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 별 찍기 - 2
 *  - 번호 : 2439
 *  - 링크 : https://www.acmicpc.net/problem/2439
 * 2. 풀이핵심
 *  - 기존의 별 찍기를 거꾸로 찍는다.
 *  - 공백과 * 모두 출력하는 반복문
 * 3. 풀이후기
 *  - 조건이 여러개라 헷갈릴 수 있으니 집중하자.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            for(int j = n - (i + 1); 0 < j; j--) {
                sb.append(" ");
            }
            
            for(int k = 0; k <= i; k++) {
                sb.append("*");
            }
            
            if(i < n - 1) {
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
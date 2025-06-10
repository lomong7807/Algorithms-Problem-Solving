import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 두 수 비교하기
 *  - 번호 : 1330번
 *  - 링크 : https://www.acmicpc.net/problem/1330
 * 2. 풀이핵심
 *  - 조건문에 맞춰 원하는 출력값 출력하기
 * 3. 풀이후기
 *  - 기초 문제
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        if(a > b) {
            System.out.println(">");
        } else if(a < b) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
        
        br.close();
    }
}
    
    
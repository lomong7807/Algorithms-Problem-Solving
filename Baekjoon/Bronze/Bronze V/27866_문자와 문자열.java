import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 문자와 문자열
 *  - 번호 : 27866
 *  - 링크 : https://www.acmicpc.net/problem/27866
 * 2. 풀이핵심
 *  - String의 index 위치 찾기
 * 3. 풀이후기
 *  - String.charAt() 을 사용해 해당 문자가 어디있는지 찾음
 *  - 여러 문자가 있더라도 제일 처음 발견된 index를 반환함
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        
        System.out.print(str.charAt(n - 1));
    }
}
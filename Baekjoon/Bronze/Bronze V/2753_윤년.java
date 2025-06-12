import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 윤년
 *  - 번호 : 2753
 *  - 링크 : https://www.acmicpc.net/problem/2753
 * 2. 풀이핵심
 *  - 조건 확인
 * 3. 풀이후기
 *  - 기초 문제
 *  - 조건을 제대로 읽지 않아 여러번 틀렸다. 조건을 잘 확인하자.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        
        if( ((year % 4) == 0 && (year % 100) != 0) || ((year % 400) == 0) ) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
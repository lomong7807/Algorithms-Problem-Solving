import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 숫자의 합
 *  - 번호 : 11720
 *  - 링크 : https://www.acmicpc.net/problem/11720
 * 2. 풀이핵심
 *  - 반복문
 *  - String index
 *  - char to int
 *  - String의 정수 변환
 * 3. 풀이후기
 *  - 문자열로 돼있는 숫자를 int로 변환할 때 아스키코드값 '0'을 빼서 int로 추출함
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int sum = 0;
        
        for(int i = 0; i < t; i++) {
            sum += str.charAt(i) - '0';
        }
        
        System.out.print(sum);
    }
}
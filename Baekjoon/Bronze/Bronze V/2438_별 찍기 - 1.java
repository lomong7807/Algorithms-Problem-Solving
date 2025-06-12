import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 별 찍기 - 1
 *  - 번호 : 2438
 *  - 링크 : https://www.acmicpc.net/problem/2438
 * 2. 풀이핵심
 *  - 조건에 맞게끔 출력
 *  - 반복문 확인
 * 3. 풀이후기
 *  - 기초 문제
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
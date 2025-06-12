import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : N 찍기
 *  - 번호 : 2741
 *  - 링크 : https://www.acmicpc.net/problem/2741
 * 2. 풀이핵심
 *  - 반복문
 * 3. 풀이후기
 *  - 기초 문제
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= n; i++) {
            sb.append(i).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
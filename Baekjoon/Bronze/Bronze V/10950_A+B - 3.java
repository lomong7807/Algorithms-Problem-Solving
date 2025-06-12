import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : A+B - 3
 *  - 번호 : 10950
 *  - 링크 : https://www.acmicpc.net/problem/10950
 * 2. 풀이핵심
 *  - 반복문
 * 3. 풀이후기
 *  - 기초 문제
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            st  = new StringTokenizer(br.readLine());
            int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            sb.append(sum).append("\n");
        }
        
        System.out.println(sb);
    }
}
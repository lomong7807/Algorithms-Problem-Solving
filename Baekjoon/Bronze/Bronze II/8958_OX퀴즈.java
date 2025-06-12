import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : OX퀴즈
 *  - 번호 : 8958
 *  - 링크 : https://www.acmicpc.net/problem/8958
 * 2. 풀이핵심
 *  - 문자열 반복문
 *  - 조건문
 * 3. 풀이후기
 *  - 처음엔 조건이 좀 어렵게 느껴져서 반복문을 총 3개 썼음
 *  - 하지만 문자열을 순회하면서 점수도 처리할 수 있었음
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            
            String str = br.readLine();            
            int sum = 0;
            int score = 0;
            
            for(int j = 0; j < str.length(); j++) {
                
                if(str.charAt(j) == 'O') {
                    score++;
                    sum += score;
                } else if (str.charAt(j) == 'X') {
                    score = 0;
                }
                
            }
            
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
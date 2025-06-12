import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 알람시계
 *  - 번호 : 2884
 *  - 링크 : https://www.acmicpc.net/problem/2884
 * 2. 풀이핵심
 *  - 조건에 따른 숫자 연산
 * 3. 풀이후기
 *  - 시간은 0~23, 분은 0~59 제한으로 인한 조건을 생각해야함
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        m = m - 45;

        if(m < 0) {
            h = h - 1;
            m = m + 60;
            if(h < 0) {
                h = 23;
            }
        }   
        
        sb.append(String.valueOf(h)).append(" ").append(String.valueOf(m));
        
        System.out.println(sb.toString());
    }
}
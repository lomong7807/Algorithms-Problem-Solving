import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : ACM 호텔
 *  - 번호 : 10250
 *  - 링크 : https://www.acmicpc.net/problem/10250
 * 2. 풀이핵심
 *  - 조건에 따른 숫자 연산
 * 3. 풀이후기
 *  - 복잡한 조건을 잘 생각해야 함
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            int y = 0;
            int x = 0;

            if(n % h == 0) {
                y = h * 100;
                x = n / h;
            } else {
                y = (n % h) * 100;
                x = (n / h) + 1;
            }
            
            int XXYY = y + x;
            
            sb.append(XXYY).append("\n");
        }
        
        System.out.print(sb);
    }
}
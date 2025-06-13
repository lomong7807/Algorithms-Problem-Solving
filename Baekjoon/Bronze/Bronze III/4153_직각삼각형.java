import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 직각삼각형
 *  - 번호 : 4153
 *  - 링크 : https://www.acmicpc.net/problem/4153
 * 2. 풀이핵심
 *  - 직각삼각형의 조건을 알아야 함
 *  - 특정 조건일때 종료
 * 3. 풀이후기
 *  - 직각삼각형의 조건: 빗변=a, 그 외의 변=b,c 일때 (b*b) + (c*c) == a*a
 *  - 직각삼각형의 조건만 알면 어려울거 없었음 
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if(a == 0 && b == 0 && c == 0) {
                break;
            }
            
            if((a*a)+(b*b) == c*c ||
               (a*a)+(c*c) == b*b ||
               (b*b)+(c*c) == a*a) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
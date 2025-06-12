import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : A+B - 5
 *  - 번호 : 10952
 *  - 링크 : https://www.acmicpc.net/problem/10952
 * 2. 풀이핵심
 *  - 한 줄의 입력값이 모두 0 일때 종료되는 조건
 *  - 조건에 맞춰 구현
 * 3. 풀이후기
 *  - 조건에 따른 반복 설정
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n1, n2;
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            
            if(n1 == 0 && n2 == 0) break;
            
            sb.append(n1 + n2).append("\n");
        }
        
        System.out.println(sb);
    }
}
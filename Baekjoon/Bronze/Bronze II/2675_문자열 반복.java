import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 문자열 반복
 *  - 번호 : 2675
 *  - 링크 : https://www.acmicpc.net/problem/2675
 * 2. 풀이핵심
 *  - 반복문을 완료한 후 다음 반복문 실행
 * 3. 풀이후기
 *  - String을 배열로 만들어서 푸는 방식도 있는데, 굳이 배열을 또 생성할 필요가 없었음
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            
            for(int j = 0; j < s.length(); j++){
                for(int k = 0; k < r; k++) {
                    sb.append(s.charAt(j));
                }
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
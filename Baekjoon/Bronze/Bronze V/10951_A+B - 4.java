import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : A+B - 4
 *  - 번호 : 10951
 *  - 링크 : https://www.acmicpc.net/problem/10951
 * 2. 풀이핵심
 *  - NullPointer 런타임 에러 발생
 *  - EOF(End Of File) 처리 방법
 * 3. 풀이후기
 *  - "A+B - 3"과 다르게 끝나는 시점을 알 수 없다.
 *  - 그래서 null일 때 종료되게끔 조건문 생성
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str = "";
        
        while((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))
                .append("\n");
        }
        
        System.out.print(sb);
    }
}
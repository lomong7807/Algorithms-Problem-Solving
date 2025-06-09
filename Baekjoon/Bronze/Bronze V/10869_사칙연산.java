import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 사칙연산
 *  - 번호 : 10869
 *  - 링크 : https://www.acmicpc.net/problem/10869
 * 2. 풀이핵심
 *  - 입력에 대한 산수 계산 출력
 * 3. 풀이후기
 *  - System.out.println()이 아닌 BufferedWriter를 사용한 출력을 해봤다.
 *  - BufferedWriter를 만들어 Buffer에 String 값들을 담아두고, flush()로 한 번에 출력
 *  - System.out.println()보다 성능이 좋다.
 *  - String만 출력 가능하고 따로 개행처리가 되지 않아 직접 해줘야 한다.
 */
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        bw.write(String.valueOf(x + y) + "\n");
        bw.write(String.valueOf(x - y) + "\n");
        bw.write(String.valueOf(x * y) + "\n");
        bw.write(String.valueOf(x / y) + "\n");
        bw.write(String.valueOf(x % y));
        
        bw.flush();
        bw.close();
        br.close();
    }
}
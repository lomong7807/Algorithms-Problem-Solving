import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 :나머지
 *  - 번호 : 10430번
 *  - 링크 : https://www.acmicpc.net/problem/10430
 * 2. 풀이핵심
 *  - 주어진 조건대로 출력하는 입출력 기초
 * 3. 풀이후기
 *  - 기초 문제
 *  - int to String은 String.valueOf()를 사용하자
 *  - int + ""를 하게되면 내부적으로 StringBuilder로 String을 만든다고 한다.
 *  - int + ""로 변환해보니 성능이 별로다
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        bw.write(String.valueOf((a + b) % c) + "\n");
        bw.write(String.valueOf(((a%c) + (b%c))%c) + "\n");
        bw.write(String.valueOf((a * b) % c) + "\n");
        bw.write(String.valueOf(((a%c) * (b%c))%c));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
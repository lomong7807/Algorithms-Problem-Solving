import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 구구단
 *  - 번호 : 2739
 *  - 링크 : https://www.acmicpc.net/problem/2739
 * 2. 풀이핵심
 *  - 반복문
 * 3. 풀이후기
 *  - StringBuilder를 사용해 성능을 최적화하자
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 1; i < 10; i++) {
            sb.append(n)
                .append(" * ")
                .append(i)
                .append(" = ")
                .append(n * i)
                .append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
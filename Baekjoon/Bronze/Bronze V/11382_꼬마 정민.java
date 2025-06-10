import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 :나머지
 *  - 번호 : 11382번
 *  - 링크 : https://www.acmicpc.net/problem/11382
 * 2. 풀이핵심
 *  - 주어진 조건대로 출력하는 입출력 기초
 * 3. 풀이후기
 *  - 기초 문제
 *  - 문제의 조건을 잘 확인하자. 해당 문제는 10의 12제곱까지 입력이 가능하여 int의 범위를 벗어남
 *  - 문제를 잘 안봤다가 낭패였다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long result = 0;
        
        while(st.hasMoreTokens()) {
            result += Long.parseLong(st.nextToken());
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
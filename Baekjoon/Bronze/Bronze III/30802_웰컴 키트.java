import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 웰컴 키트
 *  - 번호 : 30802
 *  - 링크 : https://www.acmicpc.net/problem/30802
 * 2. 풀이핵심
 *  - 조건문에 따른 연산
 * 3. 풀이후기
 *  - tCount를 추가하는 조건문이 헷갈렸었음
 *  - 그리고 코드를 최대한 가독성 좋게 만드는데 시간을 씀
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        long tCount = 0;        
        long t = Long.parseLong(st2.nextToken());
        long p = Long.parseLong(st2.nextToken());
        
        while(st1.hasMoreTokens()) {
            long temp = Long.parseLong(st1.nextToken());
            
            tCount += temp / t;            
            if(temp % t != 0) {
                tCount++;
            }
        }
        
        sb.append(tCount).append("\n")
            .append(n/p).append(" ").append(n%p);
        
        System.out.print(sb);
    }
}